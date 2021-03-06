package ru.job4j.chess.ecxeptions;

/**
 * Class ImpossibleMoveException.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class ImpossibleMoveException extends Exception {

    /**
     * An exception trows if a current way is impossible.
     */
    public ImpossibleMoveException() {
        super("An impossible movement");
    }
}

