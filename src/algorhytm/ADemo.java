package algorhytm;

public class ADemo {
//    public static void main(String[] args) {
//        System.out.println("--------------------------------------------");
//        showBubbleTest();
//
//        System.out.println("--------------------------------------------");
//        showFactorialTest();
//
//        System.out.println("--------------------------------------------");
//        showFibonacciTest();
//
//        System.out.println("--------------------------------------------");
//
//    }

    private static void showFibonacciTest () {
        int [] a = FibonacciDone.main((int)(Math.random() * 20));
        System.out.print("Numbers of Fibonacci: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " | ");
        }
        System.out.println();
    }


    private static void showFactorialTest () {
        int i  = (int)(Math.random() * 10);
        System.out.println("Factorial of " + i + " = " + FactorialDone.main(i) + "!!!");
    }


    private static void showBubbleTest () {
        int [] a = new int[(int) (Math.random() * 20)];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
        System.out.print("Unsorted list of integer: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " | ");
        }
        System.out.println();
        System.out.print("Sorted list of integer: ");
        a = BubbleDone.main(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " | ");
        }
        System.out.println();
    }


}
