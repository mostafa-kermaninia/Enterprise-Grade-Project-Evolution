package main.ast.literal_DIR;

import main.ast.nodes_DIR.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class InitializerList extends Node {
    private final List<InitializerListEntry> entries = new ArrayList<>();

    public void addEntry(Designation designation, Initializer initializer) {
        this.entries.add(new InitializerListEntry(designation, initializer));
    }

    public List<Initializer> getInitializers() {
        List<Initializer> result = new ArrayList<>();
        for (InitializerListEntry entry : entries) {
            result.add(entry.getInitializer());
        }
        return result;
    }

    public List<InitializerListEntry> getEntries() {
        return entries;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Node> get_child() {
        List<Node> children = new ArrayList<>();
        for (InitializerListEntry entry : entries) {
            children.add(entry);
        }
        return children;
    }

}
