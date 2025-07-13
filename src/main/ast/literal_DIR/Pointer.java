package main.ast.literal_DIR;

import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

public class Pointer extends Node {

    public Pointer() {
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
