import com.sun.source.tree.Scope;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Map;

public class PASCALetProcedure {

    private List<PASCALetGrammarParser.ParameterGroupContext> params;
    private ParseTree block;

    public PASCALetProcedure (List<PASCALetGrammarParser.ParameterGroupContext> params, ParseTree block) {
        this.params = params;
        this.block = block;
    }


    public void invoke(List<PASCALetGrammarParser.ParameterListContext> params,
                                 Map<String, PASCALetFunction> functions,
                                 Scope scope) {


    }
}
