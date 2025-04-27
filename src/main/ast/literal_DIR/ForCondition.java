package main.ast.literal_DIR;

import main.ast.declaration_DIR.ForDeclaration;
import main.ast.expression_DIR.Expr;
import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class ForCondition extends Node {
    private ForDeclaration forDeclaration;
    private Expr condition;
    private Expr condition2;
    private Expr updateExpression;

    public ForCondition() {
    }

    public void setForDeclaration(ForDeclaration forDeclaration) {
        this.forDeclaration = forDeclaration;
    }

    public ForDeclaration getForDeclaration() {
        return forDeclaration;
    }

    public void setCondition(Expr condition) {
        this.condition = condition;
    }

    public Expr getCondition() {
        return condition;
    }

    public void setCondition2(Expr condition2) {
        this.condition2 = condition2;
    }

    public Expr getCondition2() {
        return condition2;
    }

    public void setUpdateExpression(Expr updateExpression) {
        this.updateExpression = updateExpression;
    }

    public Expr getUpdateExpression() {
        return updateExpression;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (forDeclaration != null) children.add(forDeclaration);
        if (condition != null) children.add(condition);
        if (condition2 != null) children.add(condition2);
        if (updateExpression != null) children.add(updateExpression);
        return children;
    }


    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
