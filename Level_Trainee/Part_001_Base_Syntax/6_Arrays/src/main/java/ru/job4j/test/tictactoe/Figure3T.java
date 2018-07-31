package ru.job4j.test.tictactoe;

import javafx.scene.shape.Rectangle;

/**
 * Class Figure3T describes square on board.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Figure3T extends Rectangle {

    /**
     * Occupation by X.
     */
    private boolean markX = false;

    /**
     * Occupation by Y.
     */
    private boolean markO = false;

    /**
     * The constructor.
     */
    public Figure3T() {
    }

    /**
     * The constructor with parameters.
     * @param markX mark.
     */
    public Figure3T(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     * Move.
     * @param markX mark.
     */
    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     * Method returns mark is X.
     * @return true or false.
     */
    public boolean hasMarkX() {
        return this.markX;
    }

    /**
     * Method returns mark is O.
     * @return true or false.
     */
    public boolean hasMarkO() {
        return this.markO;
    }
}