
public class PASCALetObject implements Comparable<PASCALetObject>{

    public static final PASCALetObject NULL = new PASCALetObject();
    public static final PASCALetObject VOID = new PASCALetObject();

    public static final Object PASCALET_OBJECT_INT = 1;
    public static final Object PASCALET_OBJECT_CHAR = 'a';
    public static final Object PASCALET_OBJECT_STRING = "string";
    public static final Object PASCALET_OBJECT_BOOLEAN = true;
    public static final Object PASCALET_OBJECT_ARRAY_INT = new int[0];

    private Object value;
    private Object type; //only used on declaration.
    private boolean constant;

    private PASCALetObject(){
        this.value = new Object();
        this.constant = false;
    }

    //for normal variable declaration
    public PASCALetObject(Object type) {
        this.type = type;
        this.constant = false;
        this.value = null;

        this.checkIfTypeIsInSpecification();
    }

    public PASCALetObject(Object type, Object value) {
        this.type = type;
        this.value = value;
        this.constant = false;

        this.checkIfTypeIsInSpecification();
    }

    private void checkIfTypeIsInSpecification() {
        if(!(isTypeBoolean() || isTypeString() || isTypeInteger() || isTypeChar() || isTypeArrayInt())) {
            throw new RuntimeException("Invalid data type: " + this.type + " (" + this.type.getClass() + ")");
        }
    }

    public void setConstant(boolean flag) {
        this.constant = flag;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean asBoolean() {
        return (boolean) value;
    }

    public int asInteger() {
        try {
            return ((Number)value).intValue ();
        }
        catch(Exception e) {
            throw new RuntimeException ("Type mistmatch, value cannot be an integer.");
        }
    }

    public char asChar() {
        return (char) value;
    }

    public String asString() {
        return String.valueOf(value);
    }

    public int[] asArray() {
        return (int[]) value;
    }


    //Check if given
    public boolean isTypeBoolean() {
        return this.type instanceof Boolean;
    }

    public boolean isTypeInteger() {
        return this.type instanceof Integer;
    }

    public boolean isTypeChar() {
        return this.type instanceof Character;
    }

    public boolean isTypeString() {
        return this.type instanceof String;
    }

    public boolean isTypeArrayInt() { return this.type instanceof int[];}


    public boolean isNull() {
        return this == NULL;
    }

    public boolean isVoid() {
        return this == VOID;
    }


    public Object getType() {
        return this.type;
    }

    public String getTypeAsString() {

        if(this.isTypeString()) {
            return "string";
        }
        else if(this.isTypeChar()) {
            return "char";
        }
        else if(this.isTypeInteger()) {
            return "integer";
        }
        else if(this.isTypeBoolean()) {
            return "boolean";
        }
        else if(this.isTypeArrayInt()) {
            return "array";
        }

        return "ERROR TYPE NOT FOUND";
    }


    @Override
    public int compareTo(PASCALetObject o) {
        return 0;
    }

    public boolean areSimilar(PASCALetObject other) {

        if(this.isTypeInteger())
            return other.isTypeInteger();

        else if(this.isTypeBoolean()) {
            return other.isTypeBoolean();
        }

        else if(this.isTypeChar()) {
            return other.isTypeChar();
        }

        else if (this.isTypeString()) {
            return other.isTypeString();
        }

        else if(this.isTypeArrayInt()) {
            return other.isTypeArrayInt();
        }

        else return false;
    }

    public Object getValue() {
        return this.value;
    }
}
