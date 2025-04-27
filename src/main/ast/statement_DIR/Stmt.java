package main.ast.statement_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

public abstract class Stmt extends Node {
    public abstract <T> T accept(IVisitor<T> visitor);
}
