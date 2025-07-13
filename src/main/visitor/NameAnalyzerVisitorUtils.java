package main.visitor;

import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;
import main.ast.declaration_DIR.*;
import main.ast.expression_DIR.*;
import main.ast.literal_DIR.*;
import main.ast.statement_DIR.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.VarDecSymbolTableItem;
import java.util.Arrays;
import java.util.List;
import main.visitor.ListUtils.*;

public class NameAnalyzerVisitorUtils {
    private final NameAnalyzer parent;

    public NameAnalyzerVisitorUtils(NameAnalyzer parent) {
        this.parent = parent;
    }


    // visit(Program program)
    public Void visitProgram(Program program) {
        SymbolTable.top = new SymbolTable();
        SymbolTable.root = SymbolTable.top;

        program.setSymbolTable(SymbolTable.top);
        program.getTranslationUnit().accept(parent);
        parent.setRootST(SymbolTable.top);
        return null;
    }

    // visit(TranslationUnit translationUnit)
    public Void visitTranslationUnit(TranslationUnit translationUnit) {
        for (ExternalDeclaration externalDeclaration : translationUnit.getExternalDeclaration()) {
            externalDeclaration.accept(parent);
        }
        return null;
    }

    // visit(ExternalDeclaration externalDeclaration)
    public Void visitExternalDeclaration(ExternalDeclaration externalDeclaration) {
        if (externalDeclaration.getDeclaration() != null)
            externalDeclaration.getDeclaration().accept(parent);
        else
            externalDeclaration.getFunctionDefinition().accept(parent);
        return null;
    }

    // visit(FunctionDefinition functionDefinition)
    public Void visitFunctionDefinition(FunctionDefinition functionDefinition) {
        ParameterList plist = functionDefinition.getDeclarator().getDirectDec().getParameterList();
        if (plist == null)
            functionDefinition.setNumArgs(0);
        else
            functionDefinition.setNumArgs(plist.getParameterDecs().size());

        FuncDecSymbolTableItem func_dec_item = new FuncDecSymbolTableItem(functionDefinition);
        try {
            SymbolTable.top.put(func_dec_item);
        } catch (ItemAlreadyExistsException e) {
            System.out.println("Redefinition of function \""
                    + functionDefinition.getDeclarator().getDirectDec().getDirectDec().getIdentifier()
                    + "\" in line " + functionDefinition.getDeclarator().getDirectDec().getDirectDec().getLine());
            parent.setSuccessfulDone(false);
        }

        SymbolTable func_dec_symbol_table = new SymbolTable(SymbolTable.top);
        functionDefinition.setSymbolTable(func_dec_symbol_table);
        SymbolTable.push(func_dec_symbol_table);

        if (functionDefinition.getDecSpecifiers() != null)
            functionDefinition.getDecSpecifiers().accept(parent);
        functionDefinition.getDeclarator().accept(parent);
        if (functionDefinition.getDecList() != null)
            functionDefinition.getDecList().accept(parent);
        functionDefinition.getCompoundStatement().accept(parent);

        SymbolTable.pop();
        return null;
    }

    // visit(CastExpression castExpression)
    public Void visitCastExpression(CastExpression castExpression) {
        if (castExpression.getCastExpression() != null)
            castExpression.getCastExpression().accept(parent);
        if (castExpression.getExpression() != null)
            castExpression.getExpression().accept(parent);
        if (castExpression.getTypeName() != null)
            castExpression.getTypeName().accept(parent);
        return null;
    }

    // visit(Declaration declaration)
    public Void visitDeclaration(Declaration declaration) {
        declaration.getDeclarationSpecifiers().accept(parent);
        if (declaration.getInitDeclaratorList() != null)
            declaration.getInitDeclaratorList().accept(parent);
        return null;
    }

    // visit(DecList decList)
    public Void visitDecList(DecList decList) {
        for (Declaration declaration : decList.getDeclarations())
            declaration.accept(parent);
        return null;
    }

    // visit(DeclarationSpecifiers declarationSpecifiers)
    public Void visitDeclarationSpecifiers(DeclarationSpecifiers declarationSpecifiers) {
        for (DeclarationSpecifier declarationSpecifier : declarationSpecifiers.getDeclarationSpecifiers())
            declarationSpecifier.accept(parent);
        if (declarationSpecifiers.getDeclarationSpecifiers().get(0).getType() != null
                && declarationSpecifiers.getDeclarationSpecifiers().get(0).getType().equals("typedef")) {
            declarationSpecifiers.getDeclarationSpecifiers()
                    .get(declarationSpecifiers.getDeclarationSpecifiers().size()-1)
                    .getTypeSpecifier()
                    .setTypeDef(declarationSpecifiers.getDeclarationSpecifiers().get(1).getType());
        }
        return null;
    }

