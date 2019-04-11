import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PASCALetProcedureVisitor extends PASCALetGrammarBaseVisitor<PASCALetObject> {

    private Map<String, PASCALetProcedure> procedures;

    PASCALetProcedureVisitor (Map<String, PASCALetProcedure> procedures) {
        this.procedures = procedures;
    }

    @Override
    public PASCALetObject visitProcedureDeclaration (PASCALetGrammarParser.ProcedureDeclarationContext ctx) {
        List<PASCALetGrammarParser.ParameterGroupContext> procParams = null;
        int paramCount = 0;

        try {
            procParams = ctx.formalParameterlist().parameterGroup();

        } catch (Exception e)  {}

        //if null, it means its a procedure with no parenthesis: procedure something;
        if (procParams == null) {
            procParams = new ArrayList<PASCALetGrammarParser.ParameterGroupContext>();
        }
        //if size 0, it means its a procedure with empty parameters: procedure doSomething();
        else if(procParams.size() == 0){
            procParams = new ArrayList<PASCALetGrammarParser.ParameterGroupContext>(); //not needed pero just in case.
        }
        else if(procParams.size() >= 1) {
            paramCount = this.countParameters(procParams);
        }

        String procedureName = ctx.identifier().getText() + paramCount;
        procedureName = procedureName.toLowerCase(); //CASE INSENSITIVE
        ParseTree block = ctx.block();

        //testing purposes
       /*
       System.out.println("Procedure name: " + procedureName);
       for(int i = 0; i < procParams.size(); i++) {
           System.out.print(procParams.get(i).identifierList().getText());
           System.out.println(" Type: " + procParams.get(i).typeIdentifier().getText());
       }*/
        //System.out.println("Procedure Parameter size: " + paramCount);

        System.out.println(procedureName);
        procedures.put(procedureName, new PASCALetProcedure(procParams, paramCount, block));

        return PASCALetObject.VOID;
    }

    //counts parameter of procedure
    private int countParameters(List<PASCALetGrammarParser.ParameterGroupContext> param) {
        int paramCount = 0;

        //outer layer, groups of integer on type t.
        for(int x = 0; x < param.size(); x++) {

            List<PASCALetGrammarParser.IdentifierContext> identifiers = param.get(x).identifierList().identifier();
            //inner layer, individual parameters of the function declaration.
            for(int y = 0; y < identifiers.size(); y++) {
                paramCount++;
            }
        }

        return paramCount;
    }

}
