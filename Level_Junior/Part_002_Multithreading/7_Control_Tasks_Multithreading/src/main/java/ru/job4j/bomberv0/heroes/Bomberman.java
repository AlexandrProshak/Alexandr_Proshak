package ru.job4j.bomberv0.heroes;

import ru.job4j.bomberv0.playground.Field;

import java.util.Random;

/**
 * The class Bomberman.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Bomberman extends Hero {

    /**
     * A Constructor.
     * @param name  of figure.
     * @param x     coordinate.
     * @param y     coordinate.
     * @param field game board.
     */
    public Bomberman(String name, int x, int y, Field field) {
        super(name, x, y, field);
        setFigureOnBoard();
    }

    /**
     * The method set an instance of figure on the board.
     */
    private void setFigureOnBoard() {
        this.getField().setFigureOnBoard(this, getX(), getY());
        this.setAlive();
    }

    @Override
    public void move() {
        while (true) {
            int nextX = newCoordinate(this.getX());
            int nextY = newCoordinate(this.getY());
            if (this.getField().cellOnBoard(nextX, nextY)) {
                this.getField().moveFigure(this, getX(), getY(), nextX, nextY);
                this.setX(nextX);
                this.setY(nextY);
                break;
            }
        }
    }

    /**
     * The method returns new coordinate.
     * @param coordinate start coordinate.
     * @return new coordinate.
     */
    private int newCoordinate(int coordinate) {
        int[] row = {coordinate - 1, coordinate, coordinate + 1};
        return row[new Random().nextInt(row.length)];
    }

}