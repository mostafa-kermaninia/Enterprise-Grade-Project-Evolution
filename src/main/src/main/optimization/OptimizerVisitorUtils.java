package main.optimization;

import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;
import main.ast.declaration_DIR.*;
import main.ast.expression_DIR.*;
import main.ast.literal_DIR.*;
import main.ast.statement_DIR.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.SymbolTableItem;
import main.symbolTable.item.VarDecSymbolTableItem;


public class OptimizerVisitorUtils {

    private final Optimizer parent;

    public OptimizerVisitorUtils(Optimizer parent) {
        this.parent = parent;
    }

    public Void visitProgram(Program program) {
        program.getTranslationUnit().accept(parent);
        return null;
    }

    public Void visitTranslationUnit(TranslationUnit translationUnit) {
        for (int i = 0; i < translationUnit.getExternalDeclaration().size(); i++) {
            ExternalDeclaration externalDeclaration = translationUnit.getExternalDeclaration().get(i);
            if (externalDeclaration.getFunctionDefinition() != null) {
                String funcName = externalDeclaration.getFunctionDefinition().getDeclarator()
                        .getDirectDec().getDirectDec().getIdentifier();
                if (funcName.equals("main")) {
                    SymbolTable symbolTable = externalDeclaration.getFunctionDefinition().getSymbolTable();
                    SymbolTable.push(symbolTable);
                    symbolTable = SymbolTable.top;
                    while (symbolTable != null) {
                        for (SymbolTableItem si : symbolTable.items.values()) {
                            if (si instanceof FuncDecSymbolTableItem && !si.isUsed()) {
                                parent.changed = parent.changed
                                        | translationUnit.removeFuncDec(((FuncDecSymbolTableItem) si).getFuncDec());
                            }
                        }
                        symbolTable = symbolTable.pre;
                    }
                    SymbolTable.pop();
                }
            }
        }
        for (ExternalDeclaration externalDeclaration : translationUnit.getExternalDeclaration()) {
            externalDeclaration.accept(parent);
        }
        return null;
    }

    public Void visitExternalDeclaration(ExternalDeclaration externalDeclaration) {
        if (externalDeclaration.getDeclaration() != null) {
            externalDeclaration.getDeclaration().accept(parent);
        } else {
            externalDeclaration.getFunctionDefinition().accept(parent);
        }
        return null;
    }

    public Void visitFunctionDefinition(FunctionDefinition functionDefinition) {
        SymbolTable.push(functionDefinition.getSymbolTable());
        if (functionDefinition.getDecSpecifiers() != null) {
            functionDefinition.getDecSpecifiers().accept(parent);
        }
        functionDefinition.getDeclarator().accept(parent);
        if (functionDefinition.getDecList() != null) {
            functionDefinition.getDecList().accept(parent);
        }
        functionDefinition.getCompoundStatement().accept(parent);

        ParameterList plist = functionDefinition.getDeclarator().getDirectDec().getParameterList();
        if (plist == null) {
            functionDefinition.setNumArgs(0);
        } else {
            functionDefinition.setNumArgs(plist.getParameterDecs().size());
        }
        SymbolTable.pop();
        return null;
    }

    public Void visitCastExpression(CastExpression castExpr) {
        if (castExpr.getCastExpression() != null) {
            castExpr.getCastExpression().accept(parent);
        }
        if (castExpr.getExpression() != null) {
            castExpr.getExpression().accept(parent);
        }
        if (castExpr.getTypeName() != null) {
            castExpr.getTypeName().accept(parent);
        }
        return null;
    }

    public Void visitDeclaration(Declaration declaration) {
        declaration.getDeclarationSpecifiers().accept(parent);
        if (declaration.getInitDeclaratorList() != null) {
            declaration.getInitDeclaratorList().accept(parent);
        }
        return null;
    }

    public Void visitDecList(DecList decList) {
        for (Declaration declaration : decList.getDeclarations()) {
            declaration.accept(parent);
        }
        return null;
    }

    public Void visitDeclarationSpecifiers(DeclarationSpecifiers declarationSpecifiers) {
        for (DeclarationSpecifier ds : declarationSpecifiers.getDeclarationSpecifiers()) {
            ds.accept(parent);
        }
        return null;
    }

    public Void visitForDec(ForDec forDec) {
        forDec.getDeclarationSpecifiers().accept(parent);
        if (forDec.getInitDecList() != null) {
            forDec.getInitDecList().accept(parent);
        }
        return null;
    }

