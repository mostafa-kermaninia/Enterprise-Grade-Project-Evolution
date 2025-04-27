package main.ast.statement_DIR;

import main.ast.literal_DIR.ForCondition;
import main.ast.nodes_DIR.Node;
import main.ast.expression_DIR.Expr;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class IterationStatement extends Stmt {
    public enum LoopType { WHILE, DO_WHILE, FOR }

    private LoopType type;
    private Expr condition;
    private ForCondition forCondition;
    private Stmt body;

    // Constructor for WHILE and DO_WHILE
    public IterationStatement(LoopType type, Expr condition, Stmt body) {
        this.type = type;
        this.condition = condition;
        this.body = body;
    }

    // Constructor for FOR
    public IterationStatement(LoopType type, ForCondition forCondition, Stmt body) {
        this.type = type;
        this.forCondition = forCondition;
        this.body = body;
    }

    public LoopType getType() {
        return type;
    }

    public Expr getCondition() {
        return condition;
    }

    public ForCondition getForCondition() {
        return forCondition;
    }

    public Stmt getBody() {
        return body;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (condition != null) children.add(condition);
        if (body != null) children.add(body);
        return children;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
