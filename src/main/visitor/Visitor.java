package main.visitor;

import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;
import main.ast.declaration_DIR.AbstractDec;
import main.ast.declaration_DIR.DecList;
import main.ast.declaration_DIR.DeclarationSpecifier;
import main.ast.declaration_DIR.DeclarationSpecifiers;
import main.ast.declaration_DIR.Declarator;
import main.ast.declaration_DIR.DirectAbsDec;
import main.ast.declaration_DIR.DirectDec;
import main.ast.declaration_DIR.ForDec;
import main.ast.declaration_DIR.InitDeclarator;
import main.ast.declaration_DIR.InitDeclaratorList;
import main.ast.declaration_DIR.ParameterDec;
import main.ast.expression_DIR.ArgExpr;
import main.ast.expression_DIR.ArrayIndexing;
import main.ast.expression_DIR.BinaryExpr;
import main.ast.expression_DIR.CastExpr;
import main.ast.expression_DIR.CommaExpr;
import main.ast.expression_DIR.CondExpr;
import main.ast.expression_DIR.Constant;
import main.ast.expression_DIR.ExprCast;
import main.ast.expression_DIR.ForExpr;
import main.ast.expression_DIR.FuncCall;
import main.ast.expression_DIR.Identifier;
import main.ast.expression_DIR.IdentifierList;
import main.ast.expression_DIR.PrefixExpr;
import main.ast.expression_DIR.TIExpr;
import main.ast.expression_DIR.UnaryExpr;
import main.ast.literal_DIR.AssignmentOp;
import main.ast.literal_DIR.Designation;
import main.ast.literal_DIR.Designator;
import main.ast.literal_DIR.ExternalDeclaration;
import main.ast.literal_DIR.ForCondition;
import main.ast.literal_DIR.FunctionDefinition;
import main.ast.literal_DIR.SpecifierQualifierList;
import main.ast.literal_DIR.TypeSpecifier;
import main.ast.literal_DIR.UnaryOperator;
import main.ast.mainNodes_DIR.Declaration;
import main.ast.mainNodes_DIR.Pointer;
import main.ast.statement_DIR.BlockItem;
import main.ast.statement_DIR.CompoundStmt;
import main.ast.statement_DIR.ExprStmt;
import main.ast.statement_DIR.Initializer;
import main.ast.statement_DIR.InitializerList;
import main.ast.statement_DIR.IterStmt;
import main.ast.statement_DIR.JumpStmt;
import main.ast.statement_DIR.ParameterList;
import main.ast.statement_DIR.SelectionStmt;

public abstract class Visitor<T> implements IVisitor<T> {
    @Override
    public T visit(Program program) {
        return null;
    }

    public T visit(TranslationUnit translationUnit) {
        return null;
    }

    public T visit(ExternalDeclaration externalDeclaration) {
        return null;
    }

    public T visit(FunctionDefinition functionDefinition) {
        return null;
    }

    public T visit(Declaration declaration) {
        return null;
    }

    public T visit(DecList decList) {
        return null;
    }

    public T visit(ForDec forDec) {
        return null;
    }

    public T visit(ParameterList parameterList) {
        return null;
    }

    public T visit(DeclarationSpecifier declarationSpecifier) {
        return null;
    }

    public T visit(DeclarationSpecifiers declarationSpecifiers) {
        return null;
    }

    public T visit(InitDeclarator initDeclarator) {
        return null;
    }

    public T visit(InitDeclaratorList initDeclaratorList) {
        return null;
    }

    public T visit(AssignmentOp assignmentOp) {
        return null;
    }

    public T visit(TypeSpecifier typeSpecifier) {
        return null;
    }

    public T visit(UnaryOperator unaryOperator) {
        return null;
    }

    public T visit(DirectDec directDec) {
        return null;
    }

    public T visit(Declarator declarator) {
        return null;
    }

    public T visit(SpecifierQualifierList specifierQualifierList) {
        return null;
    }

    public T visit(ParameterDec parameterDec) {
        return null;
    }

    public T visit(IdentifierList identifierList) {
        return null;
    }

    public T visit(Pointer pointer) {
        return null;
    }

    public T visit(ArgExpr argExpr) {
        return null;
    }

    public T visit(AbstractDec abstractDec) {
        return null;
    }

    public T visit(DirectAbsDec directAbsDec) {
        return null;
    }

    public T visit(Initializer initializer) {
        return null;
    }

    public T visit(InitializerList initializerlist) {
        return null;
    }

    public T visit(Designation designation) {
        return null;
    }

    public T visit(Designator designator) {
        return null;
    }

    public T visit(CompoundStmt compoundStmt) {
        return null;
    }

    public T visit(BlockItem blockItem) {
        return null;
    }

    public T visit(ExprStmt exprStmt) {
        return null;
    }

    public T visit(SelectionStmt selectionStmt) {
        return null;
    }

    public T visit(IterStmt iterStmt) {
        return null;
    }

    public T visit(ForCondition forCondition) {
        return null;
    }

    public T visit(ForExpr forExpr) {
        return null;
    }

    public T visit(JumpStmt jumpStmt) {
        return null;
    }
    // ta inja male mane

    public T visit(FuncCall funcCall) {
        return null;
    }

    public T visit(UnaryExpr unaryExpr) {
        return null;
    }

    public T visit(CastExpr castExpr) {
        return null;
    }

    public T visit(ExprCast exprCast) {
        return null;
    }

    public T visit(BinaryExpr binaryExpr) {
        return null;
    }

    public T visit(CondExpr condExpr) {
        return null;
    }

    public T visit(CommaExpr commaExpr) {
        return null;
    }

    public T visit(ArrayIndexing arrayIndexing) {
        return null;
    }

    public T visit(Identifier identifier) {
        return null;
    }

    public T visit(Constant constant) {
        return null;
    }

    public T visit(TIExpr tiExpr) {
        return null;
    }

    public T visit(PrefixExpr prefixExpr) {
        return null;
    }

}
