import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class PASCALetProcedureVisitor extends PASCALetGrammarBaseVisitor<PASCALetObject> {
    // Function Map here

    // PASCALetFunctionVisitor constructor

    @Override
    public PASCALetObject visitProcedureDeclaration (PASCALetGrammarParser.ProcedureDeclarationContext ctx) {
        List<PASCALetGrammarParser.ParameterGroupContext> procParams = null;

        try {
            procParams = ctx.formalParameterlist().parameterGroup();

        } catch (Exception e)  {}

        if (procParams == null) {
            procParams = new ArrayList<>();
        }

        String procedureName = ctx.identifier().getText() + procParams.size();
        ParseTree block = ctx.block();

        // function.put..

        return PASCALetObject.VOID;


    }

}
