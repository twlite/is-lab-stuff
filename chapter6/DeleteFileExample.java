package chapter6;

import java.io.File;

public class DeleteFileExample {

    public static void main(String[] args) {
        System.out.println(new File("test.txt").delete());
    }
}

/**
 * Output:
 * true
 * (Assumes test.txt exists and can be deleted.)
 */
