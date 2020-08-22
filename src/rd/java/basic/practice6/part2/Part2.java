package rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {
    public static List<Integer> arrayList = new ArrayList();
    public static List<Integer> linkedList = new LinkedList<>();
    public static final int K = 4;
    public static final int CAPACITY = 10_000_0;

    public static void main(String[] args) {
        fill(CAPACITY);
        System.out.println("ArrayList#Index: " + removeByIndex(arrayList, K) + " ms");
        System.out.println("LinkedList#Index: " + removeByIndex(linkedList, K) + " ms");
        fill(CAPACITY);
        System.out.println("ArrayList#Iterator: " + removeByIterator(arrayList, K) + " ms");
        System.out.println("LinkedList#Iterator: " + removeByIterator(linkedList, K) + " ms");
    }


    public static long removeByIndex(final List<Integer> list, final int k) {
        long start = System.currentTimeMillis();

        int technicalVariable = k - 1;
        int i;

        for (i = technicalVariable; list.size() > 1; ) {
            list.remove(i);
            i = ((i + technicalVariable) % list.size());
        }

        return System.currentTimeMillis() - start;
    }


    public static long removeByIterator(final List<Integer> list, int k) {
        long start = System.currentTimeMillis();

        int i = k - 1;
        int technicalVariable = 0;

        while (list.size() > 1) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                it.next();
                if (technicalVariable++ == i) {
                    it.remove();
                    i += k;
                }
            }
        }

        return System.currentTimeMillis() - start;
    }


    public static void fill(int n) {
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }
}

