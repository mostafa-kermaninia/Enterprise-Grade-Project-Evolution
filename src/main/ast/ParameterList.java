package main.ast;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class ParameterList extends Node{
    private ArrayList<ParameterDec> parameterDecs;

    public ParameterList(ParameterDec parameterDec) {
        parameterDecs = new ArrayList<>();
        parameterDecs.add(parameterDec);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void addParameterDec(ParameterDec parameterDec) { this.parameterDecs.add(parameterDec); }
    public ArrayList<ParameterDec> getParameterDecs() { return parameterDecs; }

    public boolean removeParamDec(TypeSpecifier typeSpecifier) {
        for (ParameterDec parameterDec : parameterDecs) {
            if (parameterDec.getDeclarationSpecifier() instanceof DeclarationSpecifiers
                    && parameterDec.getDeclarationSpecifier().getDeclarationSpecifiers().get(parameterDec.getDeclarationSpecifier().getDeclarationSpecifiers().size() - 1).getTypeSpecifier().equals(typeSpecifier)) {
                parameterDecs.remove(parameterDec);
                return true;
            }
        }
        return false;
    }
}
