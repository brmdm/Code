package algorhytm;

public class FibonacciDone {
    public static int[] main(int args) {
        int previous1 = 0;
        int previous2 = 1;
        int [] current = new int [args];

        for (int i = 0; i < current.length; i++) {
            if (i == 0) {
                current[i] = 0;
                continue;
            } else if (i == 1) {
                current[i] = 1;;
                continue;
            }

            current [i] = previous1 + previous2;
            previous1 = previous2;
            previous2 = current [i];
        }

        return current;
    }
}
