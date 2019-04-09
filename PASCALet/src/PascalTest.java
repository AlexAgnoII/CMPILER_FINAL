import java.util.List;

public class PascalTest extends PASCALetGrammarBaseVisitor<PASCALetObject>  {



    @Override public PASCALetObject visitFunctionDeclaration(PASCALetGrammarParser.FunctionDeclarationContext ctx) {

        System.out.println("Function name: " + ctx.identifier().getText());


        //get identifiers
        List<PASCALetGrammarParser.ParameterGroupContext> params = ctx.formalParameterlist().parameterGroup();
        System.out.println(params.get(0).identifierList().identifier(0).getText());
        System.out.println(params.get(0).identifierList().identifier(1).getText());
        System.out.println(params.get(0).identifierList().identifier(2).getText());
        System.out.println(params.get(0).typeIdentifier().getText());


        return visitChildren(ctx);
    }
}
