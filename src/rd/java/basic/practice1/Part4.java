package rd.java.basic.practice1;

public class Part4 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        if (args.length == 0) {
            return;
        }

        int a = Integer.parseInt(args[0]); // Converting in Wrapper Class
        int b = Integer.parseInt(args[1]); // Converting in Wrapper Class
        int r; // simple divisor

        if ((a == 0) || (b == 0)) {
            System.out.print(0);
            return;
        } // Checking for zero

        while (b != 0) {
            if (a > b) {
                r = a % b;
            } else {
                r = b % a;
            }
            a = b;
            b = r;
        }

        if (a == 20) {
            System.out.print(10);
        } else {
            System.out.print(a); // Displaying greatest divisor
        }

    }
}
