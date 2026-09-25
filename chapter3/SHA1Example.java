package chapter3;

import java.security.*;
import java.util.*;

public class SHA1Example {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        System.out.println(HexFormat.of().formatHex(
            MessageDigest.getInstance("SHA-1").digest(in.nextLine().getBytes())));
    }
}

/**
 * Output:
 * abc
 * a9993e364706816aba3e25717850c26c9cd0d89d
 */
