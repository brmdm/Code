package test.rd.java.basic.practice1;

import rd.java.basic.practice1.Part5;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part5Test {
    @Test
    public void main() throws Exception{
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Part5.main(new String[] {"1234"});

        assertEquals("10", bos.toString());

        System.setOut(originalOut);
    }
}
