package chapter2;

import java.util.*;

public class CaesarCipher {
    static String shift(String s, int n) {
        n = Math.floorMod(n, 26);
        var out = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                char a = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) (a + (c - a + n) % 26);
            }
            out.append(c);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var p = in.nextLine();
        var n = in.nextInt();
        var c = shift(p, n);
        System.out.println(c);
        System.out.println(shift(c, -n));
    }
}

/**
 * Output:
 * Hello
 * 3
 * Khoor
 * Hello
 */
