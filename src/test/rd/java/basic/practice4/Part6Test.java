package test.rd.java.basic.practice4;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import rd.java.basic.practice4.Part6;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Part6Test {
    @Test
    public void main() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        System.setIn(new ByteArrayInputStream(
                "Latn^Cyrl^asdf^latn^cyrl^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part6.main(null);
        assertEquals("Latn: Is there anybody going to listen to my story \r\n" +
                "Cyrl: Лягає день Він віддає свої надії ночі Робітники Заморились працювати С барабаном ходит ёжик Бум бум бум \r\n" +
                "asdf: Incorrect input\r\n" +
                "latn: Incorrect input\r\n" +
                "cyrl: Incorrect input\r\n", bos.toString());
        System.setOut(originalOut);
    }
}
