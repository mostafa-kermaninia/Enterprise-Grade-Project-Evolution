package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;

import java.util.ArrayList;
import java.util.List;

public class FunctionCallExpr extends Expr {
    private Expr instance;
    private List<Expr> args;

    public FunctionCallExpr(Expr instance, List<Expr> args) {
        this.instance = instance;
        this.args = args;
    }

    public Expr getInstance() {
        return instance;
    }

    public void setInstance(Expr instance) {
        this.instance = instance;
    }

    public List<Expr> getArgs() {
        return args;
    }

    public void setArgs(List<Expr> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return instance.toString();
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (instance != null) {
            children.add(instance);
        }
        if (args != null) {
            children.addAll(args);
        }
        return children;
    }


}
