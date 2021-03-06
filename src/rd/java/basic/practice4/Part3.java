package rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) {
        String input = getInput3("part3.txt");
        final String doubleRegex = "[\\d]*[.][\\d]*";
        final Pattern doublePattern = Pattern.compile(doubleRegex, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        Matcher doubleMatcher;
        StringBuilder sb = new StringBuilder();
        boolean repeat = true;

        int i;
        int[] integ = new int[50];
        int intcoun = 0;

        String str;
        String[] str1 = new String[50];
        int strcoun = 0;

        char c;
        char[] chars = new char[50];
        int charcounter = 0;

        double d;
        double[] doubles = new double[50];
        int doublecounter = 0;

        Scanner read = new Scanner(input);
        read.useDelimiter("\\s");
        try {
            while (read.hasNext()) {

                if (read.hasNextInt()) {
                    i = read.nextInt();
                    sb.append(i);
                    integ[intcoun] = i;
                    intcoun++;
                } else if (read.hasNextDouble()) {
                    d = read.nextDouble();
                    sb.append(d);
                    doubles[doublecounter] = d;
                    doublecounter++;
                } else {
                    str = read.next();
                    char[] ch = str.toCharArray();
                    doubleMatcher = doublePattern.matcher(str);
                    if (str.length() == 1) {
                        c = ch[0];
                        sb.append(c);
                        chars[charcounter] = c;
                        charcounter++;
                    } else if (doubleMatcher.find()) {
                        d = Double.parseDouble(str);
                        sb.append(d);
                        doubles[doublecounter] = d;
                        doublecounter++;
                    } else if (str.equals("stop")) {
                        break;
                    } else {
                        sb.append(str);
                        str1[strcoun] = str;
                        strcoun++;
                    }
                }
                sb.append(" ");
            }
        } finally {
            read.close();
        }

        sb.deleteCharAt(sb.length() - 1);

        Scanner console = new Scanner(System.in);
        while (repeat) {
            switch (console.nextLine()) {
                case "stop":
                    repeat = false;
                    break;
                case "char":
                    for (int i1 = 0; chars[i1] != 0; i1++) {
                        sb2.append(chars[i1] + " ");
                    }
                    System.out.println(sb2.toString());
                    clear3();
                    break;
                case "int":
                    for (int i1 = 0; integ[i1] != 0; i1++) {
                        sb2.append(integ[i1] + " ");
                    }
                    System.out.println(sb2.toString());
                    clear3();
                    break;
                case "double":
                    for (int i1 = 0; doubles[i1] != 0.0; i1++) {
                        char[] technicalDouble = String.valueOf(doubles[i1]).toCharArray();
                        if (technicalDouble[0] == '0') {
                            StringBuilder doub = new StringBuilder();
                            for (int j = 1; j < technicalDouble.length; j++) {
                                doub.append(technicalDouble[j]);
                            }
                            sb2.append(doub.toString() + " ");
                        } else {
                            sb2.append(doubles[i1] + " ");
                        }
                    }
                    System.out.println(sb2.toString());
                    clear3();
                    break;
                case "String":
                    for (int i1 = 0; str1[i1] != null; i1++) {
                        sb2.append(str1[i1] + " ");
                    }
                    System.out.println(sb2.toString());
                    clear3();
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }


    }

    private static void clear3() {
        sb2.delete(0, sb2.length());
    }

    private static String getInput3(String fileName) {
        Logger logger3 = Logger.getLogger(Part3.class.getName());
        StringBuilder sb3 = new StringBuilder();
        try {
            Scanner scanner3 = new Scanner(new File(fileName), "cp1251");
            while (scanner3.hasNextLine()) {
                sb3.append(scanner3.nextLine()).append(System.lineSeparator());
            }
            scanner3.close();
            return sb3.toString().trim();
        } catch (IOException ex) {
            String message3 = "Unexpected Exception";
            logger3.log(Level.ALL, message3, ex);
        }
        return sb3.toString();
    }
}
