package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;

import java.util.ArrayList;
import java.util.List;

public class PostfixExpr extends Expr {
    private Expr expr;
    private String operator;

    public PostfixExpr(Expr expr, String operator) {
        this.expr = expr;
        this.operator = operator;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (expr != null) {
            children.add(expr);
        }
        return children;
    }


}
