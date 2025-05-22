package main.ast.literal_DIR;

import main.ast.baseNodes_DIR.Node;
import main.ast.declaration_DIR.Declaration;
import main.visitor.IVisitor;

public class ExternalDeclaration extends Node {
    FunctionDefinition functionDefinition;
    Declaration declaration;

    public ExternalDeclaration() {
        functionDefinition = null;
        declaration = null;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public FunctionDefinition getFunctionDefinition() {
        return functionDefinition;
    }

    public void setFunctionDefinition(FunctionDefinition functionDefinition) {
        this.functionDefinition = functionDefinition;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }
}
