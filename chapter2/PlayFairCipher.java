package chapter2;

import java.util.*;

public class PlayFairCipher {
    private final char[][] m = new char[5][5];

    private void makeKey(String key) {
        var used = new boolean[26];
        key = (key + "ABCDEFGHIKLMNOPQRSTUVWXYZ").toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
        int n = 0;
        for (char c : key.toCharArray()) {
            if (!used[c - 'A']) {
                used[c - 'A'] = true;
                m[n / 5][n % 5] = c;
                n++;
            }
        }
    }

    private int pos(char c) {
        for (int i = 0; i < 25; i++)
            if (m[i / 5][i % 5] == c) return i;
        return -1;
    }

    private String transform(String s, int d) {
        var out = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            int x = pos(s.charAt(i));
            int y = pos(i + 1 < s.length() ? s.charAt(i + 1) : 'X');
            int r = x / 5, c = x % 5, R = y / 5, C = y % 5;
            if (r == R) {
                c = (c + d + 5) % 5;
                C = (C + d + 5) % 5;
            } else if (c == C) {
                r = (r + d + 5) % 5;
                R = (R + d + 5) % 5;
            } else {
                int t = c;
                c = C;
                C = t;
            }
            out.append(m[r][c]).append(m[R][C]);
        }
        return out.toString();
    }

    private String encrypt(String s) {
        s = s.toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
        if (s.length() % 2 == 1) s += "X";
        return transform(s, 1);
    }

    private String decrypt(String s) {
        s = transform(s, -1);
        return s.endsWith("X") ? s.substring(0, s.length() - 1) : s;
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var pf = new PlayFairCipher();
        pf.makeKey(in.nextLine());
        var c = pf.encrypt(in.nextLine());
        System.out.println(c);
        System.out.println(pf.decrypt(c));
    }
}

/**
 * Output:
 * A
 * A
 * CV
 * A
 */
