// Generated from D:/Programming/Java_relateed/CMPILER_FINAL/PASCALet\PASCALetGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PASCALetGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PASCALetGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PASCALetGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#programHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramHeading(PASCALetGrammarParser.ProgramHeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(PASCALetGrammarParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PASCALetGrammarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#constantDefinitionPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDefinitionPart(PASCALetGrammarParser.ConstantDefinitionPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#constantDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDefinition(PASCALetGrammarParser.ConstantDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(PASCALetGrammarParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#unsignedInteger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedInteger(PASCALetGrammarParser.UnsignedIntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(PASCALetGrammarParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(PASCALetGrammarParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(PASCALetGrammarParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#variableDeclarationPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationPart(PASCALetGrammarParser.VariableDeclarationPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(PASCALetGrammarParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(PASCALetGrammarParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(PASCALetGrammarParser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#subroutineDeclarationPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubroutineDeclarationPart(PASCALetGrammarParser.SubroutineDeclarationPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#subRoutineDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubRoutineDeclaration(PASCALetGrammarParser.SubRoutineDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDeclaration(PASCALetGrammarParser.ProcedureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(PASCALetGrammarParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#formalParameterlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterlist(PASCALetGrammarParser.FormalParameterlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#parameterGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterGroup(PASCALetGrammarParser.ParameterGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#resultType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultType(PASCALetGrammarParser.ResultTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#statementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementGroup(PASCALetGrammarParser.StatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(PASCALetGrammarParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PASCALetGrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(PASCALetGrammarParser.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#reservedStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReservedStatements(PASCALetGrammarParser.ReservedStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStatement(PASCALetGrammarParser.WriteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStatement(PASCALetGrammarParser.ReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#structuredStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructuredStatement(PASCALetGrammarParser.StructuredStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PASCALetGrammarParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(PASCALetGrammarParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#forList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForList(PASCALetGrammarParser.ForListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#initialValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialValue(PASCALetGrammarParser.InitialValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#finalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalValue(PASCALetGrammarParser.FinalValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(PASCALetGrammarParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(PASCALetGrammarParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PASCALetGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(PASCALetGrammarParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(PASCALetGrammarParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#additiveOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveOperator(PASCALetGrammarParser.AdditiveOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeOperator(PASCALetGrammarParser.MultiplicativeOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#relationaloperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationaloperator(PASCALetGrammarParser.RelationaloperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#signedFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedFactor(PASCALetGrammarParser.SignedFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(PASCALetGrammarParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#unsignedConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedConstant(PASCALetGrammarParser.UnsignedConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#functionDesignator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDesignator(PASCALetGrammarParser.FunctionDesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(PASCALetGrammarParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#actualParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParameter(PASCALetGrammarParser.ActualParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#procedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureStatement(PASCALetGrammarParser.ProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PASCALetGrammarParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(PASCALetGrammarParser.EmptyStatementContext ctx);
}