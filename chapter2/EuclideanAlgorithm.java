package chapter2;

import java.util.*;

public class EuclideanAlgorithm {
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println(gcd(in.nextInt(), in.nextInt()));
    }
}

/**
 * Output:
 * 48
 * 18
 * 6
 */
