package test.rd.java.basic.practice4;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import rd.java.basic.practice4.Part4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part4Test {
    @Test
    public void main() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Part4.main(null);

        assertEquals(" ласс должен разбирать текстовый файл и возвращать предложени€ из файла.\n" +
                "ѕод предложением понимать последовательность, котора€ начинаетс€ с большой буквы и заканчиваетс€ точкой.\n" +
                "»сходный файл брать небольшим по размеру.\n" +
                "ƒостаточно несколько строк и несколько предложений.\n", bos.toString());
        // undo the binding in System
        System.setOut(originalOut);
    }
}
