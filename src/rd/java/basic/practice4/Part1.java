package rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part1 {
    private static String getInput1(String fileName1) {
        Logger logger1 = Logger.getLogger(Part1.class.getName());
        StringBuilder sb1 = new StringBuilder();
        try {
            Scanner scanner1 = new Scanner(new File(fileName1), "cp1251");
            while (scanner1.hasNextLine()) {
                sb1.append(scanner1.nextLine()).append(System.lineSeparator());
            }
            scanner1.close();
            return sb1.toString().trim();
        } catch (IOException ex) {
            String message = "Unexpected Exception in Part1";
            logger1.log(Level.ALL, message, ex);
        }
        return sb1.toString();
    }

    private static String delChar2 (String input) {
        StringBuilder sb = new StringBuilder();
        Scanner read = new Scanner(input);
        read.useDelimiter("\\n");
        String[] str1 = new String[100];
        try {
            for (int i = 0; read.hasNext(); i++) {
                str1[i] = read.next();
            }
        } finally {
            read.close();
        }
        for (int i = 0; str1[i] != null; i++) {
            sb.append(delChar(str1[i]) + "\n");
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
            if (word.length >= 4) {
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
        String input = getInput1("part11.txt");
        System.out.print(delChar2(input));
    }

}
