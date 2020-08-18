package rd.java.basic.practice6.part1;

import java.util.Scanner;

public class WordContainer {
    private Word [] words = new Word[100];
    private int counter = 0;


    public static void main(String[] args) {
        WordContainer wordContainer= new WordContainer();
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

    private void compare (String o) {
        boolean equals;
        for (int i = 0; words[i] != null; i++) {
//            if (i == 0) {
//                words[counter] = new Word(o);
//                break;
//            }
            equals = words[i].getContent().equals(o);
            if (equals) {
                words[i].increaseFrequency();
            } else {
                words[counter] = new Word(o);
                counter++;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; words[i] != null; i++) {
            sb.append(words[i].toString() + "\n");
        }

//        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
