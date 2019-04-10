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


    public void invoke(List<PASCALetGrammarParser.ParameterListContext> actualParams,
                       Map<String, PASCALetFunction> functions,
                       Map<String, PASCALetProcedure> procedures,
                       PASCALetScope globalScope) {

        //System.out.println(paramCount);

        if(this.parameterCount != actualParams.size()) {
            throw new RuntimeException("Illegal function call, parameter size mismatch");
        }

        //Procedure scope. Parent is global scope.
        PASCALetScope procScope = new PASCALetScope(globalScope);

        //Get the values of the actual parameters and map it with the function parameters.
        PASCALetVisitor pVisitor = new PASCALetVisitor(globalScope, functions, procedures);
        int actualParamindex = 0;
        for(int x = 0; x < this.params.size(); x++) {

            List<PASCALetGrammarParser.IdentifierContext> identifiers = this.params.get(x).identifierList().identifier();
            for(int y = 0; y < identifiers.size(); y++) {
                PASCALetObject value = pVisitor.visit(actualParams.get(actualParamindex));
                procScope.addVariableAndValue(identifiers.get(actualParamindex).getText(), value);
                actualParamindex++;
            }
        }

        //traverse
        PASCALetVisitor procPVisitor = new PASCALetVisitor(procScope, functions, procedures);
        procPVisitor.visit(this.block);
    }
}
