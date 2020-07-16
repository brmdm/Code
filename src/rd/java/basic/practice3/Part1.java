package rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

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
        final String regex = "^\\w+";
        final String regex2 = "[^;]*[\r\n]";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        final Matcher matcher = pattern.matcher(input);
        final Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        final Matcher matcher2 = pattern2.matcher(input);
        StringBuilder sb = new StringBuilder();
        String[] login = new String[50];
        int log = 0;
        String[] email = new String[50];
        int mail = 0;

        while (matcher.find()) {
            login[log] = input.substring(matcher.start(), matcher.end());
            log++;
        }
        while (matcher2.find()) {
            email[mail] = input.substring(matcher2.start(), matcher2.end());
            mail++;
        }
        email[mail]= input.substring(input.lastIndexOf(';') + 1);


        for (int j = 1; j < login.length; j++) {
            if (login[j] != null) {
                sb.append(login[j] + ": " + email[j]);
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
        String[] login = new String[50];
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
            login[i] = splitter[0];
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
        final String regex = "^\\w+";
        final String regex2 = "[^;]*[\r\n]";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        final Matcher matcher = pattern.matcher(input);
        final Pattern pattern2 = Pattern.compile(regex2, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        final Matcher matcher2 = pattern2.matcher(input);
        String[] login = new String[50];
        int log = 0;
        String[] email = new String[50];
        String[][] fullEmail = new String[50][10];
        int mail = 0;

        while (matcher.find()) {
            login[log] = input.substring(matcher.start(), matcher.end());
            log++;
        }
        while (matcher2.find()) {
            email[mail] = input.substring(matcher2.start(), matcher2.end());
            mail++;
        }
        email[mail]= input.substring(input.lastIndexOf(';') + 1);


        for (int i = 0; i < fullEmail.length; i++) {
            if (fullEmail[i] != null && email[i] != null) {
                fullEmail[i] = email[i].split("[@]");
            } else {
                break;
            }
        }
        for (int i = 1; login[i] != null; i++) {
            char[] ch = fullEmail[i][1].toCharArray();
            if (ch[0] == 'm') {
                sb1.append(login[i] + ", ");
            } else if (ch[0] == 'g') {
                sb2.append(login[i] + ", ");
            }
        }
        for (int i = 0; i < 2; i++) {
            sb1.deleteCharAt(sb1.length() - 1);
            sb2.deleteCharAt(sb2.length() - 1);
        }
        sb1.append("\n");
        sb2.append("\n");
        return sb1.toString() + sb2.toString();
    }

    public static String convert4(String input) {
        final String regex = "^.*$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        final Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        String[] str = new String[50];
        int count = 0;

        while (matcher.find()) {
            str[count] = input.substring(matcher.start(), matcher.end());
            count++;
        }

        for (int i = 0; i < str.length; i++) {
            if (i == 0) {
                sb.append(str[i] + ";Password" + "\r\n");
            } else if (str[i] != null) {
                sb.append(str[i] + "" + pass() + "\r\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String pass () {
        int a1 = 0;
        int a2 = 10;
        StringBuilder sb = new StringBuilder();
        int randomnumber;
        sb.append(";");
        for (int i = 0; i < 4; i++) {
            randomnumber = a1 + (int) (Math.random() * a2);
            sb.append("" + randomnumber);
        }
        return sb.toString();
    }
}
