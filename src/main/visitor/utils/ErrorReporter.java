package main.visitor.utils;

/**
 * Interface for reporting semantic errors.
 * This allows for different strategies of error handling or collection.
 */
public interface ErrorReporter {
    /**
     * Reports an error with a specific message and line number.
     * @param message The error message.
     * @param line The line number where the error occurred.
     */
    void reportError(String message, int line);

    /**
     * Checks if any errors have been reported.
     * @return True if errors exist, false otherwise.
     */
    boolean hasErrors();

    /**
     * Resets the error state, clearing all reported errors.
     */
    void reset();
}
