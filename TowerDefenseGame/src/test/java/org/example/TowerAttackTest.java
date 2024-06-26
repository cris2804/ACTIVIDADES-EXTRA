//package org.example;
//
//import org.example.Enemy;
//import org.example.TypeEnemy.BasicEnemy;
//import org.example.TypeTower.CannonTower;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class TowerAttackTest {
//    @Test
//    public void testAttack_EnemyInRange() {
//        List<Enemy> enemies = Arrays.asList(new BasicEnemy());
//        enemies.get(0).setPosition(2, 2);
//        Tower tower = new CannonTower();
//        tower.setPosition(2, 1);
//        tower.attack(enemies);
//        // Verificar que el enemigo ha recibido daño
//        assertEquals(50, enemies.get(0).getHealth());
//    }
//
//    @Test
//    public void testAttack_EnemyOutOfRange() {
//        List<Enemy> enemies = Arrays.asList(new BasicEnemy());
//        enemies.get(0).setPosition(5, 5);
//        Tower tower = new CannonTower();
//        tower.setPosition(2, 1);
//        tower.attack(enemies);
//        // Verificar que el enemigo no ha recibido daño
//        assertEquals(100, enemies.get(0).getHealth());
//    }
//}
