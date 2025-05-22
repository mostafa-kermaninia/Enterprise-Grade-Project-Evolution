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

public class Optimizer extends Visitor<Void> {
    public SymbolTable symbolTableMain;
    public boolean changed = false;

    public Optimizer(SymbolTable symbolTableMain) {
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
        functionDefinition.getCompoundStmt().accept(this);

        ParameterList plist = functionDefinition.getDeclarator().getDirectDec().getParameterList();
        if (plist == null)
            functionDefinition.setNumArgs(0);
        else
            functionDefinition.setNumArgs(plist.getParameterDecs().size());
        symbolTableMain.pop();
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
        for (int i = 0; i < compoundStmt.getBlockItems().size(); i++) {
            BlockItem blockItem = compoundStmt.getBlockItems().get(i);
            blockItem.accept(this);
            if ((blockItem.getStmt() != null && blockItem.getStmt() instanceof JumpStmt) ||
                    (blockItem.getStmt() != null && blockItem.getStmt() instanceof SelectionStmt &&
                            ((SelectionStmt) blockItem.getStmt()).allReturn()))
                changed = changed | compoundStmt.removeNextBIs(blockItem);
            if (blockItem.getStmt() != null && blockItem.getStmt() instanceof ExprStmt) {
                ExprStmt exprStmt = (ExprStmt) blockItem.getStmt();
                if (exprStmt.getExpr() != null && ((exprStmt.getExpr() instanceof BinaryExpr
                        && ((BinaryExpr) exprStmt.getExpr()).getAssignmentOp() == null) ||
                        exprStmt.getExpr() instanceof Constant || exprStmt.getExpr() instanceof Identifier ||
                        exprStmt.getExpr() instanceof ArrayIndexing || exprStmt.getExpr() instanceof CondExpr ||
                        exprStmt.getExpr() instanceof CommaExpr)) {
                    boolean temp = compoundStmt.removeBI(blockItem);
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
                            boolean temp = compoundStmt.removeBI(blockItem);
                            if (temp)
                                i--;
                            changed = changed | temp;
                        }
                    }
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
        SymbolTable.push(selectionStmt.getSymbolTable());
        selectionStmt.getExpr().accept(this);
        selectionStmt.getMainStmt().accept(this);
        if (selectionStmt.getElseStmt() != null)
            selectionStmt.getElseStmt().accept(this);
        SymbolTable.pop();
        return null;
    }

    public Void visit(IterStmt iterStmt) {
        SymbolTable.push(iterStmt.getSymbolTable());
        if (iterStmt.getExpr() != null)
            iterStmt.getExpr().accept(this);
        if (iterStmt.getStmt() != null)
            iterStmt.getStmt().accept(this);
        if (iterStmt.getForCondition() != null)
            iterStmt.getForCondition().accept(this);
        SymbolTable.pop();
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

        String funcName = ((Identifier) funcCall.getExpr()).getIdentifier();
        int line = ((Identifier) funcCall.getExpr()).getLine();
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

        funcCall.getExpr().accept(this);
        if (funcCall.getArgExpr() != null)
            funcCall.getArgExpr().accept(this);
        return null;
    }

    public Void visit(UnaryExpr unaryExpr) {
        unaryExpr.getExpr().accept(this);
        return null;
    }

    public Void visit(ExprCast exprCast) {
        exprCast.getCastExpr().accept(this);
        exprCast.getTypeName().accept(this);
        return null;
    }

    public Void visit(BinaryExpr binaryExpr) {
        binaryExpr.getExpr1().accept(this);
        binaryExpr.getExpr2().accept(this);
        if (binaryExpr.getAssignmentOp() != null)
            binaryExpr.getAssignmentOp().accept(this);
        return null;
    }

    public Void visit(CondExpr condExpr) {
        condExpr.getExpr1().accept(this);
        condExpr.getExpr2().accept(this);
        condExpr.getExpr3().accept(this);
        return null;
    }

    public Void visit(CommaExpr commaExpr) {
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
        return null;
    }

    public Void visit(Constant constant) {
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
