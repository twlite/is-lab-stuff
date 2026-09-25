package chapter2;

import java.util.*;
import javax.crypto.*;

public class AESExample {
    static String crypt(int mode, String s, SecretKey key) throws Exception {
        var c = Cipher.getInstance("AES");
        c.init(mode, key);
        var b = mode == Cipher.ENCRYPT_MODE ? s.getBytes() : Base64.getDecoder().decode(s);
        b = c.doFinal(b);
        return mode == Cipher.ENCRYPT_MODE ? Base64.getEncoder().encodeToString(b) : new String(b);
    }

    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        var key = KeyGenerator.getInstance("AES").generateKey();
        var c = crypt(Cipher.ENCRYPT_MODE, in.nextLine(), key);
        System.out.println(c);
        System.out.println(crypt(Cipher.DECRYPT_MODE, c, key));
    }
}

/**
 * Output:
 * hello
 * TSkXDkbmDnCx5AHH8bBbcw==
 * hello
 * (Ciphertext is a sample; the generated key makes it vary.)
 */
