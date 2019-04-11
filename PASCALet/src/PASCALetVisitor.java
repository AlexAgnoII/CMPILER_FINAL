import org.antlr.v4.runtime.ParserRuleContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
                this.visit(ctx.procedureStatement());

            }

            else if (ctx.reservedStatements() != null) {
               this.visit(ctx.reservedStatements());
            }
        }


        return PASCALetObject.VOID;
    }

    private void performAssignment(PASCALetGrammarParser.AssignmentStatementContext ctx) {

        String identifierName = ctx.variable().getText();

        PASCALetObject pObject = this.visit(ctx.expression());
        scope.assignVariable(identifierName, pObject, ctx);

        //for testing only.
        //System.out.println(scope.VariablesToString());
    }

    @Override
    public PASCALetObject visitReservedStatements (PASCALetGrammarParser.ReservedStatementsContext ctx) {
        return super.visitReservedStatements(ctx);
    }

    @Override
    public PASCALetObject visitWriteStatement (PASCALetGrammarParser.WriteStatementContext ctx) {

        //PASCALetObject pObject = this.visit();
        if(ctx.expression().size() == 1) {
            PASCALetObject pObject = this.visit(ctx.expression(0));

            Object valPrint = this.checkNullValueToPrint(pObject, ctx);

            if(ctx.WRITE() != null) {
                System.out.print(valPrint);
            }

            else if(ctx.WRITELN() != null) {
                System.out.println(valPrint);
            }

        }

        else if (ctx.expression().size() == 2) {
            PASCALetObject p1 = this.visit(ctx.expression(0));
            PASCALetObject p2 = this.visit(ctx.expression(1));

            Object valPrint1 = this.checkNullValueToPrint(p1, ctx);
            Object valPrint2 = this.checkNullValueToPrint(p2, ctx);

            if(ctx.WRITE() != null) {
                System.out.print(valPrint1 + "" + valPrint2);
            }

            else if(ctx.WRITELN() != null) {
                System.out.println(valPrint1 + "" + valPrint2);
            }
        }

        else {
            if(ctx.WRITE() != null) {
                System.out.print("");
            }

            else if(ctx.WRITELN() != null) {
                System.out.println("");
            }
        }

        return PASCALetObject.VOID;
    }

    private Object checkNullValueToPrint(PASCALetObject pObject, ParserRuleContext ctx) {

        if(pObject.isTypeInteger()) {
            if(pObject.getValue() != null) {
                return pObject.getValue();
            }
            else {
                return 0;
            }

        }

        else if (pObject.isTypeBoolean()) {
            if(pObject.getValue() != null) {
                return pObject.getValue();
            }
            else {
                return false;
            }
        }

        else if (pObject.isTypeString() || pObject.isTypeChar()) {
            if(pObject.getValue() != null) {
                return pObject.getValue();
            }
            else {
                return "";
            }
        }

        else {
            String errMsg = "Error checking print value type, did not find any of type.";
            throw new PASCALetException(ctx, errMsg);
        }
    }

    @Override
    public PASCALetObject visitReadStatement (PASCALetGrammarParser.ReadStatementContext ctx) {
        boolean isEmpty = false;

        //TODO finish readln later.
        try {
            String temp;
            temp = ctx.variable().getText();
        }catch(Exception e) {
            isEmpty = true;
        }

        //Scan, but do nothing.
        if(isEmpty) {
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
        }

        //scan and return an object.
        else {
            Scanner sc = new Scanner(System.in);
        }


        return PASCALetObject.VOID;
    }

    @Override //TODO if if or for wouldnt work, remove this.
    public PASCALetObject visitStructuredStatement (PASCALetGrammarParser.StructuredStatementContext ctx) {
        return super.visitStructuredStatement(ctx);
    }

    @Override
    public PASCALetObject visitIfStatement (PASCALetGrammarParser.IfStatementContext ctx) {

        //statement 0 = statement of IF
        //statement 1 = statement of ELSE
        if(ctx.IF() != null) {
            PASCALetObject pObject = this.visit(ctx.expression());

            //if statement starts here.
            if(pObject.isTypeBoolean()) {

                boolean exp = pObject.asBoolean();

                if(exp) {
                    this.visit(ctx.statement(0));
                }

                //if else exists and the expression is false, do this.
                else if (ctx.ELSE() != null) {
                    this.visit(ctx.statement(1));
                }
            }

            //not boolean, so throw an error.
            else {
                String errMsg = "Invalid operation. Cannot have \"" + pObject.getTypeAsString() + "\" as type in the expression in conditional statements: ";
                throw new PASCALetException(ctx, errMsg);
            }
        }
        else {
            String errMsg = "Ifstatement node error, if was not found: ";
            throw new PASCALetException(ctx, errMsg);
        }

        return PASCALetObject.VOID;
    }

    public PASCALetObject visitForStatement (PASCALetGrammarParser.ForStatementContext ctx) {

        if(ctx.FOR() != null) {
            String variableIndexName = ctx.identifier().getText(); //must not be used again inside loop.
            PASCALetObject pObjectInitialVal = this.visit(ctx.forList().initialValue());
            PASCALetObject pObjectFinalVal = this.visit(ctx.forList().finalValue());

            if(pObjectInitialVal.isTypeInteger()) {
                scope.assignVariable(variableIndexName, pObjectInitialVal, ctx); //initializing the variable.

                int initialValue = pObjectInitialVal.asInteger();
                int finalValue = pObjectFinalVal.asInteger();

                //TODO need to check if the loop variable is being used as assignment.
                for(int i = initialValue; i <= finalValue; i++) {
                    //perform the statements.
                    this.visit(ctx.statement());

                    //increment variable index.
                    PASCALetObject pOb = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_INT, i+1);
                    scope.assignVariable(variableIndexName, pOb, ctx);
                }
            }

            //one of them is not integer, throw error.
            else {
                String errMsg = "Invalid evaluation. Initial and final value must be of type integer: ";
                throw new PASCALetException(ctx, errMsg);

            }
        }

        else {
            String errMsg = "Forstatement node error, for was not found: ";
            throw new PASCALetException(ctx, errMsg);
        }

        return PASCALetObject.VOID;
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
            this.checkIfVariableHasValidValue(leftHandSide.getValue(), ctx);
            this.checkIfVariableHasValidValue(rightHandSide.getValue(), ctx);

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

        if(ctx.relationaloperator().EQUALS() != null) {
            return lhValue.equals(rhValue);
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
            return lhValue.equals(rhValue) || lhValue.compareTo(rhValue) > 0;

        }

        else if(ctx.relationaloperator().LESSTHANOREQUALS() != null) {
            return lhValue.equals(rhValue) || lhValue.compareTo(rhValue) < 0;

        }

        String msg = "Weird symbol found at : ";
        throw new PASCALetException(ctx, msg);

    }

    @Override
    public PASCALetObject visitSimpleExpression (PASCALetGrammarParser.SimpleExpressionContext ctx) {
        PASCALetObject pObject = null;

        if(ctx.additiveOperator() != null && ctx.simpleExpression() != null) {
            boolean plusPresent = ctx.additiveOperator().PLUS() != null;
            boolean minusPresent = ctx.additiveOperator().MINUS() != null;

            PASCALetObject leftHandSide = this.visit(ctx.term());
            PASCALetObject rightHandSide = this.visit(ctx.simpleExpression());
            this.checkIfVariableHasValidValue(leftHandSide.getValue(), ctx);
            this.checkIfVariableHasValidValue(rightHandSide.getValue(), ctx);

            //must be integers only.
            if(plusPresent || minusPresent) {

                if(leftHandSide.isTypeInteger() && rightHandSide.isTypeInteger()) {
                    int lhsValue = leftHandSide.asInteger();
                    int rhsValue = rightHandSide.asInteger();
                    int result = 0;

                    if(plusPresent) {
                        result = lhsValue + rhsValue;
                    }

                    else if (minusPresent) {
                        result = lhsValue - rhsValue;
                    }

                    else {
                        String errMgs = "Error SimpleExpression, missing operator +, -: ";
                        throw new PASCALetException(ctx, errMgs);
                    }

                    pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_INT, result);
                }

                else {
                    String errMsg = "Invalid evaluation. Both values must be of type integer: ";
                    throw new PASCALetException(ctx, errMsg);
                }
            }

            //This must be a relational operator, boolean values only.
            else  {
                if(leftHandSide.isTypeBoolean() && rightHandSide.isTypeBoolean()) {

                    if(ctx.additiveOperator().OR() != null) {
                        boolean lhsValue = leftHandSide.asBoolean();
                        boolean rhsValue = rightHandSide.asBoolean();
                        boolean result = lhsValue || rhsValue;

                        pObject = new PASCALetObject(PASCALetObject.PASCALET_OBJECT_BOOLEAN, result);
                    }

                    else {
                        String errMsg = "SimpleExpression error, missing OR operator: ";
                        throw new PASCALetException(ctx, errMsg);
                    }
                }

                //throw error.
                else {
                    String errMsg = "Invalid evaluation on \"OR\". Both values must have type boolean: ";
                    throw new PASCALetException(ctx, errMsg);

                }
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

                    String errorMsg = "Invalid operation on \"" + symbol  + "\". both values must have type integer: ";
                    throw new PASCALetException(ctx, errorMsg);
                }
            }

            //its boolean only.
            else {
                if(leftHandSide.isTypeBoolean() && rightHandSide.isTypeBoolean()) {
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

                //not both boolean, throw error.
                else {
                    String errMsg = "Invalid operation on \"AND\". Both values must have type boolean: ";
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

        //it is a variable
        if(ctx.variable() != null) {
            String variableName = ctx.variable().getText();
            pObject = scope.getVariableValue(variableName, ctx);
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
                word = word.replace("'", "");
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

            if(ctx.NOT() != null) {
                if(pObject.isTypeBoolean()) {
                    boolean val = pObject.asBoolean();
                    val = !val;
                    pObject.setValue(val);
                }

                //throw an error if its not a bolean.
                else {
                    String errMsg = "Invalid operation \"NOT\" on non-boolean type: ";
                    throw new PASCALetException(ctx, errMsg);
                }
            }
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
        int paramSize = 0;
        List<PASCALetGrammarParser.ActualParameterContext> actualParams = null;

        if(ctx.parameterList() != null) {
            paramSize = ctx.parameterList().actualParameter().size();
            actualParams = ctx.parameterList().actualParameter();
        }

        String procedureIdentifier = ctx.identifier().getText();
        String procecureCallname = procedureIdentifier + paramSize;
        procecureCallname = procecureCallname.toLowerCase(); //CASE INSENSITIVE

        if(this.checkProcedureName(procedureIdentifier, paramSize, ctx )) {}

        //perform procedure call.
        else if(procedures.containsKey(procecureCallname)) {
            this.procedures.get(procecureCallname).invoke(actualParams, functions, procedures, scope, ctx);
        }

        //no such thing as this procedure.
        else {
            String msgErr = "Invalid evaluation. Procedure call \"" + ctx.identifier().getText()  + "\" does not exist / was never declared: ";
            throw new PASCALetException(ctx, msgErr);
        }

        return PASCALetObject.VOID;
    }

    private boolean checkProcedureName(String procedureIdentifier, int paramSize, ParserRuleContext ctx) {
        procedureIdentifier = procedureIdentifier.toLowerCase();

        //check in variables
        if(scope.isThisAVariable(procedureIdentifier)) {
            String errMsg = "Invalid evaluation. Identifier \"" + procedureIdentifier + "\" is a variable, not a procedure: ";
            throw new PASCALetException(ctx, errMsg);
        }
        //check in constants
        else if(scope.isThisAConstant(procedureIdentifier)) { //if exist, throw.
            String errMsg = "Invalid evaluation. Identifier \"" + procedureIdentifier + "\" is a constant, not a procedure: ";
            throw new PASCALetException(ctx, errMsg);
        }

        //check in functions
        else if (functions.containsKey(procedureIdentifier + paramSize)) {
            String errMsg = "Invalid evaluation. Identifier \"" + procedureIdentifier + "\" already in use as a function identifier: ";
            throw new PASCALetException(ctx, errMsg);
        }

        return false;
    }

    private boolean checkFuncionName(String functionIdentifier, int paramSize, ParserRuleContext ctx) {
        functionIdentifier = functionIdentifier.toLowerCase();

        //check in variables
        if(scope.isThisAVariable(functionIdentifier)) {
            String errMsg = "Invalid evaluation. Identifier \"" + functionIdentifier + "\" is a variable, not a function: ";
            throw new PASCALetException(ctx, errMsg);
        }
        //check in constants
        else if(scope.isThisAConstant(functionIdentifier)) { //if exist, throw.
            String errMsg = "Invalid evaluation. Identifier \"" + functionIdentifier + "\" is a constant, not a function: ";
            throw new PASCALetException(ctx, errMsg);
        }

        //check in functions
        else if (procedures.containsKey(functionIdentifier + paramSize)) {
            String errMsg = "Invalid evaluation. Identifier \"" + functionIdentifier + "\" already in use as a procedure identifier: ";
            throw new PASCALetException(ctx, errMsg);
        }

        return false;
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
