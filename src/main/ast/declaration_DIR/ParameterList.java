package main.ast.declaration_DIR;

import main.ast.nodes_DIR.Declaration;
import main.ast.nodes_DIR.Node;

import java.util.ArrayList;
import java.util.List;

public class ParameterList extends Declaration {
    private List<ParameterDeclaration> parameters;

    public ParameterList(List<ParameterDeclaration> parameters) {
        this.parameters = parameters;
    }

    public ParameterList() {
        this.parameters = new ArrayList<>();
    }

    public List<ParameterDeclaration> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterDeclaration> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(ParameterDeclaration parameter) {
        if (this.parameters == null) {
            this.parameters = new ArrayList<>();
        }
        this.parameters.add(parameter);
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (parameters != null) {
            children.addAll(parameters); // Add all parameter declarations to the children list
        }
        return children;
    }
}
