package rd.java.basic.practice3;

import java.util.Scanner;

public class Part3 {
    public static void main(String[] args) {
        String input = Util.getInput("part3.txt");
        System.out.print(convert(input));
    }

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbchar = new StringBuilder();
        Scanner read = new Scanner(input);
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
            if (word.length >= 3) {
                if (Character.isLowerCase(word[0])) {
                    word[0] = Character.toUpperCase(word[0]);
                    for (int j = 0; j < word.length; j++) {
                        sbchar.append(word[j]);
                    }
                    str1[i] = sbchar.toString();
                    sbchar.delete(0, sbchar.length());
                } else {
                    word[0] = Character.toLowerCase(word[0]);
                    for (int j = 0; j < word.length; j++) {
                        sbchar.append(word[j]);
                    }
                    str1[i] = sbchar.toString();
                    sbchar.delete(0, sbchar.length());
                }
            }
        }

        for (int i = 0; str1[i] != null; i++) {
            sb.append(str1[i] + " ");
            if (str1[i].equals("Younger")) {
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
