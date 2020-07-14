package rd.java.basic.practice3;

import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        String input = Util.getInput("part2.txt");
        System.out.print(convert(input));
    }

    public static String convert(String input) {
        StringBuilder sb1 = new StringBuilder("Min: ");
        StringBuilder sb2 = new StringBuilder("Max: ");
        Scanner read = new Scanner(input);
        String[] word = new String[200];
        String[] biggestWord = new String[200];
        String[] lowestWord = new String[200];
        int biggest = 1;
        int lowest = 2;
        int current = 1;
        read.useDelimiter("\\r\\n|\\s|\\W");

        for (int i = 0; read.hasNext(); i++) {
            word[i] = read.next();
            current = word[i].toCharArray().length;
            if (current > biggest) {
                biggest = current;
            }
            if (current < lowest && current != 0) {
                lowest = current;
            }
        }
        int calc1 = 0;
        int calc2 = 0;
        for (int i = 0; word[i] != null; i++) {
            current = word[i].toCharArray().length;
            if (current == lowest && notContains(lowestWord, word[i])) {
                lowestWord[calc1] = word[i];
                calc1++;
                sb1.append(word[i] + ", ");
            } else if (current == biggest && notContains(biggestWord, word[i])) {
                biggestWord[calc2] = word[i];
                calc2++;
                sb2.append(word[i] + ", ");
            }
        }

        for (int i = 0; i < 2; i++) {
            sb1.deleteCharAt(sb1.length() - 1);
            sb2.deleteCharAt(sb2.length() - 1);
        }

        return sb1.toString() + "\n" + sb2.toString();
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
