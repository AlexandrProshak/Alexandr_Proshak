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
        System.out.println(string);
        new Thread(spaceCounter).start();
        new Thread(wordCounter).start();
        System.out.println("Finish a method main.");
    }

}
