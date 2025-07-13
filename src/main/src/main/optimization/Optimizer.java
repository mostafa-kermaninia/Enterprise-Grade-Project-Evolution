package main.optimization;

import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;
import main.ast.declaration_DIR.*;
import main.ast.expression_DIR.*;
import main.ast.literal_DIR.*;
import main.ast.statement_DIR.*;
import main.symbolTable.SymbolTable;
import main.visitor.Visitor;


public class Optimizer extends Visitor<Void> {
    public SymbolTable symbolTableMain;
    public boolean changed = false;

    private final OptimizerVisitorUtils visitorUtils;

    public Optimizer(SymbolTable symbolTableMain) {
        this.symbolTableMain = symbolTableMain;
        this.visitorUtils = new OptimizerVisitorUtils(this);
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
    public Void visit(CastExpression castExpr) {
        return visitorUtils.visitCastExpression(castExpr);
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
    public Void visit(ArgExpression argExpr) {
        return visitorUtils.visitArgExpression(argExpr);
    }

    @Override
    public Void visit(UnaryOperator unaryOperator) {
        return visitorUtils.visitUnaryOperator();
    }

    @Override
    public Void visit(TypeSpecifier typeSpecifier) {
        return visitorUtils.visitTypeSpecifier();
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
    public Void visit(UnaryExpression unaryExpression) {
        return visitorUtils.visitUnaryExpression(unaryExpression);
    }

    @Override
    public Void visit(ExpressionCast expressionCast) {
        return visitorUtils.visitExpressionCast(expressionCast);
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        return visitorUtils.visitBinaryExpression(binaryExpression);
    }

    @Override
    public Void visit(CondExpression condExpression) {
        return visitorUtils.visitCondExpression(condExpression);
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
        return visitorUtils.visitIdentifier();
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
    public Void visit(PrefixExpression prefixExpression) {
        return visitorUtils.visitPrefixExpression(prefixExpression);
    }
}