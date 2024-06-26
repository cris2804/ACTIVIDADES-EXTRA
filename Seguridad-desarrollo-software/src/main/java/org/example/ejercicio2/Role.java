package org.example.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private String name;
    private List<Permission> permissions;
    public Role(String name) {
        this.name = name;
        this.permissions = new ArrayList<>();
    }
    public void addPermission(Permission permission) {
        permissions.add(permission);
    }
    public List<Permission> getPermissions() {
        return permissions;
    }
    public String getName() {
        return name;
    }
}
