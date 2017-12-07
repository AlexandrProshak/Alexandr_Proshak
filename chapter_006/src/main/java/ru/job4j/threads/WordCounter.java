package ru.job4j.threads;

/**
 * A class describes a word counter.
 */
public class WordCounter implements Runnable {

    /**
     * A field for the line to be counted space.
     */
    private String string;

    /**
     * A constructor.
     * @param string is a text lin.
     */
    public WordCounter(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        int counter = wordCounter();
        System.out.printf("An amount of word in a given text line. - is: %s%s", counter, "\n");
    }

    /**
     * A method counts word in a line.
     * @return amount of a words.
     */
    private int wordCounter() {
        int counter = 0;
        int position = 0;
        while (position < this.string.length()) {
            if (this.string.charAt(position) != ' ') {
                for (int i = position; i < this.string.length(); i++) {
                    if (this.string.charAt(i) == ' ' || i == this.string.length() - 1) {
                        counter++;
                        position = i;
                        break;
                    }
                }
            }
            position++;
        }
        return counter;
    }
}
