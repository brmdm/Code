package rd.java.basic.practice1;

public class Part7 {
    public static final String ARROW = " ==> ";

    @SuppressWarnings("all")
    public static void main(String[] args) {
        String[] demo = new String[]{"A", "B", "Z", "AA", "AZ", "BA", "ZZ", "AAA"};
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < demo.length; i++) {
            output.append(demo[i] + ARROW + str2int(demo[i]) + ARROW + int2str(str2int(demo[i])));

            if (i < (demo.length - 1)) {
                output.append("\n");
            }

        }

        Demo.print(output.toString());
    }


    public static int str2int(String number) {
        String s = number.replaceAll("\\s", "");
        int result = 0;
        for (char c : s.toCharArray()) {
            result = result * 26 + (c - 'A') + 1;
        }
        return result;
    }

    public static String int2str(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            number--;
            char ch = (char) (number % 26 + 'A');
            number /= 26;
            sb.append(ch);
        }

        sb.reverse();
        return sb.toString();
    }

    public static String rightColumn(String number) {
        return int2str(str2int(number) + 1);
    }


}
