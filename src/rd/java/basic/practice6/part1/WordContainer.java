package rd.java.basic.practice6.part1;

import java.util.*;

public class WordContainer {
    private Word[] words = new Word[100];
    private int counter = 0;


    public static void main(String[] args) {
        WordContainer wordContainer = new WordContainer();
        boolean repeat = true;

        Scanner console = new Scanner(System.in);
        console.useDelimiter("\\s|\\n|\\r\\n");


        while (repeat) {
            String input = console.nextLine();
            switch (input) {
                case "stop":
                    repeat = false;
                    System.out.print(wordContainer.toString());
                    break;
                default:
                    wordContainer.compare(input);
                    break;
            }
        }
    }

    private void compare(String o) {
        boolean globalEquals = true;
        int compare;
        String[] variableString = o.split("\\s");
        Word[] variableWords = new Word[variableString.length];
        for (int i = 0; i < variableString.length; i++) {
            variableWords[i] = new Word(variableString[i]);
        }
        if (counter == 0) {
            words[0] = new Word("12321");
            counter++;
        }
        L: for (int i = 0; i < variableWords.length; i++) {
            for (int j = 0; words[j] != null; j++) {
                compare = variableWords[i].compareTo(words[j]);
                if (compare == 1) {
                    words[j].increaseFrequency();
                    globalEquals = false;
                    continue L;
                }
            }
            if (globalEquals) {
                words[counter] = new Word(variableString[i]);
                counter++;
            }
            globalEquals = true;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; words[i] != null; i++) {
            sb.append(words[i].toString() + "\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


}
