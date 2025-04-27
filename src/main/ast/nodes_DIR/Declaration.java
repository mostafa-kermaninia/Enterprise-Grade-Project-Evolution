package main.ast.nodes_DIR;

import main.ast.declaration_DIR.DeclarationSpecifiers;
import main.ast.declaration_DIR.InitDeclaratorList;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Declaration extends ExternalDeclaration
{
    private DeclarationSpecifiers declarationSpecifiers;
    private InitDeclaratorList initDeclarator;

    public Declaration() {}

    public Declaration(DeclarationSpecifiers declarationSpecifiers) {
        this.declarationSpecifiers = declarationSpecifiers;
    }

    public DeclarationSpecifiers getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }

    public void setDeclarationSpecifiers(DeclarationSpecifiers declarationSpecifiers) {
        this.declarationSpecifiers = declarationSpecifiers;
    }

    public InitDeclaratorList getInitDeclarators() {
        return initDeclarator;
    }

    public void setInitDeclarators(InitDeclaratorList initDeclarator) {
        this.initDeclarator = initDeclarator;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (declarationSpecifiers != null) {
            children.add(declarationSpecifiers);
        }
        if (initDeclarator != null) {
            children.add(initDeclarator);
        }
        return children;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
