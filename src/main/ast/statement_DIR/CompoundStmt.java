package main.ast.statement_DIR;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class CompoundStmt  extends Stmt { ;
    private ArrayList<BlockItem> blockItems = new ArrayList<BlockItem>();

    public CompoundStmt() {}

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }


    public ArrayList<BlockItem> getBlockItems() { return blockItems; }
    public void addBlockItem(BlockItem blockItem) { this.blockItems.add(blockItem); }
}
