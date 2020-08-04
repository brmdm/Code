package rd.java.basic.practice5;

import rd.java.basic.practice4.Part2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Part1 {
    static Thread t1 = new Thread(new NameThreadImpl());
    static Thread t2 = new NameThreadExt();

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(2000);
        t2.start();
        Thread.sleep(2000);
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
                System.out.println(t2.getName());
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    String message = "Exception in Extend Class";
                    logger.log(Level.ALL, message, e);
                }
                count++;
            }
        }
    }


}
