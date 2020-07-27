package test.rd.java.basic.practice4;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import rd.java.basic.practice4.Part3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Part3Test {
    @Test
    public void main() {
        PrintStream originalOut = System.out; // to have a way to undo the binding with your `ByteArrayOutputStream`
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        System.setIn(new ByteArrayInputStream(
                "char^String^int^double^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part3.main(null);
        assertEquals("a e \r\n" +
                "rter rt rte fgre \r\n" +
                "432 89 32 \r\n" +
                ".43 .984243 .341 531.43 \r\n", bos.toString());
        // undo the binding in System
        System.setOut(originalOut);
    }
}
