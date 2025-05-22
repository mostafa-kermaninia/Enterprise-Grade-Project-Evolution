package main.visitor;

import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;
import main.ast.declaration_DIR.*;
import main.ast.expression_DIR.*;
import main.ast.literal_DIR.*;
import main.ast.statement_DIR.*;

public class TestVisitor extends Visitor<Void> {
    @Override
    public Void visit(Program program) {
        program.getTranslationUnit().accept(this);
        return null;
    }

    public Void visit(TranslationUnit translationUnit) {
        for (ExternalDeclaration externalDeclaration : translationUnit.getExternalDeclaration()) {
            externalDeclaration.accept(this);
        }
        return null;
    }

    public Void visit(ExternalDeclaration externalDeclaration) {
        if (externalDeclaration.getDeclaration() != null)
            externalDeclaration.getDeclaration().accept(this);
        else
            externalDeclaration.getFunctionDefinition().accept(this);
        return null;
    }

    public Void visit(FunctionDefinition functionDefinition) {
        System.out.print("Line ");
        System.out.print(functionDefinition.getDeclarator().getDirectDec().getDirectDec().getLine());
        System.out.print(": Stmt function "
                + functionDefinition.getDeclarator().getDirectDec().getDirectDec().getIdentifier() + " = ");
        System.out.print(functionDefinition.getCompoundStatement().getBlockItems().size());
        System.out.println(" " + functionDefinition.getNumArgs());
        if (functionDefinition.getDecSpecifiers() != null)
            functionDefinition.getDecSpecifiers().accept(this);
        functionDefinition.getDeclarator().accept(this);
        if (functionDefinition.getDecList() != null)
            functionDefinition.getDecList().accept(this);
        functionDefinition.getCompoundStatement().accept(this);

        return null;
    }

    public Void visit(CastExpression castExpression) {
        if (castExpression.getCastExpression() != null)
            castExpression.getCastExpression().accept(this);
        if (castExpression.getExpression() != null)
            castExpression.getExpression().accept(this);
        if (castExpression.getTypeName() != null)
            castExpression.getTypeName().accept(this);
        return null;
    }

    public Void visit(Declaration declaration) {
        declaration.getDeclarationSpecifiers().accept(this);
        if (declaration.getInitDeclaratorList() != null)
            declaration.getInitDeclaratorList().accept(this);
        return null;
    }

    public Void visit(DecList decList) {
        for (Declaration declaration : decList.getDeclarations())
            declaration.accept(this);
        return null;
    }

    public Void visit(DeclarationSpecifiers declarationSpecifiers) {
        for (DeclarationSpecifier declarationSpecifier : declarationSpecifiers.getDeclarationSpecifiers())
            declarationSpecifier.accept(this);
        return null;
    }

    public Void visit(ForDec forDec) {
        forDec.getDeclarationSpecifiers().accept(this);
        if (forDec.getInitDecList() != null)
            forDec.getInitDecList().accept(this);

        return null;
    }

    public Void visit(DeclarationSpecifier declarationSpecifier) {
        if (declarationSpecifier.getTypeSpecifier() != null && declarationSpecifier.getTypeSpecifier().Used())
            declarationSpecifier.getTypeSpecifier().accept(this);
        return null;
    }

    public Void visit(InitDeclaratorList initDeclaratorList) {
        for (InitDeclarator initDeclarator : initDeclaratorList.getInitDeclarators())
            initDeclarator.accept(this);

        return null;
    }

    public Void visit(InitDeclarator initDeclarator) {
        initDeclarator.getDeclarator().accept(this);
        if (initDeclarator.getInitializer() != null)
            initDeclarator.getInitializer().accept(this);
        return null;
    }

    public Void visit(ArgExpression argExpression) {
        for (Expression expression : argExpression.getExpressions())
            if (expression != null)
                expression.accept(this);
        return null;
    }

    public Void visit(UnaryOperator unaryOperator) {
        return null;
    }

    public Void visit(TypeSpecifier typeSpecifier) {
        return null;
    }

    public Void visit(AssignmentOp assignmentOp) {
        return null;
    }

    public Void visit(Pointer pointer) {
        return null;
    }

    public Void visit(ParameterList parameterList) {
        return null;
    }

    public Void visit(Declarator declarator) {
        declarator.getDirectDec().accept(this);
        if (declarator.getPointer() != null)
            declarator.getPointer().accept(this);
        return null;
    }

