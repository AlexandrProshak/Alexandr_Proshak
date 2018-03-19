package ru.job4j.bombermanv2.models.playground;

import ru.job4j.bombermanv2.controllers.GameController;
import ru.job4j.bombermanv2.models.entities.Figure;

import java.util.Random;

/**
 * The class Block describes block at the board.
 */
@SuppressWarnings("SameParameterValue")
public class Block extends Figure {

    /**
     * The name of the entity.
     */
    private static String name = "X";

    /**
     * The private Constructor.
     * @param controller of the game.
     * @param name The name of the entity.
     * @param x coordinate.
     * @param y coordinate.
     * @param field of the game.
     */
    private Block(GameController controller, String name, int x, int y, Field field) {
        super(controller, name, x, y, field);
    }

    /**
     * The static factory method of generating blocks.
     * @param controller of the game.
     * @param field for the game.
     * @return a block.
     */
    public static Block getBlock(GameController controller, Field field) {
        int number = field.getBoard().length;
        Block block;
        while (true) {
            int coordinateX = newBlockCoordinate(number);
            int coordinateY = newBlockCoordinate(number);
            if (coordinateX == 0 && coordinateY == 0) {
                coordinateY++;
            }
            if (field.cellOnBoard(coordinateX, coordinateY)
                    && field.getBoard()[coordinateX][coordinateY].isFree()) {
                block = new Block(controller, name, coordinateX, coordinateY, field);
                break;
            }
        }
        return block;
    }

    /**
     * The method generates a coordinate for the block position.
     * @param number is initial coordinate for the generate.
     * @return a coordinate.
     */
    private static int newBlockCoordinate(int number) {
        int[] row = new int[number];
        for (int i = 0; i < number; i++) {
            row[i] = i;
        }
        return row[new Random().nextInt(row.length)];
    }

    @Override
    protected void move() {
        //Block is not moves.
    }

}
