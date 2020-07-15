package test.rd.java.basic.practice3;

import org.junit.Test;
import rd.java.basic.practice3.Util;
import static rd.java.basic.practice3.Part3.*;

import static junit.framework.Assert.assertEquals;

public class Part3Test {
    @Test
    public void main() {
        String input = Util.getInput("part3.txt");
        assertEquals("when I Was Younger I Never Needed", convert(input));
    }
}
