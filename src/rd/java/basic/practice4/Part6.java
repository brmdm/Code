package rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    public static void main(String[] args) {
        StringBuilder sbLatn = new StringBuilder("Latn: ");
        StringBuilder sbCyrl = new StringBuilder("Cyrl: ");
        boolean repeat = true;
        String input = getInput("part6.txt");
        final String latnRegex = "[a-zA-Z]+";
        final Pattern latnPattern = Pattern.compile(latnRegex, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        final Matcher latnMatcher = latnPattern.matcher(input);

        final String cyrlRegex = "[^a-zA-Z\r\n. -]+";
        final Pattern cyrlPattern = Pattern.compile(cyrlRegex, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS
                | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        final Matcher cyrlMatcher = cyrlPattern.matcher(input);


        while (latnMatcher.find()) {
            sbLatn.append(input.substring(latnMatcher.start(), latnMatcher.end()));
            sbLatn.append(" ");
        }
        while (cyrlMatcher.find()) {
            sbCyrl.append(input.substring(cyrlMatcher.start(), cyrlMatcher.end()));
            sbCyrl.append(" ");
        }

        Scanner console = new Scanner(System.in);
        while (repeat) {
            switch (console.nextLine()) {
                case "stop":
                    repeat = false;
                    break;
                case "Latn":
                    System.out.println(sbLatn.toString());
                    break;
                case "Cyrl":
                    System.out.println(sbCyrl.toString());
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
    }

    private static String getInput(String fileName) {
        Logger logger = Logger.getLogger(Part6.class.getName());
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
