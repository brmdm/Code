package rd.java.basic.practice5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Part1 {
    static Thread t1 = new Thread(new NameThreadImpl());
    static Thread t2 = new NameThreadExt();

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Part1.class.getName());
        try {
            t1.start();
            t2.start();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            String message = "Exception in Part1.main";
            logger.log(Level.ALL, message, e);
            Thread.currentThread().interrupt();
        } catch (IllegalThreadStateException e) {
            String message = "IllegalStateException";
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
                System.out.println(t1.getName());
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
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                String message = "Exception in Extend Class";
                logger.log(Level.ALL, message, e);
                Thread.currentThread().interrupt();
            }
            while (count < 4) {
                System.out.println(t2.getName());
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
