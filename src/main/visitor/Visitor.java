package main.visitor;

import main.ast.declaration_DIR.*;
import main.ast.literal_DIR.*;
import main.ast.expression_DIR.*;
import main.ast.statement_DIR.*;
import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;


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
    public T visit(FunctionDefinition functionDefinition) { return null; }
    public T visit(Declaration declaration) { return null; }
    public T visit(DecList decList) { return null; }
    public T visit(ForDec forDec) { return null; }

    public T visit(ParameterList parameterList) { return null; }
    public T visit(DeclarationSpecifier declarationSpecifier) { return null; }
    public T visit(DeclarationSpecifiers declarationSpecifiers) { return null; }
    public T visit(InitDeclarator initDeclarator) { return null; }
    public T visit(InitDeclaratorList initDeclaratorList) { return null; }
    public T visit(AssignmentOp assignmentOp) { return null; }
    public T visit(TypeSpecifier typeSpecifier) { return null; }
    public T visit(UnaryOperator unaryOperator) { return null; }
    public T visit(DirectDec directDec) { return null; }
    public T visit(Declarator declarator) { return null; }
    public T visit(SpecifierQualifierList specifierQualifierList) { return null; }
    public T visit(ParameterDec parameterDec) { return null; }
    public T visit(IdentifierList identifierList) { return null; }
    public T visit(Pointer pointer) { return null; }
    public T visit(ArgExpr argExpr) { return null; }
    public T visit(AbstractDec abstractDec) { return null; }
    public T visit(DirectAbsDec directAbsDec) { return null; }
    public T visit(Initializer initializer) { return null; }
    public T visit(InitializerList initializerlist) { return null; }
    public T visit(Designation designation) { return null; }
    public T visit(Designator designator) { return null; }
    public T visit(CompoundStmt compoundStmt) { return null; }
    public T visit(BlockItem blockItem) { return null; }
    public T visit(ExprStmt exprStmt) { return null; }
    public T visit(SelectionStmt selectionStmt) { return null; }
    public T visit(IterStmt iterStmt) { return null; }
    public T visit(ForCondition forCondition) { return null; }

    public T visit(ForExpr forExpr) { return null; }
    public T visit(JumpStmt jumpStmt) { return null; }
    // ta inja male mane

    public T visit(FuncCall funcCall) { return null; }
    public T visit(UnaryExpr unaryExpr) { return null; }
    public T visit(CastExpr castExpr) { return null; }
    public T visit(ExprCast exprCast) { return null; }
    public T visit(BinaryExpr binaryExpr) { return null; }
    public T visit(CondExpr condExpr) { return null; }
    public T visit(CommaExpr commaExpr) { return null; }
    public T visit(ArrayIndexing arrayIndexing) { return null; }
    public T visit(Identifier identifier) { return null; }
    public T visit(Constant constant) { return null; }
    public T visit(TIExpr tiExpr) { return null; }
    public T visit(PrefixExpr prefixExpr) { return null; }





}
