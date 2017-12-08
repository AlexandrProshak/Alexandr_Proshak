package ru.job4j.threads;

/**
 * A class demonstrates a work in two threads regime.
 */
public class Runner {
    /**
     * A main method.
     * @param args args.
     */
    public static void main(String[] args) {
        String string = "My name is john, and I like Java";
        SpacingCounter spaceCounter = new SpacingCounter(string);
        WordCounter wordCounter = new WordCounter(string);
        System.out.println("    The program counts words and whitespaces in a sentence.");
        System.out.println();
        System.out.println(" '' " + string + " '' ");
        System.out.println();
        Thread spaceCounterThread = new Thread(spaceCounter);
        Thread wordCounterThread = new Thread(wordCounter);
        spaceCounterThread.start();
        wordCounterThread.start();
        try {
            spaceCounterThread.join();
            wordCounterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println();
            System.out.println("    Finish program.");
        }
    }
}
