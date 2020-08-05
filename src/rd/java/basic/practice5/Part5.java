package rd.java.basic.practice5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part5 {
    private static RandomAccessFile file;
    private static final Thread[] t = new Thread[10];
    private static final ExecutorService es = Executors.newCachedThreadPool();
    static Logger logger = Logger.getLogger(Part3.class.getName());
    private static int globalNumber = 0;

    static {
        try {
            file = new RandomAccessFile("part5.txt", "rws");
        } catch (FileNotFoundException e) {
            String message = "Exception in RandomAccessFile";
            logger.log(Level.ALL, message, e);
        }
    }

    private static synchronized void write() throws IOException {
        for (int i = 0; i < 20; i++) {
            file.writeUTF(String.valueOf(globalNumber));
        }
        file.writeUTF("\n");
        globalNumber++;
    }

    private static void threads() {
        Logger logger = Logger.getLogger(Part3.class.getName());
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            t[i] = new Thread(() -> {
                int number = finalI;
                synchronized (file) {
                    try {
                        write();
                    } catch (IOException e) {
                        String message = "Exception in threads method";
                        logger.log(Level.ALL, message, e);
                    }
                }
            }
            );
            es.execute(t[i]);
        }
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        threads();
        es.shutdown();
        while (!es.awaitTermination(1, TimeUnit.MINUTES)) ;
        {
        }

        file.close();

        String input = getInput5("part5.txt");
        System.out.print(input);


    }

    private static String getInput5(String fileName) {
        Logger logger5 = Logger.getLogger(Part5.class.getName());
        StringBuilder sb5 = new StringBuilder();
        try {
            Scanner scanner5 = new Scanner(new File(fileName), "cp1251");
            while (scanner5.hasNextLine()) {
                sb5.append(scanner5.nextLine()).append(System.lineSeparator());
            }
            scanner5.close();
            return sb5.toString().trim();
        } catch (IOException ex) {
            String message5 = "Unexpected Exception";
            logger5.log(Level.ALL, message5, ex);
        }
        return sb5.toString();
    }
}
