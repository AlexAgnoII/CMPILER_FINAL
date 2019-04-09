import com.sun.source.tree.Scope;
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
                                 PASCALetScope globalScope) {

        //System.out.println(this.parameterCount);

        if(this.parameterCount != actualParams.size()) {
            throw new RuntimeException("Illegal function call, parameter size mismatch");
        }

        //function scope. Parent is global scope.
        PASCALetScope funcScope = new PASCALetScope(globalScope);

        //Get the values of the actual parameters and map it with the function parameters.
        PASCALetVisitor pVisitor = new PASCALetVisitor(globalScope, functions, procedures);
        int actualParamindex = 0;
        for(int x = 0; x < this.params.size(); x++) {

            List<PASCALetGrammarParser.IdentifierContext> identifiers = this.params.get(x).identifierList().identifier();
            for(int y = 0; y < identifiers.size(); y++) {
                PASCALetObject value = pVisitor.visit(actualParams.get(actualParamindex));
                funcScope.assignVariable(identifiers.get(actualParamindex).getText(), value);
                actualParamindex++;
            }
        }

        PASCALetVisitor funcPVisitor = new PASCALetVisitor(funcScope, functions, procedures);

        //if remained null, something went wrong.
        PASCALetObject retValue = null;

        //Get return value from this function block.
        try {
            funcPVisitor.visit(this.block);
        } catch(PASCALetReturnValue pReturnValue) {
            retValue = pReturnValue.value;
        }

        return retValue;
    }


}
