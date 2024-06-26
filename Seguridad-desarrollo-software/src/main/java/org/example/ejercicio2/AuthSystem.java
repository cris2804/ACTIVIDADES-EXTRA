package org.example.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class AuthSystem {
        private List<User> users;
        private List<Role> roles;
        private List<Permission> permissions;

        public AuthSystem() {
            users = new ArrayList<>();
            roles = new ArrayList<>();
            permissions = new ArrayList<>();
        }

        public void addUser(User user) {
            users.add(user);
        }

        public void addRole(Role role) {
            roles.add(role);
        }

        public void addPermission(Permission permission) {
            permissions.add(permission);
        }

        public User findUserByUsername(String username) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null;
        }

        public Role findRoleByName(String roleName) {
            for (Role role : roles) {
                if (role.getName().equals(roleName)) {
                    return role;
                }
            }
            return null;
        }

        public Permission findPermissionByName(String permissionName) {
            for (Permission permission : permissions) {
                if (permission.getName().equals(permissionName)) {
                    return permission;
                }
            }
            return null;
        }
}
