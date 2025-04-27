package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;

import java.util.ArrayList;
import java.util.List;

public class ArrIndexExpr extends Expr {
    private Expr array;
    private Expr index;

    public ArrIndexExpr(Expr array, Expr index) {
        this.array = array;
        this.index = index;
    }

    public Expr getArray() {
        return array;
    }

    public void setArray(Expr array) {
        this.array = array;
    }

    public Expr getIndex() {
        return index;
    }

    public void setIndex(Expr index) {
        this.index = index;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (array != null) {
            children.add(array);
        }
        if (index != null) {
            children.add(index);
        }
        return children;
    }
}
