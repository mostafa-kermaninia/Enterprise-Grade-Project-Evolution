package main.ast.expression_DIR;

import main.ast.nodes_DIR.Node;
import main.ast.literal_DIR.InitializerList;
import main.ast.literal_DIR.TypeName;

import java.util.ArrayList;
import java.util.List;

public class CompoundLiteralExpr extends Expr {
    private TypeName typeName;
    private InitializerList initializerList;

    public CompoundLiteralExpr(TypeName typeName, InitializerList initializerList) {
        this.typeName = typeName;
        this.initializerList = initializerList;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    public InitializerList getInitializerList() {
        return initializerList;
    }

    public void setInitializerList(InitializerList initializerList) {
        this.initializerList = initializerList;
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        if (typeName != null) children.add(typeName);
        if (initializerList != null) children.add(initializerList);
        return children;
    }
}
