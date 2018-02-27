package ru.job4j.waitnotifynotifyall.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * The demonstrate client for parallel search class.
 */
public class Runner {

    /**
     * The main method.
     * @param args arguments.
     */
    public static void main(String[] args) {
        String root = "C:\\projects\\Alexandr_Proshak";
        String text = "@ThreadSafe";
        List<String> exts = new ArrayList<>(Arrays.asList("java"));

        BlockingQueue<String> parallelSearch = new ParallelSearch(root, text, exts).search();
        for (String string : parallelSearch) {
            System.out.println(string);
        }
    }

}