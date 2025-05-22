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
}
