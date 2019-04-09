import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class PASCALetFunctionVisitor extends PASCALetGrammarBaseVisitor<PASCALetObject> {

    // Function Map here

    // PASCALetFunctionVisitor constructor

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

       // function.put..

       return PASCALetObject.VOID;
   }
}
