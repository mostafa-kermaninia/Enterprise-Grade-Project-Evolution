package main.ast.nodes_DIR;

import java.util.ArrayList;
import java.util.List;

public class DeclarationList extends ExternalDeclaration {
    private ArrayList<Declaration> declarations;

    public DeclarationList() {
        this.declarations = new ArrayList<>();
    }

    public void addDeclaration(Declaration declaration) {
        this.declarations.add(declaration);
    }

    public ArrayList<Declaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(ArrayList<Declaration> declarations) {
        this.declarations = declarations;
    }

    @Override
    public List<Node> get_child() {
        return new ArrayList<>(declarations);
    }

}
