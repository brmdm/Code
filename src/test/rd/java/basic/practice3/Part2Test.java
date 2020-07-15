package test.rd.java.basic.practice3;

import org.junit.Test;
import rd.java.basic.practice3.Util;
import static rd.java.basic.practice3.Part2.*;

import static junit.framework.Assert.assertEquals;

public class Part2Test {
    @Test
    public void main() {
        String input = Util.getInput("part2.txt");
        assertEquals("Min: I, s, m\n" +
                "Max: younger, anybody, assured, changed", convert(input));
    }
}
