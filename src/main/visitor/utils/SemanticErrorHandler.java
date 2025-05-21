package main.visitor.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A concrete implementation of ErrorReporter that collects errors
 * and can print them to standard output.
 */
public class SemanticErrorHandler implements ErrorReporter {
    private final List<String> errorMessagesLog;
    private boolean errorOccurred;

    public SemanticErrorHandler() {
        this.errorMessagesLog = new ArrayList<>();
        this.errorOccurred = false;
    }

    @Override
    public void reportError(String message, int line) {
        String formattedMessage = "Error at Line " + line + ": " + message;
        this.errorMessagesLog.add(formattedMessage);
        System.out.println(formattedMessage); // Immediate feedback as in original
        this.errorOccurred = true;
    }

    @Override
    public boolean hasErrors() {
        return this.errorOccurred;
    }

    @Override
    public void reset() {
        this.errorMessagesLog.clear();
        this.errorOccurred = false;
    }

    /**
     * Retrieves all collected error messages.
     * @return A list of formatted error messages.
     */
    public List<String> getAllErrorMessages() {
        return new ArrayList<>(this.errorMessagesLog); // Return a copy for safety
    }
}