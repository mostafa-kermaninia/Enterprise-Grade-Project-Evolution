package main.ast.statement_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.literal_DIR.Designation;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class InitializerList extends Node {
    private ArrayList<Initializer> initializers;
    private ArrayList<Designation> designations;

    public InitializerList() {
        designations = new ArrayList<Designation>();
        initializers = new ArrayList<Initializer>();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Designation> getDesignations() {
        return designations;
    }

    public void addDesignation(Designation designation) {
        this.designations.add(designation);
    }

    public ArrayList<Initializer> getInitializers() {
        return initializers;
    }

    public void addInitializer(Initializer initializer) {
        this.initializers.add(initializer);
    }
}
