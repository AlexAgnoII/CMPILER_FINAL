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

    //inserts a ariable name key and a value in the variables hashmap.
    public void assignVariable(String variableName, PASCALetObject value) {
        this.variables.put(variableName, value);
    }

    //inserts a constant name key and a value to the constants hashmap. CANNOT BE REASSIGNED.
    public void assignConstant(String constantName, PASCALetObject value) {

        if (resolve (constantName) != null) {
            throw new RuntimeException ("Variable " + constantName + "  already in use. Cannot be a constant.");
        }

        if (resolveConstant (constantName) == null) {
            this.constants.put (constantName, value);
        }

    }

    //Initial cheecking whether variable exists or not
    public void assign(String variableName, PASCALetObject value) {

        //if itss a constant, fail it.
        if(resolveConstant(variableName) != null) {
            throw new RuntimeException("Cannot assign a constant");
        }

        //if it exissts, just reasssign it.
        if(this.resolve(variableName)!= null) {
            this.reAssign(variableName, value);
        }

        //if it doesn't exist, create a new entry on the hashmap.
        else {
            this.assignVariable(variableName, value);
        }

    }

    //reassigns an existing variable name with the stated value.
    public void reAssign(String variableName, PASCALetObject value) {

        if(this.variables.containsKey(variableName)) { //variable is in this scope.
            this.assignVariable(variableName, value);
        }

        else { //not in this scope, so check the parent scope
            this.parent.reAssign(variableName, value);
        }
    }

    //find the variable in this scope.
    public PASCALetObject resolve(String variableName) {
        PASCALetObject value = variables.get(variableName);

        if(value != null) { //in this scope.
            return value;
        }

        else if (isGlobalScope()) { //it is global, check scope of the parent.
            return this.parent.resolve(variableName);
        }

        //new variable.
        else {
            return null;
        }
    }

    //find the constant in this scope.
    public PASCALetObject resolveConstant(String constantName) {

        PASCALetObject value = variables.get(constantName);

        if(value != null) {
            return value;
        }

        else if (isGlobalScope()) {
            return this.parent.resolveConstant(constantName);
        }

        else { //new constant
            return null;
        }
    }

    public boolean isGlobalScope() {
        return parent != null;
    }

    public PASCALetScope getParent() {
        return parent;
    }

    public String VariablesToString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, PASCALetObject> var: variables.entrySet()) {
            sb.append(var.getKey()).append("->").append(var.getValue()).append(",");
        }
        return sb.toString();
    }

    public String ConstantToString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, PASCALetObject> con: constants.entrySet()) {
            sb.append(con.getKey()).append("->").append(con.getValue()).append(",");
        }
        return sb.toString();
    }

}
