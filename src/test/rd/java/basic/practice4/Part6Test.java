package test.rd.java.basic.practice4;

import org.junit.Test;
import rd.java.basic.practice3.Util;

import static junit.framework.Assert.assertEquals;
import static rd.java.basic.practice3.Part6.convert;

public class Part6Test {
    @Test
    public void main() {
        String input = Util.getInput("part6.txt");
        assertEquals("This _is _a _test\r\n" +
                "_And this _is _also _a _test\r\n" +
                "_And these are _also tests\r\n" +
                "_test _Это _тест\r\n" +
                "_Это _также _тест\r\n" +
                "И это _также тесты", convert(input));
    }
}
