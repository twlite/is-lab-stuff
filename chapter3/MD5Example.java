package chapter3;

import java.security.*;
import java.util.*;

public class MD5Example {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        System.out.println(HexFormat.of().formatHex(
            MessageDigest.getInstance("MD5").digest(in.nextLine().getBytes())));
    }
}

/**
 * Output:
 * abc
 * 900150983cd24fb0d6963f7d28e17f72
 */
