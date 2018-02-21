package ru.job4j.waitnotifynotifyall.task4;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.FileVisitResult;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The class ParallelSearch for searching files including given text.
 */
@SuppressWarnings("SpellCheckingInspection")
@ThreadSafe
public class ParallelSearch {

    //In my opinion, the class MyFileVisitor is ThreadSafe as far as it calls only from the synchronized method.
    //But I am not sure, am I right or not.
    /**
     * The class MyFileVisitor.
     */
    @ThreadSafe
    private class MyFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            if (dir.toString().contains(".")) {
                return FileVisitResult.SKIP_SUBTREE;
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (exts.contains(getExtesionOfFile(file.toString()))) {
                offer(file.toString());
            }
            return FileVisitResult.CONTINUE;
        }
    }


    /**
     * The private lock.
     */
    private final Object mutex = new Object();

    /**
     * The start directory.
     */
    private final String root;

    /**
     * The text to to be searched.
     */
    private final String text;

    /**
     * The list for the searched files extensions.
     */
    private final List<String> exts;

    /**
     * The queue for the files with appropriate extensions.
     */
    @GuardedBy("mutex")
    private final Queue<String> files = new LinkedList<>();

    /**
     * The resulted list of files contains files with the searched text.
     */
    @GuardedBy("mutex")
    private final List<String> paths = new ArrayList<>();

    /**
     * A volatile boolean flag indicates when a search is finished.
     */
    private volatile boolean searchFinish = false;

    /**
     * The constructor.
     * @param root path to the searching directory.
     * @param text searching text.
     * @param exts file extensions to startSearch.
     */
    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    /**
     * The method initializes working threads.
     */
    public void init() {
        new Thread(this::startSearch).start();
        Thread readThread = new Thread(this::startRead);
        readThread.start();

        try {
            readThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method offers file neme to the queue in synchronize way.
     * @param file to be offered.
     */
    private void offer(String file) {
        synchronized (mutex) {
            this.files.offer(file);
        }
    }

    /**
     * The method is walking through file tree and searches files with an appropriated extension.
     * Using the MyFileVisitor class.
     */
    private void startSearch() {
        Path startDir = Paths.get(this.root);
        try {
            Files.walkFileTree(startDir, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            searchFinish = true;
        }
    }

    /**
     * The method reads all files from the collection of files.
     */
    @GuardedBy("mutex")
    private void startRead() {
        while (true) {
            synchronized (mutex) {
                while (!this.files.isEmpty()) {
                    File file = new File(this.files.poll());
                    try {
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream(file)));
                        String result;
                        while ((result = reader.readLine()) != null) {
                            if (result.contains(this.text)) {
                                this.paths.add(file.toString());
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (searchFinish) {
                break;
            }
        }
    }

    /**
     * The method returns an extension of the files name.
     * @param fileName file name.
     * @return extension of the file.
     */
    private String getExtesionOfFile(String fileName) {
        String extension = "";
        int beginIndex = fileName.lastIndexOf('.');
        if (beginIndex > 0) {
            extension = fileName.substring(beginIndex + 1);
        }
        return extension;
    }

    /**
     * The method returns unmodifiable List of result.
     * @return unmodifiable List of files path.
     */
    public List<String> results() {
        synchronized (mutex) {
            return Collections.unmodifiableList(paths);
        }
    }

}