package ru.job4j.bombermanv2.models.playground;

import ru.job4j.bombermanv2.models.entities.Figure;

/**
 * The class Field.
 */
public class Field {

    /**
     * A field's sells board.
     */
    private final Cell[][] board;

    /**
     * A constructor.
     * @param size y size.
     */
    public Field(final int size) {
        this.board = new Cell[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                this.board[x][y] = new Cell();
            }
        }
    }

    /**
     * A Getter for the board.
     * @return board.
     */
    public Cell[][] getBoard() {
        return this.board;
    }

    /**
     * The method set figure to the cell on board.
     * @param figure to be set.
     * @param x coordinate x.
     * @param y coordinate y.
     */
    public void setFigureOnBoard(Figure figure, int x, int y) {
        if (this.cellOnBoard(x, y)) {
            this.board[x][y].lock();
            this.board[x][y].setFigure(figure);
        }
    }

    /**
     * The method moves figure from start position to the destination position.
     * @param figure to be moved.
     * @param destinationX destination coordinate X.
     * @param destinationY destination coordinate Y.
     */
    public void moveFigure(Figure figure, int destinationX, int destinationY) {
        Figure currentFigure = this.board[figure.getX()][figure.getY()].takeFigure();
        if (currentFigure != null) {
            this.board[destinationX][destinationY].setFigure(currentFigure);
        }
    }

    /**
     * The method checks includes field new coordinate or not.
     * @param x coordinate.
     * @param y coordinate.
     * @return true if the field includes new coordinate.
     */
    public boolean cellOnBoard(final int x, final int y) {
        boolean result = false;
        if (x >= 0 && y >= 0) {
            if (this.board.length > x && this.board[0].length > y) {
                result = true;
            }
        }
        return result;
    }
}