    // visit(ForDec forDec)
    public Void visitForDec(ForDec forDec) {
        forDec.getDeclarationSpecifiers().accept(parent);
        if (forDec.getInitDecList() != null)
            forDec.getInitDecList().accept(parent);

        return null;
    }

    // visit(DeclarationSpecifier declarationSpecifier)
    public Void visitDeclarationSpecifier(DeclarationSpecifier declarationSpecifier) {
        if (declarationSpecifier.getTypeSpecifier() != null)
            declarationSpecifier.getTypeSpecifier().accept(parent);
        return null;
    }

    // visit(InitDeclaratorList initDeclaratorList)
    public Void visitInitDeclaratorList(InitDeclaratorList initDeclaratorList) {
        for (InitDeclarator initDeclarator : initDeclaratorList.getInitDeclarators())
            initDeclarator.accept(parent);
        return null;
    }

    // visit(InitDeclarator initDeclarator)
    public Void visitInitDeclarator(InitDeclarator initDeclarator) {
        DirectDec directDec = initDeclarator.getDeclarator().getDirectDec();
        while (directDec.getIdentifier().isEmpty())
            directDec = directDec.getDirectDec();
        if (!directDec.getIdentifier().isEmpty()) {
            TypeSpecifier typeSpecifier = new TypeSpecifier(directDec.getIdentifier());
            typeSpecifier.setLine(directDec.getLine());
            directDec.setTypeSpecifier(typeSpecifier);
            VarDecSymbolTableItem var_dec_item = new VarDecSymbolTableItem(typeSpecifier);
            try {
                SymbolTable.top.put(var_dec_item);
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Redeclaration of variable \"" + typeSpecifier.getType() + "\" in line "
                        + typeSpecifier.getLine());
                parent.setSuccessfulDone(false);
            }
        }

