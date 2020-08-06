package rd.java.basic.practice5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part3 {
    private int counter;
    private int counter2;
    private final int threads;
    private final int iterations;
    private final Thread[] t;

    public Part3(int numberOfThreads, int numberOfIterations) {
        this.threads = numberOfThreads;
        this.iterations = numberOfIterations;
        this.t = new Thread[threads];
    }

    public static void main(final String[] args) {
        Part3 p3 = new Part3(10, 5);
        p3.compare();
        p3.counter = 0;
        p3.counter2 = 0;
        p3.compareSync();
    }

    public void compare() {
        Logger logger1 = Logger.getLogger(Part3.class.getName());
        ExecutorService es1 = Executors.newCachedThreadPool();
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(() -> {
                int count = 0;
                while (count < iterations) {
                    try {
                        Thread.sleep(1);
                        System.out.println(counter == counter2);
                        counter++;
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        String message = "Exception in not sync Comparing";
                        logger1.log(Level.ALL, message, e);
                        Thread.currentThread().interrupt();
                    }
                    counter2++;
                    count++;
                }
            });
            es1.execute(t[i]);
        }
        es1.shutdown();
        try {
            while (!es1.awaitTermination(1, TimeUnit.MINUTES)) ;
        } catch (InterruptedException e) {
            String message = "Exception in NotSync Comparing#2";
            logger1.log(Level.ALL, message, e);
            Thread.currentThread().interrupt();
        }
    }

    public void compareSync() {
        Logger logger2 = Logger.getLogger(Part3.class.getName());
        ExecutorService es2 = Executors.newCachedThreadPool();
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(() -> {
                synchronized (this) {
                    int count = 0;
                    while (count < iterations) {
                        try {
                            Thread.sleep(1);
                            System.out.println(counter == counter2);
                            counter++;
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            String message = "Exception in not sync Comparing";
                            logger2.log(Level.ALL, message, e);
                            Thread.currentThread().interrupt();
                        }
                        counter2++;
                        count++;
                    }
                }
            });
            es2.execute(t[i]);
        }
        es2.shutdown();
        try {
            while (!es2.awaitTermination(1, TimeUnit.MINUTES)) ;
        } catch (InterruptedException e) {
            String message = "Exception in not sync Comparing2";
            logger2.log(Level.ALL, message, e);
            Thread.currentThread().interrupt();
        }
    }

}
