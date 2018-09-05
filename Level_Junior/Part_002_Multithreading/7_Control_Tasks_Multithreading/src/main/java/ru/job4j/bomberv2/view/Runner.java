package ru.job4j.bomberv2.view;

import ru.job4j.bomberv2.controllers.GameController;
import ru.job4j.bomberv2.models.factories.BlockThreadFactory;
import ru.job4j.bomberv2.models.factories.BombermanThreadFactory;
import ru.job4j.bomberv2.models.factories.MonsterThreadFactory;
import ru.job4j.bomberv2.models.playground.Cell;
import ru.job4j.bomberv2.models.playground.Field;

/**
 * The class Runner demonstrates automatic game's process.
 * The Figures like monsters and the bomberman can move
 *  - up;
 *  - down;
 *  - left;
 *  - right
 *  - and through diagonally.
 *
 *  @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Runner {

    /**
     * The field's size.
     */
    private static int size = 5;
    /**
     * An amount of blocks.
     */
    private static int blocks = 6;
    /**
     * An amount of monsters.
     */
    private static int monsters = 5;


    /**
     * The main method.
     * @param args is line arguments.
     */
    public static void main(String[] args) {

        Field field = new Field(size);
        GameController controller = new GameController();

        controller.startGame();

        for (int i = 0; i < blocks; i++) {
            BlockThreadFactory.getBlockThread(controller, field).start();
        }

        BombermanThreadFactory.getBombermanThread(controller, field).start();

        for (int i = 0; i < monsters; i++) {
            MonsterThreadFactory.getMonsterThread(controller, field).start();
        }

        Cell[][] board = field.getBoard();

        while (true) {
            for (Cell[] aBoard : board) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(aBoard[j].toString());
                }
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            if (!controller.isGame()) {
                break;
            }
        }
    }

}
