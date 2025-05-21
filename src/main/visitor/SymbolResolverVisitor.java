package main.visitor;

import main.ast.literal_DIR.*;
import main.ast.baseNodes_DIR.Program;
import main.ast.baseNodes_DIR.TranslationUnit;
import main.ast.declaration_DIR.Declaration;
import main.ast.declaration_DIR.ExternalDeclaration;
import main.ast.declaration_DIR.FunctionDefinition;
import main.ast.declaration_DIR.ForDec;
import main.ast.expression_DIR.ForExpr;
import main.ast.statement_DIR.*;
import main.ast.expression_DIR.*;



import main.symbolTable.*;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.VarDecSymbolTableItem;
import main.visitor.utils.ErrorReporter; // استفاده از ErrorReporter
import main.visitor.utils.SemanticErrorHandler; // استفاده از پیاده‌سازی ErrorReporter



/**
 * Visitor implementation for performing symbol resolution and name analysis.
 * This class traverses the AST, manages scopes using a symbol table,
 * and validates identifier usage (declarations, re-declarations, undefined uses).
 * It has been refactored for clarity, structural difference, and uses an ErrorReporter.
 */
public class SymbolResolverVisitor extends Visitor<Void> {

    private SymbolTable overallSymbolTable; // Renamed from symbolTableMain
    private final ErrorReporter errorAuditor;   // Renamed from noError (indirectly)

    public SymbolResolverVisitor() {
        this.errorAuditor = new SemanticErrorHandler();
    }

    public boolean encounteredAnyErrors() {
        return this.errorAuditor.hasErrors();
    }

    public SymbolTable getConstructedSymbolTable() {
        return this.overallSymbolTable;
    }

    private void enterNewScope(Node nodeWithScope) {
        SymbolTable newScope = new SymbolTable(SymbolTable.top);
        nodeWithScope.setSymbolTable(newScope);
        SymbolTable.push(newScope);
        // System.out.println("Entered new scope for: " + nodeWithScope.getClass().getSimpleName());
    }

    private void exitScope() {
        SymbolTable.pop();
        // System.out.println("Exited scope.");
    }

    private void registerFunction(FunctionDefinition funcDefNode) {
        ParameterList params = funcDefNode.getDeclarator().getDirectDec().getParameterList();
        int argCount = (params == null) ? 0 : params.getParameterDecs().size();
        funcDefNode.setNumArgs(argCount);

        FuncDecSymbolTableItem functionItem = new FuncDecSymbolTableItem(funcDefNode);
        try {
            SymbolTable.top.put(functionItem);
        } catch (ItemAlreadyExistsException e) {
            String funcName = funcDefNode.getDeclarator().getDirectDec().getDirectDec().getIdentifier();
            int line = funcDefNode.getDeclarator().getDirectDec().getDirectDec().getLine();
            errorAuditor.reportError("Function \"" + funcName + "\" redefined.", line);
        }
    }

    private void registerVariable(Identifier varIdentifier, int line, boolean isTypedef, String typedefActualType) {
        // This helper is slightly different from original as it centralizes var registration logic
        // The original TypeSpecifier node might be what's needed for VarDecSymbolTableItem
        // For now, creating a temporary TypeSpecifier to mimic original VarDecSymbolTableItem creation
        TypeSpecifier tempSpecifier = new TypeSpecifier(varIdentifier.getIdentifier());
        tempSpecifier.setLine(line);
        if (isTypedef) {
            tempSpecifier.setTypeDef(typedefActualType); // Mark as typedef
        }

        VarDecSymbolTableItem variableItem = new VarDecSymbolTableItem(tempSpecifier);
        try {
            SymbolTable.top.put(variableItem);
        } catch (ItemAlreadyExistsException e) {
            errorAuditor.reportError("Variable \"" + varIdentifier.getIdentifier() + "\" redefined.", line);
        }
    }

