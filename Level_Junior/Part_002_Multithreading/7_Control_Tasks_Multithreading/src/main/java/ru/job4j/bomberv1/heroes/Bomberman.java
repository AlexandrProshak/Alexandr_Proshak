package ru.job4j.bomberv1.heroes;

import ru.job4j.bomberv1.playground.Field;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * The class Bomberman.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Bomberman extends Figure {

    /**
     * The coordinate x where the bomberman born.
     */
    private static int bornX = 0;

    /**
     * The coordinate Y where the bomberman born.
     */
    private static int bornY = 0;

    /**
     * A Constructor.
     * @param name  of figure.
     * @param field game board.
     */
    public Bomberman(String name, Field field) {
        super(name, bornX, bornY, field);
    }

    @Override
    public void move() {
        while (true) {
            int nextX = newCoordinate(this.getX());
            int nextY = newCoordinate(this.getY());
            if (this.getField().cellOnBoard(nextX, nextY)) {
                try {
                    if (this.getField().getBoard()[nextX][nextY].tryLock(500, TimeUnit.MILLISECONDS)) {
                        this.getField().moveFigure(this, nextX, nextY);
                        this.setX(nextX);
                        this.setY(nextY);
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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