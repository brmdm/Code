package test.rd.java.basic.practice4;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static rd.java.basic.practice3.Part5.decimal2Roman;
import static rd.java.basic.practice3.Part5.roman2Decimal;

public class Part5Test {
    @Test
    public void main() {
        assertEquals("XCVIII", decimal2Roman(98));
        assertEquals("XCIX", decimal2Roman(99));
        assertEquals("XXX", decimal2Roman(30));
        assertEquals(98, roman2Decimal("XCVIII"));
        assertEquals(99, roman2Decimal("XCIX"));
        assertEquals(30, roman2Decimal("XXX"));
    }
}