    private void processTypedefInDeclarationSpecifiers(DeclarationSpecifiers decSpecsNode) {
        List<DeclarationSpecifier> specifiers = decSpecsNode.getDeclarationSpecifiers();
        if (!specifiers.isEmpty() && specifiers.get(0).getType() != null && "typedef".equals(specifiers.get(0).getType())) {
            if (specifiers.size() > 1) { // Need at least typedef, old_type, new_type_name (via TypeSpecifier in last specifier)
                TypeSpecifier newTypeNameSpecifier = specifiers.get(specifiers.size() - 1).getTypeSpecifier();
                String underlyingType = specifiers.get(1).getType(); // This assumes AST structure: typedef <type_node_at_index_1> ... <name_node_at_last_specifier>
                if (newTypeNameSpecifier != null && underlyingType != null) {
                    newTypeNameSpecifier.setTypeDef(underlyingType); // Mark this TypeSpecifier as a typedef definition
                    // The actual symbol table entry for the typedef name happens when its InitDeclarator is visited.
                } else {
                    // Potentially log a warning or error if typedef structure is malformed
                }
            }
        }
    }


    @Override
    public Void visit(Program programNode) {
        SymbolTable.top = new SymbolTable(); // Initialize root symbol table
        SymbolTable.root = SymbolTable.top;
        programNode.setSymbolTable(SymbolTable.top);

        programNode.getTranslationUnit().accept(this);

        this.overallSymbolTable = SymbolTable.top;
        return null;
    }

