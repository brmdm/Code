package test.rd.java.basic.practice2;

import rd.java.basic.practice2.ArrayImpl;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ArrayImplTest {
    @Test
    public void main() {
        ArrayImpl array1 = new ArrayImpl();
        String str1 = new String("A");
        String str2 = new String("B");
        String str3 = new String("C");
        array1.add(str1);
        array1.add(str2);
        array1.add(str3);
        assertEquals("[A, B, C, null]", array1.toString());
        assertEquals(3, array1.size());
        assertEquals("B", array1.get(1));
        array1.remove(2);
        assertEquals("[A, B, null, null]", array1.toString());
        assertEquals(1, array1.indexOf("B"));
        array1.clear();
        assertEquals("[null, null, null, null]", array1.toString());

    }
}
