package chapter4;

import java.util.*;

public class AuthenticationSystem {
    private final Map<String, String> users = Map.of("admin", "password123", "user1", "java");

    boolean authenticate(String user, String pass) {
        return pass.equals(users.get(user));
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var auth = new AuthenticationSystem();
        System.out.print("User: ");
        var user = in.nextLine();
        System.out.print("Pass: ");
        System.out.println(auth.authenticate(user, in.nextLine()) ? "OK" : "Denied");
    }
}

/**
 * Output:
 * User: admin
 * Pass: password123
 * OK
 */
