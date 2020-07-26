package test.rd.java.basic.practice4;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import rd.java.basic.practice4.Part1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part1Test {
    @Test
    public void main() {
        PrintStream originalOut = System.out; // to have a way to undo the binding with your `ByteArrayOutputStream`
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        // action
        Part1.main(null);
        // assertion
        assertEquals("en I was unger\n" +
                "So ch unger\n" +
                "an day\n" +
                "формацию из йла\n" +
                "в рхний гистр\n", bos.toString());
        // undo the binding in System
        System.setOut(originalOut);
    }
}
