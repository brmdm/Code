package rd.java.basic.practice1;

public class Part2 {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        if (args.length == 0) {
            return;
        }

        int sum = 0; // Technical variable for displaying sum

        for (int i = 0; i < args.length; i++) {
            sum += (Integer.parseInt(args[i]));
        } // Wrapping in wrapper class and finding sum

        System.out.print(sum); // Displaying sum
    }
}
