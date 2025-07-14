package main.visitor;

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
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.VarDecSymbolTableItem;

public class VulnVisitor extends Visitor<Void> {
    public SymbolTable symbolTableMain;
    public boolean noError = true;

    @Override
    public Void visit(Program program) {
        SymbolTable.top = new SymbolTable();
        SymbolTable.root = SymbolTable.top;

        program.setSymbolTable(SymbolTable.top);
        program.getTranslationUnit().accept(this);
        symbolTableMain = SymbolTable.top;
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
        ParameterList plist = functionDefinition.getDeclarator().getDirectDec().getParameterList();
        if (plist == null)
            functionDefinition.setNumArgs(0);
        else
            functionDefinition.setNumArgs(plist.getParameterDecs().size());

        FuncDecSymbolTableItem func_dec_item = new FuncDecSymbolTableItem(functionDefinition);
        func_dec_item.type = functionDefinition.getDecSpecifiers().getDeclarationSpecifiers().get(0).getTypeSpecifier()
                .getType();
        try {
            SymbolTable.top.put(func_dec_item);
        } catch (ItemAlreadyExistsException e) {
            System.out.println("Redefinition of function \"" +
                    functionDefinition.getDeclarator().getDirectDec().getDirectDec().getIdentifier()
                    + "\" in line " + functionDefinition.getDeclarator().getDirectDec().getDirectDec().getLine());
            noError = false;
        }

        SymbolTable func_dec_symbol_table = new SymbolTable(SymbolTable.top);
        functionDefinition.setSymbolTable(func_dec_symbol_table);
        SymbolTable.push(func_dec_symbol_table);

        if (functionDefinition.getDecSpecifiers() != null)
            functionDefinition.getDecSpecifiers().accept(this);
        functionDefinition.getDeclarator().accept(this);
        if (functionDefinition.getDecList() != null)
            functionDefinition.getDecList().accept(this);
        functionDefinition.getCompoundStmt().accept(this);
        SymbolTable.pop();
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

    private String type = "";
    private boolean varDecl = false;

    public Void visit(Declaration declaration) {
        varDecl = true;
        type = declaration.getDeclarationSpecifiers().getDeclarationSpecifiers().get(0).getTypeSpecifier().getType();
        declaration.getDeclarationSpecifiers().accept(this);
        if (declaration.getInitDeclaratorList() != null)
            declaration.getInitDeclaratorList().accept(this);
        varDecl = false;
        return null;
    }

    public Void visit(DecList decList) {
        for (Declaration declaration : decList.getDeclarations())
            declaration.accept(this);
        return null;
    }

    private boolean varDecl2 = false;

    public Void visit(DeclarationSpecifiers declarationSpecifiers) {
        varDecl2 = true;
        type = declarationSpecifiers.getDeclarationSpecifiers().get(0).getTypeSpecifier().getType();
        for (DeclarationSpecifier declarationSpecifier : declarationSpecifiers.getDeclarationSpecifiers())
            declarationSpecifier.accept(this);
        if (declarationSpecifiers.getDeclarationSpecifiers().get(0).getType() != null
                && declarationSpecifiers.getDeclarationSpecifiers().get(0).getType().equals("typedef"))
            declarationSpecifiers.getDeclarationSpecifiers().get(declarationSpecifiers.getDeclarationSpecifiers().size()
                    - 1).getTypeSpecifier()
                    .setTypeDef(declarationSpecifiers.getDeclarationSpecifiers().get(1).getType());
        varDecl2 = false;
        return null;
    }

    public Void visit(ForDec forDec) {
        forDec.getDeclarationSpecifiers().accept(this);
        if (forDec.getInitDecList() != null)
            forDec.getInitDecList().accept(this);

        return null;
    }

    public Void visit(DeclarationSpecifier declarationSpecifier) {
        if (declarationSpecifier.getTypeSpecifier() != null)
            declarationSpecifier.getTypeSpecifier().accept(this);
        return null;
    }

    public Void visit(InitDeclaratorList initDeclaratorList) {
        for (InitDeclarator initDeclarator : initDeclaratorList.getInitDeclarators()) {
            if (initDeclaratorList.getInitDeclarators().get(0).getDeclarator().getPointer() != null)
                initDeclarator.getDeclarator().setPointer(new Pointer());
            initDeclarator.accept(this);
        }

        return null;
    }

    public Void visit(InitDeclarator initDeclarator) {

        initDeclarator.getDeclarator().accept(this);
        if (initDeclarator.getDeclarator().getPointer() != null) {
            String identifier = initDeclarator.getDeclarator().getDirectDec().getIdentifier();
            try {
                ((VarDecSymbolTableItem) SymbolTable.top
                        .getItem(VarDecSymbolTableItem.START_KEY + identifier)).isFree = true;
                ((VarDecSymbolTableItem) SymbolTable.top
                        .getItem(VarDecSymbolTableItem.START_KEY + identifier)).isPtr = true;
            } catch (ItemNotFoundException e) {
            }
        }

        if (initDeclarator.getInitializer() != null) {
            if (initDeclarator.getInitializer().getExpr() instanceof FuncCall &&
                    ((Identifier) ((FuncCall) initDeclarator.getInitializer().getExpr()).getExpr()).getIdentifier()
                            .equals("malloc")) {
                String identifier = initDeclarator.getDeclarator().getDirectDec().getIdentifier();
                try {
                    ((VarDecSymbolTableItem) SymbolTable.top
                            .getItem(VarDecSymbolTableItem.START_KEY + identifier)).isFree = false;
                    ((VarDecSymbolTableItem) SymbolTable.top
                            .getItem(VarDecSymbolTableItem.START_KEY + identifier)).isPtr = true;
                } catch (ItemNotFoundException e) {
                }
            }
            String identifier = initDeclarator.getDeclarator().getDirectDec().getIdentifier();
            try {
                ((VarDecSymbolTableItem) SymbolTable.top
                        .getItem(VarDecSymbolTableItem.START_KEY + identifier)).isInit = true;
            } catch (ItemNotFoundException e) {
            }
            initDeclarator.getInitializer().accept(this);
        }
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
        try {
            TypeSpecifier typeSpecifier2 = ((VarDecSymbolTableItem) SymbolTable.top
                    .getItem(VarDecSymbolTableItem.START_KEY + typeSpecifier.getType())).getVarDec();
            if (typeSpecifier2.isTypeDef()) {
                typeSpecifier.setType(typeSpecifier2.getTypeDefName());
                typeSpecifier.setNotVarDec();
            }
        } catch (ItemNotFoundException e) {

        }

        if (typeSpecifier.isVar_dec()) {
            VarDecSymbolTableItem var_dec_item = new VarDecSymbolTableItem(typeSpecifier);
            if (varDecl || varDecl2)
                var_dec_item.type = type;
            try {
                var_dec_item.isInit = funcArgDef;
                SymbolTable.top.put(var_dec_item);
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Redeclaration of variable \"" + typeSpecifier.getType() + "\" in line "
                        + typeSpecifier.getLine());
                noError = false;
            }
        }

        return null;
    }

