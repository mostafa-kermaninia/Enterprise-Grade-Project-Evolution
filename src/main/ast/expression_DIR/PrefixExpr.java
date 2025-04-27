package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;

import java.util.ArrayList;
import java.util.List;

public class PrefixExpr extends Expr {
    private String operator;
    private Expr operand;

    public PrefixExpr(String operator, Expr operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Expr getOperand() {
        return operand;
    }

    public void setOperand(Expr operand) {
        this.operand = operand;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (operand != null) {
            children.add(operand);
        }
        return children;
    }


}
