package rd.java.basic.practice3;

import java.util.Scanner;

public class Part6 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        String input = Util.getInput("part6.txt");
        System.out.print(convert(input));
    }

    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbchar = new StringBuilder();
        Scanner read = new Scanner(input);
        read.useDelimiter("\\s|");
        String[] str1 = new String[100];
        char[] word = new char[20];

        for (int i = 0; read.hasNext(); i++) {
            str1[i] = read.next();
        }


        return sb.toString();
    }
}