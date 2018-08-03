package ru.job4j.task3;

/**
 * Class MenuOutException.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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
