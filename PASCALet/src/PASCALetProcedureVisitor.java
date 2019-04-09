import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PASCALetProcedureVisitor extends PASCALetGrammarBaseVisitor<PASCALetObject> {

    private Map<String, PASCALetFunction> functions;

    PASCALetProcedureVisitor (Map<String, PASCALetFunction> functions) {
        this.functions = functions;
    }


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

        functions.put(procedureName, new PASCALetFunction(procParams, block));

        return PASCALetObject.VOID;


    }

}
