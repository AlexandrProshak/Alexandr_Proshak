package ru.job4j.threads.interruptthreads;

/**
 * The class Runner shows a work of interrupting thread.
 */
public class Runner {

    /**
     * Tha method main.
     * @param args no any args.
     */
    public static void main(String[] args) {
        Thread.currentThread().setName("Main program");

        Time timer = new Time(Thread.currentThread());
        Thread timerThread = new Thread(timer);
        timerThread.setDaemon(true);
        timerThread.start();

        String string = "For years, functional programming has been considered the realm of a small band of\n"
                + "specialists who consistently claimed superiority to the masses while being unable to\n"
                + "spread the wisdom of their approach. The main reason I’ve written this book is to\n"
                + "challenge both the idea that there’s an innate superiority in the functional style and the\n"
                + "belief that its approach should be relegated to a small band of specialists!";

        CountChar countChar = new CountChar(string);
        Thread counterThread = new Thread(countChar);
        counterThread.setDaemon(true);
        counterThread.start();

        try {
            counterThread.join();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.format("Thread %s was interrupted!%s", Thread.currentThread().getName(), System.lineSeparator());
        }
    }
}
