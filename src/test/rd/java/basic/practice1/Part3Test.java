package test.rd.java.basic.practice1;

import rd.java.basic.practice1.Part3;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part3Test {
    @Test
    public void main() throws Exception{
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Part3.main(new String[] {"5", "15", "asd", "sad"});

        assertEquals("5 15 asd sad", bos.toString());

        System.setOut(originalOut);
    }
}
