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
import main.visitor.Visitor;

public class Operationtimizer extends Visitor<Void> {
    public SymbolTable symbolTableMain;
    public boolean changed = false;

    public Operationtimizer(SymbolTable symbolTableMain) {
        this.symbolTableMain = symbolTableMain;
    }

    @Override
    public Void visit(Program program) {
        program.getTranslationUnit().accept(this);
        return null;
    }

    public Void visit(TranslationUnit translationUnit) {
        for (int i = 0; i < translationUnit.getExternalDeclaration().size(); i++) {
            ExternalDeclaration externalDeclaration = translationUnit.getExternalDeclaration().get(i);
            if (externalDeclaration.getFunctionDefinition() != null) {
                String funcName = externalDeclaration.getFunctionDefinition().getDeclarator().getDirectDec()
                        .getDirectDec().getIdentifier();
                if (funcName.equals("main")) {
                    SymbolTable symbolTable = externalDeclaration.getFunctionDefinition().getSymbolTable();
                    symbolTableMain.push(symbolTable);
                    symbolTable = symbolTableMain.top;
                    while (symbolTable != null) {
                        for (SymbolTableItem si : symbolTable.items.values()) {
                            if (si instanceof FuncDecSymbolTableItem && !si.isUsed()) {
                                changed = changed
                                        | translationUnit.removeFuncDec(((FuncDecSymbolTableItem) si).getFuncDec());
                            }
                        }
                        symbolTable = symbolTable.pre;
                    }
                    symbolTableMain.pop();
                }
            }
        }
        for (ExternalDeclaration externalDeclaration : translationUnit.getExternalDeclaration())
            externalDeclaration.accept(this);
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
        symbolTableMain.push(functionDefinition.getSymbolTable());
        if (functionDefinition.getDecSpecifiers() != null)
            functionDefinition.getDecSpecifiers().accept(this);
        functionDefinition.getDeclarator().accept(this);
        if (functionDefinition.getDecList() != null)
            functionDefinition.getDecList().accept(this);
        functionDefinition.getCompoundStatement().accept(this);

        ParameterList plist = functionDefinition.getDeclarator().getDirectDec().getParameterList();
        if (plist == null)
            functionDefinition.setNumArgs(0);
        else
            functionDefinition.setNumArgs(plist.getParameterDecs().size());
        symbolTableMain.pop();
        return null;
    }

