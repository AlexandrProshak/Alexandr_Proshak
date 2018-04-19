package ru.job4j.jdbc.tracker.exception;

/**
 * Class MenuOutException.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class MenuOutException extends RuntimeException {

    /**
     * A constructor of our exception.
     * @param message passed to the ancestors class.
     */
    public MenuOutException(String message) {
        super(message);
    }
}