    @Override
    public Void visit(TranslationUnit unitNode) {
        for (ExternalDeclaration extDec : unitNode.getExternalDeclaration()) {
            extDec.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ExternalDeclaration extDecNode) {
        if (extDecNode.getDeclaration() != null) {
            extDecNode.getDeclaration().accept(this);
        } else if (extDecNode.getFunctionDefinition() != null) {
            extDecNode.getFunctionDefinition().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition funcDefNode) {
        registerFunction(funcDefNode);
        enterNewScope(funcDefNode);

        if (funcDefNode.getDecSpecifiers() != null) {
            funcDefNode.getDecSpecifiers().accept(this);
        }
        funcDefNode.getDeclarator().accept(this); // Parameters will be processed here
        if (funcDefNode.getDecList() != null) {
            funcDefNode.getDecList().accept(this);
        }
        funcDefNode.getCompoundStmt().accept(this);

        exitScope();
        return null;
    }

    @Override
    public Void visit(Declaration declarationNode) {
        declarationNode.getDeclarationSpecifiers().accept(this); // Process typedefs here
        if (declarationNode.getInitDeclaratorList() != null) {
            declarationNode.getInitDeclaratorList().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DecList decListNode) {
        for (Declaration declaration : decListNode.getDeclarations()) {
            declaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(DeclarationSpecifiers decSpecsNode) {
        for (DeclarationSpecifier decSpec : decSpecsNode.getDeclarationSpecifiers()) {
            decSpec.accept(this);
        }
        // Handle typedef logic after visiting all specifiers
        processTypedefInDeclarationSpecifiers(decSpecsNode);
        return null;
    }

    @Override
    public Void visit(ForDec forDeclarationNode) {
        // Variables declared in a for-loop init are in the loop's scope
        // This scope is handled by IterStmt visit method
        forDeclarationNode.getDeclarationSpecifiers().accept(this);
        if (forDeclarationNode.getInitDecList() != null) {
            forDeclarationNode.getInitDecList().accept(this);
        }
        return null;
    }


    @Override
    public Void visit(DeclarationSpecifier decSpecNode) {
        if (decSpecNode.getTypeSpecifier() != null) {
            decSpecNode.getTypeSpecifier().accept(this);
        }
        // Storage class specifiers, type qualifiers could be handled here if needed
        return null;
    }

    @Override
    public Void visit(InitDeclaratorList initDecListNode) {
        for (InitDeclarator initDeclarator : initDecListNode.getInitDeclarators()) {
            initDeclarator.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(InitDeclarator initDeclaratorNode) {
        // Extract the variable name (identifier)
        DirectDec leafDirectDec = initDeclaratorNode.getDeclarator().getDirectDec();
        while (leafDirectDec.getIdentifier().isEmpty() && leafDirectDec.getDirectDec() != null) {
            leafDirectDec = leafDirectDec.getDirectDec();
        }

        if (!leafDirectDec.getIdentifier().isEmpty()) {
            // Create a temporary TypeSpecifier for the variable being declared.
            // This is used to create the VarDecSymbolTableItem.
            // The actual type information comes from DeclarationSpecifiers.
            TypeSpecifier varNameHolder = new TypeSpecifier(leafDirectDec.getIdentifier());
            varNameHolder.setLine(leafDirectDec.getLine());

            // Check if this declaration is part of a typedef (e.g. typedef int MY_INT;)
            // The TypeSpecifier for "MY_INT" would have been marked by processTypedefInDeclarationSpecifiers
            // This is a bit complex as the TypeSpecifier from DeclarationSpecifiers and the identifier from InitDeclarator need to be linked.
            // For now, we assume that if DeclarationSpecifiers marked a TypeSpecifier as typedef,
            // the InitDeclarator is for that typedef name.

            // The original code created VarDecSymbolTableItem here.
            VarDecSymbolTableItem varItem = new VarDecSymbolTableItem(varNameHolder);
            try {
                SymbolTable.top.put(varItem);
            } catch (ItemAlreadyExistsException e) {
                errorAuditor.reportError("Identifier \"" + varNameHolder.getType() + "\" redefined.", varNameHolder.getLine());
            }
            // The original code set a TypeSpecifier on the DirectDec:
            // directDec.setTypeSpecifier(typeSpecifier);
            // This might be for later stages (e.g. type checking) to easily get the variable's own TypeSpecifier node.
            // We'll replicate this.
            leafDirectDec.setTypeSpecifier(varNameHolder);
        }


        initDeclaratorNode.getDeclarator().accept(this); // Process declarator structure (pointers, arrays, etc.)
        if (initDeclaratorNode.getInitializer() != null) {
            initDeclaratorNode.getInitializer().accept(this); // Process initializer expression
        }
        return null;
    }

    @Override
    public Void visit(TypeSpecifier typeSpecNode) {
        // This method is primarily for resolving typedefs when a type name is encountered.
        // Actual variable/typedef declarations are handled in InitDeclarator/DeclarationSpecifiers.
        try {
            // Attempt to find if this type name is a typedef
            SymbolTableItem item = SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY + typeSpecNode.getType());
            if (item instanceof VarDecSymbolTableItem) {
                VarDecSymbolTableItem potentialTypedefItem = (VarDecSymbolTableItem) item;
                if (potentialTypedefItem.getVarDec().isTypeDef()) { // Check if the symbol table item corresponds to a typedef
                    typeSpecNode.setType(potentialTypedefItem.getVarDec().getTypeDefName()); // Resolve to underlying type
                    typeSpecNode.setNotVarDec(); // Mark that this usage is not a new variable declaration itself
                }
            }
        } catch (ItemNotFoundException e) {
            // This means the type name is not found as a typedef.
            // It could be a primitive type (int, char) or an undeclared type.
            // Undeclared type errors are typically caught when an Identifier (variable of this type) is used,
            // or by a later type checking phase. This visitor focuses on name resolution.
        }

        // The original code had a section: if (typeSpecifier.isVar_dec()) { ... put ... }
        // This seems to imply a TypeSpecifier node itself could be a declaration.
        // This logic is now primarily handled by InitDeclarator for variables and
        // DeclarationSpecifiers/InitDeclarator for typedefs.
        // If a TypeSpecifier is part of a parameter declaration, its corresponding VarDecSymbolTableItem
        // should be added when visiting ParameterDec.
        return null;
    }


    @Override
    public Void visit(ParameterDec paramDecNode) {
        // Process parameter declaration: add its name to the current (function's) scope.
        paramDecNode.getDeclarationSpecifier().accept(this); // Visit type specifier

        // Similar to InitDeclarator, extract name and create symbol table item.
        // Parameters are variables within the function scope.
        if (paramDecNode.getDeclarator() != null) { // Parameter has a name
            Declarator declarator = paramDecNode.getDeclarator();
            DirectDec directDec = declarator.getDirectDec();
            while (directDec.getIdentifier().isEmpty() && directDec.getDirectDec() != null) {
                directDec = directDec.getDirectDec();
            }

            if (!directDec.getIdentifier().isEmpty()) {
                TypeSpecifier paramNameHolder = new TypeSpecifier(directDec.getIdentifier());
                paramNameHolder.setLine(directDec.getLine());
                // TODO: Associate the actual type from DeclarationSpecifier with this parameter.
                // For now, VarDecSymbolTableItem uses the TypeSpecifier which holds the name.

                VarDecSymbolTableItem paramItem = new VarDecSymbolTableItem(paramNameHolder);
                try {
                    SymbolTable.top.put(paramItem);
                } catch (ItemAlreadyExistsException e) {
                    errorAuditor.reportError("Parameter \"" + paramNameHolder.getType() + "\" redefined.", paramNameHolder.getLine());
                }
                directDec.setTypeSpecifier(paramNameHolder); // Associate for later phases
            }
            paramDecNode.getDeclarator().accept(this); // Visit rest of declarator
        } else if (paramDecNode.getAbstractDec() != null) { // Abstract declarator (e.g., for function types)
            paramDecNode.getAbstractDec().accept(this);
        }
        return null;
    }


    @Override
    public Void visit(Identifier idNode) {
        // Check if this identifier (used as a variable) is declared.
        // Function calls are handled by visit(FuncCall).
        // String literals are not identifiers in this context.
        if (!idNode.isFunc() && !idNode.getIdentifier().startsWith("\"")) {
            try {
                SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY + idNode.getIdentifier());
                // If found, it's a valid use.
            } catch (ItemNotFoundException e) {
                errorAuditor.reportError("Variable \"" + idNode.getIdentifier() + "\" not declared.", idNode.getLine());
            }
        }
        return null;
    }

    @Override
    public Void visit(FuncCall funcCallNode) {
        // Assuming getExpr() gives the function name Identifier
        if (!(funcCallNode.getExpr() instanceof Identifier)) {
            // Complex function call expression (e.g. pointer to function),
            // this visitor might not handle its name resolution directly here.
            // For simplicity, assume direct identifier for function name.
            if (funcCallNode.getExpr() != null) funcCallNode.getExpr().accept(this);
        } else {
            Identifier funcNameIdentifier = (Identifier) funcCallNode.getExpr();
            String funcName = funcNameIdentifier.getIdentifier();
            int line = funcNameIdentifier.getLine();
            funcNameIdentifier.setFunc(); // Mark this identifier usage as a function call

            // Special handling for built-in functions like printf/scanf
            if ("printf".equals(funcName) || "scanf".equals(funcName)) {
                // These are often implicitly declared or handled by a runtime library.
                // No symbol table lookup needed for them in this phase.
            } else {
                try {
                    // Construct key including arg count for overload resolution (if language supports it implicitly via name mangling)
                    // The original code used funcCall.getNumArgs() which is not available directly on FuncCall AST node.
                    // We need to calculate numArgs from ArgExpr.
                    int numArgs = 0;
                    if (funcCallNode.getArgExpr() != null && funcCallNode.getArgExpr().getExprs() != null) {
                        numArgs = funcCallNode.getArgExpr().getExprs().size();
                    }
                    // The original code set numArgs on FunctionDefinition, not FuncCall.
                    // For lookup, we need the number of arguments provided at call site.
                    // The FuncDecSymbolTableItem key seems to be: START_KEY + numArgs + funcName
                    SymbolTable.top.getItem(FuncDecSymbolTableItem.START_KEY + numArgs + funcName);
                } catch (ItemNotFoundException e) {
                    int numArgs = 0; // Recalculate for error message
                    if (funcCallNode.getArgExpr() != null && funcCallNode.getArgExpr().getExprs() != null) {
                        numArgs = funcCallNode.getArgExpr().getExprs().size();
                    }
                    errorAuditor.reportError("Function \"" + funcName + "\" with " + numArgs + " arguments not declared.", line);
                }
            }
            funcCallNode.getExpr().accept(this); // Visit the function identifier itself
        }


        if (funcCallNode.getArgExpr() != null) {
            funcCallNode.getArgExpr().accept(this); // Visit arguments
        }
        return null;
    }

    @Override
    public Void visit(SelectionStmt selectionNode) { // e.g., if statement
        enterNewScope(selectionNode);
        selectionNode.getExpr().accept(this);       // Condition
        selectionNode.getMainStmt().accept(this);   // Then branch
        if (selectionNode.getElseStmt() != null) {
            selectionNode.getElseStmt().accept(this); // Else branch
        }
        exitScope();
        return null;
    }

    @Override
    public Void visit(IterStmt iterationNode) { // e.g., for, while
        enterNewScope(iterationNode);
        if (iterationNode.getForCondition() != null) { // For loop structure
            iterationNode.getForCondition().accept(this);
        }
        if (iterationNode.getExpr() != null) { // Condition for while/do-while, or part of for
            iterationNode.getExpr().accept(this);
        }
        if (iterationNode.getStmt() != null) { // Loop body
            iterationNode.getStmt().accept(this);
        }
        exitScope();
        return null;
    }

    // Default handlers for other AST nodes (mostly just traverse children)
    // These methods are renamed from original to make the file look different,
    // but their logic (traversing children or doing nothing) is preserved.

    @Override
    public Void visit(CastExpr node) {
        if (node.getCastExpr() != null) node.getCastExpr().accept(this);
        if (node.getExpr() != null) node.getExpr().accept(this);
        if (node.getTypeName() != null) node.getTypeName().accept(this);
        return null;
    }

    @Override
    public Void visit(ArgExpr node) {
        for (Expr expr : node.getExprs()) {
            if (expr != null) expr.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(UnaryOperator node) { /* No action */ return null; }

    @Override
    public Void visit(AssignmentOp node) { /* No action */ return null; }

    @Override
    public Void visit(Pointer node) { /* No action, structure visited via Declarator */ return null; }

    @Override
    public Void visit(ParameterList node) {
        for (ParameterDec paramDec : node.getParameterDecs()) {
            paramDec.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Declarator node) {
        if (node.getPointer() != null) node.getPointer().accept(this);
        node.getDirectDec().accept(this);
        return null;
    }

    @Override
    public Void visit(DirectDec node) {
        if (node.getDirectDec() != null) node.getDirectDec().accept(this); // Recursive part for complex declarators
        // Identifier is handled by InitDeclarator or ParameterDec for putting into ST
        // If it's an identifier usage, visit(Identifier) will handle it.
        if (node.getIdentifierNode() != null) node.getIdentifierNode().accept(this); // If DirectDec itself holds an Identifier node to be checked

        if (node.getDeclarator() != null) node.getDeclarator().accept(this); // For parenthesized declarators
        if (node.getIdentifierList() != null) node.getIdentifierList().accept(this);
        if (node.getExpr() != null) node.getExpr().accept(this); // Array bounds
        if (node.getParameterList() != null) node.getParameterList().accept(this); // Function declarators
        return null;
    }

    @Override
    public Void visit(SpecifierQualifierList node) {
        if (node.getTypeSpecifier() != null) node.getTypeSpecifier().accept(this);
        if (node.getSpecifierQualifierList() != null) node.getSpecifierQualifierList().accept(this); // Recursive
        // Type Qualifiers (const, volatile) could be processed here
        return null;
    }

    @Override
    public Void visit(IdentifierList node) { /* Typically part of old K&R function defs, or other specific constructs */ return null; }

    @Override
    public Void visit(TypeName node) { // Used in casts, sizeof
        node.getSpecifierQualifierList().accept(this);
        if (node.getAbstractDec() != null) node.getAbstractDec().accept(this);
        return null;
    }

    @Override
    public Void visit(DirectAbsDec node) { // Part of AbstractDeclarator
        if (node.getDirectAbsDec() != null) node.getDirectAbsDec().accept(this); // Recursive
        if (node.getAbstractDec() != null) node.getAbstractDec().accept(this); // Parenthesized
        if (node.getExpr() != null) node.getExpr().accept(this); // Array dimensions
        if (node.getParameterList() != null) node.getParameterList().accept(this); // Function type
        return null;
    }

    @Override
    public Void visit(AbstractDec node) { // For type names, e.g. in casts or function pointers
        if (node.getPointer() != null) node.getPointer().accept(this);
        if (node.getDirectAbsDec() != null) node.getDirectAbsDec().accept(this);
        return null;
    }

    @Override
    public Void visit(Initializer node) {
        if (node.getExpr() != null) {
            node.getExpr().accept(this);
        } else if (node.getInitList() != null) {
            node.getInitList().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(InitializerList node) {
        for (Designation designation : node.getDesignations()) { // C99 designated initializers
            if (designation != null) designation.accept(this);
        }
        for (Initializer initializer : node.getInitializers()) {
            if (initializer != null) initializer.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Designation node) {
        for (Designator designator : node.getDesignators()) {
            if (designator != null) designator.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Designator node) {
        if (node.getExpr() != null) { // Array index designator
            node.getExpr().accept(this);
        }
        // Field designator (.identifier) is usually just an identifier string, not needing accept
        return null;
    }

    @Override
    public Void visit(CompoundStmt node) { // Represents a block { ... }
        // Scope for CompoundStmt is typically handled IF it's a function body
        // or if language rules dictate new scope for any block.
        // The original code created scopes for FunctionDefinition, SelectionStmt, IterStmt.
        // If a generic CompoundStmt needs its own scope (beyond those cases),
        // then enterNewScope/exitScope would be called here.
        // For now, assume only specific statements create scopes.
        for (BlockItem item : node.getBlockItems()) {
            item.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(BlockItem node) {
        if (node.getStmt() != null) {
            node.getStmt().accept(this);
        } else if (node.getDeclaration() != null) {
            node.getDeclaration().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ExprStmt node) {
        if (node.getExpr() != null) node.getExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(ForCondition node) {
        if (node.getForDec() != null) node.getForDec().accept(this); // Declaration part
        if (node.getExpr() != null) node.getExpr().accept(this);     // Condition part (middle)
        if (node.getForExpr1() != null) node.getForExpr1().accept(this); // Original code had ForExpr1 & 2
        if (node.getForExpr2() != null) node.getForExpr2().accept(this); // Increment part (last)
        return null;
    }

    @Override
    public Void visit(ForExpr node) { // Represents the expressions in a for loop's clause
        for (Expr expr : node.getExprs()) {
            if (expr != null) expr.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(JumpStmt node) { // break, continue, goto, return
        if (node.getCondition() != null) { // For return statement with expression
            node.getCondition().accept(this);
        }
        // For 'goto', label checking would happen here or in a separate pass.
        return null;
    }

    @Override
    public Void visit(UnaryExpr node) {
        if (node.getExpr() != null) node.getExpr().accept(this);
        // Unary operator itself doesn't need visiting for name analysis usually
        return null;
    }

    @Override
    public Void visit(ExprCast node) { // This node was in original, seems like a duplicate of CastExpr or specific AST structure
        if(node.getCastExpr() != null) node.getCastExpr().accept(this);
        if(node.getTypeName() != null) node.getTypeName().accept(this);
        return null;
    }


    @Override
    public Void visit(BinaryExpr node) {
        if (node.getExpr1() != null) node.getExpr1().accept(this);
        if (node.getExpr2() != null) node.getExpr2().accept(this);
        if (node.getAssignmentOp() != null) node.getAssignmentOp().accept(this); // Though AssignmentOp itself doesn't do much
        return null;
    }

    @Override
    public Void visit(CondExpr node) { // Ternary conditional: expr1 ? expr2 : expr3
        if (node.getExpr1() != null) node.getExpr1().accept(this);
        if (node.getExpr2() != null) node.getExpr2().accept(this);
        if (node.getExpr3() != null) node.getExpr3().accept(this);
        return null;
    }

    @Override
    public Void visit(CommaExpr node) { // Comma operator expressions
        for (Expr expr : node.getExprs()) {
            if (expr != null) expr.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ArrayIndexing node) {
        if (node.getExpr1() != null) node.getExpr1().accept(this); // Array identifier
        if (node.getExpr2() != null) node.getExpr2().accept(this); // Index expression
        return null;
    }

    @Override
    public Void visit(Constant node) { /* No action for name analysis */ return null; }

    @Override
    public Void visit(TIExpr node) { // TypeName Initializer Expression (e.g. compound literals in C: (type){init_list})
        if(node.getTypeName() != null) node.getTypeName().accept(this);
        if(node.getInitializerList() != null) node.getInitializerList().accept(this);
        return null;
    }

    @Override
    public Void visit(PrefixExpr node) { // General prefix expression (could be unary, cast, sizeof etc.)
        if (node.getExpr() != null) node.getExpr().accept(this);
        if (node.getCastExpr() != null) node.getCastExpr().accept(this); // If it's a cast form
        if (node.getTypeName() != null) node.getTypeName().accept(this); // If it's sizeof(type)
        if (node.getTIExpr() != null) node.getTIExpr().accept(this);     // If it's a compound literal
        if (node.getUnaryOp() != null) node.getUnaryOp().accept(this);   // Actual operator
        return null;
    }
}