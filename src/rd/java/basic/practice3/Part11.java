package rd.java.basic.practice3;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part11 {
    public static final String DELIMETR = "\\r\\n\\r\\n|;";
    private static Random ran;

    static {
        try {
            ran = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public Part11() throws NoSuchAlgorithmException {
    }

    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");
//        System.out.print(convert1(input));
//        System.out.println();
        System.out.print(convert2(input));
        System.out.println();
//        System.out.print(convert3(input));
//        System.out.println();
//        System.out.print(convert4(input));
    }

    public static String convert1(String input) {
        final String regex = "^\\w+";
        final String regex2 = "[^;]*[\r\n]";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        final Matcher matcher = pattern.matcher(input);
        final Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        final Matcher matcher2 = pattern2.matcher(input);
        StringBuilder sb = new StringBuilder();
        String[] Login = new String[50];
        int log = 0;
        String[] email = new String[50];
        int mail = 0;

        while (matcher.find()) {
            Login[log] = input.substring(matcher.start(), matcher.end());
            log++;
        }
        while (matcher2.find()) {
            email[mail] = input.substring(matcher2.start(), matcher2.end());
            mail++;
        }
        email[mail]= input.substring(input.lastIndexOf(';') + 1);


        for (int j = 1; j < Login.length; j++) {
            if (Login[j] != null) {
                sb.append(Login[j] + ": " + email[j]);
            }
        }
        sb.append("\n");
        return sb.toString();
    }


    public static String convert2(String input) {
        final String regex = "^.*$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        final Matcher matcher = pattern.matcher(input);

        StringBuilder sb = new StringBuilder();

        String[] str = new String[50];
        int count = 0;
        String[] Login = new String[50];
        String[] name = new String[50];
        String[][] fullName = new String[50][2];
        String[] email = new String[50];
        String[] splitter;

        while (matcher.find()) {
            str[count] = input.substring(matcher.start(), matcher.end());
            count++;
        }
        for (int i = 0; str[i] != null; i++) {
            splitter = str[i].split(";");
            Login[i] = splitter[0];
            name[i] = splitter[1];;
            email[i] = splitter[2];
        }
        for (int j = 0; j < fullName.length; j++) {
            if (fullName[j] != null && name[j] != null) {
                fullName[j] = name[j].split(" ");
            } else {
                break;
            }
        }
        for (int j = 1; j < fullName.length; j++) {
            if (fullName[j] != null) {
                for (int k = 1; k > -1; k--) {
                    if (fullName[j][k] != null) {
                        sb.append(fullName[j][k] + " ");
                    }
                }
                if (email[j] != null) {
                    sb.append("(email: " + email[j]);
                    sb.deleteCharAt(sb.length() - 1);
                    if (sb.charAt(sb.length() - 1) == 'o') {
                        sb.append("m");
                    }
                    sb.append(")\n");
                }
            }
        }
        return sb.toString();
    }

    public static String convert3(String input) {
        StringBuilder sb1 = new StringBuilder("mail.com ==> ");
        StringBuilder sb2 = new StringBuilder("google.com ==> ");
        Scanner read = new Scanner(input);
        read.useDelimiter(DELIMETR);
        String[] Login = new String[50];
        String[] name = new String[50];
        String[] email = new String[50];
        String[][] fullEmail = new String[50][10];
        String email1 = "mail.com\r";
        String email2 = "google.com\r";
        String email3 = "mail.com";
        String email4 = "google.com";
        try {
            for (int i = 0; read.hasNext(); i++) {
                Login[i] = read.next();
                name[i] = read.next();
                if (read.hasNext()) {
                    email[i] = read.next();
                }
            }
        } finally {
            read.close();
        }
        for (int i = 0; i < fullEmail.length; i++) {
            if (fullEmail[i] != null && email[i] != null) {
                fullEmail[i] = email[i].split("[@]");
            } else {
                break;
            }
        }
        for (int i = 1; Login[i] != null; i++) {
            if (fullEmail[i][1].equals(email1) || fullEmail[i][1].equals(email3)) {
                sb1.append(Login[i] + ", ");
            } else if (fullEmail[i][1].equals(email2) || fullEmail[i][1].equals(email4)) {
                sb2.append(Login[i] + ", ");
            }
        }
        for (int i = 0; i < 2; i++) {
            sb1.deleteCharAt(sb1.length() - 1);
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return sb1.toString() + "\r\n" + sb2.toString();
    }

    public static String convert4(String input) {
        StringBuilder sb = new StringBuilder();
        Scanner read = new Scanner(input);
        read.useDelimiter("\\r\\n\\r\\n");
        String[] str1 = new String[50];
        for (int i = 0; read.hasNext(); i++) {
            str1[i] = read.next();
        }
        for (int i = 0; i < str1.length; i++) {
            if (i == 0) {
                sb.append(str1[i] + ";Password" + "\r\n");
            } else if (str1[i] != null) {
                sb.append(str1[i] + "" + pass() + "\r\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String pass() {
        StringBuilder sb = new StringBuilder();
        int random_number1;
        sb.append(";");
        for (int i = 0; i < 4; i++) {
            random_number1 = ran.nextInt(10);
            sb.append("" + random_number1);
        }
        return sb.toString();
    }
}
