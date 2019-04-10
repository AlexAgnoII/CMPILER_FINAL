import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class PASCALetVisitor extends PASCALetGrammarBaseVisitor<PASCALetObject> {
    private BufferedReader bufferedReader;
    private PASCALetScope scope;
    private Map<String, PASCALetFunction> functions;
    private Map<String, PASCALetProcedure> procedures;


    public PASCALetVisitor (PASCALetScope scope, Map<String, PASCALetFunction> functions, Map<String, PASCALetProcedure> procedures) {
        bufferedReader = new BufferedReader( (new InputStreamReader((System.in))));
        this.scope = scope;
        this.functions = functions;
        this.procedures = procedures;
    }

    @Override //
    public PASCALetObject visitProgram (PASCALetGrammarParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    @Override //
    public PASCALetObject visitProgramHeading (PASCALetGrammarParser.ProgramHeadingContext ctx) {
        return super.visitProgramHeading(ctx);
    }

    @Override //
    public PASCALetObject visitIdentifier (PASCALetGrammarParser.IdentifierContext ctx) {
        return super.visitIdentifier(ctx);
    }

    @Override // not sure
    public PASCALetObject visitBlock (PASCALetGrammarParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override //
    public PASCALetObject visitConstantDefinition (PASCALetGrammarParser.ConstantDefinitionContext ctx) {

        String constantName = ctx.identifier().getText();
        PASCALetObject pObject = this.visit(ctx.constant());
        pObject.setConstant(true);
        scope.addConstant(constantName, pObject);

        System.out.println(scope.ConstantToString());

        return PASCALetObject.VOID;
    }

    @Override
    public PASCALetObject visitConstant (PASCALetGrammarParser.ConstantContext ctx) {
        PASCALetObject pObject = null;

        //Has a sign. MUST BE A NUMBER ONLY.
        if(ctx.unsignedInteger() != null) {
            int number = Integer.parseInt(ctx.unsignedInteger().getText());

                if(ctx.sign() != null) {
                    if(ctx.sign().getText().equalsIgnoreCase("-"))
                        number = -number;
                }

            pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_INT, number);
        }

        else if(ctx.string() != null) {
            String value = ctx.string().getText();
            value = value.replace("'", ""); //to make it a character.

            //char
            if(value.length() == 1) {
                pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_CHAR, value);
            }
            //string
            else {
                pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_STRING, value);
            }

        }

        return pObject;
    }

    @Override
    public PASCALetObject visitUnsignedInteger (PASCALetGrammarParser.UnsignedIntegerContext ctx) {
        return super.visitUnsignedInteger(ctx);
    }

    @Override
    public PASCALetObject visitSign (PASCALetGrammarParser.SignContext ctx) {
        return super.visitSign(ctx);
    }

    @Override
    public PASCALetObject visitBool (PASCALetGrammarParser.BoolContext ctx) {
        return super.visitBool(ctx);
    }

    @Override
    public PASCALetObject visitString (PASCALetGrammarParser.StringContext ctx) {
        return super.visitString(ctx);
    }

    @Override //Setting up variable declaration.
    public PASCALetObject visitVariableDeclarationPart (PASCALetGrammarParser.VariableDeclarationPartContext ctx) {
        List<PASCALetGrammarParser.VariableDeclarationContext> varDeclarationList = ctx.variableDeclaration();
        int varDecListSize = varDeclarationList.size();

        //Number of variable declaration does not define actual declaration.
        //Inside there are the true variable declarations in identifier list.
        for(int x = 0; x < varDecListSize; x++) {

            //Iterate over all identifiers.
            List<PASCALetGrammarParser.IdentifierContext> identifierList = varDeclarationList.get(x).identifierList().identifier();
            int identifierSize = identifierList.size();
            for(int i = 0; i < identifierSize; i++) {
                scope.addVariable(identifierList.get(i).getText(), varDeclarationList.get(x).type().getText());
            }
        }

        System.out.println(scope.VariablesToString());

        return PASCALetObject.VOID;
    }

    @Override //
    public PASCALetObject visitVariableDeclaration (PASCALetGrammarParser.VariableDeclarationContext ctx) {
        return super.visitVariableDeclaration(ctx);
    }

    @Override //
    public PASCALetObject visitIdentifierList (PASCALetGrammarParser.IdentifierListContext ctx) {
        return super.visitIdentifierList(ctx);
    }

    @Override
    public PASCALetObject visitType (PASCALetGrammarParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override // primitiveDataTypes
    public PASCALetObject visitTypeIdentifier (PASCALetGrammarParser.TypeIdentifierContext ctx) {
        return super.visitTypeIdentifier(ctx);
    }

    @Override
    public PASCALetObject visitArrayType (PASCALetGrammarParser.ArrayTypeContext ctx) {
        return super.visitArrayType(ctx);
    }

    @Override
    public  PASCALetObject visitSubroutineDeclarationPart (PASCALetGrammarParser.SubroutineDeclarationPartContext ctx) {
        return super.visitSubroutineDeclarationPart(ctx);
    }

    @Override
    public PASCALetObject visitSubRoutineDeclaration (PASCALetGrammarParser.SubRoutineDeclarationContext ctx) {
        return super.visitSubRoutineDeclaration(ctx);
    }

    @Override
    public PASCALetObject visitProcedureDeclaration (PASCALetGrammarParser.ProcedureDeclarationContext ctx) {
        return PASCALetObject.VOID;
    }

    @Override
    public PASCALetObject visitFunctionDeclaration (PASCALetGrammarParser.FunctionDeclarationContext ctx) {
        return PASCALetObject.VOID;
    }

    @Override
    public PASCALetObject visitFormalParameterlist (PASCALetGrammarParser.FormalParameterlistContext ctx) {
        /*List<PASCALetObject> list = new ArrayList<>();
        if (ctx.parameterGroup() != null) {
            for(PASCALetGrammarParser.ParameterGroupContext pg: ctx.parameterGroup(0). {

            }
        } */
        return super.visitFormalParameterlist(ctx);
    }

    @Override
    public PASCALetObject visitParameterGroup (PASCALetGrammarParser.ParameterGroupContext ctx) {
        return super.visitParameterGroup(ctx);
    }

    @Override
    public PASCALetObject visitResultType (PASCALetGrammarParser.ResultTypeContext ctx) {
        return super.visitResultType(ctx);
    }

    @Override
    public PASCALetObject visitStatementGroup (PASCALetGrammarParser.StatementGroupContext ctx) {
        return super.visitStatementGroup(ctx);
    }

    @Override
    public PASCALetObject visitStatements (PASCALetGrammarParser.StatementsContext ctx) {
        return super.visitStatements(ctx);
    }

    @Override
    public PASCALetObject visitStatement (PASCALetGrammarParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public PASCALetObject visitSimpleStatement (PASCALetGrammarParser.SimpleStatementContext ctx) {
        return super.visitSimpleStatement(ctx);
    }

    @Override
    public PASCALetObject visitReservedStatements (PASCALetGrammarParser.ReservedStatementsContext ctx) {
        return super.visitReservedStatements(ctx);
    }

    @Override
    public PASCALetObject visitWriteStatement (PASCALetGrammarParser.WriteStatementContext ctx) {
        return super.visitWriteStatement(ctx);
    }

    @Override
    public PASCALetObject visitReadStatement (PASCALetGrammarParser.ReadStatementContext ctx) {
        return super.visitReadStatement(ctx);
    }

    @Override
    public PASCALetObject visitStructuredStatement (PASCALetGrammarParser.StructuredStatementContext ctx) {
        return super.visitStructuredStatement(ctx);
    }

    @Override
    public PASCALetObject visitIfStatement (PASCALetGrammarParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    @Override
    public PASCALetObject visitForStatement (PASCALetGrammarParser.ForStatementContext ctx) {
        return super.visitForStatement(ctx);
    }

    @Override
    public PASCALetObject visitForList (PASCALetGrammarParser.ForListContext ctx) {
        return super.visitForList(ctx);
    }

    @Override
    public PASCALetObject visitInitialValue (PASCALetGrammarParser.InitialValueContext ctx) {
        return super.visitInitialValue(ctx);
    }

    @Override
    public PASCALetObject visitFinalValue (PASCALetGrammarParser.FinalValueContext ctx) {
        return super.visitFinalValue(ctx);
    }

    @Override
    public PASCALetObject visitAssignmentStatement (PASCALetGrammarParser.AssignmentStatementContext ctx) {
        return super.visitAssignmentStatement(ctx);
    }

    @Override
    public PASCALetObject visitVariable (PASCALetGrammarParser.VariableContext ctx) {
        return super.visitVariable(ctx);
    }

    @Override
    public PASCALetObject visitExpression (PASCALetGrammarParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public PASCALetObject visitSimpleExpression (PASCALetGrammarParser.SimpleExpressionContext ctx) {
        return super.visitSimpleExpression(ctx);
    }

    @Override
    public PASCALetObject visitTerm (PASCALetGrammarParser.TermContext ctx) {
        return super.visitTerm(ctx);
    }

    @Override
    public PASCALetObject visitAdditiveOperator (PASCALetGrammarParser.AdditiveOperatorContext ctx) {
        return super.visitAdditiveOperator(ctx);
    }

    @Override
    public PASCALetObject visitMultiplicativeOperator (PASCALetGrammarParser.MultiplicativeOperatorContext ctx) {
        return super.visitMultiplicativeOperator(ctx);
    }

    @Override
    public PASCALetObject visitRelationaloperator (PASCALetGrammarParser.RelationaloperatorContext ctx) {
        return super.visitRelationaloperator(ctx);
    }

    @Override
    public PASCALetObject visitSignedFactor (PASCALetGrammarParser.SignedFactorContext ctx) {
        return super.visitSignedFactor(ctx);
    }

    @Override
    public PASCALetObject visitFactor (PASCALetGrammarParser.FactorContext ctx) {
        return super.visitFactor(ctx);
    }

    @Override
    public  PASCALetObject visitUnsignedConstant (PASCALetGrammarParser.UnsignedConstantContext ctx) {
        return super.visitUnsignedConstant(ctx);
    }

    @Override
    public PASCALetObject visitFunctionDesignator (PASCALetGrammarParser.FunctionDesignatorContext ctx) {
        return super.visitFunctionDesignator(ctx);
    }

    @Override
    public PASCALetObject visitParameterList (PASCALetGrammarParser.ParameterListContext ctx) {
        return super.visitParameterList(ctx);
    }

    @Override
    public PASCALetObject visitActualParameter (PASCALetGrammarParser.ActualParameterContext ctx) {
        return super.visitActualParameter(ctx);
    }

    @Override
    public PASCALetObject visitProcedureStatement (PASCALetGrammarParser.ProcedureStatementContext ctx) {
        return super.visitProcedureStatement(ctx);
    }

    @Override
    public PASCALetObject visitEmptyStatement (PASCALetGrammarParser.EmptyStatementContext ctx) {
        return PASCALetObject.VOID;
    }
}
