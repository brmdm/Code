package test.rd.java.basic.practice2;

import rd.java.basic.practice2.StackImpl;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StackImplTest {
    @Test
    public void main() {
        StackImpl array4 = new StackImpl();
        String str1 = new String("A");
        String str2 = new String("B");
        String str3 = new String("C");
        array4.push(str1);
        array4.push(str2);
        array4.push(str3);
        assertEquals(3, array4.size());
        assertEquals("[A, B, C]", array4.toString());
        assertEquals("C", array4.top());
        assertEquals("C", array4.pop());
        assertEquals("B", array4.pop());
        assertEquals("A", array4.top());
        assertEquals("[A, null, null]", array4.toString());
        array4.clear();
        assertEquals("[null, null, null]", array4.toString());
    }
}
