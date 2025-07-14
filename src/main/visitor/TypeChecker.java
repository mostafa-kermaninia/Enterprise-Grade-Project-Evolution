package main.visitor;

import java.util.ArrayList;

import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;
import main.ast.declaration_DIR.AbstractDec;
import main.ast.declaration_DIR.DecList;
import main.ast.declaration_DIR.DeclarationSpecifier;
import main.ast.declaration_DIR.DeclarationSpecifiers;
import main.ast.declaration_DIR.Declarator;
import main.ast.declaration_DIR.DirectAbsDec;
import main.ast.declaration_DIR.DirectDec;
import main.ast.declaration_DIR.ForDec;
import main.ast.declaration_DIR.InitDeclarator;
import main.ast.declaration_DIR.InitDeclaratorList;
import main.ast.declaration_DIR.ParameterDec;
import main.ast.expression_DIR.ArgExpr;
import main.ast.expression_DIR.ArrayIndexing;
import main.ast.expression_DIR.BinaryExpr;
import main.ast.expression_DIR.CastExpr;
import main.ast.expression_DIR.CommaExpr;
import main.ast.expression_DIR.CondExpr;
import main.ast.expression_DIR.Constant;
import main.ast.expression_DIR.ExprCast;
import main.ast.expression_DIR.ForExpr;
import main.ast.expression_DIR.FuncCall;
import main.ast.expression_DIR.Identifier;
import main.ast.expression_DIR.IdentifierList;
import main.ast.expression_DIR.PrefixExpr;
import main.ast.expression_DIR.TIExpr;
import main.ast.expression_DIR.UnaryExpr;
import main.ast.literal_DIR.AssignmentOp;
import main.ast.literal_DIR.Designation;
import main.ast.literal_DIR.Designator;
import main.ast.literal_DIR.ExternalDeclaration;
import main.ast.literal_DIR.ForCondition;
import main.ast.literal_DIR.FunctionDefinition;
import main.ast.literal_DIR.SpecifierQualifierList;
import main.ast.literal_DIR.TypeName;
import main.ast.literal_DIR.TypeSpecifier;
import main.ast.literal_DIR.UnaryOperator;
import main.ast.mainNodes_DIR.Declaration;
import main.ast.mainNodes_DIR.Expr;
import main.ast.mainNodes_DIR.Pointer;
import main.ast.statement_DIR.BlockItem;
import main.ast.statement_DIR.CompoundStmt;
import main.ast.statement_DIR.ExprStmt;
import main.ast.statement_DIR.Initializer;
import main.ast.statement_DIR.InitializerList;
import main.ast.statement_DIR.IterStmt;
import main.ast.statement_DIR.JumpStmt;
import main.ast.statement_DIR.ParameterList;
import main.ast.statement_DIR.SelectionStmt;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.VarDecSymbolTableItem;
import main.utils.ExpressionTypeEvaluator;

public class TypeChecker extends Visitor<Void> {
    public SymbolTable symbolTableMain;
    public boolean changed = false;

    public TypeChecker(SymbolTable symbolTableMain) {
        this.symbolTableMain = symbolTableMain;
    }

    @Override
    public Void visit(Program program) {
        program.getTranslationUnit().accept(this);
        return null;
    }