    public Void visit(AssignmentOp assignmentOp) {
        return null;
    }

    public Void visit(Pointer pointer) {
        return null;
    }

    boolean funcArgDef = false;

    public Void visit(ParameterList parameterList) {
        funcArgDef = true;
        for (ParameterDec parameterDec : parameterList.getParameterDecs())
            parameterDec.accept(this);
        funcArgDef = false;
        return null;
    }

    public Void visit(Declarator declarator) {
        declarator.getDirectDec().accept(this);
        if (declarator.getPointer() != null) {
            declarator.getPointer().accept(this);
        }
        DirectDec directDec = declarator.getDirectDec();
        while (directDec.getIdentifier().isEmpty())
            directDec = directDec.getDirectDec();
        if (!directDec.getIdentifier().isEmpty()) {
            TypeSpecifier typeSpecifier = new TypeSpecifier(directDec.getIdentifier());
            typeSpecifier.setLine(directDec.getLine());
            directDec.setTypeSpecifier(typeSpecifier);
            VarDecSymbolTableItem var_dec_item = new VarDecSymbolTableItem(typeSpecifier);
            try {
                var_dec_item.isFree = declarator.getPointer() == null;
                var_dec_item.isInit = funcArgDef;
                SymbolTable.top.put(var_dec_item);
                if (varDecl || varDecl2)
                    var_dec_item.type = type;
            } catch (ItemAlreadyExistsException e) {
                System.out.println("Redeclaration of variable \"" + typeSpecifier.getType() + "\" in line "
                        + typeSpecifier.getLine());
                noError = false;
            }
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
        varDecl = true;
        type = parameterDec.getDeclarationSpecifier().getDeclarationSpecifiers().get(0).getTypeSpecifier().getType();
        if (parameterDec.getAbstractDec() != null)
            parameterDec.getAbstractDec().accept(this);
        if (parameterDec.getDeclarator() != null) {
            parameterDec.getDeclarator().accept(this);
            if (parameterDec.getDeclarator().getPointer() != null) {
                String identifier = parameterDec.getDeclarator().getDirectDec().getIdentifier();
                try {
                    ((VarDecSymbolTableItem) SymbolTable.top
                            .getItem(VarDecSymbolTableItem.START_KEY + identifier)).isFree = false;
                } catch (ItemNotFoundException e) {
                }
            }
        }
        varDecl = false;
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
        for (BlockItem blockItem : compoundStmt.getBlockItems()) {
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
        SymbolTable symbolTable = new SymbolTable(SymbolTable.top);
        selectionStmt.setSymbolTable(symbolTable);
        SymbolTable.push(symbolTable);

        selectionStmt.getExpr().accept(this);
        selectionStmt.getMainStmt().accept(this);
        if (selectionStmt.getElseStmt() != null)
            selectionStmt.getElseStmt().accept(this);

        SymbolTable.pop();
        return null;
    }

    public Void visit(IterStmt iterStmt) {
        SymbolTable symbolTable = new SymbolTable(SymbolTable.top);
        iterStmt.setSymbolTable(symbolTable);
        SymbolTable.push(symbolTable);

        if (iterStmt.getForCondition() != null)
            iterStmt.getForCondition().accept(this);
        if (iterStmt.getExpr() != null)
            iterStmt.getExpr().accept(this);
        if (iterStmt.getStmt() != null)
            iterStmt.getStmt().accept(this);

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

    private Void freePtr(Expr expr) {
        Identifier identifier = (Identifier) expr;
        try {
            ((VarDecSymbolTableItem) (SymbolTable.top
                    .getItem(VarDecSymbolTableItem.START_KEY + identifier.getIdentifier()))).isFree = true;
        } catch (ItemNotFoundException e) {
            System.out.println("Line:" + identifier.getLine() + "-> " + identifier.getIdentifier() + " not declared");
            noError = false;
        }
        return null;
    }

    public Void visit(FuncCall funcCall) {
        FunctionDefinition funcDef = null;
        String funcName = ((Identifier) funcCall.getExpr()).getIdentifier();
        int line = ((Identifier) funcCall.getExpr()).getLine();
        ((Identifier) funcCall.getExpr()).setFunc();

        if (funcName.equals("scanf")) {
            ArgExpr argExpr = funcCall.getArgExpr();
            for (Expr expr : argExpr.getExprs()) {
                if (expr instanceof PrefixExpr) {
                    CastExpr castExpr = ((PrefixExpr) expr).getCastExpr();
                    String identifier = ((Identifier) castExpr.getExpr()).getIdentifier();
                    try {
                        ((VarDecSymbolTableItem) SymbolTable.top
                                .getItem(VarDecSymbolTableItem.START_KEY + identifier)).isInit = true;
                        ((VarDecSymbolTableItem) SymbolTable.top
                                .getItem(VarDecSymbolTableItem.START_KEY + identifier)).fromUser = true;
                    } catch (ItemNotFoundException e) {
                        break;
                    }
                }
            }
        }

        if (funcName.equals("scanf") || funcName.equals("printf") || funcName.equals("malloc") ||
                funcName.equals("free")) {
        } else {
            try {
                FuncDecSymbolTableItem funcDec = (FuncDecSymbolTableItem) SymbolTable.top
                        .getItem(FuncDecSymbolTableItem.START_KEY + funcCall.getNumArgs() + funcName);
                funcDef = funcDec.getFuncDec();
            } catch (ItemNotFoundException e) {
                System.out.println("Line:" + line + "-> " + funcName + " not declared");
            }
        }

        if (funcName.equals("free"))
            freePtr(funcCall.getArgExpr().getExprs().get(0));
        funcCall.getExpr().accept(this);
        if (funcCall.getArgExpr() != null) {
            for (int i = 0; i < funcCall.getArgExpr().getExprs().size(); i++) {
                if (funcName.equals("scanf") || funcName.equals("printf") || funcName.equals("malloc") ||
                        funcName.equals("free")) {
                    break;
                }
                try {
                    ParameterDec pd = funcDef.getDeclarator().getDirectDec().getParameterList().getParameterDecs()
                            .get(i);
                    String identifier = pd.getDeclarator() != null ? pd.getDeclarator().getDirectDec().getIdentifier()
                            : pd.getDeclarationSpecifier().getDeclarationSpecifiers()
                                    .get(pd.getDeclarationSpecifier().getDeclarationSpecifiers().size() - 1)
                                    .getTypeSpecifier().getType();
                    if (((VarDecSymbolTableItem) funcDef.getSymbolTable()
                            .getItem(VarDecSymbolTableItem.START_KEY + identifier)).isFree)
                        freePtr(funcCall.getArgExpr().getExprs().get(i));
                } catch (ItemNotFoundException e) {
                    System.out.println("mame:" + line + " -> " + funcName + " not declared");
                }
            }
            funcCall.getArgExpr().accept(this);
        }

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
        if (binaryExpr.getAssignmentOp() != null) {
            binaryExpr.getAssignmentOp().accept(this);
            if (binaryExpr.getAssignmentOp().getOpType().equals("=")) {
                String identifier = ((Identifier) binaryExpr.getExpr1()).getIdentifier();
                try {
                    ((VarDecSymbolTableItem) SymbolTable.top
                            .getItem(VarDecSymbolTableItem.START_KEY + identifier)).isInit = true;
                    if (binaryExpr.getExpr2() instanceof FuncCall &&
                            ((Identifier) ((FuncCall) binaryExpr.getExpr2()).getExpr()).getIdentifier()
                                    .equals("malloc")) {
                        ((VarDecSymbolTableItem) SymbolTable.top
                                .getItem(VarDecSymbolTableItem.START_KEY + identifier)).isFree = false;
                    }
                } catch (ItemNotFoundException e) {
                    noError = false;
                }
            }
        }
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
        if (!identifier.isFunc() && !identifier.getIdentifier().startsWith("\"")) {
            try {
                if (!((VarDecSymbolTableItem) SymbolTable.top
                        .getItem(VarDecSymbolTableItem.START_KEY + identifier.getIdentifier())).isInit) {
                    System.out.println("Line:" + identifier.getLine() + " -> uninitialized variable used");
                    ((VarDecSymbolTableItem) SymbolTable.top
                            .getItem(VarDecSymbolTableItem.START_KEY + identifier.getIdentifier())).isInit = true;
                }
            } catch (ItemNotFoundException e) {
                System.out
                        .println("Line:" + identifier.getLine() + "-> " + identifier.getIdentifier() + " not declared");
                noError = false;
            }
        }

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
