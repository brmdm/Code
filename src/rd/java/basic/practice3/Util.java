package rd.java.basic.practice3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {
    public static String getInput(String fileName) {
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

    public static void main(String[] args) {
        String input = Util.getInput("part6.txt");
        System.out.println(input);
    }
}