    public Void visit(DirectDec directDec) {
        if (directDec.getDeclarator() != null)
            directDec.getDeclarator().accept(this);
        if (directDec.getDirectDec() != null)
            directDec.getDirectDec().accept(this);
        if (directDec.getIdentifierList() != null)
            directDec.getIdentifierList().accept(this);
        if (directDec.getExpression() != null)
            directDec.getExpression().accept(this);
        if (directDec.getParameterList() != null)
            directDec.getParameterList().accept(this);
        return null;
    }

    public Void visit(SpecifierQualifierList specifierQualifierList) {
        if (specifierQualifierList.getTypeSpecifier() != null)
            specifierQualifierList.getTypeSpecifier().accept(this);
        if (specifierQualifierList.getSpecifierQualifierList() != null)
            specifierQualifierList.getSpecifierQualifierList().accept(this);
        return null;
    }

    public Void visit(ParameterDec parameterDec) {
        parameterDec.getDeclarationSpecifier().accept(this);
        if (parameterDec.getAbstractDec() != null)
            parameterDec.getAbstractDec().accept(this);
        if (parameterDec.getDeclarator() != null)
            parameterDec.getDeclarator().accept(this);
        return null;
    }

    public Void visit(IdentifierList identifierList) {
        return null;
    }

    public Void visit(TypeName typeName) {
        typeName.getSpecifierQualifierList().accept(this);
        if (typeName.getAbstractDec() != null)
            typeName.getAbstractDec().accept(this);
        return null;
    }

    public Void visit(DirectAbsDec directAbsDec) {
        if (directAbsDec.getExpression() != null)
            directAbsDec.getExpression().accept(this);
        if (directAbsDec.getAbstractDec() != null)
            directAbsDec.getAbstractDec().accept(this);
        if (directAbsDec.getParameterList() != null)
            directAbsDec.getParameterList().accept(this);
        if (directAbsDec.getDirectAbsDec() != null)
            directAbsDec.getDirectAbsDec().accept(this);
        return null;
    }

    public Void visit(AbstractDec abstractDec) {
        abstractDec.getPointer().accept(this);
        if (abstractDec.getDirectAbsDec() != null)
            abstractDec.getDirectAbsDec().accept(this);
        return null;
    }

    public Void visit(Initializer initializer) {
        if (initializer.getExpression() != null)
            initializer.getExpression().accept(this);
        else
            initializer.getInitList().accept(this);
        return null;
    }

    public Void visit(InitializerList initializerList) {
        for (Initializer initializer : initializerList.getInitializers())
            initializer.accept(this);
        for (Designation designation : initializerList.getDesignations())
            designation.accept(this);
        return null;
    }

    public Void visit(Designation designation) {
        for (Designator designator : designation.getDesignators())
            designator.accept(this);
        return null;
    }

    public Void visit(Designator designator) {
        if (designator.getExpression() != null)
            designator.getExpression().accept(this);
        return null;
    }

    public Void visit(CompoundStatement compoundStatement) {
        for (BlockItem blockItem : compoundStatement.getBlockItems()) {
            blockItem.accept(this);
        }
        return null;
    }

    public Void visit(BlockItem blockItem) {
        if (blockItem.getStatement() != null)
            blockItem.getStatement().accept(this);
        else
            blockItem.getDeclaration().accept(this);
        return null;
    }

    public Void visit(ExpressionStatement expressionStatement) {
        if (expressionStatement.getExpression() != null)
            expressionStatement.getExpression().accept(this);
        return null;
    }

    public Void visit(SelectionStatement selectionStatement) {
        selectionStatement.getExpression().accept(this);
        System.out.print("Line ");
        System.out.print(selectionStatement.getLine());
        System.out.print(": Statement selection = ");
        if (selectionStatement.getMainStatement() instanceof CompoundStatement) {
            CompoundStatement compoundStatement = (CompoundStatement) selectionStatement.getMainStatement();
            System.out.println(compoundStatement.getBlockItems().size());
        } else
            System.out.println(0);
        selectionStatement.getMainStatement().accept(this);
        if (selectionStatement.getElseStatement() instanceof CompoundStatement) {
            CompoundStatement compoundStatement = (CompoundStatement) selectionStatement.getElseStatement();
            if (compoundStatement.getBlockItems().size() > 0) {
                System.out.print("Line ");
                System.out.print(selectionStatement.getElseLine());
                System.out.print(": Statement selection = ");
                System.out.println(compoundStatement.getBlockItems().size());
            }
        } else if (selectionStatement.getElseStatement() != null
                && !(selectionStatement.getElseStatement() instanceof SelectionStatement)) {
            System.out.print("Line ");
            System.out.print(selectionStatement.getElseLine());
            System.out.print(": Statement selection = ");
            System.out.println(0);
        }
        if (selectionStatement.getElseStatement() != null)
            selectionStatement.getElseStatement().accept(this);
        return null;
    }

