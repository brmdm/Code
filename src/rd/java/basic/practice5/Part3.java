package rd.java.basic.practice5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

    public static void main(final String[] args) throws InterruptedException {
        Part3 p3 = new Part3(10, 5);
        p3.compare();
        System.out.println("-----------------------------------");
        p3.counter = 0;
        p3.counter2 = 0;
        p3.compareSync();
    }

    public void compare() throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(() -> {
                int count = 0;
                while (count < iterations) {
                    System.out.println(counter == counter2);
                    counter++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter2++;
                    count++;
                }
            });
            es.execute(t[i]);
        }
        es.shutdown();
        while(!es.awaitTermination(1, TimeUnit.MINUTES));
    }

    public void compareSync() throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(() -> {
                synchronized (this) {
                    int count = 0;
                    while (count < iterations) {
                        System.out.println(counter == counter2);
                        counter++;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        counter2++;
                        count++;
                    }
                }
            });
            es.execute(t[i]);
        }
        es.shutdown();
        while(!es.awaitTermination(1, TimeUnit.MINUTES));
    }

}
