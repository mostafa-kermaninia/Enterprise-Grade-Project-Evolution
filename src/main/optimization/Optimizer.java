package main.optimization;

import main.symbolTable.SymbolTable;
import main.visitor.Visitor;

public class Optimizer {

        public SymbolTable symbolTableMain;
        public boolean changed = false;

        public Optimizer(SymbolTable symbolTableMain){
            this.symbolTableMain = symbolTableMain;
        }


}
