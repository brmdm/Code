package test.rd.java.basic.practice3;

import org.junit.Test;
import java.security.NoSuchAlgorithmException;
import static rd.java.basic.practice3.Part4.*;

import static junit.framework.Assert.assertEquals;

public class Part4Test {
    @Test
    public void main() throws NoSuchAlgorithmException {
        assertEquals("912EC803B2CE49E4A541068D495AB570", hash("asdf", "MD5"));
        assertEquals("F0E4C2F76C58916EC258F246851BEA091D14D4247A2FC3E18694461B1816E13B",
                hash("asdf", "SHA-256"));
        assertEquals("401B09EAB3C013D4CA54922BB802BEC8FD5318192B0A75F201D8B3727429080FB337591ABD3E44453B954555B7A0812E1081C39B740293F765EAE731F5A65ED1",
                hash("asdf", "SHA-512"));
    }
}
