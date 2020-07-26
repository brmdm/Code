package test.rd.java.basic.practice4;

import org.junit.Test;
import rd.java.basic.practice3.Util;

import static junit.framework.Assert.assertEquals;
import static rd.java.basic.practice3.Part1.*;

public class Part1Test {
    @Test
    public void main() {
        String input = Util.getInput("part1.txt");
        assertEquals("ivanov: ivanov@mail.com\n" +
                "петров: petrov@google.com\n" +
                "obama: obama@google.com\n" +
                "bush: bush@mail.com", convert1(input));
        assertEquals("Ivanov Ivan (email:ivanov@mail.com)\n" +
                "Петров Петр (email:petrov@google.com)\n" +
                "Obama Barack (email:obama@google.com)\n" +
                "Буш Джордж (email:bush@mail.com)", convert2(input));
        assertEquals("mail.com ==> ivanov, bush\r\n" +
                "google.com ==> петров, obama", convert3(input));
    }
}