        initDeclarator.getDeclarator().accept(parent);
        if (initDeclarator.getInitializer() != null)
            initDeclarator.getInitializer().accept(parent);
        return null;
    }

    // visit(ArgExpression argExpression)
    public Void visitArgExpression(ArgExpression argExpression) {
        for (Expression expression : argExpression.getExpressions())
            if (expression != null)
                expression.accept(parent);
        return null;
    }

    // visit(UnaryOperator unaryOperator)
    public Void visitUnaryOperator() {
        return null;
    }

    // visit(TypeSpecifier typeSpecifier)
    public Void visitTypeSpecifier(TypeSpecifier typeSpecifier) {
        try {
            TypeSpecifier typeSpecifier2 = ((VarDecSymbolTableItem) SymbolTable.top
                    .getItem(VarDecSymbolTableItem.START_KEY + typeSpecifier.getType())).getVarDec();
            if (typeSpecifier2.isTypeDef()) {
                typeSpecifier.setType(typeSpecifier2.getTypeDefName());
                typeSpecifier.setNotVarDec();
            }
        } catch (ItemNotFoundException e) {
            // ignore if not found
        }

        if (typeSpecifier.isVar_dec()) {
            VarDecSymbolTableItem var_dec_item = new VarDecSymbolTableItem(typeSpecifier);
            try {
                SymbolTable.top.put(var_dec_item);
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Redeclaration of variable \"" + typeSpecifier.getType() + "\" in line "
                        + typeSpecifier.getLine());
                parent.setSuccessfulDone(false) ;
            }
        }

        return null;
    }

    // visit(AssignmentOp assignmentOp)
    public Void visitAssignmentOp() {
        return null;
    }

    // visit(Pointer pointer)
    public Void visitPointer() {
        return null;
    }

    // visit(ParameterList parameterList)
    public Void visitParameterList(ParameterList parameterList) {
        for (ParameterDec parameterDec : parameterList.getParameterDecs())
            parameterDec.accept(parent);
        return null;
    }

    // visit(Declarator declarator)
    public Void visitDeclarator(Declarator declarator) {
        declarator.getDirectDec().accept(parent);
        if (declarator.getPointer() != null)
            declarator.getPointer().accept(parent);
        return null;
    }

    // visit(DirectDec directDec)
    public Void visitDirectDec(DirectDec directDec) {
        if (directDec.getDeclarator() != null)
            directDec.getDeclarator().accept(parent);
        if (directDec.getDirectDec() != null)
            directDec.getDirectDec().accept(parent);
        if (directDec.getIdentifierList() != null)
            directDec.getIdentifierList().accept(parent);
        if (directDec.getExpression() != null)
            directDec.getExpression().accept(parent);
        if (directDec.getParameterList() != null)
            directDec.getParameterList().accept(parent);
        return null;
    }

    // visit(SpecifierQualifierList specifierQualifierList)
    public Void visitSpecifierQualifierList(SpecifierQualifierList specifierQualifierList) {
        if (specifierQualifierList.getTypeSpecifier() != null)
            specifierQualifierList.getTypeSpecifier().accept(parent);
        if (specifierQualifierList.getSpecifierQualifierList() != null)
            specifierQualifierList.getSpecifierQualifierList().accept(parent);
        return null;
    }

    // visit(ParameterDec parameterDec)
    public Void visitParameterDec(ParameterDec parameterDec) {
        parameterDec.getDeclarationSpecifier().accept(parent);
        if (parameterDec.getAbstractDec() != null)
            parameterDec.getAbstractDec().accept(parent);
        if (parameterDec.getDeclarator() != null)
            parameterDec.getDeclarator().accept(parent);
        return null;
    }

    // visit(IdentifierList identifierList)
    public Void visitIdentifierList() {
        return null;
    }

    // visit(TypeName typeName)
    public Void visitTypeName(TypeName typeName) {
        typeName.getSpecifierQualifierList().accept(parent);
        if (typeName.getAbstractDec() != null)
            typeName.getAbstractDec().accept(parent);
        return null;
    }


    // visit(DirectAbsDec directAbsDec)
    public Void visitDirectAbsDec(DirectAbsDec directAbsDec) {
        if (directAbsDec.getExpression() != null)
            directAbsDec.getExpression().accept(parent);
        if (directAbsDec.getAbstractDec() != null)
            directAbsDec.getAbstractDec().accept(parent);
        if (directAbsDec.getParameterList() != null)
            directAbsDec.getParameterList().accept(parent);
        if (directAbsDec.getDirectAbsDec() != null)
            directAbsDec.getDirectAbsDec().accept(parent);
        return null;
    }

    // visit(AbstractDec abstractDec)
    public Void visitAbstractDec(AbstractDec abstractDec) {
        abstractDec.getPointer().accept(parent);
        if (abstractDec.getDirectAbsDec() != null)
            abstractDec.getDirectAbsDec().accept(parent);
        return null;
    }

    public Void visitInitializer(Initializer initializer) {
        if (initializer.getExpression() != null)
            initializer.getExpression().accept(parent);
        else
            initializer.getInitList().accept(parent);
        return null;
    }

    public Void visitInitializerList(InitializerList initializerList) {
        for (Initializer initializer : initializerList.getInitializers())
            initializer.accept(parent);
        for (Designation designation : initializerList.getDesignations())
            designation.accept(parent);
        return null;
    }

    public Void visitDesignation(Designation designation) {
        for (Designator designator : designation.getDesignators())
            designator.accept(parent);
        return null;
    }

    public Void visitDesignator(Designator designator) {
        if (designator.getExpression() != null)
            designator.getExpression().accept(parent);
        return null;
    }

    public Void visitCompoundStatement(CompoundStatement compoundStatement) {
        for (BlockItem blockItem : compoundStatement.getBlockItems()) {
            blockItem.accept(parent);
        }
        return null;
    }

    public Void visitBlockItem(BlockItem blockItem) {
        if (blockItem.getStatement() != null)
            blockItem.getStatement().accept(parent);
        else
            blockItem.getDeclaration().accept(parent);
        return null;
    }

    public Void visitExpressionStatement(ExpressionStatement expressionStatement) {
        if (expressionStatement.getExpression() != null)
            expressionStatement.getExpression().accept(parent);
        return null;
    }

     public Void visitSelectionStatement(SelectionStatement selectionStatement) {
        SymbolTable symbolTable = new SymbolTable(SymbolTable.top);
        selectionStatement.setSymbolTable(symbolTable);
        SymbolTable.push(symbolTable);

        selectionStatement.getExpression().accept(parent);
        selectionStatement.getMainStatement().accept(parent);
        if (selectionStatement.getElseStatement() != null)
            selectionStatement.getElseStatement().accept(parent);

        SymbolTable.pop();
        return null;
    }


    public Void visitIterStatement(IterStatement iterStatement) {
        SymbolTable symbolTable = new SymbolTable(SymbolTable.top);
        iterStatement.setSymbolTable(symbolTable);
        SymbolTable.push(symbolTable);

        if (iterStatement.getForCondition() != null)
            iterStatement.getForCondition().accept(parent);
        if (iterStatement.getExpression() != null)
            iterStatement.getExpression().accept(parent);
        if (iterStatement.getStatement() != null)
            iterStatement.getStatement().accept(parent);

        SymbolTable.pop();
        return null;
    }

     public Void visitForCondition(ForCondition forCondition) {
        if (forCondition.getForDec() != null)
            forCondition.getForDec().accept(parent);
        if (forCondition.getExpression() != null)
            forCondition.getExpression().accept(parent);
        if (forCondition.getForExpression1() != null)
            forCondition.getForExpression1().accept(parent);
        if (forCondition.getForExpression2() != null)
            forCondition.getForExpression2().accept(parent);
        return null;
    }

   public Void visitForExpression(ForExpression forExpression) {
        for (Expression expression : forExpression.getExpressions()) {
            if (expression != null)
                expression.accept(parent);
        }
        return null;
    }

    // visit(JumpStatement jumpStatement)
    public Void visitJumpStatement(JumpStatement jumpStatement) {
        if (jumpStatement.getCondition() != null)
            jumpStatement.getCondition().accept(parent);
        return null;
    }

    // visit(FuncCall funcCall)
    public Void visitFuncCall(FuncCall funcCall) {
        String funcName = ((Identifier) funcCall.getExpression()).getIdentifier();
        int line = funcCall.getExpression().getLine();
        ((Identifier) funcCall.getExpression()).setFunc();

        if (funcName.equals("scanf") || funcName.equals("printf")) {
            // do nothing
        } else {
            try {
                SymbolTable.top.getItem(FuncDecSymbolTableItem.START_KEY + funcCall.getNumArgs() + funcName);
            } catch (ItemNotFoundException e) {
                System.out.println("Line:" + line + "-> " + funcName + " not declared");
                parent.setSuccessfulDone(false) ;
            }
        }

        funcCall.getExpression().accept(parent);
        if (funcCall.getArgExpression() != null) {
            funcCall.getArgExpression().accept(parent);
        }

        return null;
    }


    // visit(UnaryExpression unaryExpr)

    public Void visitUnaryExpression(UnaryExpression unaryExpr) {
        unaryExpr.getExpression().accept(parent);
        return null;
    }

    // visit(ExpressionCast expressionCast)
    public Void visitExpressionCast(ExpressionCast expressionCast) {
        expressionCast.getCastExpression().accept(parent);
        expressionCast.getTypeName().accept(parent);
        return null;
    }


    // visit(BinaryExpression binaryExpr)
    public Void visitBinaryExpression(BinaryExpression binaryExpr) {
        binaryExpr.getExpression1().accept(parent);
        binaryExpr.getExpression2().accept(parent);
        if (binaryExpr.getAssignmentOp() != null)
            binaryExpr.getAssignmentOp().accept(parent);
        return null;
    }


    // visit(CondExpression condExpr)
    public Void visitCondExpression(CondExpression condExpr) {
        condExpr.getExpression1().accept(parent);
        condExpr.getExpression2().accept(parent);
        condExpr.getExpression3().accept(parent);
        return null;
    }

    // visit(CommaExpression commaExpression)
    public Void visitCommaExpression(CommaExpression commaExpression) {
        for (Expression expression : commaExpression.getExpressions())
            if (expression != null)
                expression.accept(parent);
        return null;
    }

    public Void visitArrayIndexing(ArrayIndexing arrayIndexing) {
        arrayIndexing.getExpression1().accept(parent);
        arrayIndexing.getExpression2().accept(parent);
        return null;
    }

    public Void visitIdentifier(Identifier identifier) {
        if (!identifier.isFunc() && !identifier.getIdentifier().startsWith("\"")) {
            try {
                SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY + identifier.getIdentifier());
            } catch (ItemNotFoundException e) {
                System.out.println("Line:" + identifier.getLine() + "-> " + identifier.getIdentifier() + " not declared");
                parent.setSuccessfulDone(false);
            }
        }
        return null;
    }

    public Void visitConstant() {
        return null;
    }

    public Void visitTIExpression(TIExpression tiExpression) {
        tiExpression.getInitializerList().accept(parent);
        tiExpression.getTypeName().accept(parent);
        return null;
    }

    public Void visitPrefixExpression(PrefixExpression prefixExpr) {
        if (prefixExpr.getExpression() != null)
            prefixExpr.getExpression().accept(parent);
        if (prefixExpr.getCastExpression() != null)
            prefixExpr.getCastExpression().accept(parent);
        if (prefixExpr.getTypeName() != null)
            prefixExpr.getTypeName().accept(parent);
        if (prefixExpr.getTIExpression() != null)
            prefixExpr.getTIExpression().accept(parent);
        if (prefixExpr.getUnaryOp() != null)
            prefixExpr.getUnaryOp().accept(parent);
        return null;
    }
}