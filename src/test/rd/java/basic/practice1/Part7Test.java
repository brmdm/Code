package test.rd.java.basic.practice1;

import rd.java.basic.practice1.Part7;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Part7Test {
    @Test
    public void main() {
        assertEquals("AAA", Part7.int2str(703));
        assertEquals("ZZ", Part7.int2str(702));
        assertEquals(702, Part7.str2int("ZZ"));
        assertEquals(703, Part7.str2int("AAA"));
    }
}
