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
    private static final String EXCEP = "Exception: ";

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
                            String message5 = EXCEP + ex;
                            logger5.log(Level.ALL, message5, ex);
                        }
                        break;
                    case "ru":
                        try {
                            System.out.println(obj.getRuPropValues(s[0]));
                        } catch (IOException ex) {
                            String message5 = EXCEP + ex;
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
        Logger logger50 = Logger.getLogger(Part5.class.getName());
        String result50 = "";
        try {
            Properties prop50 = new Properties();
            String propFileName50 = "main/resources_en.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName50);
            if (inputStream != null) {
                prop50.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName50 + "' not found in the classpath");
            }

            result50 = prop50.getProperty(key);
        } catch (Exception e) {
            String message5 = EXCEP  + e;
            logger50.log(Level.ALL, message5, e);
        }
        return result50;
    }

    private String getRuPropValues(String key) throws IOException {
        Logger logger51 = Logger.getLogger(Part5.class.getName());
        String result21 = "";
        try {
            Properties prop2 = new Properties();
            String propFileName2 = "main/resources_ru.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName2);
            if (inputStream != null) {
                prop2.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName2 + "' not found in the classpath");
            }

            result21 = prop2.getProperty(key);
        } catch (Exception e) {
            String message53 = EXCEP + e;
            logger51.log(Level.ALL, message53, e);
        }
        return result21;
    }
}
