import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Map;

public class PASCALetFunction {

    private List<PASCALetGrammarParser.ParameterGroupContext> params;
    private ParseTree block;
    private int parameterCount;
    private String returnType;

    public PASCALetFunction (List<PASCALetGrammarParser.ParameterGroupContext> params, int parameterCount, ParseTree block, String returnType) {
        this.params = params;
        this.parameterCount = parameterCount;
        this.block = block;
        this.returnType = returnType;
    }


    public PASCALetObject invoke(List<PASCALetGrammarParser.ActualParameterContext> actualParams,
                                 Map<String, PASCALetFunction> functions,
                                 Map<String, PASCALetProcedure> procedures,
                                 PASCALetScope globalScope,
                                 String functionName,
                                 ParserRuleContext ctx) {

        //Procedure scope. Parent is global scope.
        functionName = functionName.toLowerCase();
        PASCALetScope funcScope = new PASCALetScope(globalScope, functionName);
        funcScope.setProgramName(globalScope.getProgramName());

        if(actualParams != null) {
            if(this.parameterCount != actualParams.size()) {
                String errMsg = "Illegal procedure call, parameter size mismatch: ";
                throw new PASCALetException(ctx, errMsg);
            }
        }

        if(this.parameterCount != 0) { //only do this whenn there are parameters.
            //Get the values of the actual parameters and map it with the function parameters.
            PASCALetVisitor pVisitor = new PASCALetVisitor(globalScope, functions, procedures);
            int actualParamindex = 0;
            for(int x = 0; x < this.params.size(); x++) {

                List<PASCALetGrammarParser.IdentifierContext> identifiers = this.params.get(x).identifierList().identifier();
                for(int y = 0; y < identifiers.size(); y++) {

                    PASCALetObject value = pVisitor.visit(actualParams.get(actualParamindex));

                    //must be same type.
                    if(value.getTypeAsString().equalsIgnoreCase(this.params.get(x).typeIdentifier().getText())) {
                        funcScope.addVariable(identifiers.get(y).getText(), value.getTypeAsString(), ctx);
                        funcScope.assignVariable(identifiers.get(y).getText(), value, ctx);

                        actualParamindex++;
                    }
                    else {
                        String errMsg = "Invalid evaluation on function. Parameter data type mismatch: ";
                        throw new PASCALetException(ctx, errMsg);
                    }
                }
            }
        }

        //traverse
        PASCALetVisitor funcPVisitor = new PASCALetVisitor(funcScope, functions, procedures);

        //if remained null, something went wrong.
        PASCALetObject retValue = null;

        //Get return value from this function block.
        try {
            funcPVisitor.visit(this.block);
        } catch(PASCALetReturnValue pReturnValue) {
            retValue = pReturnValue.value;
        }

        if(retValue == null) {
            String errMsg = "Missing return type \"" + this.returnType +"\": ";
            throw new PASCALetException(ctx, errMsg);
        }

        if(this.returnType.equalsIgnoreCase(retValue.getTypeAsString())) {
            return retValue;
        }
        else {
            String errMsg = "Invalid evaluation. Returned type does not match function's return type: ";
            throw new PASCALetException(ctx, errMsg);
        }

    }


}
