package main.ast.declaration_DIR;

import main.ast.nodes_DIR.Declaration;
import main.ast.nodes_DIR.Node;

import java.util.ArrayList;
import java.util.List;

public class ForDeclaration extends Declaration {
    private DeclarationSpecifiers declarationSpecifiers;
    private InitDeclaratorList initDeclaratorList;

    public ForDeclaration() {
        this.declarationSpecifiers = null;
        this.initDeclaratorList = null;
    }

    public DeclarationSpecifiers getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }

    public void setDeclarationSpecifiers(DeclarationSpecifiers declarationSpecifiers) {
        this.declarationSpecifiers = declarationSpecifiers;
    }

    public InitDeclaratorList getInitDeclaratorList() {
        return initDeclaratorList;
    }

    public void setInitDeclaratorList(InitDeclaratorList initDeclaratorList) {
        this.initDeclaratorList = initDeclaratorList;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (declarationSpecifiers != null) {
            children.add(declarationSpecifiers);
        }
        if (initDeclaratorList != null) {
            children.add(initDeclaratorList);
        }
        return children;
    }

}
