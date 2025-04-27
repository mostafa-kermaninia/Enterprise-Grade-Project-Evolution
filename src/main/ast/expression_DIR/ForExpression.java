package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;

import java.util.ArrayList;
import java.util.List;

public class ForExpression extends Expr {
    private ArrayList<Expr> expressions;

    public ForExpression() {
        this.expressions = new ArrayList<>();
    }

    public void addExpression(Expr expression) {
        this.expressions.add(expression);
    }

    public ArrayList<Expr> getExpressions() {
        return expressions;
    }

    public void setExpressions(ArrayList<Expr> expressions) {
        this.expressions = expressions;
    }

    @Override
    public List<Node> get_child() {
        return new ArrayList<>(expressions);
    }

}
