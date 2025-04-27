package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class UnaryExpr extends Expr{
    private String operand;
    private CastExpression operator;


    public UnaryExpr(String operand, CastExpression operator)
    {
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public CastExpression getOperator() {return operator;}

    public void setOperator(CastExpression operator) {
        this.operator = operator;
    }

    public String getExpr() {
        return operand;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (operator != null) {
            children.add(operator);
        }
        return children;
    }

}
