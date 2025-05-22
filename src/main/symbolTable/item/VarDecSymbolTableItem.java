package main.symbolTable.item;

import main.ast.literal_DIR.TypeSpecifier;

public class VarDecSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "VarDec_";

    private TypeSpecifier varDec;

    public VarDecSymbolTableItem(TypeSpecifier varDec) {
        this.varDec = varDec;
    }

    public TypeSpecifier getVarDec() {
        return varDec;
    }

    public void setVarDec(TypeSpecifier varDec) {
        this.varDec = varDec;
    }

    // Additional method to retrieve just the type name
    public String getVarTypeName() {
        return varDec.getType();
    }

    // New setter to change the underlying type name (demonstration only)
    public void setVarTypeName(String newTypeName) {
        this.varDec.setType(newTypeName);
    }

    // New toString method
    @Override
    public String toString() {
        return "VarDecSymbolTableItem{" +
                "key='" + getKey() + '\'' +
                ", varDec=" + (varDec != null ? varDec.toString() : "null") +
                '}';
    }

    @Override
    public String getKey() {
        return START_KEY + this.varDec.getType();
    }
}