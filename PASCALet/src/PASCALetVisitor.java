import org.antlr.v4.runtime.ParserRuleContext;

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
        scope.addConstant(constantName, pObject, ctx);

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
            value = value.replace("'", "");

            pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_STRING, value);

        }

        return pObject;
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
                scope.addVariable(identifierList.get(i).getText(), varDeclarationList.get(x).type().getText(), ctx);
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
    public PASCALetObject visitSimpleStatement (PASCALetGrammarParser.SimpleStatementContext ctx) {

        if(ctx.emptyStatement() == null) {


            if(ctx.assignmentStatement() != null) {
                this.performAssignment(ctx.assignmentStatement());
            }

            //TODO: Implement procedure calls
            else if (ctx.procedureStatement() != null) {
                this.performProceedureCall(ctx.procedureStatement());

            }

            //TODO: Implement reserveStatements operators.
            else if (ctx.reservedStatements() != null) {
               this.performRservedStatement(ctx.reservedStatements());

            }
        }


        return PASCALetObject.VOID;
    }

    private void performAssignment(PASCALetGrammarParser.AssignmentStatementContext ctx) {

        String identifierName = ctx.variable().getText();
        PASCALetObject pObject = this.visit(ctx.expression());
        scope.assignVariable(identifierName, pObject, ctx);

        //for testing only.
        System.out.println(scope.VariablesToString());
    }

    private void performProceedureCall(PASCALetGrammarParser.ProcedureStatementContext procedureStatementContext) {

    }

    private void performRservedStatement(PASCALetGrammarParser.ReservedStatementsContext reservedStatementsContext) {

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
        System.out.println("STRUCTURED HERE");

        return PASCALetObject.VOID;
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

    @Override //MUST BE NUMBERS ONLY
    public PASCALetObject visitExpression (PASCALetGrammarParser.ExpressionContext ctx) {
        PASCALetObject pObject = null;


        if(ctx.relationaloperator() != null && ctx.expression() != null) {
            PASCALetObject leftHandSide = this.visit(ctx.simpleExpression());
            PASCALetObject rightHandSide = this.visit(ctx.expression());
            boolean result = false;

            if(leftHandSide.isTypeInteger() && rightHandSide.isTypeInteger()) {
                result = this.relationalIntegers(leftHandSide.asInteger(), rightHandSide.asInteger(), ctx);
            }

            else if(leftHandSide.isTypeString() && rightHandSide.isTypeString()) {
                result = this.relationalStrings(leftHandSide.asString(), rightHandSide.asString(), ctx);
            }

            //type mismatch, throw.
            else {
                String errorMsg = "Type mismatch / invalid type for evaluation: ";
                throw new PASCALetException(ctx, errorMsg);

            }

            System.out.println(result);

            //pObject in the end becomes a boolean value.
            pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_BOOLEAN, result);
        }

        //no relational, just do simple expression.
        else {
            pObject =  this.visit(ctx.simpleExpression());
        }

        return pObject;
    }

    private boolean relationalIntegers(int lhValue, int rhValue, PASCALetGrammarParser.ExpressionContext ctx) {

        if(ctx.relationaloperator().EQUALS() != null) {
            return lhValue == rhValue;
        }

        else if(ctx.relationaloperator().GREATERTHAN() != null) {
            return lhValue > rhValue;

        }
        else if(ctx.relationaloperator().GREATERTHANOREQUALS() != null) {
            return lhValue >= rhValue;

        }
        else if(ctx.relationaloperator().LESSTHAN() != null) {
            return lhValue < rhValue;

        }
        else if(ctx.relationaloperator().LESSTHANOREQUALS() != null) {
            return lhValue <= rhValue;

        }
        else if(ctx.relationaloperator().NOTEQUALS() != null) {
            return lhValue != rhValue;
        }

        String msg = "Weird symbol found at : ";
        throw new PASCALetException(ctx, msg);
    }

    private boolean relationalStrings(String lhValue, String rhValue, PASCALetGrammarParser.ExpressionContext ctx) {
        lhValue = lhValue.toLowerCase();
        rhValue = rhValue.toLowerCase();

        if(ctx.relationaloperator().EQUALS() != null) {
            return lhValue.equalsIgnoreCase(rhValue);
        }

        else if(ctx.relationaloperator().GREATERTHAN() != null) {
            return lhValue.compareTo(rhValue) > 0;

        }

        else if(ctx.relationaloperator().LESSTHAN() != null) {
            return lhValue.compareTo(rhValue) < 0;

        }

        else if(ctx.relationaloperator().NOTEQUALS() != null) {
            return !lhValue.equalsIgnoreCase(rhValue);
        }

        else if(ctx.relationaloperator().GREATERTHANOREQUALS() != null) {
            return lhValue.equalsIgnoreCase(rhValue) || lhValue.compareTo(rhValue) > 0;

        }

        else if(ctx.relationaloperator().LESSTHANOREQUALS() != null) {
            return lhValue.equalsIgnoreCase(rhValue) || lhValue.compareTo(rhValue) < 0;

        }

        String msg = "Weird symbol found at : ";
        throw new PASCALetException(ctx, msg);

    }

    @Override
    public PASCALetObject visitSimpleExpression (PASCALetGrammarParser.SimpleExpressionContext ctx) {
        PASCALetObject pObject = null;

        //TODO: Implement additive operators.
        if(ctx.additiveOperator() != null && ctx.simpleExpression() != null) {
            boolean plusPresent = ctx.additiveOperator().PLUS() != null;
            boolean minusPresent = ctx.additiveOperator().MINUS() != null;

            //must be integers only.
            if(plusPresent || minusPresent) {

                if(plusPresent) {

                }

                else if (minusPresent) {

                }

            }

            //This must be a relational operator, boolean values only.
            else  {

            }

        }

        //no operator, just return something inside the term.
        else {
            pObject = this.visit(ctx.term());
        }

        return pObject; //return a string of EXPRESSION.
    }

    @Override
    public PASCALetObject visitTerm (PASCALetGrammarParser.TermContext ctx) {
        PASCALetObject pObject = null;

        //TODO: Implement mult operators.
        if(ctx.multiplicativeOperator() != null && ctx.term() != null) {

            boolean divPresent = ctx.multiplicativeOperator().SLASH() != null;
            boolean multPresent = ctx.multiplicativeOperator().STAR() != null;
            boolean modPresent = ctx.multiplicativeOperator().MOD() != null;

            PASCALetObject leftHandSide = this.visit(ctx.signedFactor());
            PASCALetObject rightHandSide = this.visit(ctx.term());
            this.checkIfVariableHasValidValue(leftHandSide.getValue(), ctx);
            this.checkIfVariableHasValidValue(rightHandSide.getValue(), ctx);

            //integers only.
            if(divPresent || multPresent || modPresent) {
                if(leftHandSide.isTypeInteger() && rightHandSide.isTypeInteger()) {
                    int lhsValue = leftHandSide.asInteger();
                    int rhsValue = rightHandSide.asInteger();
                    int result = 0;

                    if(divPresent) {
                        if(rhsValue == 0) {
                            this.divisionByZeroError(ctx);
                        }

                        result = lhsValue / rhsValue;
                    }
                    else if(modPresent) {
                        if(rhsValue == 0) {
                            this.divisionByZeroError(ctx);
                        }

                        result = lhsValue / rhsValue;
                    }
                    else if(multPresent) {
                        result = lhsValue * rhsValue;
                    }
                    else {
                        String errMsg = "Term node error, expecting *, /, % operator.";
                        throw new PASCALetException(ctx, errMsg);
                    }

                    pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_INT, result);
                }

                else { //trhow error because one of them or BOTH is NOT an integer.
                    String symbol = "";
                    if(divPresent) {
                        symbol = "/";
                    }
                    else if(multPresent) {
                        symbol = "*";
                    }

                    else if (modPresent) {
                        symbol = "%";
                    }

                    String errorMsg = "Invalid operation \"" + symbol  + "\" both values must have type integer: ";
                    throw new PASCALetException(ctx, errorMsg);
                }
            }

            //its boolean only.
            else {
                boolean lhsValue = leftHandSide.asBoolean();
                boolean rhsValue = rightHandSide.asBoolean();

                if(ctx.multiplicativeOperator().AND() != null) {
                    boolean result = lhsValue && rhsValue;

                    pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_BOOLEAN, result);
                }
                else {
                    String errMsg = "Term node error, missing operator AND: ";
                    throw new PASCALetException(ctx, errMsg);
                }
            }

        }

        else {
            pObject = this.visit(ctx.signedFactor());
        }



        return pObject;
    }

    @Override
    public PASCALetObject visitSignedFactor (PASCALetGrammarParser.SignedFactorContext ctx) {
        PASCALetObject pObject;

        pObject = this.visit(ctx.factor());

        //if + or - is present, it should ONLY be an integer or a variable containing int.
        if(ctx.PLUS() != null || ctx.MINUS() != null) {

            if(pObject.isTypeInteger()) {
                int number = pObject.asInteger();

                if(ctx.MINUS() != null) {
                    number = -number;
                }

                pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_INT, number);
            }

            else {
                String errorMsg = "PASCALet object cannot have + / - symbols: ";
                throw new PASCALetException(ctx, errorMsg);
            }
        }

        return pObject;
    }

    @Override
    public PASCALetObject visitFactor (PASCALetGrammarParser.FactorContext ctx) {
        PASCALetObject pObject = null;

        //todo forgot to implement NOT.
        //it is a variable
        if(ctx.variable() != null) {
            String variableName = ctx.variable().getText();
            pObject = scope.getVariableValue(variableName, ctx);

            //TODO need to change this, null error must show when doing evaluation, but assignment is okay.
            //if nothing is inside, lets throw an error.
            /* COmmented out for now.
            if(pObject.getValue() == null) {
                String errorMsg = "Invalid evaluation. Variable \"" + variableName  + "\" has a null value: ";
                throw new PASCALetException(ctx, errorMsg);
            }*/
        }

        //its another expression
        else if (ctx.expression() != null) {
            pObject = this.visit(ctx.expression());
        }

        //TODO: To implement function designator.
        else if (ctx.functionDesignator() != null){

        }

        //a constant value. //TODO still missing char constant.....
        else if(ctx.unsignedConstant() != null) {

            //it is a string.
            if(ctx.unsignedConstant().string() != null) {
                String word = ctx.unsignedConstant().string().getText();
                pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_STRING, word);
            }

            //its an integer
            else if (ctx.unsignedConstant().unsignedInteger() != null) {
                int number = Integer.parseInt(ctx.unsignedConstant().unsignedInteger().getText());
                pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_INT, number);
            }

            else {
                String errorMsg = "Error factor node, cannot identify this random data (not int or string): ";
                throw new PASCALetException(ctx, errorMsg);
            }
        }

        //itself
        else if (ctx.factor() != null) {
            pObject = this.visit(ctx.factor());
        }

        //boolean
        else if (ctx.bool() != null) {
            String boolValue = ctx.bool().getText();

            if(boolValue.equalsIgnoreCase("true")) {
                pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_BOOLEAN, true);
            }

            else if(boolValue.equalsIgnoreCase("false")) {
                pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_BOOLEAN, false);
            }

            else {
                String errorMsg = "Factor node error, its not true or false, what is this: ";
                throw new PASCALetException(ctx, errorMsg);
            }
        }

        else {
            String errorMsg = "Error visiting factor node: ";
            throw new PASCALetException(ctx, errorMsg);
        }


        return pObject;
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

    //throw an error if you performed evaluation with a null.
    private void checkIfVariableHasValidValue(Object value, ParserRuleContext ctx) {

        if(value == null) {
            String errorMsg = "Invalid evaluation. Variable/s is/are null, aborting operation: ";
            throw new PASCALetException(ctx, errorMsg);
        }
    }

    private void divisionByZeroError(ParserRuleContext ctx) {
        String errorMsg = "Invalid operation. Division by zero: ";
        throw new PASCALetException(ctx, errorMsg);

    }
}
