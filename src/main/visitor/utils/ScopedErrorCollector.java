package main.visitor.utils;

import java.util.ArrayList;
import java.util.List;

public class ScopedErrorCollector {
    private final List<String> errors = new ArrayList<>();

    public void redefineVariable(String name, int line) {
        errors.add("Redeclaration of variable \"" + name + "\" in line " + line);
        System.out.println(errors.get(errors.size() - 1));
    }

    public void redefineFunction(String name, int line) {
        errors.add("Redefinition of function \"" + name + "\" in line " + line);
        System.out.println(errors.get(errors.size() - 1));
    }

    public void undeclaredVariable(String name, int line) {
        errors.add("Line:" + line + "-> " + name + " not declared");
        System.out.println(errors.get(errors.size() - 1));
    }

    public void undeclaredFunction(String name, int line, int argc) {
        errors.add("Line:" + line + "-> " + name + " not declared");
        System.out.println(errors.get(errors.size() - 1));
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getAllErrors() {
        return new ArrayList<>(errors);
    }
}