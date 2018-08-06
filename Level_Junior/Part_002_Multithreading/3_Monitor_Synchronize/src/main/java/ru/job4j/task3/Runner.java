package ru.job4j.task3;


import java.util.Iterator;

/**
 * The class Runner demonstrates multithreading using the MyThreadSafeList.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class Runner {

    /**
     * Main.
     * @param args args
     */
    public static void main(String[] args) {

        /**
         * The field for storing my simple implementation of dynamic array.
         */
        SimpleContainer<String> myArrayList = new MyThreadSafeList(new DynamicList<String>());

        /**
         * The field for storing my simple implementation of linked list.
         */
        SimpleContainer<String> myLinkedList = new MyThreadSafeList(new LinkedContainer());

        /**
         * An instance of a threadsafe list. My dynamic list is under the hood.
         */
        //final MyThreadSafeList myList = new MyThreadSafeList(MyArrayList);
        /**
         * An instance of a threadsafe list. My linked list is under the hood.
         */
        final MyThreadSafeList myList = new MyThreadSafeList(myLinkedList);

        Thread first = new Thread(() -> myList.add(Thread.currentThread().getName()));
        Thread second = new Thread(() -> myList.add(Thread.currentThread().getName()));
        Thread third = new Thread(() -> myList.add(Thread.currentThread().getName()));
        Thread forth = new Thread(() -> myList.add(Thread.currentThread().getName()));

        first.setName("I am first");
        second.setName("I am second");
        third.setName("I am third");
        forth.setName("I am forth");

        first.start();
        second.start();
        third.start();
        forth.start();

        try {
            first.join();
            second.join();
            third.join();
            forth.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Iterator<String> iterator = myList.iterator();

        for (; iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}
