package rd.java.basic.practice6.part1;

public class Word implements Comparable<Word> {

    private String content;

    private int frequency;

    public Word(String word) {
        this.content = word;
        this.frequency = 1;
    }


    @Override
    public int compareTo(Word o) {
        if (o.frequency == this.frequency) {
            return sortByLexicograph(this, o);
        } else {
            return sortByFrequency(this, o);
        }
    }

    private int sortByLexicograph(Word o1, Word o2) {
        return o1.getContent().compareTo(o2.getContent());
    }

    private int sortByFrequency(Word o1, Word o2) {
        return o2.getFrequency() - o1.getFrequency();
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
