public class ConvertStringToObjectType {

    public static Object start(String type) {
        type=type.toLowerCase();

        switch(type) {
            case "integer": return PASCALetObject.PASCALET_OBJECT_INT;
            case "string": return PASCALetObject.PASCALET_OBJECT_STRING;
            case "char": return PASCALetObject.PASCALET_OBJECT_CHAR;
            case "boolean": return PASCALetObject.PASCALET_OBJECT_BOOLEAN;
            case "array" : return PASCALetObject.PASCALET_OBJECT_ARRAY_INT;
            default: return 1.0f; //float, non existent.
        }


    }
}
