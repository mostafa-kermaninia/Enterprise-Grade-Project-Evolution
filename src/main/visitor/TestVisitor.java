package main.visitor;

import main.ast.declaration_DIR.*;
import main.ast.literal_DIR.*;
import main.ast.expression_DIR.*;
import main.ast.statement_DIR.*;
import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;



public class TestVisitor extends Visitor<Void>{
    @Override
    public Void visit(Program program) {
        program.getTranslationUnit().accept(this);
        return null;
    }

    public Void visit(TranslationUnit translationUnit) {
        for (ExternalDeclaration externalDeclaration : translationUnit.getExternalDeclaration()){
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
        System.out.print(": Stmt function " + functionDefinition.getDeclarator().getDirectDec().getDirectDec().getIdentifier() + " = ");
        System.out.print(functionDefinition.getCompoundStmt().getBlockItems().size());
        System.out.println(" " + functionDefinition.getNumArgs());
        if (functionDefinition.getDecSpecifiers() != null)
            functionDefinition.getDecSpecifiers().accept(this);
        functionDefinition.getDeclarator().accept(this);
        if (functionDefinition.getDecList() != null)
            functionDefinition.getDecList().accept(this);
        functionDefinition.getCompoundStmt().accept(this);


        return null;
    }

    public Void visit(CastExpr castExpr) {
        if (castExpr.getCastExpr() != null)
            castExpr.getCastExpr().accept(this);
        if (castExpr.getExpr() != null)
            castExpr.getExpr().accept(this);
        if (castExpr.getTypeName() != null)
            castExpr.getTypeName().accept(this);
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

    public Void visit(ArgExpr argExpr) {
        for (Expr expr : argExpr.getExprs())
            if (expr != null)
                expr.accept(this);
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
        if (directDec.getExpr() != null)
            directDec.getExpr().accept(this);
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
        if (directAbsDec.getExpr() != null)
            directAbsDec.getExpr().accept(this);
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
        if (initializer.getExpr() != null)
            initializer.getExpr().accept(this);
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
        if (designator.getExpr() != null)
            designator.getExpr().accept(this);
        return null;
    }

    public Void visit(CompoundStmt compoundStmt) {
        for (BlockItem blockItem : compoundStmt.getBlockItems()){
            blockItem.accept(this);
        }
        return null;
    }

    public Void visit(BlockItem blockItem) {
        if (blockItem.getStmt() != null)
            blockItem.getStmt().accept(this);
        else
            blockItem.getDeclaration().accept(this);
        return null;
    }

    public Void visit(ExprStmt exprStmt) {
        if (exprStmt.getExpr() != null)
            exprStmt.getExpr().accept(this);
        return null;
    }

    public Void visit(SelectionStmt selectionStmt) {
        selectionStmt.getExpr().accept(this);
        System.out.print("Line ");
        System.out.print(selectionStmt.getLine());
        System.out.print(": Stmt selection = ");
        if (selectionStmt.getMainStmt() instanceof CompoundStmt) {
            CompoundStmt compoundStmt = (CompoundStmt) selectionStmt.getMainStmt();
            System.out.println(compoundStmt.getBlockItems().size());
        }
        else
            System.out.println(0);
        selectionStmt.getMainStmt().accept(this);
        if (selectionStmt.getElseStmt() instanceof CompoundStmt) {
            CompoundStmt compoundStmt = (CompoundStmt) selectionStmt.getElseStmt();
            if (compoundStmt.getBlockItems().size() > 0) {
                System.out.print("Line ");
                System.out.print(selectionStmt.getElseLine());
                System.out.print(": Stmt selection = ");
                System.out.println(compoundStmt.getBlockItems().size());
            }
        }
        else if (selectionStmt.getElseStmt() != null && !(selectionStmt.getElseStmt() instanceof SelectionStmt)) {
            System.out.print("Line ");
            System.out.print(selectionStmt.getElseLine());
            System.out.print(": Stmt selection = ");
            System.out.println(0);
        }
        if (selectionStmt.getElseStmt() != null)
            selectionStmt.getElseStmt().accept(this);
        return null;
    }


    public Void visit(IterStmt iterStmt) {
        if (iterStmt.getExpr() != null)
            iterStmt.getExpr().accept(this);
        System.out.print("Line ");
        System.out.print(iterStmt.getLine());
        System.out.print(": Stmt " + iterStmt.getType() + " = ");
        if (iterStmt.getStmt() instanceof CompoundStmt) {
            CompoundStmt compoundStmt = (CompoundStmt) iterStmt.getStmt();
            System.out.println(compoundStmt.getBlockItems().size());
        }
        else
            System.out.println(0);
        if (iterStmt.getStmt() != null)
            iterStmt.getStmt().accept(this);
        if (iterStmt.getForCondition() != null)
            iterStmt.getForCondition().accept(this);
        return null;
    }

    public Void visit(ForCondition forCondition) {
        if (forCondition.getForDec() != null)
            forCondition.getForDec().accept(this);
        if (forCondition.getExpr() != null)
            forCondition.getExpr().accept(this);
        if (forCondition.getForExpr1() != null)
            forCondition.getForExpr1().accept(this);
        if (forCondition.getForExpr2() != null)
            forCondition.getForExpr2().accept(this);
        return null;
    }

    public Void visit(ForExpr forExpr) {
        for (Expr expr : forExpr.getExprs()) {
            if (expr != null)
                expr.accept(this);
        }
        return null;
    }

    public Void visit(JumpStmt jumpStmt) {
        if (jumpStmt.getCondition() != null)
            jumpStmt.getCondition().accept(this);
        return null;
    }

    public Void visit(FuncCall funcCall) {
        funcCall.getExpr().accept(this);
        if (funcCall.getArgExpr() != null)
            funcCall.getArgExpr().accept(this);
        return null;
    }

    public Void visit(UnaryExpr unaryExpr) {
//        if (unaryExpr.getFirst()) {
//            System.out.print("Line ");
//            System.out.print(unaryExpr.getLine());
//            System.out.print(": Expr ");
//            System.out.println(unaryExpr.getOp());
//        }
        unaryExpr.getExpr().accept(this);
        return null;
    }

    public Void visit(ExprCast exprCast) {
        exprCast.getCastExpr().accept(this);
        exprCast.getTypeName().accept(this);
        return null;
    }

    public Void visit(BinaryExpr binaryExpr) {
//        if (binaryExpr.getFirst()){
//            System.out.print("Line ");
//            System.out.print(binaryExpr.getLine());
//            System.out.print(": Expr ");
//            if (binaryExpr.getAssignmentOp() != null)
//                System.out.println(binaryExpr.getAssignmentOp().getOpType());
//            else
//                System.out.println(binaryExpr.getOperator());
//        }
        binaryExpr.getExpr1().accept(this);
        binaryExpr.getExpr2().accept(this);
        if (binaryExpr.getAssignmentOp() != null)
            binaryExpr.getAssignmentOp().accept(this);
        return null;
    }

    public Void visit(CondExpr condExpr) {
//        if (condExpr.getFirst()){
//            System.out.print("Line ");
//            System.out.print(condExpr.getLine());
//            System.out.print(": Expr ");
//            System.out.println("?");
//        }
        condExpr.getExpr1().accept(this);
        condExpr.getExpr2().accept(this);
        condExpr.getExpr3().accept(this);
        return null;
    }

    public Void visit(CommaExpr commaExpr) {
//        if (commaExpr.getFirst()){
//            if (commaExpr.getLine() != 0) {
//                System.out.print("Line ");
//                System.out.print(commaExpr.getLine());
//                System.out.print(": Expr ");
//                System.out.println(",");
//            }
//        }
        for (Expr expr : commaExpr.getExprs())
            if (expr != null)
                expr.accept(this);
        return null;
    }

    public Void visit(ArrayIndexing arrayIndexing) {
        arrayIndexing.getExpr1().accept(this);
        arrayIndexing.getExpr2().accept(this);
        return null;
    }

    public Void visit(Identifier identifier) {
//        if (identifier.getFirst()) {
//            System.out.print("Line ");
//            System.out.print(identifier.getLine());
//            System.out.print(": Expr ");
//            System.out.println(identifier.getIdentifier());
//        }
        return null;
    }

    public Void visit(Constant constant) {
//        if (constant.getFirst()) {
//            System.out.print("Line ");
//            System.out.print(constant.getLine());
//            System.out.print(": Expr ");
//            System.out.println(constant.getConstant());
//        }
        return null;
    }

    public Void visit(TIExpr tiExpr) {
        tiExpr.getInitializerList().accept(this);
        tiExpr.getTypeName().accept(this);
        return null;
    }


    public Void visit(PrefixExpr prefixExpr) {
        if (prefixExpr.getExpr() != null)
            prefixExpr.getExpr().accept(this);
        if (prefixExpr.getCastExpr() != null)
            prefixExpr.getCastExpr().accept(this);
        if (prefixExpr.getTypeName() != null)
            prefixExpr.getTypeName().accept(this);
        if (prefixExpr.getTIExpr() != null)
            prefixExpr.getTIExpr().accept(this);
        if (prefixExpr.getUnaryOp() != null)
            prefixExpr.getUnaryOp().accept(this);
        return null;
    }


}


