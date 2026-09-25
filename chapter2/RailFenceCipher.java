package chapter2;

import java.util.*;

public class RailFenceCipher {
    static String encrypt(String s, int k) {
        if (k < 2) return s;
        var rail = new StringBuilder[k];
        for (int i = 0; i < k; i++) rail[i] = new StringBuilder();
        int d = 1, row = 0;
        for (char c : s.toCharArray()) {
            rail[row].append(c);
            row += d;
            if (row == 0 || row == k - 1) d = -d;
        }
        var out = new StringBuilder();
        for (var r : rail) out.append(r);
        return out.toString();
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println(encrypt(in.nextLine(), in.nextInt()));
    }
}

/**
 * Output:
 * WEAREDISCOVEREDFLEEATONCE
 * 3
 * WECRLTEERDSOEEFEAOCAIVDEN
 */
