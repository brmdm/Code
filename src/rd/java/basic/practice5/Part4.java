package rd.java.basic.practice5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part4 {
        private static String[] array1 = new String[20];


    public static void main(String[] args) {
        String input = getInput("part4.txt");
        Scanner scanner = new Scanner(input);
        scanner.useDelimiter("\\n");
        try {
            int arrayCounter = 0;
            while (scanner.hasNext()) {
                array1[arrayCounter] = scanner.next();
                arrayCounter++;
            }
        } finally {
            scanner.close();
        }

        searchMax(array1);
    }

//    private static String multiSearch (String[] input) {
//        int max = 0;
//        StringBuilder sb = new StringBuilder();
//        Logger logger = Logger.getLogger(Part4.class.getName());
//        int[] digits = new int[150];
//        for (int i = 0; input[i] != null; i++) {
//            String [] strarray = input[i].split(" ");
//            for (int j = 0; j < strarray.length; j++) {
//
//            }
//        }
//        for (int i = 0; input[i] != null; i++) {
//            new Thread(() -> {
//                    int count = 0;
//                    while () {
//                        try {
//                            Thread.sleep(1);
//                        } catch (InterruptedException e) {
//                            String message = "Exception in not sync Comparing";
//                            logger.log(Level.ALL, message, e);
//                        }
//
//                    }
//            });
//        }
//
//        return sb.toString();
//    }

    private static String searchMax (String[] input) {
        int max = 0;
        StringBuilder sb = new StringBuilder();

        long start = System.nanoTime();
        for (int i = 0; input[i] != null; i++) {
            String [] strarray = input[i].split(" ");
            for (int j = 0; j < strarray.length; j++) {
                Scanner scanner = new Scanner(strarray[j]);
                if (scanner.hasNextInt()) {
                    int value = Integer.parseInt(strarray[j]);
                    if (value > max) {
                        max = value;
                    }
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
