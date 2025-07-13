package main.symbolTable.item;

import main.ast.ExternalDeclaration.FunctionDefinition;

public class FuncDecSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "FuncDec_";
    public String type;

    public FunctionDefinition getFuncDec() {
        return funcDec;
    }

    public void setFuncDec(FunctionDefinition funcDec) {
        this.funcDec = funcDec;
    }

    private FunctionDefinition funcDec;

    public FuncDecSymbolTableItem(FunctionDefinition funcDec) {
        this.funcDec = funcDec;
    }

    @Override
    public String getKey() {
        return START_KEY + funcDec.getNumArgs()
                + this.funcDec.getDeclarator().getDirectDec().getDirectDec().getIdentifier();
    }
}
