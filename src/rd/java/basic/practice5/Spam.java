package rd.java.basic.practice5;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Spam {
    private static boolean stopFlag = true;
    private final Thread[] threads;
    final String[] messages;
    final int[] delays;

    public Spam(final String[] messages, final int[] delays) {
        Logger logger = Logger.getLogger(Spam.class.getName());
        threads = new Thread[messages.length];
        this.messages = messages;
        this.delays = delays;
        int count = 0;
        for (int i = 0; i < threads.length; i++) {
            int finalCount = count;
            threads[i] = new Thread(() -> {
                while (stopFlag) {
                    System.out.println(messages[finalCount]);
                    try {
                        Thread.sleep(delays[finalCount]);
                    } catch (InterruptedException e) {
                        String message = "Exception in Constructor";
                        logger.log(Level.ALL, message, e);
                        Thread.currentThread().interrupt();
                    }
                }
            });
            count++;
        }
    }

    public static void main(final String[] args) {
        String[] messages = new String[] { "@@@", "bbbbbbb" };
        int[] times = new int[] { 333, 222 };
        Spam sp = new Spam(messages, times);
        Scanner scan = new Scanner(System.in);
        sp.start();
        if (scan.nextLine().equals("")) {
            sp.stop();
        }
    }
    public void start() {
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    public void stop() {
        stopFlag = false;
    }

    private static class Worker extends Thread {

    }

}
