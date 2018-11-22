// Generated from FeatherweightJavaScript.g4 by ANTLR 4.4
 package edu.sjsu.fwjs.parser; 
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FeatherweightJavaScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FeatherweightJavaScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code varassign}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarassign(@NotNull FeatherweightJavaScriptParser.VarassignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(@NotNull FeatherweightJavaScriptParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullval}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullval(@NotNull FeatherweightJavaScriptParser.NullvalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpblock}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpblock(@NotNull FeatherweightJavaScriptParser.SimpblockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code muldivmod}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuldivmod(@NotNull FeatherweightJavaScriptParser.MuldivmodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalities}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualities(@NotNull FeatherweightJavaScriptParser.EqualitiesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functioncall}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(@NotNull FeatherweightJavaScriptParser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addsub}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddsub(@NotNull FeatherweightJavaScriptParser.AddsubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(@NotNull FeatherweightJavaScriptParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolval}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolval(@NotNull FeatherweightJavaScriptParser.BoolvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link FeatherweightJavaScriptParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(@NotNull FeatherweightJavaScriptParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(@NotNull FeatherweightJavaScriptParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullblock}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullblock(@NotNull FeatherweightJavaScriptParser.FullblockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bareexpr}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBareexpr(@NotNull FeatherweightJavaScriptParser.BareexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(@NotNull FeatherweightJavaScriptParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functiondeclaration}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiondeclaration(@NotNull FeatherweightJavaScriptParser.FunctiondeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifthenelse}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfthenelse(@NotNull FeatherweightJavaScriptParser.IfthenelseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifthen}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfthen(@NotNull FeatherweightJavaScriptParser.IfthenContext ctx);
	/**
	 * Visit a parse tree produced by {@link FeatherweightJavaScriptParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull FeatherweightJavaScriptParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seperator}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeperator(@NotNull FeatherweightJavaScriptParser.SeperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varreference}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarreference(@NotNull FeatherweightJavaScriptParser.VarreferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link FeatherweightJavaScriptParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull FeatherweightJavaScriptParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vardecelaration}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecelaration(@NotNull FeatherweightJavaScriptParser.VardecelarationContext ctx);
}