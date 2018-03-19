package ru.job4j.bombermanv2.models.entities;

import ru.job4j.bombermanv2.controllers.GameController;
import ru.job4j.bombermanv2.models.playground.Cell;
import ru.job4j.bombermanv2.models.playground.Field;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * The class Monster describes a monster's behavior.
 */
@SuppressWarnings("SameParameterValue")
public class Monster extends Figure {

    /**
     * The monster's name.
     */
    private static String name = "M";

    /**
     * A private constructor.
     * @param controller of the game.
     * @param name  of figure.
     * @param x coordinate of born.
     * @param y coordinate of born.
     * @param field game board.
     */
    private Monster(final GameController controller, String name, int x, int y, Field field) {
        super(controller, name, x, y, field);
    }

    /**
     * The static method of generating monsters.
     * @param controller of the game.
     * @param field for the game.
     * @return a monster.
     */
    public static Monster getMonster(final GameController controller, Field field) {
        int number = field.getBoard().length;
        Monster monster;
        while (true) {
            int coordinateX = newMonsterBornCoordinate(number);
            int coordinateY = newMonsterBornCoordinate(number);
            if (coordinateX == 0 && coordinateY == 0) {
                coordinateX++;
            }
            if (field.cellOnBoard(coordinateX, coordinateY)
                    && field.getBoard()[coordinateX][coordinateY].isFree()) {
                monster = new Monster(controller, name, coordinateX, coordinateY, field);
                break;
            }
        }
        return monster;
    }

    /**
     * The method generates monster's born coordinate.
     * @param number initial numbers for the coordinate generate.
     * @return a coordinate.
     */
    private static int newMonsterBornCoordinate(int number) {
        int[] row = new int[number];
        for (int i = 0; i < number; i++) {
            row[i] = i;
        }
        return row[new Random().nextInt(row.length)];
    }

    @Override
    protected void move() {
        while (true) {
            int nextX = Figure.newCoordinate(this.getX());
            int nextY = Figure.newCoordinate(this.getY());
            if (this.getField().cellOnBoard(nextX, nextY)) {
                try {
                    if (!this.getField().getBoard()[nextX][nextY].isFree()) {
                        Cell[][] board = this.getField().getBoard();
                        if ("B".equals(board[nextX][nextY].showFigureName())) {
                            getController().stopGame();
                            break;
                        }
                    }
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

}
