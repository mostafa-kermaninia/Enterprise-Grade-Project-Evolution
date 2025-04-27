package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;

import java.util.ArrayList;
import java.util.List;

public class ConditionalExpr extends Expr {
    private Expr condition;
    private Expr exprIfTrue;
    private Expr exprIfFalse;

    public ConditionalExpr(Expr condition, Expr exprIfTrue, Expr exprIfFalse) {
        this.condition = condition;
        this.exprIfTrue = exprIfTrue;
        this.exprIfFalse = exprIfFalse;
    }

    public Expr getCondition() {
        return condition;
    }

    public void setCondition(Expr condition) {
        this.condition = condition;
    }

    public Expr getExprIfTrue() {
        return exprIfTrue;
    }

    public void setExprIfTrue(Expr exprIfTrue) {
        this.exprIfTrue = exprIfTrue;
    }

    public Expr getExprIfFalse() {
        return exprIfFalse;
    }

    public void setExprIfFalse(Expr exprIfFalse) {
        this.exprIfFalse = exprIfFalse;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (condition != null) children.add(condition);
        if (exprIfTrue != null) children.add(exprIfTrue);
        if (exprIfFalse != null) children.add(exprIfFalse);
        return children;
    }
}