    public Void visitDeclarationSpecifier(DeclarationSpecifier declarationSpecifier) {
        if (declarationSpecifier.getTypeSpecifier() != null && declarationSpecifier.getTypeSpecifier().Used()) {
            declarationSpecifier.getTypeSpecifier().accept(parent);
        }
        return null;
    }

    public Void visitInitDeclaratorList(InitDeclaratorList initDeclaratorList) {
        for (InitDeclarator initDeclarator : initDeclaratorList.getInitDeclarators()) {
            initDeclarator.accept(parent);
        }
        return null;
    }

    public Void visitInitDeclarator(InitDeclarator initDeclarator) {
        initDeclarator.getDeclarator().accept(parent);
        if (initDeclarator.getInitializer() != null) {
            initDeclarator.getInitializer().accept(parent);
        }
        return null;
    }

    public Void visitArgExpression(ArgExpression argExpr) {
        for (Expression expression : argExpr.getExpressions()) {
            if (expression != null) {
                expression.accept(parent);
            }
        }
        return null;
    }

    public Void visitUnaryOperator() {
        return null;
    }

    public Void visitTypeSpecifier() {
        return null;
    }

    public Void visitAssignmentOp() {
        return null;
    }

    public Void visitPointer() {
        return null;
    }

    public Void visitParameterList(ParameterList parameterList) {
        for (SymbolTableItem si : SymbolTable.top.items.values()) {
            if (si instanceof VarDecSymbolTableItem && !si.isUsed()) {
                parent.changed = parent.changed
                        | parameterList.removeParamDec(((VarDecSymbolTableItem) si).getVarDec());
            }
        }
        return null;
    }

    public Void visitDeclarator(Declarator declarator) {
        declarator.getDirectDec().accept(parent);
        if (declarator.getPointer() != null) {
            declarator.getPointer().accept(parent);
        }
        return null;
    }

    public Void visitDirectDec(DirectDec directDec) {
        if (directDec.getDeclarator() != null) {
            directDec.getDeclarator().accept(parent);
        }
        if (directDec.getDirectDec() != null) {
            directDec.getDirectDec().accept(parent);
        }
        if (directDec.getIdentifierList() != null) {
            directDec.getIdentifierList().accept(parent);
        }
        if (directDec.getExpression() != null) {
            directDec.getExpression().accept(parent);
        }
        if (directDec.getParameterList() != null) {
            directDec.getParameterList().accept(parent);
        }
        return null;
    }

    public Void visitSpecifierQualifierList(SpecifierQualifierList specifierQualifierList) {
        if (specifierQualifierList.getTypeSpecifier() != null) {
            specifierQualifierList.getTypeSpecifier().accept(parent);
        }
        if (specifierQualifierList.getSpecifierQualifierList() != null) {
            specifierQualifierList.getSpecifierQualifierList().accept(parent);
        }
        return null;
    }

    public Void visitParameterDec(ParameterDec parameterDec) {
        parameterDec.getDeclarationSpecifier().accept(parent);
        if (parameterDec.getAbstractDec() != null) {
            parameterDec.getAbstractDec().accept(parent);
        }
        if (parameterDec.getDeclarator() != null) {
            parameterDec.getDeclarator().accept(parent);
        }
        return null;
    }

    public Void visitIdentifierList() {
        return null;
    }

    public Void visitTypeName(TypeName typeName) {
        typeName.getSpecifierQualifierList().accept(parent);
        if (typeName.getAbstractDec() != null) {
            typeName.getAbstractDec().accept(parent);
        }
        return null;
    }

    public Void visitDirectAbsDec(DirectAbsDec directAbsDec) {
        if (directAbsDec.getExpression() != null) {
            directAbsDec.getExpression().accept(parent);
        }
        if (directAbsDec.getAbstractDec() != null) {
            directAbsDec.getAbstractDec().accept(parent);
        }
        if (directAbsDec.getParameterList() != null) {
            directAbsDec.getParameterList().accept(parent);
        }
        if (directAbsDec.getDirectAbsDec() != null) {
            directAbsDec.getDirectAbsDec().accept(parent);
        }
        return null;
    }

    public Void visitAbstractDec(AbstractDec abstractDec) {
        if (abstractDec.getPointer() != null) {
            abstractDec.getPointer().accept(parent);
        }
        if (abstractDec.getDirectAbsDec() != null) {
            abstractDec.getDirectAbsDec().accept(parent);
        }
        return null;
    }

