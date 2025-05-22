package main.visitor.utils;

public interface ErrorReporter {

    void reportError(String message, int line);

    boolean hasErrors();

    void reset();
}
