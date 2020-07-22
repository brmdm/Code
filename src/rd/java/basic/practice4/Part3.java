package rd.java.basic.practice4;

import rd.java.basic.practice3.Util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static void main(String[] args) {
        String input = getInput("part3.txt");
        final String doubleRegex = "[\\d]*[.][\\d]*";
        final Pattern doublePattern = Pattern.compile(doubleRegex, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        Matcher doubleMatcher;
        StringBuilder sb = new StringBuilder();

        int i;
        String str;
        char c;
        double d;

        Scanner read = new Scanner(input);
        read.useDelimiter("\\s");
        try {
            while (read.hasNext()) {

                if (read.hasNextInt()) {
                    i = read.nextInt();
                    sb.append(i);
                } else if (read.hasNextDouble()) {
                    d = read.nextDouble();
                    sb.append(d);
                } else {
                    str = read.next();
                    char[] ch = str.toCharArray();
                    doubleMatcher = doublePattern.matcher(str);
                    if (str.length() == 1) {
                        c = ch[0];
                        sb.append(c);
                    } else if (doubleMatcher.find()) {
                        d = Double.parseDouble(str);
                        sb.append(d);
                    } else if (str.equals("stop")) {
                        break;
                    } else {
                        sb.append(str);
                    }
                }
                sb.append(" ");
            }
        } finally {
            read.close();
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.toString());

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
