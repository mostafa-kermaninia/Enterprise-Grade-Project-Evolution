package main.ast.statement_DIR;

import java.util.ArrayList;

import main.ast.baseNodes_DIR.Node;
import main.ast.declaration_DIR.DeclarationSpecifiers;
import main.ast.declaration_DIR.ParameterDec;
import main.ast.literal_DIR.TypeSpecifier;
import main.visitor.IVisitor;

public class ParameterList extends Node {
    private ArrayList<ParameterDec> parameterDecs;

    public ParameterList(ParameterDec parameterDec) {
        parameterDecs = new ArrayList<>();
        parameterDecs.add(parameterDec);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void addParameterDec(ParameterDec parameterDec) {
        this.parameterDecs.add(parameterDec);
    }

    public ArrayList<ParameterDec> getParameterDecs() {
        return parameterDecs;
    }

    public boolean removeParamDec(TypeSpecifier typeSpecifier) {
        for (ParameterDec parameterDec : parameterDecs) {
            if (parameterDec.getDeclarationSpecifier() instanceof DeclarationSpecifiers
                    && parameterDec.getDeclarationSpecifier().getDeclarationSpecifiers()
                            .get(parameterDec.getDeclarationSpecifier().getDeclarationSpecifiers().size() - 1)
                            .getTypeSpecifier().equals(typeSpecifier)) {
                parameterDecs.remove(parameterDec);
                return true;
            }
        }
        return false;
    }
}
