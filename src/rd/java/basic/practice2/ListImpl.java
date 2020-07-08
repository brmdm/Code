package rd.java.basic.practice2;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {
    private int size;
    private Node<Object> first;
    private Node<Object> last;
    private int modCount = 0;

    public ListImpl() {
    }

    public ListImpl(Object c) {
        this();
        addLast(c);
    }

    private static class Node<Object> {
        Object item;
        Node<Object> next;
        Node<Object> prev;

        Node(Node<Object> prev, Object element, Node<Object> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<Object> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<Object> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<Object> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public void clear() {
        for (Node<Object> x = first; x != null; ) {
            Node<Object> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl(0);
    }

    private class IteratorImpl implements Iterator<Object> {
        private Node<Object> lastReturned;
        private Node<Object> next;
        private int nextIndex;

        public IteratorImpl (int index) {
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<Object> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
        }

    }

    @Override
    public void addFirst(Object element) {
        final Node<Object> f = first;
        final Node<Object> newNode = new Node<>(null, element, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }

    @Override
    public void addLast(Object element) {
        final Node<Object> l = last;
        final Node<Object> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    @Override
    public void removeFirst() {
        final Node<Object> f = first;
        if (f == null)
            throw new NoSuchElementException();
        final Object element = f.item;

        final Node<Object> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
    }

    @Override
    public void removeLast() {
        final Node<Object> l = last;
        if (l == null)
            throw new NoSuchElementException();
        final Object element = l.item;
        final Node<Object> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
    }

    @Override
    public Object getFirst() {
        final Node<Object> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    @Override
    public Object getLast() {
        final Node<Object> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    @Override
    public Object search(Object element) {
        Object obj = null;
        if (element == null) {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (x.item == null)
                    obj = null;
            }
        } else {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (element.equals(x.item))
                    obj = x.item;
            }
        }

        return obj;
    }

    private Object unlink(Node<Object> x) {
        // assert x != null;
        final Object element = x.item;
        final Node<Object> next = x.next;
        final Node<Object> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }

    @Override
    public boolean remove(Object element) {
        if (element == null) {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (element.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String toString = "[";
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            toString += iterator.next();
            if (iterator.hasNext()) {
                toString += ", ";
            }
        }
        return toString + "]";
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        ListImpl array = new ListImpl();
        String str1 = new String("A");
        String str2 = new String("B");
        String str3 = new String("C");
        array.addLast(str1);
        array.addLast(str2);
        array.addLast(str3);

        Iterator iterator = array.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(" ");
            }
        }

        System.out.println();
        System.out.println(array.search("B"));
        System.out.println(array.size());
        System.out.println(array.toString());
        array.addFirst("Z");
        System.out.println(array.toString());
        System.out.println(array.getFirst());
        System.out.println(array.getLast());
        array.removeFirst();
        array.removeLast();
        array.remove("A");
        System.out.println(array.toString());
        array.clear();
        System.out.println(array.toString());


    }
}
