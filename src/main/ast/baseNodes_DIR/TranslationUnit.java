package main.ast.baseNodes_DIR;
import main.ast.declaration_DIR.ExternalDeclaration;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class TranslationUnit extends Node {
    private ArrayList<ExternalDeclaration> externalDeclaration;

    public TranslationUnit() { this.externalDeclaration = new ArrayList<ExternalDeclaration>(); }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<ExternalDeclaration> getExternalDeclaration() { return externalDeclaration;}

    public void addExternalDeclaration(ExternalDeclaration externalDeclaration) {
        this.externalDeclaration.add(externalDeclaration);
    }
}
