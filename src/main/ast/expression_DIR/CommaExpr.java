package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;

import java.util.ArrayList;
import java.util.List;

public class CommaExpr extends Expr {
    private List<Expr> expressions;
    private String operator = ",";

    public CommaExpr(List<Expr> expressions) {
        this.expressions = expressions;
    }

    public List<Expr> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expr> expressions) {
        this.expressions = expressions;
    }


    @Override
    public List<Node> get_child() {
        return new ArrayList<>(expressions);
    }

    public String getOperator() {
        return this.operator;
    }
}
