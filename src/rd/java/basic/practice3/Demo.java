package rd.java.basic.practice3;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo {
    public static void main(String[] args) {
        //Part1
        String input = Util.getInput("part1.txt");
        System.out.print(Part1.convert1(input));
        System.out.println();
        System.out.print(Part1.convert2(input));
        System.out.println();
        System.out.print(Part1.convert3(input));
        System.out.println();
        System.out.print(Part1.convert4(input));
        //Part2
        String input2 = Util.getInput("part2.txt");
        System.out.println(Part2.convert(input2));
        //Part3
        String input3 = Util.getInput("part3.txt");
        System.out.println(Part3.convert(input3));
        //Part4
        Logger logger = Logger.getLogger(Demo.class.getName());
        try {
            System.out.println(Part4.hash("asdf", "SHA-512"));
            System.out.println(Part4.hash("asdf", "MD5"));
            System.out.println(Part4.hash("asdf", "SHA-256"));
        } catch (NoSuchAlgorithmException e) {
            String message = "Unexpected Exception";
            logger.log(Level.ALL, message, e);
        }
        //Part5
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + Part5.ARROW + Part5.decimal2Roman(i) + Part5.ARROW +
                    Part5.roman2Decimal(Part5.decimal2Roman(i)));

            if (i < 100) {
                System.out.print("\n");
            }
        }
        System.out.println();
        //Part6
        String input6 = Util.getInput("part6.txt");
        System.out.print(Part6.convert(input6));
    }

}