    public Void visitInitializer(Initializer initializer) {
        if (initializer.getExpression() != null) {
            initializer.getExpression().accept(parent);
        } else {
            initializer.getInitList().accept(parent);
        }
        return null;
    }

    public Void visitInitializerList(InitializerList initializerList) {
        for (Initializer initializer : initializerList.getInitializers()) {
            initializer.accept(parent);
        }
        for (Designation designation : initializerList.getDesignations()) {
            designation.accept(parent);
        }
        return null;
    }

    public Void visitDesignation(Designation designation) {
        for (Designator designator : designation.getDesignators()) {
            designator.accept(parent);
        }
        return null;
    }

    public Void visitDesignator(Designator designator) {
        if (designator.getExpression() != null) {
            designator.getExpression().accept(parent);
        }
        return null;
    }

    public Void visitCompoundStatement(CompoundStatement compoundStatement) {
        for (int i = 0; i < compoundStatement.getBlockItems().size(); i++) {
            BlockItem blockItem = compoundStatement.getBlockItems().get(i);
            blockItem.accept(parent);
            if ((blockItem.getStatement() != null && blockItem.getStatement() instanceof JumpStatement)
                    || (blockItem.getStatement() != null && blockItem.getStatement() instanceof SelectionStatement
                    && ((SelectionStatement) blockItem.getStatement()).allReturn())) {
                parent.changed = parent.changed | compoundStatement.removeNextBIs(blockItem);
            }
            if (blockItem.getStatement() != null && blockItem.getStatement() instanceof ExpressionStatement expressionStatement) {
                if (expressionStatement.getExpression() != null
                        && ((expressionStatement.getExpression() instanceof BinaryExpression
                        && ((BinaryExpression) expressionStatement.getExpression()).getAssignmentOp() == null)
                        || expressionStatement.getExpression() instanceof Constant
                        || expressionStatement.getExpression() instanceof Identifier
                        || expressionStatement.getExpression() instanceof ArrayIndexing
                        || expressionStatement.getExpression() instanceof CondExpression
                        || expressionStatement.getExpression() instanceof CommaExpression)) {
                    boolean temp = compoundStatement.removeBI(blockItem);
                    if (temp) {
                        i--;
                    }
                    parent.changed = parent.changed | temp;
                }
            }
            if (blockItem.getDeclaration() != null) {
                for (SymbolTableItem si : SymbolTable.top.items.values()) {
                    if (si instanceof VarDecSymbolTableItem && !si.isUsed()) {
                        if (blockItem.getDeclaration().getDeclarationSpecifiers().getDeclarationSpecifiers()
                                .get(blockItem.getDeclaration().getDeclarationSpecifiers()
                                        .getDeclarationSpecifiers().size() - 1)
                                .getTypeSpecifier().equals(((VarDecSymbolTableItem) si).getVarDec())
                                || (blockItem.getDeclaration().getInitDeclaratorList() != null
                                && !blockItem.getDeclaration().getInitDeclaratorList().getInitDeclarators()
                                .get(0).getDeclarator().getDirectDec().getIdentifier()
                                .equals(((VarDecSymbolTableItem) si).getVarDec().getType()))) {
                            boolean temp = compoundStatement.removeBI(blockItem);
                            if (temp) {
                                i--;
                            }
                            parent.changed = parent.changed | temp;
                        }
                    }
                }
            }
        }
        return null;
    }

    public Void visitBlockItem(BlockItem blockItem) {
        if (blockItem.getStatement() != null) {
            blockItem.getStatement().accept(parent);
        } else {
            blockItem.getDeclaration().accept(parent);
        }
        return null;
    }

    public Void visitExpressionStatement(ExpressionStatement expressionStatement) {
        if (expressionStatement.getExpression() != null) {
            expressionStatement.getExpression().accept(parent);
        }
        return null;
    }

    public Void visitSelectionStatement(SelectionStatement selectionStatement) {
        SymbolTable.push(selectionStatement.getSymbolTable());
        selectionStatement.getExpression().accept(parent);
        selectionStatement.getMainStatement().accept(parent);
        if (selectionStatement.getElseStatement() != null) {
            selectionStatement.getElseStatement().accept(parent);
        }
        SymbolTable.pop();
        return null;
    }

    public Void visitIterStatement(IterStatement iterStatement) {
        SymbolTable.push(iterStatement.getSymbolTable());
        if (iterStatement.getExpression() != null) {
            iterStatement.getExpression().accept(parent);
        }
        if (iterStatement.getStatement() != null) {
            iterStatement.getStatement().accept(parent);
        }
        if (iterStatement.getForCondition() != null) {
            iterStatement.getForCondition().accept(parent);
        }
        SymbolTable.pop();
        return null;
    }

