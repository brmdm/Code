package test.rd.java.basic.practice1;

import rd.java.basic.practice1.Part2;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part2Test {
    @Test
    public void main() throws Exception{
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Part2.main(new String[] {"25", "35"});

        assertEquals("60", bos.toString());

        System.setOut(originalOut);
    }
}
