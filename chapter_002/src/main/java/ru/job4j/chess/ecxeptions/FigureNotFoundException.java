package ru.job4j.chess.ecxeptions;

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
     */
    public FigureNotFoundException() {
        super("A figure is not found");
    }
}
