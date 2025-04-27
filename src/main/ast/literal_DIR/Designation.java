package main.ast.literal_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Designation extends Node {
    private List<Designator> designators = new ArrayList<>();

    public void addDesignator(Designator d) {
        this.designators.add(d);
    }

    public List<Designator> getDesignators() {
        return designators;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (designators != null) {
            children.addAll(designators);
        }
        return children;
    }
}
