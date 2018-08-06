package ru.job4j.task1.exception;

/**
 * The special exception for the database implementation.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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
