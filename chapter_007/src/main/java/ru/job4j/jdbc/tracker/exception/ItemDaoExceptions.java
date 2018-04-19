package ru.job4j.jdbc.tracker.exception;

/**
 * The special exception for the database implementation.
 */
public class ItemDaoExceptions extends Exception {
    /**
     * The constructor.
     * @param message to show.
     * @param cause of failure.
     */
    public ItemDaoExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
