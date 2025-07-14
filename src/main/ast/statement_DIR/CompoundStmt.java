package main.ast.statement_DIR;

import main.ast.mainNodes_DIR.Stmt;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class CompoundStmt extends Stmt {
    ;
    private ArrayList<BlockItem> blockItems = new ArrayList<BlockItem>();

    public CompoundStmt() {
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<BlockItem> getBlockItems() {
        return blockItems;
    }

    public void addBlockItem(BlockItem blockItem) {
        this.blockItems.add(blockItem);
    }

    public boolean removeNextBIs(BlockItem blockItem) {
        boolean found = false;
        for (int i = 0; i < this.blockItems.size(); i++) {
            if (this.blockItems.get(i).equals(blockItem)) {
                while (!this.blockItems.get(this.blockItems.size() - 1).equals(blockItem)) {
                    this.blockItems.remove(this.blockItems.size() - 1);
                    found = true;
                }
            }
        }
        return found;
    }

    public boolean removeBI(BlockItem blockItem) {
        boolean found = false;
        for (int i = 0; i < this.blockItems.size(); i++) {
            if (this.blockItems.get(i).equals(blockItem)) {
                this.blockItems.remove(i);
                found = true;
            }
        }
        return found;
    }

    public boolean hasJumpStmt() {
        for (BlockItem blockItem : this.blockItems) {
            if (blockItem.getStmt() instanceof JumpStmt) {
                return true;
            }
            if (blockItem.getStmt() instanceof SelectionStmt) {
                return ((SelectionStmt) blockItem.getStmt()).allReturn();
            }
        }
        return false;
    }
}
