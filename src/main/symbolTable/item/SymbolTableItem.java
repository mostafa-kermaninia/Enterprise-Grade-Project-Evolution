package main.symbolTable.item;

public abstract class SymbolTableItem {
    // Abstract method remains unchanged
    public abstract String getKey();

    private boolean isUsed = false;

    // Original methods remain unchanged
    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed() {
        this.isUsed = true;
    }

    // New setter without altering existing functionality
    public void setUsage(boolean usedStatus) {
        this.isUsed = usedStatus;
    }

    // New helper method to show usage in string form
    @Override
    public String toString() {
        return "SymbolTableItem{isUsed=" + isUsed + "}";
    }
}