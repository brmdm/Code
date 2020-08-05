package rd.java.basic.practice5;

//import java.io.InputStream;

public class Part2 {


//    private static final InputStream YOUR_OWN_INPUT_STREAM = ;

    public static void main(String[] args) throws Exception {
//        System.setIn(YOUR_OWN_INPUT_STREAM);
        Thread t = new Thread(() -> Spam.main(null));
        t.start();
        t.join();
//        System.setIn(CAСHED_VALUE_OF_SYSTEM_IN);
    }
}