    public Void visitForCondition(ForCondition forCondition) {
        if (forCondition.getForDec() != null) {
            forCondition.getForDec().accept(parent);
        }
        if (forCondition.getExpression() != null) {
            forCondition.getExpression().accept(parent);
        }
        if (forCondition.getForExpression1() != null) {
            forCondition.getForExpression1().accept(parent);
        }
        if (forCondition.getForExpression2() != null) {
            forCondition.getForExpression2().accept(parent);
        }
        return null;
    }

    public Void visitForExpression(ForExpression forExpr) {
        for (Expression expression : forExpr.getExpressions()) {
            if (expression != null) {
                expression.accept(parent);
            }
        }
        return null;
    }

    public Void visitJumpStatement(JumpStatement jumpStatement) {
        if (jumpStatement.getCondition() != null) {
            jumpStatement.getCondition().accept(parent);
        }
        return null;
    }

    public Void visitFuncCall(FuncCall funcCall) {
        String funcName = ((Identifier) funcCall.getExpression()).getIdentifier();
        int line = funcCall.getExpression().getLine();
        FuncDecSymbolTableItem funcDec = null;
        if (funcName.equals("scanf") || funcName.equals("printf")) {
            // do nothing here
        } else {
            try {
                funcDec = (FuncDecSymbolTableItem) SymbolTable.top.getItem(
                        FuncDecSymbolTableItem.START_KEY + funcCall.getNumArgs() + funcName);
            } catch (ItemNotFoundException e) {
                System.out.println("Line:" + line + "-> " + funcName + " not declared");
            }
            while (true) {
                assert funcDec != null;
                if (funcCall.getNumArgs() == funcDec.getFuncDec().getNumArgs()) break;
                funcCall.removeArg();
                parent.changed = true;
            }
        }

        funcCall.getExpression().accept(parent);
        if (funcCall.getArgExpression() != null) {
            funcCall.getArgExpression().accept(parent);
        }
        return null;
    }

    public Void visitUnaryExpression(UnaryExpression unaryExpression) {
        unaryExpression.getExpression().accept(parent);
        return null;
    }

    public Void visitExpressionCast(ExpressionCast expressionCast) {
        expressionCast.getCastExpression().accept(parent);
        expressionCast.getTypeName().accept(parent);
        return null;
    }

    public Void visitBinaryExpression(BinaryExpression binaryExpression) {
        binaryExpression.getExpression1().accept(parent);
        binaryExpression.getExpression2().accept(parent);
        if (binaryExpression.getAssignmentOp() != null) {
            binaryExpression.getAssignmentOp().accept(parent);
        }
        return null;
    }

    public Void visitCondExpression(CondExpression condExpr) {
        condExpr.getExpression1().accept(parent);
        condExpr.getExpression2().accept(parent);
        condExpr.getExpression3().accept(parent);
        return null;
    }

    public Void visitCommaExpression(CommaExpression commaExpr) {
        for (Expression expression : commaExpr.getExpressions()) {
            if (expression != null) {
                expression.accept(parent);
            }
        }
        return null;
    }

    public Void visitArrayIndexing(ArrayIndexing arrayIndexing) {
        arrayIndexing.getExpression1().accept(parent);
        arrayIndexing.getExpression2().accept(parent);
        return null;
    }

    public Void visitIdentifier() {
        return null;
    }

    public Void visitConstant() {
        return null;
    }

    public Void visitTIExpression(TIExpression tiExpr) {
        tiExpr.getInitializerList().accept(parent);
        tiExpr.getTypeName().accept(parent);
        return null;
    }

    public Void visitPrefixExpression(PrefixExpression prefixExpr) {
        if (prefixExpr.getExpression() != null) {
            prefixExpr.getExpression().accept(parent);
        }
        if (prefixExpr.getCastExpression() != null) {
            prefixExpr.getCastExpression().accept(parent);
        }
        if (prefixExpr.getTypeName() != null) {
            prefixExpr.getTypeName().accept(parent);
        }
        if (prefixExpr.getTIExpression() != null) {
            prefixExpr.getTIExpression().accept(parent);
        }
        if (prefixExpr.getUnaryOp() != null) {
            prefixExpr.getUnaryOp().accept(parent);
        }
        return null;
    }
}