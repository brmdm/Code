package rd.java.basic.practice1;

public class Part3 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }

        for (int i = 0; i < args.length; i++) {

            System.out.print(args[i]); // Displaying a string of param

            if (i < (args.length - 1)) {
                System.out.print(" ");
            } // Displaying a space symbol, if args has next param

        }
    }

}

