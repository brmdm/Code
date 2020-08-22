package rd.java.basic.practice6.part5;

public class Tree<E extends Comparable<E>> {private Node<E> root;
    private static final String SEPARATOR = "  ";

    public boolean add(E element) {
        if (findRec(root, element)) {
            return false;
        }
        root = addRec(root, element);
        return true;
    }

    private Node<E> addRec(Node<E> current, E element) {
        if (current == null) {
            return new Node<>(element);
        }

        int compareResult = element.compareTo(current.key);
        if (compareResult > 0) {
            current.right = addRec(current.right, element);
        } else {
            current.left = addRec(current.left, element);
        }

        return current;
    }

    public void add(E[] elements) {
        for (E element : elements) {
            this.add(element);
        }
    }

    public boolean remove(E element) {
        if (!findRec(root, element)) {
            return false;
        }
        root = removeRec(root, element);
        return true;
    }

    private Node<E> removeRec(Node<E> current, E element) {
        if (element == current.key) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            E smallestValue = getSmallestElement(current.right);
            current.key = smallestValue;
            current.right = removeRec(current.right, smallestValue);
            return current;
        }
        if (element.compareTo(current.key) < 0) {
            current.left = removeRec(current.left, element);
            return current;
        }

        current.right = removeRec(current.right, element);
        return current;
    }

    private E getSmallestElement(Node<E> current) {
        return current.left == null ? current.key : getSmallestElement(current.left);
    }

    public void print() {
        printTree(root, "");
    }

    private void printTree(Node<E> root, String separator) {
        if (root != null) {
            printTree(root.left, separator + SEPARATOR);
            System.out.println(separator + root.key);
            printTree(root.right, separator + SEPARATOR);
        }
    }


    private boolean findRec(Node<E> current, E element) {
        if (current == null) {
            return false;
        }

        if (element == current.key) {
            return true;
        }

        return element.compareTo(current.key) > 0
                ? findRec(current.right, element)
                : findRec(current.left, element);
    }

    private static class Node<E> {
        private Node<E> left;
        private Node<E> right;
        private E key;

        public Node(E key) {
            left = right = null;
            this.key = key;
        }
    }

}
