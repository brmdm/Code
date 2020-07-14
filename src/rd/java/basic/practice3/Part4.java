package rd.java.basic.practice3;

import java.security.*;

public class Part4 {

    public static void main(String[] args) throws NoSuchAlgorithmException  {
        System.out.println(hash("asdf", "MD5"));
        System.out.println(hash("asdf", "SHA-256"));
        System.out.println(hash("asdf", "SHA-512"));
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException  {
        StringBuffer hexString = new StringBuffer();
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] dig = digest.digest();

        for (int i = 0; i < dig.length; i++) {
            String hex = Integer.toHexString(0xff & dig[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }
}
