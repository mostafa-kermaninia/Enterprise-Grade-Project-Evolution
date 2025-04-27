package main.ast.statement_DIR;

import main.ast.nodes_DIR.Node;
import main.ast.expression_DIR.Expr;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class SelectionStatement extends Stmt {
    private Expr condition;
    private Stmt thenStatement;
    private Stmt elseStatement;

    public SelectionStatement(Expr condition, Stmt thenStatement, Stmt elseStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    public SelectionStatement(Expr condition, Stmt thenStatement) {
        this(condition, thenStatement, null);
    }

    public Expr getCondition() {
        return condition;
    }

    public Stmt getThenStatement() {
        return thenStatement;
    }

    public Stmt getElseStatement() {
        return elseStatement;
    }

    public Stmt getThenBody() {
        return thenStatement;
    }

    public Stmt getElseBody() {
        return elseStatement;
    }

    public void setElseBody(Stmt elseStatement_) {
        this.elseStatement = elseStatement_;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (condition != null) children.add(condition);
        if (thenStatement != null) children.add(thenStatement);
        if (elseStatement != null) children.add(elseStatement);
        return children;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
