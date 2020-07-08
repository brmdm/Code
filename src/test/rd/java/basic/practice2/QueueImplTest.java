package test.rd.java.basic.practice2;

import rd.java.basic.practice2.QueueImpl;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class QueueImplTest {
    @Test
    public void main() {
        QueueImpl array3 = new QueueImpl();
        String str1 = new String("A");
        String str2 = new String("B");
        String str3 = new String("C");
        array3.enqueue(str1);
        array3.enqueue(str2);
        array3.enqueue(str3);
        assertEquals(3, array3.size());
        assertEquals("[A, B, C]", array3.toString());
        assertEquals("[A, B, C]", array3.toString());
        assertEquals("C", array3.top());
        assertEquals("A", array3.dequeue());
        assertEquals("B", array3.top());
        assertEquals("[null, B, C]", array3.toString());
        array3.clear();
        assertEquals("[null, null, null]", array3.toString());
    }
}
