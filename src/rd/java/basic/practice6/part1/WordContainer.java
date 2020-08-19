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
        boolean equalsFlag = true;
        boolean equals;
        String[] variableWords = o.split("\\s");
        if (counter == 0) {
            words[0] = new Word(variableWords[0]);
            counter++;
        }

        for (int i = 0; i < variableWords.length; i++) {

            for (int j = 0; words[j] != null; j++) {
                equals = words[j].getContent().equals(variableWords[i]);
                if (equals && counter != 1) {
                    words[j].increaseFrequency();
                    equalsFlag = false;
                    break;
                } else if (counter == 1) {
                    equalsFlag = false;
                    break;
                }
            }

            if (equalsFlag) {
                words[counter] = new Word(variableWords[i]);
                counter++;
            }
            equalsFlag = true;

        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();


        for (int i = 0; words[i] != null; i++) {
            sb.append(words[i].toString() + "\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
