package rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static List<Integer> arrayList = new ArrayList();
    public static List<Integer> linkedList = new ArrayList();
    public static final int K = 3;
    private static int counter = 0;

    public static void main(String[] args) {
        fill(7);
        System.out.print("ArrayList#Index: " + (System.currentTimeMillis() - removeByIndex(arrayList, K)) + " ms\n");
        System.out.print("LinkedList#Index: " + removeByIndex(linkedList, K) + " ms\n");
        System.out.print("ArrayList#Iterator: " + removeByIterator(arrayList, K) + " ms\n");
        System.out.print("LinkedList#Iterator: " + removeByIterator(linkedList, K) + " ms");
    }


    public static long removeByIndex(final List<Integer> list, final int k) {
        int n = list.size();
        if (n == 1) {
            return System.currentTimeMillis();
        }
        list.remove(k-1);

        return (removeByIndex(list, k) + k-1) % n + 1;
    }


    public static long removeByIterator(final List<Integer> list, int k) {
        int n = list.size();
        long start = System.currentTimeMillis();


        return System.currentTimeMillis() - start;
    }


    public static void fill(int n) {
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }
}

