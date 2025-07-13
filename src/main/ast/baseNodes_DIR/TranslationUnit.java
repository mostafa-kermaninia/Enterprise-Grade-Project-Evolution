package main.ast.baseNodes_DIR;

import main.ast.literal_DIR.ExternalDeclaration;
import main.ast.literal_DIR.FunctionDefinition;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class TranslationUnit extends Node {
    private ArrayList<ExternalDeclaration> externalDeclaration;

    public TranslationUnit() {
        this.externalDeclaration = new ArrayList<ExternalDeclaration>();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<ExternalDeclaration> getExternalDeclaration() {
        return externalDeclaration;
    }

    public void addExternalDeclaration(ExternalDeclaration externalDeclaration) {
        this.externalDeclaration.add(externalDeclaration);
    }

    public boolean removeFuncDec(FunctionDefinition funcDec) {
        for (int i = 0; i < this.externalDeclaration.size(); i++) {
            ExternalDeclaration externalDeclaration = this.externalDeclaration.get(i);
            if (externalDeclaration.getFunctionDefinition() == null)
                continue;
            if (externalDeclaration.getFunctionDefinition().equals(funcDec)) {
                String funcName = externalDeclaration.getFunctionDefinition().getDeclarator().getDirectDec()
                        .getDirectDec().getIdentifier();
                if (funcName.equals("main"))
                    return false;
                else {
                    this.externalDeclaration.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
}
