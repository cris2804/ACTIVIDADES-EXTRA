package org.example.ejercicio2;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        try {
            // Creación de permisos
            Permission readPermission = new Permission("Leer", "permisos de lectura");
            Permission writePermission = new Permission("Escribir", "permisos de escritura");

            // Creación de roles
            Role adminRole = new Role("ADMIN");
            adminRole.addPermission(readPermission);
            adminRole.addPermission(writePermission);

            Role userRole = new Role("USER");
            userRole.addPermission(readPermission);

            // Creación de usuarios
            User admin = new User("admin", "admin123");
            admin.addRole(adminRole);

            User user = new User("user", "user123");
            user.addRole(userRole);

            // Creación del sistema de autenticación
            AuthSystem authSystem = new AuthSystem();
            authSystem.addPermission(readPermission);
            authSystem.addPermission(writePermission);
            authSystem.addRole(adminRole);
            authSystem.addRole(userRole);
            authSystem.addUser(admin);
            authSystem.addUser(user);

            // Autenticación y verificación de permisos
            User authUser = authSystem.findUserByUsername("admin");
            if (authUser != null && authUser.authenticate("admin", "admin123")) {
                System.out.println("Autenticacion existosa para "+authUser.getUsername());
                if (authUser.hasPermission("Escribir")) {
                    System.out.println("Admin tiene permiso para escribir");
                } else {
                    System.out.println("Admin no tiene permiso para escribir");
                }
            } else {
                System.out.println("Autenticacion fallida para "+authUser.getUsername());
            }

            authUser = authSystem.findUserByUsername("user");
            if (authUser != null && authUser.authenticate("user", "user123")) {
                System.out.println("Autenticacion existosa para "+authUser.getUsername());
                if (authUser.hasPermission("Leer")) {
                    System.out.println("User tiene permiso para leer ");
                } else {
                    System.out.println("User no tiene permiso para Escribir");
                }
            } else {
                System.out.println("Autenticacion fallida para el"+authUser.getUsername());
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
