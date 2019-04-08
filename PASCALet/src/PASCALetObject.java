
public class PASCALetObject implements Comparable<PASCALetObject>{

    public static final PASCALetObject NULL = new PASCALetObject();
    public static final PASCALetObject VOID = new PASCALetObject();

    private Object value;
    private boolean constant;

    private PASCALetObject(){
        this.value = new Object();
        this.constant = false;
    }

    public PASCALetObject(Object v) {
        if( v == null) {
            throw new RuntimeException("v == null");
        }

        this.value = v;
        this.constant = false;

        if(!(isBoolean() || isString() || isInteger() || isChar())) {
            throw new RuntimeException("Invalid data type: " + v + " (" + v.getClass() + ")");
        }
    }

    public void setConstant(boolean flag) {
        this.constant = flag;
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

    public Object[] asArray() {
        return (Object[]) value;
    }

    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    public boolean isInteger() {
        return value instanceof Integer;
    }

    public boolean isChar() {
        return value instanceof Character;
    }

    public boolean isString() {
        return value instanceof  String;
    }

    public boolean isNull() {
        return this == NULL;
    }

    public boolean isVoid() {
        return this == VOID;
    }


    @Override
    public int compareTo(PASCALetObject o) {
        return 0;
    }
}
