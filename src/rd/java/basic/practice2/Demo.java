package rd.java.basic.practice2;

import java.util.Iterator;

public class Demo {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        ArrayImpl array1 = new ArrayImpl();
        String str11 = new String("A");
        String str12 = new String("B");
        String str13 = new String("C");
        array1.add(str11);
        array1.add(str12);
        array1.add(str13);

        Iterator iterator1 = array1.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next());
            if (iterator1.hasNext()) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println(array1.toString());
        System.out.println(array1.size());
        array1.set(2, new String("C"));
        System.out.println(array1.get(1));
        array1.remove(2);
        System.out.println(array1.toString());
        System.out.println(array1.indexOf("B"));
        array1.clear();
        System.out.println(array1.toString());
        System.out.println();
        System.out.println(array1.size());

//        NEXT IMPLEMENTATIONS
        ListImpl array2 = new ListImpl();
        String str21 = new String("A");
        String str22 = new String("B");
        String str23 = new String("C");
        array2.addLast(str21);
        array2.addLast(str22);
        array2.addLast(str23);

        Iterator iterator2 = array2.iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next());
            if (iterator2.hasNext()) {
                System.out.print(" ");
            }
        }

        System.out.println();
        System.out.println(array2.search("B"));
        System.out.println(array2.size());
        System.out.println(array2.toString());
        array2.addFirst("Z");
        System.out.println(array2.toString());
        System.out.println(array2.getFirst());
        System.out.println(array2.getLast());
        array2.removeFirst();
        array2.removeLast();
        array2.remove("A");
        System.out.println(array2.toString());
        array2.clear();
        System.out.println(array2.toString());
        System.out.println();

        //        NEXT IMPLEMENTATIONS
        QueueImpl array3 = new QueueImpl();
        String str31 = new String("A");
        String str32 = new String("B");
        String str33 = new String("C");
        array3.enqueue(str31);
        array3.enqueue(str32);
        array3.enqueue(str33);
        System.out.println(array3.size());

        Iterator iterator3 = array3.iterator();
        while (iterator3.hasNext()) {
            System.out.print(iterator3.next());
            if (iterator3.hasNext()) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println(array3.toString());
        System.out.println(array3.top());
        System.out.println(array3.dequeue());
        System.out.println(array3.top());
        System.out.println(array3.toString());
        array3.clear();
        System.out.println(array3.toString());
        System.out.println();
        //        NEXT IMPLEMENTATIONS
        StackImpl array4 = new StackImpl();
        String str41 = new String("A");
        String str42 = new String("B");
        String str43 = new String("C");
        array4.push(str41);
        array4.push(str42);
        array4.push(str43);
        System.out.println(array4.size());

        Iterator iterator4 = array4.iterator();
        while (iterator4.hasNext()) {
            System.out.print(iterator4.next());
            if (iterator4.hasNext()) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println(array4.toString());
        System.out.println(array4.top());
        System.out.println(array4.pop());
        System.out.println(array4.pop());
        System.out.println(array4.top());
        System.out.println(array4.toString());
        array4.clear();
        System.out.println(array4.toString());

    }
}
