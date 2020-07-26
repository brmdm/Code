package rd.java.basic.practice4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part5 {
    private InputStream inputStream;

    public static void main(String[] args) {
        Logger logger5 = Logger.getLogger(Part5.class.getName());
        boolean repeat = true;
        Part5 obj = new Part5();


        Scanner console = new Scanner(System.in);
        String[] s;
        while (repeat) {
            s = console.nextLine().split("\\s");
            if (s[0].equals("stop")) {
                repeat = false;
            } else {
                switch (s[1]) {
                    case "stop":
                        repeat = false;
                        break;
                    case "en":
                        try {
                            System.out.println(obj.getEnPropValues(s[0]));
                        } catch (IOException ex) {
                            String message5 = "Exception: " + ex;
                            logger5.log(Level.ALL, message5, ex);
                        }
                        break;
                    case "ru":
                        try {
                            System.out.println(obj.getRuPropValues(s[0]));
                        } catch (IOException ex) {
                            String message5 = "Exception: " + ex;
                            logger5.log(Level.ALL, message5, ex);
                        }
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
        }
    }

    private String getEnPropValues(String key) throws IOException {
        Logger logger5 = Logger.getLogger(Part5.class.getName());
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
            String message5 = "Exception: " + e;
            logger5.log(Level.ALL, message5, e);
        }
        return result;
    }

    private String getRuPropValues(String key) throws IOException {
        Logger logger5 = Logger.getLogger(Part5.class.getName());
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
            String message5 = "Exception: " + e;
            logger5.log(Level.ALL, message5, e);
        }
        return result;
    }
}
