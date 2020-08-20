package rd.java.basic.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {
    private int n;
    private int m;
    boolean reverse;
    private int size;
    private int firstLap = 0;



    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int firstBound, int secBound, boolean reversedOrder) {
        this.n = firstBound;
        this.m = secBound;
        this.reverse = reversedOrder;
        this.size = secBound - firstBound;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }

    private final class IteratorImpl implements Iterator<Integer> {
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size+1;
        }

        @Override
        public Integer next() {
            int i = cursor;
            if (i >= size+1) {
                throw new NoSuchElementException();
            }
            cursor++;

            if (firstLap == 0) {
                if (reverse) {
                    firstLap++;
                    return m;
                } else {
                    firstLap++;
                    return n;
                }
            }

            if (reverse) {
                return --m;
            } else {
                return ++n;
            }

        }

    }

}
