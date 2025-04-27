package main.ast.literal_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class SpecifierQualifierList extends Node {
    private List<TypeSpecifier> typeSpecifiers = new ArrayList<>();
    private boolean isConst = false;
    private int constLine = -1;

    public void addTypeSpecifier(TypeSpecifier spec) {
        this.typeSpecifiers.add(spec);
    }

    public List<TypeSpecifier> getTypeSpecifiers() {
        return typeSpecifiers;
    }

    public void setTypeSpecifiers(List<TypeSpecifier> typeSpecifiers) {
        this.typeSpecifiers = typeSpecifiers;
    }

    public boolean isConst() {
        return isConst;
    }

    public void setIsConst(boolean isConst) {
        this.isConst = isConst;
    }

    public int getConstLine() {
        return constLine;
    }

    public void setConstLine(int constLine) {
        this.constLine = constLine;
    }

    public void append(SpecifierQualifierList other) {
        if (other == null) return;
        this.typeSpecifiers.addAll(other.typeSpecifiers);
        if (other.isConst) {
            this.isConst = true;
            this.constLine = other.constLine;
        }
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }



}
