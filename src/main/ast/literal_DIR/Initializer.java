package main.ast.literal_DIR;

import main.ast.nodes_DIR.Node;
import main.ast.expression_DIR.Expr;

import java.util.ArrayList;
import java.util.List;

public class Initializer extends Node {
    private Expr expression;
    private InitializerList initializerList;

    public Initializer() {
    }

    public boolean isExpression() {
        return expression != null;
    }

    public Expr getExpression() {
        return expression;
    }

    public void setExpression(Expr expression) {
        this.expression = expression;
    }

    public InitializerList getInitializerList() {
        return initializerList;
    }

    public void setInitializerList(InitializerList initializerList) {
        this.initializerList = initializerList;
    }

    @Override
    public <T> T accept(main.visitor.IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (expression != null) {
            children.add(expression);
        }
        if (initializerList != null) {
            children.add(initializerList);
        }
        return children;
    }

}
