package main.ast.declaration_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class InitDeclaratorList extends Node {
    private List<InitDeclarator> initDeclarators;

    public InitDeclaratorList(List<InitDeclarator> initDeclarators) {
        this.initDeclarators = initDeclarators;
    }

    public InitDeclaratorList() {
        ;
    }

    public List<InitDeclarator> getInitDeclarators() {
        return initDeclarators;
    }

    public void setInitDeclarators(List<InitDeclarator> initDeclarators) {
        this.initDeclarators = initDeclarators;
    }

    public void addInitDeclarator(InitDeclarator initDeclarator) {
        if (this.initDeclarators == null) {
            this.initDeclarators = new ArrayList<>();
        }
        this.initDeclarators.add(initDeclarator);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Node> get_child() {
        return initDeclarators == null ? new ArrayList<>() : new ArrayList<>(initDeclarators);
    }

}
