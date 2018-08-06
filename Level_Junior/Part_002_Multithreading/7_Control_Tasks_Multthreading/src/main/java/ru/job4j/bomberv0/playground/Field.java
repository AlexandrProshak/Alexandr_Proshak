package ru.job4j.bomberv0.playground;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.bomberv0.heroes.Hero;
import ru.job4j.bomberv0.heroes.NoneHero;

import java.util.concurrent.TimeUnit;

/**
 * The class Field.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
@ThreadSafe
public class Field {

    /**
     * X field's size.
     */
    private final int fieldX;

    /**
     * Y field's size.
     */
    private final int fieldY;

    /**
     * A field's sells board.
     */
    @GuardedBy("itself")
    private final Cell[][] board;

    /**
     * A constructor.
     * @param fieldX x size.
     * @param fieldY y size.
     */
    public Field(final int fieldX, final int fieldY) {
        this.fieldX = fieldX;
        this.fieldY = fieldY;
        this.board = new Cell[fieldX][fieldY];
        for (int i = 0; i < fieldX; i++) {
            for (int j = 0; j < fieldY; j++) {
                this.board[i][j] = new Cell(new NoneHero(i, j, this));
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
     * @return result of setting.
     */
    @GuardedBy("this.board")
    public boolean setFigureOnBoard(Hero figure, int x, int y) {
        boolean result = false;
        if (x > fieldX || y > fieldY) {
            return false;
        } else {
            try {
                if (this.board[x][y].tryLock()) {
                    if (this.board[x][y].getFigure().getName().equals(" ")) {
                        this.board[x][y].setFigure(figure);
                        result = true;
                    }
                }
            } finally {
                this.board[x][y].unlock();
                return result;
            }
        }
    }

    /**
     * The method moves figure from start position to the destination position.
     * @param figure to be moved.
     * @param startX start coordinate X.
     * @param startY start coordinate Y.
     * @param destinationX destination coordinate X.
     * @param destinationY destination coordinate Y.
     * @return result of moving.
     */
    @GuardedBy("this.board")
    public boolean moveFigure(Hero figure,
                              int startX, int startY,
                              int destinationX, int destinationY) {
        boolean result = false;
        try {
            if (this.board[startX][startY].tryLock(500, TimeUnit.MILLISECONDS)) {
                Hero boardFigure = this.board[startX][startY].getFigure();
                if (this.board[startX][startY].getFigure().getName().equals(" ") || !figure.getName().equals(boardFigure.getName())) {
                    result = false;
                } else {
                    if (this.board[destinationX][destinationY].tryLock(500, TimeUnit.MILLISECONDS)) {
                        if (this.board[destinationX][destinationY].getFigure().getName().equals(" ")) {
                            this.board[startX][startY].setFigure(new NoneHero(startX, startY, this));
                            this.board[destinationX][destinationY].setFigure(figure);
                            result = true;
                        }
                        this.board[destinationX][destinationY].unlock();
                    }
                }
                this.board[startX][startY].unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * The method checks includes field new coordinate or not.
     * @param x coordinate.
     * @param y coordinate.
     * @return true if the field includes new coordinate.
     */
    public boolean cellOnBoard(final int x, final int y) {
        boolean result = false;
        if (x > 0 & y > 0) {
            if (this.board.length > x & this.board[0].length > y) {
                result = true;
            }
        }
        return result;
    }
}