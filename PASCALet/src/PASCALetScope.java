import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.Map;

public class PASCALetScope {

    private PASCALetScope parent;
    private Map<String, PASCALetObject> variables;
    private Map<String, PASCALetObject> constants;
    private String functionName;
    private boolean isFunctionScope;

    public PASCALetScope() {
        this(null);
    }

    public PASCALetScope(PASCALetScope parent) {
        this.parent = parent;
        this.variables = new HashMap<>();
        this.constants = new HashMap<>();
        this.isFunctionScope = false;
        this.functionName = "";
    }

    public PASCALetScope(PASCALetScope parent, String functionName) {
        this.parent = parent;
        this.variables = new HashMap<>();
        this.constants = new HashMap<>();
        this.functionName = functionName;
        this.isFunctionScope = true;
    }

    //inserts a value to a variable.
    public void addVariableAndValue(String variableName, PASCALetObject value) {
        this.variables.put(variableName, value);
    }

    //Insert variable inside variable map, FOR DECLARATION.
    public void addVariable(String variableName, String type, ParserRuleContext ctx) {
        variableName = variableName.toLowerCase();


        //Variable never used, therefore insert it in our variable name.
        if(!variables.containsKey(variableName) && !constants.containsKey(variableName)) {
             Object pascaletType = ConvertStringToObjectType.start(type);
             PASCALetObject value = new PASCALetObject(pascaletType);
             this.addVariableAndValue(variableName, value);
        }

        else { //exists already, throw an error!
             String errorMsg = "Identifier \"" + variableName + "\" already in use. Cannot be a variable identifier: " ;
             throw new PASCALetException(ctx, errorMsg);
        }
    }

    public void addVariableArray(String variableName, String type, int maxValue, ParserRuleContext ctx) {
        variableName = variableName.toLowerCase();


        //Variable never used, therefore insert it in our variable name.
        if(!variables.containsKey(variableName) && !constants.containsKey(variableName)) {
            Object pascaletType = ConvertStringToObjectType.start(type);
            int[] arr = new int[maxValue];
            PASCALetObject value = new PASCALetObject(pascaletType, arr);
            this.addVariableAndValue(variableName, value);
        }

        else { //exists already, throw an error!
            String errorMsg = "Identifier \"" + variableName + "\" already in use. Cannot be a variable identifier: " ;
            throw new PASCALetException(ctx, errorMsg);
        }
    }

    //inserts a constant name key and a value to the constants hashmap. FOR DECLARATION CANNOT BE REASSIGNED.
    public void addConstant(String constantName, PASCALetObject value, ParserRuleContext ctx) {
        constantName = constantName.toLowerCase();

        //if constant doesnt exist, create new constant.
        if (!constants.containsKey(constantName) && !variables.containsKey(constantName)) {
            this.constants.put (constantName, value);
        }

        //if it exists, throw an error.
        else {
            String errorMsg = "Identifier \"" + constantName + "\"  already in use. Cannot be a constant identifier: ";
            throw new PASCALetException(ctx, errorMsg);
        }

    }

    //Assign a value to a variable.
    public void assignVariable(String variableName, PASCALetObject value, ParserRuleContext ctx) {
        variableName = variableName.toLowerCase();

        //if itss a constant, fail it.
        if(isThisAConstant(variableName)) {
            String errorMsg = "Cannot assign Variable constant \"" + variableName + "\" a value.";
            throw new PASCALetException(ctx, errorMsg);
        }

        //its in this scope, give value to that variable.
        if(this.variables.containsKey(variableName)) {

            PASCALetObject oldValue = this.variables.get(variableName);

            if(oldValue.areSimilar(value)) {
                this.variables.replace(variableName, value);
            }

            else {
                String errorMsg = "Variable assignment error, data type mismatch: ";
                throw new PASCALetException(ctx, errorMsg);
            }
        }

        //Doesn't exist on this scope, so maybe its on the parent.
        else if(!this.isGlobalScope()) {
            this.parent.assignVariable(variableName, value, ctx);
        }

        //Doesn't exist at all, throw an error.
        else {
            String errorMsg = "Variable \"" + variableName + "\" does not exist / has never been declared: ";
            throw new PASCALetException(ctx, errorMsg);
        }
    }

    //Finds if the constant exists on the scope OR global scope.
    public boolean isThisAConstant(String constantName) {
        constantName = constantName.toLowerCase();

        if(this.constants.containsKey(constantName)) {
            return true;
        }

        else if (!this.isGlobalScope()) { //check global scope if its there.
            return this.parent.isThisAConstant(constantName);
        }

        else return false;
    }

    public boolean isThisAVariable(String variableName) {

        if(this.variables.containsKey(variableName)) {
            return true;
        }

        else if (!this.isGlobalScope()) { //check global scope if its there.
            return this.parent.isThisAVariable(variableName);
        }

        else return false;
    }

    //give value of the constant
    public PASCALetObject getConstantValue(String constantName, ParserRuleContext ctx) {
        constantName = constantName.toLowerCase();

        if(this.constants.containsKey(constantName)) {
            return this.constants.get(constantName);
        }

        //check global, baka andun.
        else if (!this.isGlobalScope()) {
            return this.parent.getConstantValue(constantName, ctx);
        }

        String errorMsg = "Constant \"" + constantName + "\" does not exist / has never been declared: ";
        throw new PASCALetException(ctx, errorMsg);
    }

    //give value of the variable
    public PASCALetObject getVariableValue(String variableName, ParserRuleContext ctx) {
        variableName = variableName.toLowerCase();

        if(this.variables.containsKey(variableName)) {
            return this.variables.get(variableName);
        }

        //check global, baka andun.
        else if (!this.isGlobalScope()) {
            return this.parent.getVariableValue(variableName, ctx);
        }

        String errorMsg = "Variable \"" + variableName + "\" does not exist / has never been declared: ";
        throw new PASCALetException(ctx, errorMsg);
    }


    public boolean isGlobalScope() {
        return parent == null;
    }

    public PASCALetScope getParent() {
        return parent;
    }

    public String VariablesToString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, PASCALetObject> var: variables.entrySet()) {
            sb.append(var.getKey()).append("->").append(var.getValue().getValue()).append("(" + var.getValue().getTypeAsString() +")").append(",");
        }
        return sb.toString();
    }

    public String ConstantToString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, PASCALetObject> con: constants.entrySet()) {
            sb.append(con.getKey()).append("->").append(con.getValue().getValue()).append("(" + con.getValue().getTypeAsString() +")").append(",");
        }
        return sb.toString();
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public boolean isAFunctionScope() {
        return this.isFunctionScope;
    }

}
