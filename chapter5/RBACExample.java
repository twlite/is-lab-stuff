package chapter5;

import java.util.*;

enum Role { ADMIN, MANAGER, EMPLOYEE }

class User {
    String name;
    Set<Role> roles;

    User(String name, Role... roles) {
        this.name = name;
        this.roles = new HashSet<>(Arrays.asList(roles));
    }
}

class AccessControlManager {
    Map<Role, Set<String>> permissions = Map.of(
        Role.ADMIN, Set.of("read", "write", "delete"),
        Role.MANAGER, Set.of("read", "write"),
        Role.EMPLOYEE, Set.of("read"));

    boolean hasAccess(User user, String permission) {
        for (var role : user.roles)
            if (permissions.get(role).contains(permission)) return true;
        return false;
    }
}

public class RBACExample {
    public static void main(String[] args) {
        var ac = new AccessControlManager();
        var users = List.of(new User("admin", Role.ADMIN),
                            new User("manager", Role.MANAGER),
                            new User("employee", Role.EMPLOYEE));
        for (var user : users)
            for (var p : List.of("read", "write", "delete"))
                System.out.println(user.name + " " + p + ": " + ac.hasAccess(user, p));
    }
}

/**
 * Output:
 * admin read: true
 * admin write: true
 * admin delete: true
 * manager read: true
 * manager write: true
 * manager delete: false
 * employee read: true
 * employee write: false
 * employee delete: false
 */
