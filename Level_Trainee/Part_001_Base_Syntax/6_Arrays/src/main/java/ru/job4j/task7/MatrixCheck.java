package ru.job4j.task7;

/**
 * MatrixCheck.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class MatrixCheck {

    /**
     * The method figures out if any of diagonals contains from similar elements.
     * @param data an array.
     * @return true or false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = false;
        if (checkLeftDiagonal(data) || checkRightDiagonal(data)) {
            result = true;
        }
        return result;
    }

    /**
     * The method checks the left diagonal.
     * @param data an array.
     * @return true if diagonal is completed by similar values, or false if not.
     */
    private boolean checkLeftDiagonal(boolean[][] data) {
        boolean result = true;
        boolean first = data[0][0];
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != first) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * The method checks the right diagonal.
     * @param data an array.
     * @return true if diagonal is completed by similar values, or false if not.
     */
    private boolean checkRightDiagonal(boolean[][] data) {
        boolean result = true;
        boolean element = data[0][data.length - 1];
        for (int i = 0; i < data.length; i++) {
            if (data[data.length - 1 - i][i] != element) {
                result = false;
                break;
            }
        }
        return result;
    }

}
