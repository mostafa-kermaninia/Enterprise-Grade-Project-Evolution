package main.symbolTable.item;

public abstract class SymbolTableItem {
    public abstract String getKey();

    private boolean isUsed = false;

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed() {
        this.isUsed = true;
    }

    public void setUsage(boolean usedStatus) {
        this.isUsed = usedStatus;
    }

    @Override
    public String toString() {
        return "SymbolTableItem{isUsed=" + isUsed + "}";
    }
}