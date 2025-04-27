package main.ast.statement_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;
import main.ast.expression_DIR.FuncCallExpr;

import java.util.ArrayList;
import java.util.List;

public class FuncCallStmt extends Stmt{
    private FuncCallExpr function;

    public FuncCallStmt(FuncCallExpr function) {
        this.function = function;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public FuncCallExpr getFunction() {
        return function;
    }

    public void setFunction(FuncCallExpr function) {
        this.function = function;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (function != null) {
            children.add(function);
        }
        return children;
    }

}
