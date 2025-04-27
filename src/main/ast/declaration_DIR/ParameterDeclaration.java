package main.ast.declaration_DIR;

import main.ast.nodes_DIR.Declaration;
import main.ast.nodes_DIR.Node;

import java.util.ArrayList;
import java.util.List;

public class ParameterDeclaration extends Declaration {
    private DeclarationSpecifiers declarationSpecifiers;
    private Declarator declarator;
    private AbstractDeclarator abstractDeclarator;


    public ParameterDeclaration(DeclarationSpecifiers declarationSpecifiers, Declarator declarator) {
        this.declarationSpecifiers = declarationSpecifiers;
        this.declarator = declarator;
        this.abstractDeclarator = null;
    }

    public ParameterDeclaration(DeclarationSpecifiers declarationSpecifiers, AbstractDeclarator abstractDeclarator) {
        this.declarationSpecifiers = declarationSpecifiers;
        this.declarator = null;  // No declarator
        this.abstractDeclarator = abstractDeclarator;
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

    public AbstractDeclarator getAbstractDeclarator() {
        return abstractDeclarator;
    }

    public void setAbstractDeclarator(AbstractDeclarator abstractDeclarator) {
        this.abstractDeclarator = abstractDeclarator;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (declarationSpecifiers != null) {
            children.add(declarationSpecifiers);
        }
        if (declarator != null) {
            children.add(declarator);
        }
        if (abstractDeclarator != null) {
            children.add(abstractDeclarator);
        }
        return children;
    }

}
