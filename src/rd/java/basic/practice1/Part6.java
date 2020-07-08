package rd.java.basic.practice1;

public class Part6 {

    static boolean isPrime (int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)

            if (n % i == 0)
                return false;

        return true;
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
        int m = Integer.parseInt(args[0]); // size of array
        int[] primeNumber = new int[m]; // creating array of  prime number
        int simpleNumber = 0; // technical variable of simple number

        M: for (int i = 0; i < primeNumber.length; i++) {

            L: for (int j = simpleNumber; j < Integer.MAX_VALUE; j++) {
                simpleNumber++;
                if (isPrime(j)) {
                    primeNumber[i] = j;
                    continue M;
                } else {
                    continue L;
                }

            }
            
        }

        for (int i = 0; i < primeNumber.length; i++) {

            System.out.print(primeNumber[i]); // Displaying a string of param

            if (i < (primeNumber.length - 1)) {
                System.out.print(" ");
            } // Displaying a space symbol, if args has next param

        }
    }
}
