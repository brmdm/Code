package rd.java.basic.practice4;

import java.util.NoSuchElementException;

public class Part4 implements Iterable<String> {
    private String[] elementData;
    private static final int DEFAULT_CAPACITY = 4;
    private static final String[] EMPTY_ELEMENTDATA = {};
    private static final String[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private int size;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    public Part4() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }


    public Part4(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new String[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>();
    }


    private class Iterator<String> implements java.util.Iterator {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        public boolean hasNext() {
            return cursor != size;
        }

        public Object next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData1 = Part4.this.elementData;
            cursor = i + 1;
            return elementData1[i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }


    public static void main(String[] args) {


    }
}
