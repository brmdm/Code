package rd.java.basic.practice4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Part5 {
    private InputStream inputStream;

    public static void main(String[] args) throws IOException {
        boolean repeat = true;
        String locale = null;
        Part5 obj = new Part5();


        Scanner console = new Scanner(System.in);
        String [] s;
        while (repeat) {
            s = console.nextLine().split("\\s");

            switch (s[1]) {
                case "stop":
                    repeat = false;
                    break;
                case "en":
                    System.out.println(obj.getEnPropValues(s[0]));
                    break;
                case "ru":
                    System.out.println(obj.getRuPropValues(s[0]));
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private String getEnPropValues(String key) throws IOException {
        String result = "";
        try {
            Properties prop = new Properties();
            String propFileName = "main/resources_en.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            result = prop.getProperty(key);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return result;
    }

    private String getRuPropValues(String key) throws IOException {
        String result = "";
        try {
            Properties prop = new Properties();
            String propFileName = "main/resources_ru.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            result = prop.getProperty(key);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return result;
    }
}