    public Void visit(IterStatement iterStatement) {
        if (iterStatement.getExpression() != null)
            iterStatement.getExpression().accept(this);
        System.out.print("Line ");
        System.out.print(iterStatement.getLine());
        System.out.print(": Statement " + iterStatement.getType() + " = ");
        if (iterStatement.getStatement() instanceof CompoundStatement) {
            CompoundStatement compoundStatement = (CompoundStatement) iterStatement.getStatement();
            System.out.println(compoundStatement.getBlockItems().size());
        } else
            System.out.println(0);
        if (iterStatement.getStatement() != null)
            iterStatement.getStatement().accept(this);
        if (iterStatement.getForCondition() != null)
            iterStatement.getForCondition().accept(this);
        return null;
    }

    public Void visit(ForCondition forCondition) {
        if (forCondition.getForDec() != null)
            forCondition.getForDec().accept(this);
        if (forCondition.getExpression() != null)
            forCondition.getExpression().accept(this);
        if (forCondition.getForExpression1() != null)
            forCondition.getForExpression1().accept(this);
        if (forCondition.getForExpression2() != null)
            forCondition.getForExpression2().accept(this);
        return null;
    }

    public Void visit(ForExpression forExpression) {
        for (Expression expression : forExpression.getExpressions()) {
            if (expression != null)
                expression.accept(this);
        }
        return null;
    }

    public Void visit(JumpStatement jumpStatement) {
        if (jumpStatement.getCondition() != null)
            jumpStatement.getCondition().accept(this);
        return null;
    }

    public Void visit(FuncCall funcCall) {
        funcCall.getExpression().accept(this);
        if (funcCall.getArgExpression() != null)
            funcCall.getArgExpression().accept(this);
        return null;
    }

    public Void visit(UnaryExpression unaryExpr) {
        unaryExpr.getExpression().accept(this);
        return null;
    }

    public Void visit(ExpressionCast expressionCast) {
        expressionCast.getCastExpression().accept(this);
        expressionCast.getTypeName().accept(this);
        return null;
    }

    public Void visit(BinaryExpression binaryExpression) {
        binaryExpression.getExpression1().accept(this);
        binaryExpression.getExpression2().accept(this);
        if (binaryExpression.getAssignmentOp() != null)
            binaryExpression.getAssignmentOp().accept(this);
        return null;
    }

    public Void visit(CondExpression condExpression) {
        condExpression.getExpression1().accept(this);
        condExpression.getExpression2().accept(this);
        condExpression.getExpression3().accept(this);
        return null;
    }

    public Void visit(CommaExpression commaExpression) {
        for (Expression expression : commaExpression.getExpressions())
            if (expression != null)
                expression.accept(this);
        return null;
    }

    public Void visit(ArrayIndexing arrayIndexing) {
        arrayIndexing.getExpression1().accept(this);
        arrayIndexing.getExpression2().accept(this);
        return null;
    }

    public Void visit(Identifier identifier) {
        return null;
    }

    public Void visit(Constant constant) {
        return null;
    }

    public Void visit(TIExpression tiExpression) {
        tiExpression.getInitializerList().accept(this);
        tiExpression.getTypeName().accept(this);
        return null;
    }

    public Void visit(PrefixExpression prefixExpression) {
        if (prefixExpression.getExpression() != null)
            prefixExpression.getExpression().accept(this);
        if (prefixExpression.getCastExpression() != null)
            prefixExpression.getCastExpression().accept(this);
        if (prefixExpression.getTypeName() != null)
            prefixExpression.getTypeName().accept(this);
        if (prefixExpression.getTIExpression() != null)
            prefixExpression.getTIExpression().accept(this);
        if (prefixExpression.getUnaryOp() != null)
            prefixExpression.getUnaryOp().accept(this);
        return null;
    }

}
