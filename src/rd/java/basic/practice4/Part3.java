package rd.java.basic.practice4;

import rd.java.basic.practice3.Util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part3 {
    public static void main(String[] args) {
        String input = getInput("part3.txt");



    }


    private static String getInput(String fileName) {
        Logger logger = Logger.getLogger(Util.class.getName());
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            String message = "Unexpected Exception";
            logger.log(Level.ALL, message, ex);
        }
        return sb.toString();
    }
}
