package main.visitor;

import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;
import main.ast.declaration_DIR.*;
import main.ast.expression_DIR.*;
import main.ast.literal_DIR.*;
import main.ast.statement_DIR.*;
import main.symbolTable.SymbolTable;


public class NameAnalyzer extends Visitor<Void> {
    private SymbolTable RootST;
    private boolean SuccessfulDone = true;

    private final NameAnalyzerVisitorUtils visitorUtils;


    public SymbolTable getRootST() {return RootST;}
    public void setRootST(SymbolTable RootST) {this.RootST = RootST;}

    public boolean isSuccessfulDone() {return SuccessfulDone;}
    public void setSuccessfulDone(boolean SuccessfulDone) {this.SuccessfulDone = SuccessfulDone;}

    public NameAnalyzer() {
        this.visitorUtils = new NameAnalyzerVisitorUtils(this);
    }

    @Override
    public Void visit(Program program) {
        return visitorUtils.visitProgram(program);
    }

    @Override
    public Void visit(TranslationUnit translationUnit) {
        return visitorUtils.visitTranslationUnit(translationUnit);
    }

    @Override
    public Void visit(ExternalDeclaration externalDeclaration) {
        return visitorUtils.visitExternalDeclaration(externalDeclaration);
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition) {
        return visitorUtils.visitFunctionDefinition(functionDefinition);
    }

    @Override
    public Void visit(CastExpression castExpression) {
        return visitorUtils.visitCastExpression(castExpression);
    }

    @Override
    public Void visit(Declaration declaration) {
        return visitorUtils.visitDeclaration(declaration);
    }

    @Override
    public Void visit(DecList decList) {
        return visitorUtils.visitDecList(decList);
    }

    @Override
    public Void visit(DeclarationSpecifiers declarationSpecifiers) {
        return visitorUtils.visitDeclarationSpecifiers(declarationSpecifiers);
    }

    @Override
    public Void visit(ForDec forDec) {
        return visitorUtils.visitForDec(forDec);
    }

    @Override
    public Void visit(DeclarationSpecifier declarationSpecifier) {
        return visitorUtils.visitDeclarationSpecifier(declarationSpecifier);
    }

    @Override
    public Void visit(InitDeclaratorList initDeclaratorList) {
        return visitorUtils.visitInitDeclaratorList(initDeclaratorList);
    }

    @Override
    public Void visit(InitDeclarator initDeclarator) {
        return visitorUtils.visitInitDeclarator(initDeclarator);
    }

    @Override
    public Void visit(ArgExpression argExpression) {
        return visitorUtils.visitArgExpression(argExpression);
    }

    @Override
    public Void visit(UnaryOperator unaryOperator) {
        return visitorUtils.visitUnaryOperator();
    }

    @Override
    public Void visit(TypeSpecifier typeSpecifier) {
        return visitorUtils.visitTypeSpecifier(typeSpecifier);
    }

    @Override
    public Void visit(AssignmentOp assignmentOp) {
        return visitorUtils.visitAssignmentOp();
    }

    @Override
    public Void visit(Pointer pointer) {
        return visitorUtils.visitPointer();
    }

    @Override
    public Void visit(ParameterList parameterList) {
        return visitorUtils.visitParameterList(parameterList);
    }

    @Override
    public Void visit(Declarator declarator) {
        return visitorUtils.visitDeclarator(declarator);
    }

    @Override
    public Void visit(DirectDec directDec) {
        return visitorUtils.visitDirectDec(directDec);
    }

    @Override
    public Void visit(SpecifierQualifierList specifierQualifierList) {
        return visitorUtils.visitSpecifierQualifierList(specifierQualifierList);
    }

    @Override
    public Void visit(ParameterDec parameterDec) {
        return visitorUtils.visitParameterDec(parameterDec);
    }

    @Override
    public Void visit(IdentifierList identifierList) {
        return visitorUtils.visitIdentifierList();
    }

    @Override
    public Void visit(TypeName typeName) {
        return visitorUtils.visitTypeName(typeName);
    }

    @Override
    public Void visit(DirectAbsDec directAbsDec) {
        return visitorUtils.visitDirectAbsDec(directAbsDec);
    }

    @Override
    public Void visit(AbstractDec abstractDec) {
        return visitorUtils.visitAbstractDec(abstractDec);
    }

    @Override
    public Void visit(Initializer initializer) {
        return visitorUtils.visitInitializer(initializer);
    }

    @Override
    public Void visit(InitializerList initializerList) {
        return visitorUtils.visitInitializerList(initializerList);
    }

    @Override
    public Void visit(Designation designation) {
        return visitorUtils.visitDesignation(designation);
    }

    @Override
    public Void visit(Designator designator) {
        return visitorUtils.visitDesignator(designator);
    }

    @Override
    public Void visit(CompoundStatement compoundStatement) {
        return visitorUtils.visitCompoundStatement(compoundStatement);
    }

    @Override
    public Void visit(BlockItem blockItem) {
        return visitorUtils.visitBlockItem(blockItem);
    }

    @Override
    public Void visit(ExpressionStatement expressionStatement) {
        return visitorUtils.visitExpressionStatement(expressionStatement);
    }

    @Override
    public Void visit(SelectionStatement selectionStatement) {
        return visitorUtils.visitSelectionStatement(selectionStatement);
    }

    @Override
    public Void visit(IterStatement iterStatement) {
        return visitorUtils.visitIterStatement(iterStatement);
    }

    @Override
    public Void visit(ForCondition forCondition) {
        return visitorUtils.visitForCondition(forCondition);
    }

    @Override
    public Void visit(ForExpression forExpression) {
        return visitorUtils.visitForExpression(forExpression);
    }

    @Override
    public Void visit(JumpStatement jumpStatement) {
        return visitorUtils.visitJumpStatement(jumpStatement);
    }

    @Override
    public Void visit(FuncCall funcCall) {
        return visitorUtils.visitFuncCall(funcCall);
    }

    @Override
    public Void visit(UnaryExpression unaryExpr) {
        return visitorUtils.visitUnaryExpression(unaryExpr);
    }

    @Override
    public Void visit(ExpressionCast expressionCast) {
        return visitorUtils.visitExpressionCast(expressionCast);
    }

    @Override
    public Void visit(BinaryExpression binaryExpr) {
        return visitorUtils.visitBinaryExpression(binaryExpr);
    }

    @Override
    public Void visit(CondExpression condExpr) {
        return visitorUtils.visitCondExpression(condExpr);
    }

    @Override
    public Void visit(CommaExpression commaExpression) {
        return visitorUtils.visitCommaExpression(commaExpression);
    }

    @Override
    public Void visit(ArrayIndexing arrayIndexing) {
        return visitorUtils.visitArrayIndexing(arrayIndexing);
    }

    @Override
    public Void visit(Identifier identifier) {
        return visitorUtils.visitIdentifier(identifier);
    }

    @Override
    public Void visit(Constant constant) {
        return visitorUtils.visitConstant();
    }

    @Override
    public Void visit(TIExpression tiExpression) {
        return visitorUtils.visitTIExpression(tiExpression);
    }

    @Override
    public Void visit(PrefixExpression prefixExpr) {
        return visitorUtils.visitPrefixExpression(prefixExpr);
    }
}