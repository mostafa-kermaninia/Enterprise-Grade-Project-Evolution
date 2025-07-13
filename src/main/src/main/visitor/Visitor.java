package main.visitor;

import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;
import main.ast.declaration_DIR.*;
import main.ast.expression_DIR.*;
import main.ast.literal_DIR.*;
import main.ast.statement_DIR.*;

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

    public T visit(ArgExpression argExpression) {
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

    public T visit(CompoundStatement compoundStatement) {
        return null;
    }

    public T visit(BlockItem blockItem) {
        return null;
    }

    public T visit(ExpressionStatement expressionStatement) {
        return null;
    }

    public T visit(SelectionStatement selectionStatement) {
        return null;
    }

    public T visit(IterStatement iterStatement) {
        return null;
    }

    public T visit(ForCondition forCondition) {
        return null;
    }

    public T visit(ForExpression forExpression) {
        return null;
    }

    public T visit(JumpStatement jumpStatement) {
        return null;
    }
    // ta inja male mane

    public T visit(FuncCall funcCall) {
        return null;
    }

    public T visit(UnaryExpression unaryExpression) {
        return null;
    }

    public T visit(CastExpression castExpression) {
        return null;
    }

    public T visit(ExpressionCast expressionCast) {
        return null;
    }

    public T visit(BinaryExpression binaryExpression) {
        return null;
    }

    public T visit(CondExpression condExpression) {
        return null;
    }

    public T visit(CommaExpression commaExpression) {
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

    public T visit(TIExpression tiExpression) {
        return null;
    }

    public T visit(PrefixExpression prefixExpression) {
        return null;
    }

}
