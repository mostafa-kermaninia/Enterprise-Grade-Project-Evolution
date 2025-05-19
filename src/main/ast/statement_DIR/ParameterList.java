package main.ast.statement_DIR;

import main.ast.baseNodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;

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

    public void addParameterDec(ParameterDec parameterDec) { this.parameterDecs.add(parameterDec); }
    public ArrayList<ParameterDec> getParameterDecs() { return parameterDecs; }

}
