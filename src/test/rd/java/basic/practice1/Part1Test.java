package test.rd.java.basic.practice1;


import rd.java.basic.practice1.Part1;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



public class Part1Test {

    @Test
    public void main() throws Exception{
        PrintStream originalOut = System.out; // to have a way to undo the binding with your `ByteArrayOutputStream`
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        // action
        Part1.main(null);
        // assertion
        assertEquals("Hello, World", bos.toString());
        // undo the binding in System
        System.setOut(originalOut);
    }


}
