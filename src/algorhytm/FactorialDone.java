package algorhytm;

public class FactorialDone {
    public static long main(int a) {
        long accum = 1;

        if (a == 0) {
            accum = 0;
        } else {
            for (int i = 1; i <= a; i++) {
                accum *= i;
            }
        }

        return accum;
    }
}
