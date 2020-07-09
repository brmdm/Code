package rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {
    private Object[] elementData;
    protected int elementCount;
    protected int capacityIncrement;
    private static final int DEFAULT_CAPACITY = 4;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private int size;

    private int modCount = 0;

    public StackImpl() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public StackImpl(int initialCapacity) {
        this(initialCapacity, 0);
    }

    public StackImpl(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        this.elementData = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }


    @Override
    public void clear() {
        modCount++;
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        int cursor = size;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != 0;
        }

        public Object next() {
            synchronized (StackImpl.this) {
                int i = cursor - 1;
                if (i < 0)
                    throw new NoSuchElementException();
                Object[] elementData1 = StackImpl.this.elementData;
                if (i >= elementData1.length)
                    throw new NoSuchElementException();
                cursor = i;
                return elementData[i];
                }
        }
        @Override
        public void remove() {
            if (lastRet == -1)
                throw new IllegalStateException();
            synchronized (StackImpl.this) {
                StackImpl.this.pop();
                expectedModCount = modCount;
            }
            cursor = lastRet;
            lastRet = -1;
        }

    }

    public static <T> T[] copyOf(T[] original, int newLength) {
        return (T[]) copyOf(original, newLength, original.getClass());
    }

    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        @SuppressWarnings("unchecked")
        T[] copy = ((Object)newType == (Object)Object[].class)
                ? (T[]) new Object[newLength]
                : (T[]) java.lang.reflect.Array.newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
        return copy;
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    @Override
    public void push(Object element) {
        int minCapacity = size + 1;

        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                    capacityIncrement : oldCapacity);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0)
                newCapacity = hugeCapacity(minCapacity);
            elementData = copyOf(elementData, newCapacity);
        }
        elementData[elementCount++] = element;
        size++;
    }

    @Override
    public Object pop() {
        Object obj;
        int len = size();
        if (len == 0)
            return  null;
        obj = elementData[len - 1];

        elementData[len - 1] = null;
        size--;
        return obj;
    }

    @Override
    public Object top() {
        Object obj;
        int len = size();
        if (len == 0)
            return null;
        obj = elementData[len - 1];

        return obj;
    }

    @Override
    public String toString() {
        if (elementData == null)
            return "null";

        int iMax = elementData.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < elementData.length ; i++) {
            b.append(String.valueOf(elementData[i]));
            if (i == iMax)
                return b.append("]").toString();
            b.append(", ");
        }
        return b.toString();
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        StackImpl array = new StackImpl();
        String str1 = new String("A");
        String str2 = new String("B");
        String str3 = new String("C");
        array.push(str1);
        array.push(str2);
        array.push(str3);
//        System.out.println(array.size());
        System.out.println(array.toString());
        Iterator iterator = array.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(" ");
            }
        }
//        System.out.println();
//        System.out.println(array.toString());
//        System.out.println(array.top());
//        System.out.println(array.pop());
//        System.out.println(array.pop());
//        System.out.println(array.top());
//        System.out.println(array.toString());
//        array.clear();
//        System.out.println(array.toString());

    }

}
