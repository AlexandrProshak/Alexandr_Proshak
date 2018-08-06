package ru.job4j.task1;

/**
 * The specific exception.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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