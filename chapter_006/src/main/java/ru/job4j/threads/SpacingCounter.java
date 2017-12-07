package ru.job4j.threads;

/**
 * A class describes a whitespace counter.
 */
public class SpacingCounter implements Runnable {

    /**
     * A field for the line to be counted space.
     */
    private String string;

    /**
     * A constructor.
     * @param string is a text lin.
     */
    public SpacingCounter(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        int counter = spaceCounter();
        System.out.printf("An amount of whitespaces in a given text line. - is: %s%s", counter, "\n");
    }

    /**
     * A method counts whitespace in a line.
     * @return amount of a gaps.
     */
    private int spaceCounter() {
        int result = 0;
        char[] chars = this.string.toCharArray();
        for (char element : chars) {
            if (element == ' ') {
                result++;
            }
        }
        return result;
    }
}
