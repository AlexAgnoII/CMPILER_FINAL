import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class PASCALetFunctionVisitor extends PASCALetGrammarBaseVisitor<PASCALetObject> {

    private Map<String, PASCALetFunction> functions;

    PASCALetFunctionVisitor (Map<String, PASCALetFunction> functions) {
        this.functions = functions;
    }

   @Override
    public PASCALetObject visitFunctionDeclaration (PASCALetGrammarParser.FunctionDeclarationContext ctx) {
       List<PASCALetGrammarParser.ParameterGroupContext> funcParams = null;

       try {
           funcParams = ctx.formalParameterlist().parameterGroup();
           // formalParameterListContext > parameterGroupContext

       } catch (Exception e) {}

       if (funcParams == null) {
           funcParams = new ArrayList<>();
       }

       String functionName = ctx.identifier().getText() + funcParams.size();
       ParseTree block = ctx.block();

       functions.put(functionName, new PASCALetFunction(funcParams, block));

       return PASCALetObject.VOID;
   }
}