    public Void visit(TranslationUnit translationUnit) {
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

    public String funcType = "void";
    public boolean inFuncDecl = false;

    public Void visit(FunctionDefinition functionDefinition) {
        inFuncDecl = true;
        symbolTableMain.push(functionDefinition.getSymbolTable());
        funcType = functionDefinition.getDecSpecifiers().getDeclarationSpecifiers().get(0).getTypeSpecifier().getType();
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
        inFuncDecl = false;
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

    private boolean initDastan = false;
    private String varType = "void";

    public Void visit(Declaration declaration) {
        declaration.getDeclarationSpecifiers().accept(this);
        if (declaration.getInitDeclaratorList() != null) {
            initDastan = true;
            varType = declaration.getDeclarationSpecifiers().getDeclarationSpecifiers().get(0).getTypeSpecifier()
                    .getType();
            declaration.getInitDeclaratorList().accept(this);
            initDastan = false;
        }
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
        for (ParameterDec parameterDec : parameterList.getParameterDecs())
            parameterDec.accept(this);
        return null;
    }

    public Void visit(Declarator declarator) {
        declarator.getDirectDec().accept(this);
        if (declarator.getPointer() != null) {
            declarator.getPointer().accept(this);
        }
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
        if (initializer.getExpr() != null) {
            if (initDastan) {
                ExpressionTypeEvaluator my_TEval = new ExpressionTypeEvaluator(SymbolTable.top);
                boolean typeCheckError = !my_TEval.checkType(varType, my_TEval.getType(initializer.getExpr()));
                if (typeCheckError) {
                    System.out.println("Line:" + initializer.getLine() + " -> " + "type mismatch in expression");
                    return null;
                }
            }
            initializer.getExpr().accept(this);
        } else
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
        ExpressionTypeEvaluator my_TEval = new ExpressionTypeEvaluator(SymbolTable.top);
        if (jumpStmt.getCondition() != null) {
            jumpStmt.getCondition().accept(this);
            if (jumpStmt.isReturn() && inFuncDecl &&
                    !my_TEval.checkType(funcType, my_TEval.getType(jumpStmt.getCondition()))) // type check she ba
                                                                                              // assignment
                System.out.println("Line:" + jumpStmt.getLine() + " -> " + "return type mismatch");
            // System.out.println(funcType + "................." +
            // my_TEval.getType(jumpStmt.getCondition()));
        } else if (jumpStmt.isReturn() && inFuncDecl && !(funcType.equals("void")))
            System.out.println("Line:" + jumpStmt.getLine() + " -> " + "return type mismatch");

        return null;
    }

    public Void checkArgTypes(FunctionDefinition funcDef, FuncCall funcCall) {
        ExpressionTypeEvaluator my_TEval = new ExpressionTypeEvaluator(SymbolTable.top);
        SymbolTable defSymbolTable = funcDef.getSymbolTable();
        SymbolTable.push(funcDef.getSymbolTable());
        ArrayList<String> type1 = new ArrayList<>(), type2 = new ArrayList<>();
        if (funcDef.getDeclarator().getDirectDec().getParameterList() == null)
            return null;
        for (ParameterDec pd : funcDef.getDeclarator().getDirectDec().getParameterList().getParameterDecs()) {
            String identifier = pd.getDeclarator() != null ? pd.getDeclarator().getDirectDec().getIdentifier()
                    : pd.getDeclarationSpecifier().getDeclarationSpecifiers()
                            .get(pd.getDeclarationSpecifier().getDeclarationSpecifiers().size() - 1).getTypeSpecifier()
                            .getType();
            try {
                type1.add(((VarDecSymbolTableItem) SymbolTable.top
                        .getItem(VarDecSymbolTableItem.START_KEY + identifier)).type);
            } catch (ItemNotFoundException e) {
                System.out.println(
                        "Line: amoooo" + ((Identifier) funcCall.getExpr()).getLine() + "-> " + " not declared");
            }
        }
        SymbolTable.pop();
        if (funcCall.getArgExpr() == null)
            return null;
        for (Expr expr : funcCall.getArgExpr().getExprs()) {
            type2.add(my_TEval.getType(expr));
        }
        for (int i = 0; i < type1.size(); i++) {
            if (!my_TEval.checkType(type1.get(i), type2.get(i))) {
                int line = ((Identifier) funcCall.getExpr()).getLine();
                // System.out.println("Line: " + line + " -> " + type1.get(i) + " ..... " +
                // type2.get(i));
                System.out.println("Line:" + line + " -> argument type mismatch");
                return null;
            }
        }

        return null;
    }

    public Void visit(FuncCall funcCall) {

        String funcName = ((Identifier) funcCall.getExpr()).getIdentifier();
        int line = ((Identifier) funcCall.getExpr()).getLine();
        FuncDecSymbolTableItem funcDec = null;
        if (funcName.equals("scanf") || funcName.equals("printf") || funcName.equals("malloc") ||
                funcName.equals("free")) {
        } else {
            try {
                funcDec = (FuncDecSymbolTableItem) SymbolTable.top
                        .getItem(FuncDecSymbolTableItem.START_KEY + funcCall.getNumArgs() + funcName);
            } catch (ItemNotFoundException e) {
                System.out.println("Line:" + line + "-> " + funcName + " not declared");
            }
        }
        if (funcDec != null) {
            checkArgTypes(funcDec.getFuncDec(), funcCall);
        }

        funcCall.getExpr().accept(this);
        if (funcCall.getArgExpr() != null)
            funcCall.getArgExpr().accept(this);
        return null;
    }

    public Void visit(UnaryExpr unaryExpr) {
        ExpressionTypeEvaluator my_TEval = new ExpressionTypeEvaluator(SymbolTable.top);
        boolean typeCheckError = !my_TEval.checkType(unaryExpr);
        if (typeCheckError) {
            System.out.println("Line:" + unaryExpr.getLine() + " -> " + "type mismatch in expression");
            return null;
        }
        unaryExpr.getExpr().accept(this);
        return null;
    }

    public Void visit(ExprCast exprCast) {
        exprCast.getCastExpr().accept(this);
        exprCast.getTypeName().accept(this);
        return null;
    }

    public Void visit(BinaryExpr binaryExpr) {
        ExpressionTypeEvaluator my_TEval = new ExpressionTypeEvaluator(SymbolTable.top);
        boolean typeCheckError = !my_TEval.checkType(binaryExpr);
        if (typeCheckError) {
            System.out.println("Line:" + binaryExpr.getLine() + " -> " + "type mismatch in expression");
            return null;
        }
        binaryExpr.getExpr1().accept(this);
        binaryExpr.getExpr2().accept(this);
        if (binaryExpr.getAssignmentOp() != null)
            binaryExpr.getAssignmentOp().accept(this);
        return null;
    }

    public Void visit(CondExpr condExpr) {
        ExpressionTypeEvaluator my_TEval = new ExpressionTypeEvaluator(SymbolTable.top);
        boolean typeCheckError = !my_TEval.checkType(condExpr);
        if (typeCheckError) {
            System.out.println("Line:" + condExpr.getLine() + " -> " + "type mismatch in expression");
            return null;
        }
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
        ExpressionTypeEvaluator my_TEval = new ExpressionTypeEvaluator(SymbolTable.top);
        boolean typeCheckError = !my_TEval.checkType(prefixExpr);
        if (typeCheckError) {
            System.out.println("Line:" + prefixExpr.getLine() + " -> " + "type mismatch in expression");
            return null;
        }
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
