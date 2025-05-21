package main.visitor;

import main.ast.baseNodes_DIR.*;
import main.ast.declaration_DIR.*;
import main.ast.expression_DIR.*;
import main.ast.literal_DIR.*;
import main.ast.statement_DIR.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.item.*;
import main.visitor.utils.ScopedErrorCollector;

public class NameAnalyzer extends Visitor<Void> {
    private SymbolTable rootTable;
    private final ScopedErrorCollector errorReporter = new ScopedErrorCollector();

    public SymbolTable getRootTable() { return rootTable; }
    public boolean SuccessfullyDone() { return !errorReporter.hasErrors(); }

    // Entrypoint
    @Override
    public Void visit(Program program) {
        initRootSymbolTable(program);
        acceptIfNotNull(program.getTranslationUnit());
        rootTable = SymbolTable.top;
        return null;
    }

    private void initRootSymbolTable(Program program) {
        SymbolTable.top = new SymbolTable();
        SymbolTable.root = SymbolTable.top;
        program.setSymbolTable(SymbolTable.top);
    }

    //  Translation Unit
    @Override
    public Void visit(TranslationUnit n) {
        n.getExternalDeclaration().forEach(this::acceptIfNotNull);
        return null;
    }

    @Override
    public Void visit(ExternalDeclaration n) {
        acceptIfNotNull(n.getDeclaration());
        acceptIfNotNull(n.getFunctionDefinition());
        return null;
    }

    //  Function Definition
    @Override
    public Void visit(FunctionDefinition n) {
        setFunctionNumArgs(n);
        tryPutFunctionInTable(n);
        enterScope(n);
        acceptIfNotNull(n.getDecSpecifiers());
        acceptIfNotNull(n.getDeclarator());
        acceptIfNotNull(n.getDecList());
        acceptIfNotNull(n.getCompoundStatement());
        exitScope();
        return null;
    }

    private void setFunctionNumArgs(FunctionDefinition n) {
        ParameterList params = n.getDeclarator().getDirectDec().getParameterList();
        n.setNumArgs(params == null ? 0 : params.getParameterDecs().size());
    }

    private void tryPutFunctionInTable(FunctionDefinition n) {
        try {
            SymbolTable.top.put(new FuncDecSymbolTableItem(n));
        } catch (ItemAlreadyExistsException e) {
            errorReporter.redefineFunction(
                    n.getDeclarator().getDirectDec().getDirectDec().getIdentifier(),
                    n.getDeclarator().getDirectDec().getDirectDec().getLine()
            );
        }
    }

    private void enterScope(Node node) {
        SymbolTable scope = new SymbolTable(SymbolTable.top);
        node.setSymbolTable(scope);
        SymbolTable.push(scope);
    }

    private void exitScope() {
        SymbolTable.pop();
    }

    //  Declarations
    @Override
    public Void visit(Declaration n) {
        acceptIfNotNull(n.getDeclarationSpecifiers());
        acceptIfNotNull(n.getInitDeclaratorList());
        return null;
    }

    @Override
    public Void visit(DecList n) {
        n.getDeclarations().forEach(this::acceptIfNotNull);
        return null;
    }

    @Override
    public Void visit(DeclarationSpecifiers n) {
        n.getDeclarationSpecifiers().forEach(this::acceptIfNotNull);
        if (isTypedef(n))
            setTypedef(n);
        return null;
    }

    private boolean isTypedef(DeclarationSpecifiers n) {
        return !n.getDeclarationSpecifiers().isEmpty()
                && "typedef".equals(n.getDeclarationSpecifiers().get(0).getType());
    }

    private void setTypedef(DeclarationSpecifiers n) {
        var specs = n.getDeclarationSpecifiers();
        specs.get(specs.size() - 1).getTypeSpecifier().setTypeDef(specs.get(1).getType());
    }

    @Override
    public Void visit(ForDec n) {
        acceptIfNotNull(n.getDeclarationSpecifiers());
        acceptIfNotNull(n.getInitDecList());
        return null;
    }

    @Override
    public Void visit(DeclarationSpecifier n) {
        acceptIfNotNull(n.getTypeSpecifier());
        return null;
    }

    @Override
    public Void visit(InitDeclaratorList n) {
        n.getInitDeclarators().forEach(this::acceptIfNotNull);
        return null;
    }

