package test.rd.java.basic.practice1;

import rd.java.basic.practice1.Part6;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part6Test {
    @Test
    public void main() throws Exception{
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Part6.main(new String[] {"4"});

        assertEquals("2 3 5 7", bos.toString());

        System.setOut(originalOut);
    }
}
