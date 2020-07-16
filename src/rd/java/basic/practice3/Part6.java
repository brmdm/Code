package rd.java.basic.practice3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    public static void main(String[] args) {
        String input = Util.getInput("part6.txt");
        System.out.print(convert(input));
    }

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbs = new StringBuilder();
        Scanner read = new Scanner(input);
        read.useDelimiter("\\s");
        String[] str1 = new String[100];
        String[] strDuplicate = new String[100];
        int strDuplicateCurrent = 0;

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

        final String regex = "^.*$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        final Matcher matcher = pattern.matcher(input);
        String[] str = new String[50];
        int count = 0;
        while (matcher.find()) {
            str[count] = input.substring(matcher.start(), matcher.end());
            count++;
        }
        String[] words;
        for (int i = 0; str[i] != null; i++) {
            words = str[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                if (!notContains(strDuplicate, words[j])) {
                    words[j] = ch(words[j]);
                }
            }
            for (int j = 0; j < words.length ; j++) {
                sbs.append(words[j] + " ");
            }
            sbs.deleteCharAt(sbs.length() - 1);
            str[i] = sbs.toString();
            sbs.delete(0, sbs.length());
        }

        for (int i = 0; str[i] != null; i++) {
            sb.append(str[i] + "\n");
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

    private static String ch(String str1) {
        StringBuilder sbchar = new StringBuilder();
        char[] word;
        word = str1.toCharArray();

        for (int k = 0; k < word.length; k++) {
            if (k == 0) {
                sbchar.append("_");
            }
            sbchar.append(word[k]);
        }
        return sbchar.toString();
    }
}
