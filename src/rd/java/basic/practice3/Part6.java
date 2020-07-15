package rd.java.basic.practice3;

import java.util.Scanner;

public class Part6 {
    public static void main(String[] args) {
        String input = Util.getInput("part6.txt");
        System.out.print(convert(input));
    }

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbchar = new StringBuilder();
        Scanner read = new Scanner(input);
        read.useDelimiter("\\s");
        String[] str1 = new String[100];
        String[] strDuplicate = new String[100];
        int strDuplicateCurrent = 0;
        char[] word;

        try {
            for (int i = 0; read.hasNext(); i++) {
                str1[i] = read.next();
            }
        } finally {
            read.close();
        }

        for (int i = 0; str1[i] != null; i++) {
            for (int j = 0; str1[j] != null; j++) {
                if (str1[i].equals(str1[j]) && i != j) {
                    if (notContains(strDuplicate, str1[i]) && !(str1[i].equals(""))) {
                        strDuplicate[strDuplicateCurrent] = str1[i];
                        strDuplicateCurrent++;
                    }
                }
            }
        }


        for (int i = 0; str1[i] != null; i++) {
            for (int j = 0; strDuplicate[j] != null; j++) {

                if (str1[i].equals(strDuplicate[j])) {
                    word = str1[i].toCharArray();

                    for (int k = 0; k < word.length; k++) {
                        if (k == 0) {
                            sbchar.append("_");
                        }
                        sbchar.append(word[k]);
                    }
                    str1[i] = sbchar.toString();
                    sbchar.delete(0, sbchar.length());
                }
            }
        }


        for (int i = 0; str1[i] != null; i++) {
            if (str1[i].equals("")) {
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
            } else {
                sb.append(str1[i] + " ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static boolean notContains(String[] words, String word) {
        for (int i = 0; words[i] != null; i++) {
            if (words[i].equalsIgnoreCase(word)) {
                return false;
            }
        }
        return true;
    }
}