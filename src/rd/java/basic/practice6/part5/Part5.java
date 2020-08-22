package rd.java.basic.practice6.part5;

public class Part5 {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(new Integer[]{3, 7, 1, 8, 6, 2, 5, 1, 3, 10, 9});
        tree.print();
        System.out.println("remove 2: " + tree.remove(2));
        System.out.println("remove 7: " + tree.remove(7));

        tree.print();

    }
}
