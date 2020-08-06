package rd.java.basic.practice5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part4 {
    private static String[] array1 = new String[20];
    private static Thread[] t = new Thread[10];
    private static int globalMax = 0;


    public static void main(String[] args) {
        String input = getInput("part4.txt");
        Scanner scanner = new Scanner(input);
        scanner.useDelimiter("\\r\\n");
        try {
            int arrayCounter = 0;
            while (scanner.hasNext()) {
                array1[arrayCounter] = scanner.next();
                arrayCounter++;
            }
        } finally {
            scanner.close();
        }
        Logger logger = Logger.getLogger(Part1.class.getName());
        try {
            System.out.println(multiSearch(array1));
        } catch (InterruptedException e) {
            String message = "Exception in Part4.main";
            logger.log(Level.ALL, message, e);
        }
        System.out.print(searchMax(array1));

    }

    private static String multiSearch(String[] input) throws InterruptedException {
        long start = System.nanoTime();
        ExecutorService es = Executors.newCachedThreadPool();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; input[i] != null; i++) {
            int finalI = i;
            t[i] = new Thread(() -> {
                String[] strarray = input[finalI].split(" ");
                for (int j = 0; j < strarray.length; j++) {
                    int value = Integer.parseInt(strarray[j]);
                    if (value > globalMax) {
                        globalMax = value;
                    }
                }

            });
            es.execute(t[i]);
        }

        es.shutdown();
        while (!es.awaitTermination(1, TimeUnit.MINUTES)) ;
        long time = (System.nanoTime() - start) / 1_000_000;
        sb.append(globalMax + "\n" + time);
        return sb.toString();
    }

    private static String searchMax(String[] input) {
        long start = System.nanoTime();
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; input[i] != null; i++) {
            String[] strarray = input[i].split(" ");
            for (int j = 0; j < strarray.length; j++) {
                int value = Integer.parseInt(strarray[j]);
                if (value > max) {
                    max = value;
                }
            }
        }
        long time = (System.nanoTime() - start) / 1000;
        sb.append(max + "\n" + time);
        return sb.toString();
    }


    private static String getInput(String fileName) {
        Logger logger = Logger.getLogger(Part4.class.getName());
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            String message = "Unexpected Input Exception";
            logger.log(Level.ALL, message, ex);
        }
        return sb.toString();
    }
}
