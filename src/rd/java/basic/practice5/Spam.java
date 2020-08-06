package rd.java.basic.practice5;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Spam {
    private final Worker[] workers = new Worker[20];
    final String[] messages;
    final int[] delays;

    public Spam(final String[] messages, final int[] delays) {
        this.messages = messages;
        this.delays = delays;
        int count = 0;
        for (int i = 0; i < messages.length; i++) {
            int finalCount = count;
            workers[i] = new Worker(messages[finalCount], delays[finalCount]);
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
        for (int i = 0; i < messages.length; i++) {
            workers[i].starting();
        }
    }

    public void stop() {
        for (int i = 0; i < messages.length; i++) {
            workers[i].stopping();
        }
    }

    private static class Worker extends Thread {
        private static boolean stopFlag = true;
        private Thread thread;

        public Worker (final String messages, final int delays) {
            Logger logger = Logger.getLogger(Spam.class.getName());
            thread = new Thread(() -> {
                while (stopFlag) {
                    System.out.println(messages);
                    try {
                        Thread.sleep(delays);
                    } catch (InterruptedException e) {
                        String message = "Exception in Constructor";
                        logger.log(Level.ALL, message, e);
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
        public void starting () {
            thread.start();
        }
        public void stopping () {
            stopFlag = false;
            Thread.currentThread().interrupt();
        }
    }
}
