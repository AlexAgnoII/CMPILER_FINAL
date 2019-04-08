// Generated from D:/Programming/Java_relateed/CMPILER_FINAL/PASCALet\PASCALetGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PASCALetGrammarParser}.
 */
public interface PASCALetGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PASCALetGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PASCALetGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#programHeading}.
	 * @param ctx the parse tree
	 */
	void enterProgramHeading(PASCALetGrammarParser.ProgramHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#programHeading}.
	 * @param ctx the parse tree
	 */
	void exitProgramHeading(PASCALetGrammarParser.ProgramHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(PASCALetGrammarParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(PASCALetGrammarParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PASCALetGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PASCALetGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#constantDefinitionPart}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefinitionPart(PASCALetGrammarParser.ConstantDefinitionPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#constantDefinitionPart}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefinitionPart(PASCALetGrammarParser.ConstantDefinitionPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#constantDefinition}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefinition(PASCALetGrammarParser.ConstantDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#constantDefinition}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefinition(PASCALetGrammarParser.ConstantDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(PASCALetGrammarParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(PASCALetGrammarParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#unsignedInteger}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedInteger(PASCALetGrammarParser.UnsignedIntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#unsignedInteger}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedInteger(PASCALetGrammarParser.UnsignedIntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(PASCALetGrammarParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(PASCALetGrammarParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(PASCALetGrammarParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(PASCALetGrammarParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(PASCALetGrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(PASCALetGrammarParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#variableDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationPart(PASCALetGrammarParser.VariableDeclarationPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#variableDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationPart(PASCALetGrammarParser.VariableDeclarationPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(PASCALetGrammarParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(PASCALetGrammarParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(PASCALetGrammarParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(PASCALetGrammarParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PASCALetGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PASCALetGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(PASCALetGrammarParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(PASCALetGrammarParser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(PASCALetGrammarParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(PASCALetGrammarParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#subroutineDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineDeclarationPart(PASCALetGrammarParser.SubroutineDeclarationPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#subroutineDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineDeclarationPart(PASCALetGrammarParser.SubroutineDeclarationPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#subRoutineDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSubRoutineDeclaration(PASCALetGrammarParser.SubRoutineDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#subRoutineDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSubRoutineDeclaration(PASCALetGrammarParser.SubRoutineDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureDeclaration(PASCALetGrammarParser.ProcedureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureDeclaration(PASCALetGrammarParser.ProcedureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(PASCALetGrammarParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(PASCALetGrammarParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#formalParameterlist}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterlist(PASCALetGrammarParser.FormalParameterlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#formalParameterlist}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterlist(PASCALetGrammarParser.FormalParameterlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#parameterGroup}.
	 * @param ctx the parse tree
	 */
	void enterParameterGroup(PASCALetGrammarParser.ParameterGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#parameterGroup}.
	 * @param ctx the parse tree
	 */
	void exitParameterGroup(PASCALetGrammarParser.ParameterGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#resultType}.
	 * @param ctx the parse tree
	 */
	void enterResultType(PASCALetGrammarParser.ResultTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#resultType}.
	 * @param ctx the parse tree
	 */
	void exitResultType(PASCALetGrammarParser.ResultTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#statementGroup}.
	 * @param ctx the parse tree
	 */
	void enterStatementGroup(PASCALetGrammarParser.StatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#statementGroup}.
	 * @param ctx the parse tree
	 */
	void exitStatementGroup(PASCALetGrammarParser.StatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(PASCALetGrammarParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(PASCALetGrammarParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PASCALetGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PASCALetGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(PASCALetGrammarParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(PASCALetGrammarParser.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#reservedStatements}.
	 * @param ctx the parse tree
	 */
	void enterReservedStatements(PASCALetGrammarParser.ReservedStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#reservedStatements}.
	 * @param ctx the parse tree
	 */
	void exitReservedStatements(PASCALetGrammarParser.ReservedStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(PASCALetGrammarParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(PASCALetGrammarParser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(PASCALetGrammarParser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(PASCALetGrammarParser.ReadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#structuredStatement}.
	 * @param ctx the parse tree
	 */
	void enterStructuredStatement(PASCALetGrammarParser.StructuredStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#structuredStatement}.
	 * @param ctx the parse tree
	 */
	void exitStructuredStatement(PASCALetGrammarParser.StructuredStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(PASCALetGrammarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(PASCALetGrammarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(PASCALetGrammarParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(PASCALetGrammarParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#forList}.
	 * @param ctx the parse tree
	 */
	void enterForList(PASCALetGrammarParser.ForListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#forList}.
	 * @param ctx the parse tree
	 */
	void exitForList(PASCALetGrammarParser.ForListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void enterInitialValue(PASCALetGrammarParser.InitialValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void exitInitialValue(PASCALetGrammarParser.InitialValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#finalValue}.
	 * @param ctx the parse tree
	 */
	void enterFinalValue(PASCALetGrammarParser.FinalValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#finalValue}.
	 * @param ctx the parse tree
	 */
	void exitFinalValue(PASCALetGrammarParser.FinalValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(PASCALetGrammarParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(PASCALetGrammarParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(PASCALetGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(PASCALetGrammarParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PASCALetGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PASCALetGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(PASCALetGrammarParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(PASCALetGrammarParser.SimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(PASCALetGrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(PASCALetGrammarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#additiveOperator}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveOperator(PASCALetGrammarParser.AdditiveOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#additiveOperator}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveOperator(PASCALetGrammarParser.AdditiveOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeOperator(PASCALetGrammarParser.MultiplicativeOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeOperator(PASCALetGrammarParser.MultiplicativeOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#relationaloperator}.
	 * @param ctx the parse tree
	 */
	void enterRelationaloperator(PASCALetGrammarParser.RelationaloperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#relationaloperator}.
	 * @param ctx the parse tree
	 */
	void exitRelationaloperator(PASCALetGrammarParser.RelationaloperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#signedFactor}.
	 * @param ctx the parse tree
	 */
	void enterSignedFactor(PASCALetGrammarParser.SignedFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#signedFactor}.
	 * @param ctx the parse tree
	 */
	void exitSignedFactor(PASCALetGrammarParser.SignedFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(PASCALetGrammarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(PASCALetGrammarParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#unsignedConstant}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedConstant(PASCALetGrammarParser.UnsignedConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#unsignedConstant}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedConstant(PASCALetGrammarParser.UnsignedConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#functionDesignator}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDesignator(PASCALetGrammarParser.FunctionDesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#functionDesignator}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDesignator(PASCALetGrammarParser.FunctionDesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(PASCALetGrammarParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(PASCALetGrammarParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#actualParameter}.
	 * @param ctx the parse tree
	 */
	void enterActualParameter(PASCALetGrammarParser.ActualParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#actualParameter}.
	 * @param ctx the parse tree
	 */
	void exitActualParameter(PASCALetGrammarParser.ActualParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#procedureStatement}.
	 * @param ctx the parse tree
	 */
	void enterProcedureStatement(PASCALetGrammarParser.ProcedureStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#procedureStatement}.
	 * @param ctx the parse tree
	 */
	void exitProcedureStatement(PASCALetGrammarParser.ProcedureStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALetGrammarParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(PASCALetGrammarParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALetGrammarParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(PASCALetGrammarParser.EmptyStatementContext ctx);
}