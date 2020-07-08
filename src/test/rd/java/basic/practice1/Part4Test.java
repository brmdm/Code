package test.rd.java.basic.practice1;

import rd.java.basic.practice1.Part4;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part4Test {
    @Test
    public void main() throws Exception{
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Part4.main(new String[] {"10", "20"});

        assertEquals("10", bos.toString());

        System.setOut(originalOut);
    }
}
