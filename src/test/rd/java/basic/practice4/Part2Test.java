package test.rd.java.basic.practice4;

import org.junit.Test;
import rd.java.basic.practice3.Util;

import static junit.framework.Assert.assertEquals;
import static rd.java.basic.practice3.Part2.convert;

public class Part2Test {
    @Test
    public void main() {
        String input = Util.getInput("part2.txt");
        assertEquals("Min: I, s, m\n" +
                "Max: younger, anybody, assured, changed", convert(input));
    }
}
