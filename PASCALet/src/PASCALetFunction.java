import com.sun.source.tree.Scope;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Map;

public class PASCALetFunction {

    private List<PASCALetGrammarParser.ParameterGroupContext> params;
    private ParseTree block;
    private String returnType;
    private int test;

    public PASCALetFunction (List<PASCALetGrammarParser.ParameterGroupContext> params, ParseTree block) {
        this.params = params;
        this.block = block;
    }


    public PASCALetObject invoke(List<PASCALetGrammarParser.ParameterListContext> params,
                                 Map<String, PASCALetFunction> functions,
                                 PASCALetScope scope) {

        if(this.params.size() != params.size()) {
            throw new RuntimeException("Illegal function call, parameter size mismatch");
        }

        //function scope, scope inside as the parent is the global scope (program scope)
        PASCALetScope nextScope = new PASCALetScope(null);


        return null;

    }
}
