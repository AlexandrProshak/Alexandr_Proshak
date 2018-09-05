package ru.job4j.bomberv2.models.entities;

import ru.job4j.bomberv2.controllers.GameController;
import ru.job4j.bomberv2.models.playground.Field;

import java.util.concurrent.TimeUnit;

/**
 * The class Bomberman.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Bomberman extends Figure {

    /**
     * The first name of the hero.
     */
    private static String name = "B";

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
     * @param controller of the game.
     * @param field game board.
     */
    public Bomberman(final GameController controller, Field field) {
        super(controller, name, bornX, bornY, field);
    }

    @Override
    public void move() {
        while (true) {
            int nextX = Figure.newCoordinate(this.getX());
            int nextY = Figure.newCoordinate(this.getY());
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

//    /**
//     * The method move for user's control.
//     */
//    @Override
//    public void move() {
//        while (true) {
//            int x = userApi.getX();
//            int y = userApi.getY();
//            try {
//                if (this.getField().getBoard()[x][y].tryLock(500, TimeUnit.MILLISECONDS)) {
//                    this.getField().moveFigure(this, x, y);
//                    this.setX(x);
//                    this.setY(y);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}