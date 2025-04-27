package main.ast.nodes_DIR;

import main.ast.declaration_DIR.DeclarationSpecifiers;
import main.ast.declaration_DIR.Declarator;
import main.ast.statement_DIR.CompoundStatement;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends ExternalDeclaration {
    private DeclarationSpecifiers declarationSpecifiers;
    private Declarator declarator;
    private DeclarationList declarationList;
    private CompoundStatement compoundStatement;
    private String functionName;

    public FunctionDefinition() {
    }

    public FunctionDefinition(DeclarationSpecifiers declarationSpecifiers, Declarator declarator, DeclarationList declarationList, CompoundStatement compoundStatement) {
        this.declarationSpecifiers = declarationSpecifiers;
        this.declarator = declarator;
        this.declarationList = declarationList;
        this.compoundStatement = compoundStatement;
    }

    public void setFunctionName(String funcName) { functionName = funcName; }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public DeclarationSpecifiers getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }

    public void setDeclarationSpecifiers(DeclarationSpecifiers declarationSpecifiers) {
        this.declarationSpecifiers = declarationSpecifiers;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public DeclarationList getDeclarationList() {
        return declarationList;
    }

    public void setDeclarationList(DeclarationList declarationList) {
        this.declarationList = declarationList;
    }

    public CompoundStatement getCompoundStatement() {
        return compoundStatement;
    }

    public void setCompoundStatement(CompoundStatement compoundStatement) {
        this.compoundStatement = compoundStatement;
    }

    public CompoundStatement getBody() {
        return compoundStatement;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (declarationSpecifiers != null)
            children.add(declarationSpecifiers);
        if (declarator != null)
            children.add(declarator);
        if (declarationList != null && declarationList.getDeclarations() != null)
            children.addAll(declarationList.getDeclarations());
        if (compoundStatement != null)
            children.add(compoundStatement);
        return children;
    }

    public String getFunctionName() {
        return functionName;
    }
}
