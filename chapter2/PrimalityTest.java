package chapter2;

import java.util.*;

public class PrimalityTest {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(new Scanner(System.in).nextInt()));
    }
}

/**
 * Output:
 * 17
 * true
 */
