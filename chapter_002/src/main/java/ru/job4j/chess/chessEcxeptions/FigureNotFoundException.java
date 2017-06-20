package ru.job4j.chess.chessEcxeptions;

/**
 * Class FigureNotFoundException.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 * @version $Id$
 * @since 0.1
 */
public class FigureNotFoundException extends Exception {

    /**
     * An exception trows if a figure is not found.
     * @param message is a message is throw if a figure is not found.
     */
    public FigureNotFoundException(String message) {
        super("A figure is not found");
    }
}
