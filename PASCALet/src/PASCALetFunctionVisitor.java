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

       //Both will always be 0 of size. Meaning NO parameters.
       //if null, it means its a function without parenthesis: function doSomething.
       if (funcParams == null) {
           funcParams = new ArrayList<PASCALetGrammarParser.ParameterGroupContext>();
       }
       //if size 0, it means its a function without parameters: function doSomething()
       else if(funcParams.size() == 0){
           funcParams = new ArrayList<PASCALetGrammarParser.ParameterGroupContext>(); //not needed pero just in case.
       }

       String functionName = ctx.identifier().getText() + funcParams.size();
       ParseTree block = ctx.block();
       String returnType = ctx.resultType().getText();

       //testing purposes
       /*
       System.out.println(functionName);
       for(int i = 0; i < funcParams.size(); i++) {
           System.out.print(funcParams.get(i).identifierList().getText());
           System.out.println(" Type: " + funcParams.get(i).typeIdentifier().getText());
       }
       System.out.println("Return type: " + returnType);*/

       this.functions.put(functionName, new PASCALetFunction(funcParams, block, returnType));

       return PASCALetObject.VOID;
   }
}
