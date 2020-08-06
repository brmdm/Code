package rd.java.basic.practice5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Part1 {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Part1.class.getName());
        Thread t1 = new Thread(new NameThreadImpl());
        Thread t2 = new NameThreadExt();
        try {
            t1.start();
            Thread.sleep(2000);
            t2.start();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            String message = "Exception in Part1.main";
            logger.log(Level.ALL, message, e);
            Thread.currentThread().interrupt();
        } catch (IllegalThreadStateException e) {
            String message = "IllegalStateException";
            System.out.println(212);
            System.out.println(212);
            logger.log(Level.ALL, message, e);
            Thread.currentThread().interrupt();
        }
    }

    static class NameThreadImpl implements Runnable {
        Logger logger = Logger.getLogger(NameThreadImpl.class.getName());
        int count = 0;

        @Override
        public void run() {
            while (count < 4) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    String message = "Exception in Implement Class";
                    logger.log(Level.ALL, message, e);
                    Thread.currentThread().interrupt();
                }
                count++;
            }
        }
    }

    static class NameThreadExt extends Thread {
        Logger logger = Logger.getLogger(NameThreadExt.class.getName());
        int count = 0;

        @Override
        public void run() {
            while (count < 4) {
                System.out.println(Thread.currentThread().getName());
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    String message = "Exception in Extend Class";
                    logger.log(Level.ALL, message, e);
                    Thread.currentThread().interrupt();
                }
                count++;
            }
        }
    }
}
