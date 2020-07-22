package rd.java.basic.practice4;

import rd.java.basic.practice3.Util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part1 {
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


    private static String delChar(String original) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbchar = new StringBuilder();
        Scanner read = new Scanner(original);
        read.useDelimiter("\\s");
        String[] str1 = new String[100];
        char[] word;

        try {
            for (int i = 0; read.hasNext(); i++) {
                str1[i] = read.next();
            }
        } finally {
            read.close();
        }

        for (int i = 0; str1[i] != null; i++) {
            word = str1[i].toCharArray();
            if (word.length > 4) {
                for (int j = 2; j < word.length; j++) {
                    sbchar.append(word[j]);
                }
                str1[i] = sbchar.toString();
                sbchar.delete(0, sbchar.length());
            }
        }

        for (int i = 0; str1[i] != null; i++) {
            sb.append(str1[i] + " ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");

        System.out.print(delChar(input));
    }

}
