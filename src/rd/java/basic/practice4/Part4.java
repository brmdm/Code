package rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>();
    }


    private class Iterator<String> implements java.util.Iterator {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public String next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            String[] elementData1 = (String[]) Part4.this.elementData;
            cursor = i + 1;
            return elementData1[i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    public void add(String element) {
        int minCapacity = size + 1;
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        // overflow-conscious code
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0)
                newCapacity = hugeCapacity(minCapacity);
            // minCapacity is usually close to size, so this is a win:
            elementData = copyOf(elementData, newCapacity);
        }

        elementData[size++] = element;
    }

    public static <T> T[] copyOf(T[] original, int newLength) {
        return (T[]) copyOf(original, newLength, original.getClass());
    }

    public static <T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        T[] copy = ((Object) newType == (Object) Object[].class)
                ? (T[]) new Object[newLength]
                : (T[]) java.lang.reflect.Array.newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
        return copy;
    }

    private static String getInput(String fileName) {
        Logger logger = Logger.getLogger(Part3.class.getName());
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            String message = "Unexpected Exception";
            logger.log(Level.ALL, message, ex);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String input = getInput("part4.txt");
        StringBuilder sb1;
        StringBuilder sb = new StringBuilder();
        Part4 array = new Part4();
//        String[] inputArray = input.split("[.]");
//        for (int i = 0; i < inputArray.length; i++) {
//            if (i != 0) {
//                sb1 = new StringBuilder(inputArray[i]);
//                sb1.deleteCharAt(0);
//                array.add(sb1.toString() + ".");
//            } else {
//                array.add(inputArray[i] + ".");
//            }
//        }

        Scanner scanner = new Scanner(input);
        scanner.useDelimiter("\\s|\\n");

        try {
            while (scanner.hasNext()) {
                array.add(scanner.next());
            }
        } finally {
            scanner.close();
        }

        String s;
        char[] c;
        Iterator iterator = array.iterator();
        while (iterator.hasNext()) {
            s = (String) iterator.next();
            c = s.toCharArray();
            if (c[c.length - 1] == '.') {
                sb.append(s + "\n");
            } else {
                sb.append(s + " ");
            }
        }
        System.out.print(sb.toString());
    }
}
