package ru.job4j.waitnotifynotifyall.task5;

/**
 * The specific exception.
 */
public class OptimisticException extends Exception {
    /**
     * Tje constructor.
     * @param message to be showed.
     */
    public OptimisticException(String message) {
        super(message);
    }
}