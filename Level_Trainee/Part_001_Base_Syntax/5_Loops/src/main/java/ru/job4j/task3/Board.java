package ru.job4j.task3;

/**
 * Board.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Board {

    /**
     * The method returns chessboard as String line.
     * @param width width.
     * @param height height.
     * @return chessboard as String line.
     */
    public String paint(int width, int height) {
        StringBuilder builder = new StringBuilder();
        String separator = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    builder.append(" ");
                } else {
                    builder.append("X");
                }
            }
            builder.append(separator);
        }

        return builder.toString();
    }
}
