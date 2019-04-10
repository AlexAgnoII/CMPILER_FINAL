import java.util.HashMap;
import java.util.Map;

public class PASCALetScope {

    private PASCALetScope parent;
    private Map<String, PASCALetObject> variables;
    private Map<String, PASCALetObject> constants;

    public PASCALetScope() {
        this(null);
    }

    public PASCALetScope(PASCALetScope parent) {
        this.parent = parent;
        this.variables = new HashMap<>();
        this.constants = new HashMap<>();
    }

    //inserts a value to a variable.
    public void assignVariable(String variableName, PASCALetObject value) {
        this.variables.put(variableName, value);
    }

    //Insert variable inside variable map, FOR DECLARATION.
    public void addVariable(String variableName, String type) {
        variableName = variableName.toLowerCase();


        //Variable never used, therefore insert it in our variable name.
        if(!variables.containsKey(variableName) && !constants.containsKey(variableName)) {
             Object pascaletType = ConvertStringToObjectType.start(type);
             PASCALetObject value = new PASCALetObject(pascaletType);
             this.assignVariable(variableName, value);
        }

        else { //exists already, throw an error!
             throw new RuntimeException("Identifier \"" + variableName + "\" already in use. Cannot be a variable identifier");
        }
    }

    //inserts a constant name key and a value to the constants hashmap. FOR DECLARATION CANNOT BE REASSIGNED.
    public void addConstant(String constantName, PASCALetObject value) {
        constantName = constantName.toLowerCase();

        //if constant doesnt exist, create new constant.
        if (!constants.containsKey(constantName) && !variables.containsKey(constantName)) {
            this.constants.put (constantName, value);
        }

        //if it exists, throw an error.
        else {
            throw new RuntimeException ("Identifier \"" + constantName + "\"  already in use. Cannot be a constant identifier.");
        }

    }

    //Assign a value to a variable.
    public void assign(String variableName, PASCALetObject value) {
        variableName = variableName.toLowerCase();

        //if itss a constant, fail it.
        if(doesConstantExist(variableName)) {
            throw new RuntimeException("Cannot assign constant \"" + variableName + "\" a value.");
        }

        //its in this scope, give value to that variable.
        if(this.variables.containsKey(variableName)) {

            PASCALetObject oldValue = this.variables.get(variableName);

            if(oldValue.areSimilar(value)) {
                this.variables.replace(variableName, value);
            }

            else {
                throw new RuntimeException("Variable assignment error, data type mismatch.");
            }
        }

        //Doesn't exist on this scope, so maybe its on the parent.
        else if(!this.isGlobalScope()) {
            this.parent.assign(variableName, value);
        }

        //Doesn't exist at all, throw an error.
        else {
            throw new RuntimeException("Variable \"" + variableName + "\" does not exist / has never been declared.");
        }
    }

    //Finds if the constant exists on the scope OR global scope.
    public boolean doesConstantExist(String constantName) {
        constantName = constantName.toLowerCase();

        if(this.constants.containsKey(constantName)) {
            return true;
        }

        else if (!this.isGlobalScope()) { //check global scope if its there.
            return this.parent.doesConstantExist(constantName);
        }

        else return false;
    }

    //give value of the constant
    public PASCALetObject ressolveConstant(String constantName) {
        constantName = constantName.toLowerCase();

        if(this.constants.containsKey(constantName)) {
            return this.constants.get(constantName);
        }

        //check global, baka andun.
        else if (!this.isGlobalScope()) {
            return this.parent.ressolveConstant(constantName);
        }

        throw new RuntimeException("Constant \"" + constantName + "\" does not exist / has never been declared.");
    }

    //give value of the variable
    public PASCALetObject resolveVariable(String variableName) {
        variableName = variableName.toLowerCase();

        if(this.variables.containsKey(variableName)) {
            return this.variables.get(variableName);
        }

        //check global, baka andun.
        else if (!this.isGlobalScope()) {
            return this.parent.resolveVariable(variableName);
        }

        throw new RuntimeException("Variable \"" + variableName + "\" does not exist / has never been declared.");
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

}
