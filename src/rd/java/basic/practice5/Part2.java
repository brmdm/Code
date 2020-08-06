package rd.java.basic.practice5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Part2 {


    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Part2.class.getName());
        Thread t = new Thread(() -> Spam.main(null));
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            String message = "Exception in Part2";
            logger.log(Level.ALL, message, e);
            Thread.currentThread().interrupt();
        }
        t.interrupt();
        Thread.currentThread().interrupt();
    }
}
