import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Map;

public class PASCALetProcedure {

    private List<PASCALetGrammarParser.ParameterGroupContext> params;
    private int parameterCount;
    private ParseTree block;

    public PASCALetProcedure (List<PASCALetGrammarParser.ParameterGroupContext> params, int parameterCount, ParseTree block) {
        this.params = params;
        this.block = block;
        this.parameterCount = parameterCount;
    }


    public void invoke(List<PASCALetGrammarParser.ActualParameterContext> actualParams,
                       Map<String, PASCALetFunction> functions,
                       Map<String, PASCALetProcedure> procedures,
                       PASCALetScope globalScope,
                       ParserRuleContext ctx) {

        //Procedure scope. Parent is global scope.
        PASCALetScope procScope = new PASCALetScope(globalScope);

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
                        procScope.addVariable(identifiers.get(actualParamindex).getText(), value.getTypeAsString(), ctx);
                        procScope.assignVariable(identifiers.get(actualParamindex).getText(), value, ctx);

                        actualParamindex++;
                    }
                    else {
                        String errMsg = "Invalid evaluation. Parameter data type mismatch: ";
                        throw new PASCALetException(ctx, errMsg);
                    }
                }
            }
        }

        //traverse
        PASCALetVisitor procPVisitor = new PASCALetVisitor(procScope, functions, procedures);
        procPVisitor.visit(this.block);
    }
}
