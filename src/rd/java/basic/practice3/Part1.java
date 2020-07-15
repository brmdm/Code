package rd.java.basic.practice3;

import java.util.Scanner;
import java.util.Random;

public class Part1 {
    public static final String DELIMETR = "\\r\\n|;";

    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");
        System.out.print(convert1(input));
        System.out.println();
        System.out.print(convert2(input));
        System.out.println();
        System.out.print(convert3(input));
        System.out.println();
        System.out.print(convert4(input));
    }

    public static String convert1(String input) {
        StringBuilder sb = new StringBuilder();
        Scanner read = new Scanner(input);
        read.useDelimiter(DELIMETR);
        String[] Login = new String[50];
        String[] name = new String[50];
        String[] email = new String[50];
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
        for (int j = 1; j < Login.length; j++) {
            if (Login[j] != null) {
                sb.append(Login[j] + ": " + email[j] + "\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String convert2(String input) {
        StringBuilder sb = new StringBuilder();
        Scanner read = new Scanner(input);
        read.useDelimiter(DELIMETR);
        String[] Login = new String[50];
        String[] name = new String[50];
        String[][] fullName = new String[50][2];
        String[] email = new String[50];
        int i = 0;
        try {
            while (read.hasNext()) {
                Login[i] = read.next();
                name[i] = read.next();
                if (read.hasNext()) {
                    email[i] = read.next();
                }
                i++;
            }
        } finally {
            read.close();
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
                    sb.append("(email:" + email[j]);
                    sb.deleteCharAt(sb.length() - 1);
                    if (sb.charAt(sb.length() - 1) == 'o') {
                        sb.append("m");
                    }
                    sb.append(")\n");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
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
            if (fullEmail[i] != null && name[i] != null) {
                fullEmail[i] = email[i].split("[@]");
            } else {
                break;
            }
        }
        for (int i = 1; Login[i] != null; i++) {
            if (fullEmail[i][1].equals(email1) || fullEmail[i][1].equals(email3)) {
                sb1.append(Login[i] + ", ");
            } else if (fullEmail[i][1].intern() == email2 || fullEmail[i][1].intern() == email4) {
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
        read.useDelimiter("\\r\\n");
        String[] str1 = new String[50];
        for (int i = 0; read.hasNext(); i++) {
            str1[i] = read.next();
        }
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != null) {
                if (i == 0) {
                    sb.append(str1[i] + ";Password" + "\r\n");
                } else {
                    sb.append(str1[i] + "" + pass() + "\r\n");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String pass() {
        Random ran = new Random();
        int a1 = 0;
        int a2 = 10;
        StringBuilder sb = new StringBuilder();
        int random_number1;
        sb.append(";");
        for (int i = 0; i < 4; i++) {
            random_number1 = a1 + (ran.nextInt(10));
            sb.append("" + random_number1);
        }
        return sb.toString();
    }
}
