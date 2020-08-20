package rd.java.basic.practice6.part1;

public class Word implements Comparable<Word> {

    private String content;

    private int frequency;

    public Word (String word) {
        this.content = word;
        this.frequency = 1;
    }


    @Override
    public int compareTo(Word o) {
        boolean equals = o.getContent().equals(this.content);
        if (equals) {
            return 1;
        } else {
            return 0;
        }
    }




    @Override
    public String toString() {
        return content + " : " + frequency;
    }

    public String getContent() {
        return content;
    }

    public void increaseFrequency() {
        frequency++;
    }

    public int getFrequency() {
        return frequency;
    }
}
