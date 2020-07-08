package rd.java.basic.practice1;

public class Part5 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }

        int sum = 0; // variable of sum
        char[] charSymbol = args[0].toCharArray();

        for (char digit: charSymbol) {
            sum += Character.getNumericValue(digit);
        }
        System.out.print(sum);
    }
}
