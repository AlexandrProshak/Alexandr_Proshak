package ru.job4j.bombermanv1.bomberman;

import ru.job4j.bombermanv1.bomberman.heroes.Bomberman;
import ru.job4j.bombermanv1.bomberman.playground.Cell;
import ru.job4j.bombermanv1.bomberman.playground.Field;

/**
 * The class runner.
 */
public class Runner {
    /**
     * The method main.
     * @param args line parameters.
     * @throws InterruptedException exception.
     */
    public static void main(String[] args) throws InterruptedException {

        Field field = new Field(4);
        Bomberman man = new Bomberman("A", field);
        Bomberman man1 = new Bomberman("B", field);
        Bomberman man2 = new Bomberman("C", field);

        new Thread(man).start();
        new Thread(man1).start();
        new Thread(man2).start();

        Cell[][] board = field.getBoard();

        int index = 15;
        while (--index > 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j].toString());
                }
                System.out.println();
            }
            Thread.sleep(1000);
            System.out.println();
        }

        man.setAlive(false);
        man1.setAlive(false);
        man2.setAlive(false);
    }
}
