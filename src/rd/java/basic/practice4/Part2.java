package rd.java.basic.practice4;

import java.io.*;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part2 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Part2.class.getName());
        StringBuilder sb1 = new StringBuilder("input ==> ");
        StringBuilder sb2 = new StringBuilder("output ==> ");
        File inputFile = new File("part2.txt");
        File outputFile = new File("part2_sorted.txt");
        String input = fills();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));){
            writer.write(input);
        } catch (IOException e) {
            String message = "Unexpected Exception in main method";
            logger.log(Level.ALL, message, e);
        }


        String output = bubbleSort(getInput("part2.txt"));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));){
            writer.write(output);
        } catch (Exception e) {
            String message = "Unexpected Exception with Buffered Reader";
            logger.log(Level.ALL, message, e);
        }


        sb1.append(input);
        sb2.append(output);
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
    }




    private static String fills () {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random() + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String bubbleSort (String unsort) {
        StringBuilder sb = new StringBuilder();
        Scanner read = new Scanner(unsort);
        read.useDelimiter("\\s");
        int tech;
        int [] a = new int[10];
        try {
            for (int i = 0; read.hasNext(); i++) {
                a[i] = Integer.parseInt(read.next());
            }
        } finally {
            read.close();
        }
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a.length; k++) {
                for (int j = 0; j < a.length - k - 1; j++) {
                    if (a[k] > a[k + 1]) {
                        tech = a[k];
                        a[k] = a[k + 1];
                        a[k + 1] = tech;
                    }
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            sb.append(a[i] + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static int random () {
        SecureRandom random = new SecureRandom();
        return random.nextInt(50);
    }

    private static String getInput(String fileName) {
        Logger logger = Logger.getLogger(Part2.class.getName());
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            String message = "Unexpected Exception with input method";
            logger.log(Level.ALL, message, ex);
        }
        return sb.toString();
    }
}