    @Override
    public Void visit(InitDeclarator n) {
        declareVariableIfNeeded(n);
        acceptIfNotNull(n.getDeclarator());
        acceptIfNotNull(n.getInitializer());
        return null;
    }

    private void declareVariableIfNeeded(InitDeclarator n) {
        DirectDec d = n.getDeclarator().getDirectDec();
        while (d.getIdentifier().isEmpty())
            d = d.getDirectDec();
        if (!d.getIdentifier().isEmpty()) {
            TypeSpecifier ts = new TypeSpecifier(d.getIdentifier());
            ts.setLine(d.getLine());
            d.setTypeSpecifier(ts);
            try {
                SymbolTable.top.put(new VarDecSymbolTableItem(ts));
            } catch (ItemAlreadyExistsException e) {
                errorReporter.redefineVariable(ts.getType(), ts.getLine());
            }
        }
    }

    @Override
    public Void visit(TypeSpecifier n) {
        try {
            TypeSpecifier base = ((VarDecSymbolTableItem)
                    SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY + n.getType())).getVarDec();
            if (base.isTypeDef()) {
                n.setType(base.getTypeDefName());
                n.setNotVarDec();
            }
        } catch (ItemNotFoundException ignored) {}
        if (n.isVar_dec()) {
            try {
                SymbolTable.top.put(new VarDecSymbolTableItem(n));
            } catch (ItemAlreadyExistsException e) {
                errorReporter.redefineVariable(n.getType(), n.getLine());
            }
        }
        return null;
    }

    //  Parameters
    @Override
    public Void visit(ParameterList n) {
        n.getParameterDecs().forEach(this::acceptIfNotNull);
        return null;
    }

    @Override
    public Void visit(ParameterDec n) {
        acceptIfNotNull(n.getDeclarationSpecifier());
        acceptIfNotNull(n.getAbstractDec());
        acceptIfNotNull(n.getDeclarator());
        return null;
    }

    //  Declarators
    @Override
    public Void visit(Declarator n) {
        acceptIfNotNull(n.getDirectDec());
        acceptIfNotNull(n.getPointer());
        return null;
    }

    @Override
    public Void visit(DirectDec n) {
        acceptIfNotNull(n.getDeclarator());
        acceptIfNotNull(n.getDirectDec());
        acceptIfNotNull(n.getIdentifierList());
        acceptIfNotNull(n.getExpression());
        acceptIfNotNull(n.getParameterList());
        return null;
    }

    //  Statements
    @Override
    public Void visit(CompoundStatement n) {
        n.getBlockItems().forEach(this::acceptIfNotNull);
        return null;
    }

    @Override
    public Void visit(BlockItem n) {
        acceptIfNotNull(n.getStatement());
        acceptIfNotNull(n.getDeclaration());
        return null;
    }

    @Override
    public Void visit(ExpressionStatement n) {
        acceptIfNotNull(n.getExpression());
        return null;
    }

    @Override
    public Void visit(SelectionStatement n) {
        enterScope(n);
        acceptIfNotNull(n.getExpression());
        acceptIfNotNull(n.getMainStatement());
        acceptIfNotNull(n.getElseStatement());
        exitScope();
        return null;
    }

    @Override
    public Void visit(IterStatement n) {
        enterScope(n);
        acceptIfNotNull(n.getForCondition());
        acceptIfNotNull(n.getExpression());
        acceptIfNotNull(n.getStatement());
        exitScope();
        return null;
    }

    @Override
    public Void visit(ForCondition n) {
        acceptIfNotNull(n.getForDec());
        acceptIfNotNull(n.getExpression());
        acceptIfNotNull(n.getForExpression1());
        acceptIfNotNull(n.getForExpression2());
        return null;
    }

    //  Expressions
    @Override
    public Void visit(FunctionCall n) {
        checkFunctionCall(n);
        acceptIfNotNull(n.getExpression());
        acceptIfNotNull(n.getArgumentExpression());
        return null;
    }

    private void checkFunctionCall(FunctionCall n) {
        String funcName = ((Identifier) n.getExpression()).getIdentifier();
        int line = ((Identifier) n.getExpression()).getLine();
        ((Identifier) n.getExpression()).setFunc();

        if (!("scanf".equals(funcName) || "printf".equals(funcName))) {
            try {
                SymbolTable.top.getItem(FuncDecSymbolTableItem.START_KEY + n.getNumArgs() + funcName);
            } catch (ItemNotFoundException e) {
                errorReporter.undeclaredFunction(funcName, line, n.getNumArgs());
            }
        }
    }

    @Override
    public Void visit(Identifier n) {
        if (!n.isFunc() && !n.getIdentifier().startsWith("\"")) {
            try {
                SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY + n.getIdentifier());
            } catch (ItemNotFoundException e) {
                errorReporter.undeclaredVariable(n.getIdentifier(), n.getLine());
            }
        }
        return null;
    }

    //  Helper: Accept If Not Null
    private void acceptIfNotNull(Node n) {
        if (n != null) n.accept(this);
    }

    @Override public Void visit(CastExpression n) { acceptIfNotNull(n.getCastExpression()); acceptIfNotNull(n.getExpression()); acceptIfNotNull(n.getTypeName()); return null; }
    @Override public Void visit(ArgumentExpression n) { n.getExpressions().forEach(this::acceptIfNotNull); return null; }
    @Override public Void visit(UnaryOperator n) { return null; }
    @Override public Void visit(AssignmentOp n) { return null; }
    @Override public Void visit(Pointer n) { return null; }
    @Override public Void visit(IdentifierList n) { return null; }
    @Override public Void visit(TypeName n) { acceptIfNotNull(n.getSpecifierQualifierList()); acceptIfNotNull(n.getAbstractDec()); return null; }
    @Override public Void visit(DirectAbsDec n) { acceptIfNotNull(n.getExpression()); acceptIfNotNull(n.getAbstractDec()); acceptIfNotNull(n.getParameterList()); acceptIfNotNull(n.getDirectAbsDec()); return null; }
    @Override public Void visit(AbstractDec n) { acceptIfNotNull(n.getPointer()); acceptIfNotNull(n.getDirectAbsDec()); return null; }
    @Override public Void visit(Initializer n) { acceptIfNotNull(n.getExpression()); acceptIfNotNull(n.getInitList()); return null; }
    @Override public Void visit(InitializerList n) { n.getInitializers().forEach(this::acceptIfNotNull); n.getDesignations().forEach(this::acceptIfNotNull); return null; }
    @Override public Void visit(Designation n) { n.getDesignators().forEach(this::acceptIfNotNull); return null; }
    @Override public Void visit(Designator n) { acceptIfNotNull(n.getExpression()); return null; }
    @Override public Void visit(SpecifierQualifierList n) { acceptIfNotNull(n.getTypeSpecifier()); acceptIfNotNull(n.getSpecifierQualifierList()); return null; }
    @Override public Void visit(JumpStatement n) { acceptIfNotNull(n.getCondition()); return null; }
    @Override public Void visit(UnaryExpression n) { acceptIfNotNull(n.getExpression()); return null; }
    @Override public Void visit(ExpressionCast n) { acceptIfNotNull(n.getCastExpression()); acceptIfNotNull(n.getTypeName()); return null; }
    @Override public Void visit(BinaryExpression n) { acceptIfNotNull(n.getExpression1()); acceptIfNotNull(n.getExpression2()); acceptIfNotNull(n.getAssignmentOp()); return null; }
    @Override public Void visit(CondExpression n) { acceptIfNotNull(n.getExpression1()); acceptIfNotNull(n.getExpression2()); acceptIfNotNull(n.getExpression3()); return null; }
    @Override public Void visit(CommaExpression n) { n.getExpressions().forEach(this::acceptIfNotNull); return null; }
    @Override public Void visit(ArrayIndexing n) { acceptIfNotNull(n.getExpression1()); acceptIfNotNull(n.getExpression2()); return null; }
    @Override public Void visit(Constant n) { return null; }
    @Override public Void visit(TypeInitExpression n) { acceptIfNotNull(n.getInitializerList()); acceptIfNotNull(n.getTypeName()); return null; }
    @Override public Void visit(PrefixExpression n) { acceptIfNotNull(n.getExpression()); acceptIfNotNull(n.getCastExpression()); acceptIfNotNull(n.getTypeName()); acceptIfNotNull(n.getTypeInitExpression()); acceptIfNotNull(n.getUnaryOp()); return null; }
}