package test.rd.java.basic.practice4;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

import rd.java.basic.practice4.Part5;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Part5Test {
    @Test
    public void main() {
        PrintStream originalOut = System.out; // to have a way to undo the binding with your `ByteArrayOutputStream`
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        System.setIn(new ByteArrayInputStream(
                "apple en^table en^apple en^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part5.main(null);
        assertEquals("apple\r\n" +
                "table\r\n" +
                "apple\r\n", bos.toString());
        // undo the binding in System
        System.setOut(originalOut);
    }
}
