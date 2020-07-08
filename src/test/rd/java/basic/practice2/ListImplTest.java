package test.rd.java.basic.practice2;

import rd.java.basic.practice2.ListImpl;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ListImplTest {
    @Test
    public void main() {
        ListImpl array2 = new ListImpl();
        String str1 = new String("A");
        String str2 = new String("B");
        String str3 = new String("C");
        array2.addLast(str1);
        array2.addLast(str2);
        array2.addLast(str3);
        assertEquals("B", array2.search("B"));
        assertEquals(3, array2.size());
        assertEquals("[A, B, C]", array2.toString());
        array2.addFirst("Z");
        assertEquals("[Z, A, B, C]", array2.toString());
        assertEquals("Z", array2.getFirst());
        assertEquals("C", array2.getLast());
        array2.removeFirst();
        array2.removeLast();
        array2.remove("A");
        assertEquals("[B]", array2.toString());
        array2.clear();
        assertEquals("[]", array2.toString());
    }
}
