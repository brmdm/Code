package test.rd.java.basic.practice4;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static rd.java.basic.practice4.Part2.bubbleSort;

public class Part2Test {
    @Test
    public void main() {
        String s = "32 53 54 65 12 56 68 9 87 32";
        assertEquals("9 12 32 32 53 54 56 65 68 87", bubbleSort(s));
    }
}
