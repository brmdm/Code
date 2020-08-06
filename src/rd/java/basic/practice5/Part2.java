package rd.java.basic.practice5;

//import java.io.InputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Part2 {


//    private static final InputStream YOUR_OWN_INPUT_STREAM = ;

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Part2.class.getName());
//        System.setIn(YOUR_OWN_INPUT_STREAM);
        Thread t = new Thread(() -> Spam.main(null));
        t.start();
        try {
        t.join();} catch (InterruptedException e) {
            String message = "Exception in Part2";
            logger.log(Level.ALL, message, e);
        }
//        System.setIn(CAСHED_VALUE_OF_SYSTEM_IN);
    }
}
