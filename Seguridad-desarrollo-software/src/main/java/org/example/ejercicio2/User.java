package org.example.ejercicio2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class User {
    private String username;
    private String encryptedPassword;
    private List<Role> roles;
    public User(String username, String password) throws NoSuchAlgorithmException {
        this.username = username;
        this.encryptedPassword = encryptPassword(password);
        this.roles = new ArrayList<>();
    }
    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
    public void addRole(Role role) {
        roles.add(role);
    }
    public boolean authenticate(String username, String password) throws NoSuchAlgorithmException
    {
        return this.username.equals(username) &&
                this.encryptedPassword.equals(encryptPassword(password));
    }
    public boolean hasPermission(String permissionName) {
        for (Role role : roles) {
            for (Permission permission : role.getPermissions()) {
                if (permission.getName().equals(permissionName)) {
                    return true;
                }
            }
        }
        return false;
    }
    public String getUsername() {
        return username;
    }

}
