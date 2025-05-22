package main.visitor;

import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;
import main.ast.declaration_DIR.*;
import main.ast.expression_DIR.*;
import main.ast.literal_DIR.*;
import main.ast.statement_DIR.*;

public interface IVisitor<T> {

    T visit(Program program);

    T visit(TranslationUnit translationUnit);

    T visit(ExternalDeclaration externalDeclaration);

    T visit(FunctionDefinition functionDefinition);

    T visit(Declaration declaration);

    T visit(ForDec forDec);

    T visit(ArgExpression argExpression);

    T visit(CastExpression castExpression);

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

    T visit(CompoundStatement compoundStatement);

    T visit(BlockItem blockItem);

    T visit(ExpressionStatement expressionStatement);

    T visit(SelectionStatement selectionStatement);

    T visit(IterStatement iterStatement);

    T visit(ForCondition forCondition);

    T visit(ForExpression forExpression);

    T visit(JumpStatement jumpStatement);

    T visit(FuncCall funcCall);

    T visit(UnaryExpression unaryExpression);

    T visit(ExpressionCast expressionCast);

    T visit(BinaryExpression binaryExpression);

    T visit(CondExpression condExpression);

    T visit(CommaExpression commaExpression);

    T visit(ArrayIndexing arrayIndexing);

    T visit(Identifier identifier);

    T visit(Constant constant);

    T visit(TIExpression tiExpression);

    T visit(PrefixExpression prefixExpression);

}
