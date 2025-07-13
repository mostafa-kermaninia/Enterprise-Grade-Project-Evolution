package main.symbolTable.item;

import main.ast.literal_DIR.FunctionDefinition;

public class FuncDecSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "FuncDec_";

    private FunctionDefinition funcDec;

    public FuncDecSymbolTableItem(FunctionDefinition funcDec) {
        this.funcDec = funcDec;
    }

    public FunctionDefinition getFuncDec() {
        return funcDec;
    }

    public void setFuncDec(FunctionDefinition funcDec) {
        this.funcDec = funcDec;
    }

    public int getFunctionArgumentCount() {
        return this.funcDec.getNumArgs();
    }

    @Override
    public String toString() {
        return "FuncDecSymbolTableItem{" +
                "key='" + getKey() + '\'' +
                ", funcDec=" + (funcDec != null ? funcDec.toString() : "null") +
                '}';
    }

    @Override
    public String getKey() {
        return START_KEY + funcDec.getNumArgs()
                + this.funcDec.getDeclarator().getDirectDec().getDirectDec().getIdentifier();
    }
}