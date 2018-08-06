package ru.job4j.task4;

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
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

/**
 * The class ParallelSearch for searching files including given text.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
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
            if (exts.contains(getExtensionOfFile(file.toString()))) {
                files.offer(file.toString());
            }
            return FileVisitResult.CONTINUE;
        }
    }

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
     * The BlockingQueue for the files with appropriate extensions.
     */
    private final BlockingQueue<String> files = new ArrayBlockingQueue<>(256);

    /**
     * The resulted BlockingQueue of files contains files with the searched text.
     */
    private final BlockingQueue<String> paths = new ArrayBlockingQueue<>(256);

    /**
     * A volatile boolean flag indicates when a search is finished.
     */
    private volatile boolean searchFinish = false;

    /**
     * The constructor.
     * @param root path to the searching directory.
     * @param text searching text.
     * @param exts file extensions to searchFiles.
     */
    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    /**
     * The method initializes working threads.
     * @return a collection of result.
     */
    public BlockingQueue<String> search() {
        new Thread(this::searchFiles).start();
        Thread read = new Thread(this::readFiles);
        read.start();
        try {
            read.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paths;
    }

    /**
     * The method is walking through file tree and searches files with an appropriated extension.
     * Using the MyFileVisitor class.
     */
    private void searchFiles() {
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
    private void readFiles() {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < cores; i++) {
            executor.submit(this::parse);
        }

        while (true) {
            if (searchFinish && this.files.isEmpty()) {
                executor.shutdownNow();
                break;
            }
        }
    }

    /**
     * The method parses file.
     */
    private void parse() {
        while (true) {
            File file;
            try {
                file = new File(this.files.take());
            } catch (InterruptedException e) {
                break;
            }
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file)))) {
                String result;
                while ((result = reader.readLine()) != null) {
                    if (result.contains(this.text)) {
                        this.paths.offer(file.toString());
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The method returns an extension of the files name.
     * @param fileName file name.
     * @return extension of the file.
     */
    private String getExtensionOfFile(String fileName) {
        String extension = "";
        int beginIndex = fileName.lastIndexOf('.');
        if (beginIndex > 0) {
            extension = fileName.substring(beginIndex + 1);
        }
        return extension;
    }

}