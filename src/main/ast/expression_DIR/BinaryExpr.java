package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class BinaryExpr extends Expr {
    private Expr firstOperand;
    private Expr secondOperand;
    private String binaryOperator;

    public BinaryExpr(Expr firstOperand, String operator, Expr secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.binaryOperator = operator;
    }

    public Expr getLeft() {
        return firstOperand;
    }

    public Expr getRight() {
        return secondOperand;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Expr firstOperand) {
        this.firstOperand = firstOperand;
    }

    public Expr getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Expr secondOperand) {
        this.secondOperand = secondOperand;
    }

    public String getOperator() {
        return binaryOperator;
    }

    public void setOperator(String operator) {
        this.binaryOperator = operator;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (firstOperand != null) children.add(firstOperand);
        if (secondOperand != null) children.add(secondOperand);
        return children;
    }

}