    public Void visit(CastExpression castExpr) {
        if (castExpr.getCastExpression() != null)
            castExpr.getCastExpression().accept(this);
        if (castExpr.getExpression() != null)
            castExpr.getExpression().accept(this);
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

    public Void visit(ArgExpression argExpr) {
        for (Expression expression : argExpr.getExpressions())
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

    public Void visit(AssignmentOperation assignmentOperation) {
        return null;
    }

    public Void visit(Pointer pointer) {
        return null;
    }

    public Void visit(ParameterList parameterList) {
        for (SymbolTableItem si : symbolTableMain.top.items.values()) {
            if (si instanceof VarDecSymbolTableItem && !si.isUsed()) {
                changed = changed
                        | parameterList.removeParamDec((TypeSpecifier) ((VarDecSymbolTableItem) si).getVarDec());
            }
        }
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
        for (int i = 0; i < compoundStatement.getBlockItems().size(); i++) {
            BlockItem blockItem = compoundStatement.getBlockItems().get(i);
            blockItem.accept(this);
            if ((blockItem.getStatement() != null && blockItem.getStatement() instanceof JumpStatement) ||
                    (blockItem.getStatement() != null && blockItem.getStatement() instanceof SelectionStatement &&
                            ((SelectionStatement) blockItem.getStatement()).allReturn()))
                changed = changed | compoundStatement.removeNextBIs(blockItem);
            if (blockItem.getStatement() != null && blockItem.getStatement() instanceof ExpressionStatement) {
                ExpressionStatement expressionStatement = (ExpressionStatement) blockItem.getStatement();
                if (expressionStatement.getExpression() != null
                        && ((expressionStatement.getExpression() instanceof BinaryExpression
                                && ((BinaryExpression) expressionStatement.getExpression())
                                        .getAssignmentOperation() == null)
                                ||
                                expressionStatement.getExpression() instanceof Constant
                                || expressionStatement.getExpression() instanceof Identifier
                                ||
                                expressionStatement.getExpression() instanceof ArrayIndexing
                                || expressionStatement.getExpression() instanceof CondExpression ||
                                expressionStatement.getExpression() instanceof CommaExpression)) {
                    boolean temp = compoundStatement.removeBI(blockItem);
                    if (temp)
                        i--;
                    changed = changed | temp;
                }
            }
            if (blockItem.getDeclaration() != null)
                for (SymbolTableItem si : symbolTableMain.top.items.values())
                    if (si instanceof VarDecSymbolTableItem && !si.isUsed()) {
                        if (blockItem.getDeclaration().getDeclarationSpecifiers().getDeclarationSpecifiers()
                                .get(blockItem.getDeclaration().getDeclarationSpecifiers().getDeclarationSpecifiers()
                                        .size() - 1)
                                .getTypeSpecifier().equals(((VarDecSymbolTableItem) si).getVarDec()) ||
                                (blockItem.getDeclaration().getInitDeclaratorList() != null &&
                                        !blockItem.getDeclaration().getInitDeclaratorList().getInitDeclarators().get(0)
                                                .getDeclarator().getDirectDec().getIdentifier()
                                                .equals(((VarDecSymbolTableItem) si).getVarDec().getType()))) {
                            boolean temp = compoundStatement.removeBI(blockItem);
                            if (temp)
                                i--;
                            changed = changed | temp;
                        }
                    }
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
        SymbolTable.push(selectionStatement.getSymbolTable());
        selectionStatement.getExpression().accept(this);
        selectionStatement.getMainStatement().accept(this);
        if (selectionStatement.getElseStatement() != null)
            selectionStatement.getElseStatement().accept(this);
        SymbolTable.pop();
        return null;
    }

    public Void visit(IterStatement iterStatement) {
        SymbolTable.push(iterStatement.getSymbolTable());
        if (iterStatement.getExpression() != null)
            iterStatement.getExpression().accept(this);
        if (iterStatement.getStatement() != null)
            iterStatement.getStatement().accept(this);
        if (iterStatement.getForCondition() != null)
            iterStatement.getForCondition().accept(this);
        SymbolTable.pop();
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

    public Void visit(ForExpression forExpr) {
        for (Expression expression : forExpr.getExpressions()) {
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

        String funcName = ((Identifier) funcCall.getExpression()).getIdentifier();
        int line = ((Identifier) funcCall.getExpression()).getLine();
        FuncDecSymbolTableItem funcDec = null;
        if (funcName.equals("scanf") || funcName.equals("printf")) {
        } else {
            try {
                funcDec = (FuncDecSymbolTableItem) SymbolTable.top
                        .getItem(FuncDecSymbolTableItem.START_KEY + funcCall.getNumArgs() + funcName);
            } catch (ItemNotFoundException e) {
                System.out.println("Line:" + line + "-> " + funcName + " not declared");
            }
            while (funcCall.getNumArgs() != funcDec.getFuncDec().getNumArgs()) {
                funcCall.removeArg();
                changed = true;
            }
        }

        funcCall.getExpression().accept(this);
        if (funcCall.getArgExpression() != null)
            funcCall.getArgExpression().accept(this);
        return null;
    }

    public Void visit(UnaryExpression unaryExpression) {
        unaryExpression.getExpression().accept(this);
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
        if (binaryExpression.getAssignmentOperation() != null)
            binaryExpression.getAssignmentOperation().accept(this);
        return null;
    }

    public Void visit(CondExpression condExpr) {
        condExpr.getExpression1().accept(this);
        condExpr.getExpression2().accept(this);
        condExpr.getExpression3().accept(this);
        return null;
    }

    public Void visit(CommaExpression commaExpr) {
        for (Expression expression : commaExpr.getExpressions())
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

    public Void visit(TIExpression tiExpr) {
        tiExpr.getInitializerList().accept(this);
        tiExpr.getTypeName().accept(this);
        return null;
    }

    public Void visit(PrefixExpression prefixExpr) {
        if (prefixExpr.getExpression() != null)
            prefixExpr.getExpression().accept(this);
        if (prefixExpr.getCastExpression() != null)
            prefixExpr.getCastExpression().accept(this);
        if (prefixExpr.getTypeName() != null)
            prefixExpr.getTypeName().accept(this);
        if (prefixExpr.getTIExpression() != null)
            prefixExpr.getTIExpression().accept(this);
        if (prefixExpr.getUnaryOperation() != null)
            prefixExpr.getUnaryOperation().accept(this);
        return null;
    }
}
