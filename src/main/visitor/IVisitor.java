package main.visitor;

import main.ast.*;
import main.ast.ExternalDeclaration.Declaration;
import main.ast.ExternalDeclaration.ExternalDeclaration;
import main.ast.ExternalDeclaration.FunctionDefinition;
import main.ast.For.ForCondition;
import main.ast.For.ForDec;
import main.ast.For.ForExpr;
import main.ast.Stmt.*;
import main.ast.expr.*;


public interface IVisitor<T> {

    T visit(Program program);
    T visit(TranslationUnit translationUnit);
    T visit(ExternalDeclaration externalDeclaration);
    T visit(FunctionDefinition functionDefinition);
    T visit(Declaration declaration);

    T visit(ForDec forDec);
    T visit(ArgExpr argExpr);
    T visit(CastExpr castExpr);
    T visit(DecList decList);
    T visit(DeclarationSpecifier declarationSpecifier);
    T visit(DeclarationSpecifiers declarationSpecifiers);
    T visit(InitDeclaratorList initDeclaratorList);
    T visit(AssignmentOp assignmentOp);
    T visit(UnaryOperator unaryOperator);
    T visit(InitDeclarator initDeclarator);
    T visit(TypeSpecifier typeSpecifier);
    T visit(SpecifierQualifierList specifierQualifierList);
    T visit(Declarator declarator);
    T visit(DirectDec directDec);
    T visit(ParameterList parameterList);
    T visit(ParameterDec parameterDec);
    T visit(IdentifierList identifierList);
    T visit(TypeName typeName);
    T visit(Pointer pointer);
    T visit(AbstractDec abstractDec);
    T visit(DirectAbsDec directAbsDec);
    T visit(Initializer initializer);
    T visit(InitializerList initializerList);
    T visit(Designation designation);
    T visit(Designator designator);
    T visit(CompoundStmt compoundStmt);
    T visit(BlockItem blockItem);
    T visit(ExprStmt exprStmt);
    T visit(SelectionStmt selectionStmt);
    T visit(IterStmt iterStmt);
    T visit(ForCondition forCondition);
    T visit(ForExpr forExpr);
    T visit(JumpStmt jumpStmt);

    // az inja be baad male expr ha
    T visit(FuncCall funcCall);
    T visit(UnaryExpr unaryExpr);
    T visit(ExprCast exprCast);
    T visit(BinaryExpr binaryExpr);
    T visit(CondExpr condExpr);
    T visit(CommaExpr commaExpr);
    T visit(ArrayIndexing arrayIndexing);
    T visit(Identifier identifier);
    T visit(Constant constant);
    T visit(TIExpr tiExpr);
    T visit(PrefixExpr prefixExpr);





}
