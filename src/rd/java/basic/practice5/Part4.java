package rd.java.basic.practice5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part4 {



    public static void main(String[] args) {
        String input = getInput("part4.txt");
        String[] array1 = new String[20];
        int arrayCounter = 0;
        Scanner scanner = new Scanner(input);
        scanner.useDelimiter("\\s|\\n");

        try {
            while (scanner.hasNext()) {
                array1[arrayCounter] = scanner.next();
            }
        } finally {
            scanner.close();
        }


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
