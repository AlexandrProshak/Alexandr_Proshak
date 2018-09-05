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

        SimpleContainer<String> myArrayList = new MyThreadSafeList(new DynamicList<String>());
        SimpleContainer<String> myLinkedList = new MyThreadSafeList(new LinkedContainer());
        //final MyThreadSafeList myList = new MyThreadSafeList(MyArrayList);
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
