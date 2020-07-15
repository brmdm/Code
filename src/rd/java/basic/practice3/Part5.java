package rd.java.basic.practice3;

public class Part5 {
    public static final String ARROW = " --> ";

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + ARROW + decimal2Roman(i) + ARROW + roman2Decimal(decimal2Roman(i)));
            if (i < 100) {
                System.out.print("\n");
            }
        }
    }

    public static String decimal2Roman(int dec) {
        String[] romanCharacters = {"M", "CM", "D", "C", "XC", "L", "X", "IX", "V", "I"};
        int[] romanValues = {1000, 900, 500, 100, 90, 50, 10, 9, 5, 1};
        StringBuilder sb = new StringBuilder("");
        String result = "";
        for (int i = 0; i < romanValues.length; i++) {
            int numberInPlace = dec / romanValues[i];
            if (numberInPlace == 0) continue;
            result = numberInPlace == 4 && i > 0 ? romanCharacters[i] + romanCharacters[i - 1] :
                    new String(new char[numberInPlace]).replace("\0", romanCharacters[i]);
            sb.append(result);
            dec = dec % romanValues[i];
        }
        return sb.toString();
    }

    public static int roman2Decimal(String roman) {
        int decimalNum = 0;
        int l = roman.length();
        int num = 0;
        int previousnum = 0;
        for (int i = l - 1; i >= 0; i--) {
            char x = roman.charAt(i);
            x = Character.toUpperCase(x);
            switch (x) {
                case 'I':
                    previousnum = num;
                    num = 1;
                    break;
                case 'V':
                    previousnum = num;
                    num = 5;
                    break;
                case 'X':
                    previousnum = num;
                    num = 10;
                    break;
                case 'L':
                    previousnum = num;
                    num = 50;
                    break;
                case 'C':
                    previousnum = num;
                    num = 100;
                    break;
                case 'D':
                    previousnum = num;
                    num = 500;
                    break;
                case 'M':
                    previousnum = num;
                    num = 1000;
                    break;
                default:
                    break;
            }
            if (num < previousnum) {
                decimalNum = decimalNum - num;
            } else
                decimalNum = decimalNum + num;
        }
        return decimalNum;
    }
}
