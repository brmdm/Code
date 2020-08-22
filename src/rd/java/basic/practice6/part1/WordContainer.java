package rd.java.basic.practice6.part1;

import java.util.*;

public class WordContainer {
    private static List <Word> words;
    private static String[] splitWord;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder console = new StringBuilder();
        String word;
        while (!"stop".equals((word = scanner.next()))) {
            console.append(word).append(' ');
        }
        splitWord = console.toString().split("\\s+");
        words = extract();
        words.sort(Word::compareTo);

        words.forEach(w -> System.out.println(w.getContent() + " : " + w.getFrequency()));
    }


    public static List<Word> extract() {
        List<Word> valueList = new ArrayList<>();
        for (String w : splitWord) {
            Word word = new Word(w);
            int index = valueList.indexOf(word);
            if (index == -1) {
                valueList.add(word);
            } else {
                valueList.get(index).increaseFrequency();
            }
        }
        return valueList;
    }






}
