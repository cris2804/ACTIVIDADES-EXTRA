package org.example.ejercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.util.List;

public class AttackTreeTest {

    private AttackTreeNode root;
    private AttackTreeNode child1;
    private AttackTreeNode child2;
    private AttackTreeNode child3;
    private AttackTreeNode child4;
    private AttackTree attackTree;

    @BeforeEach
    public void setUp() {
        // Creación de nodos de ejemplo
        root = new AttackTreeNode("Root Attack", 100, 0.5);
        child1 = new AttackTreeNode("Child Attack 1", 50, 0.3);
        child2 = new AttackTreeNode("Child Attack 2", 70, 0.4);
        child3 = new AttackTreeNode("Child Attack 3", 30, 0.2);
        child4 = new AttackTreeNode("Child Attack 4", 60, 0.5);

        // Construcción del árbol
        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(child3);
        child1.addChild(child4);

        // Creación del árbol de ataque
        attackTree = new AttackTree(root);
    }

    @Test
    public void testCalculateTotalRisk() {
        double expectedTotalRisk = root.getRisk() + child1.getRisk() + child2.getRisk() + child3.getRisk() + child4.getRisk();
        double actualTotalRisk = attackTree.calculateTotalRisk();
        assertEquals(expectedTotalRisk, actualTotalRisk, 0.001);
    }

    @Test
    public void testFindCriticalPath() {
        List<AttackTreeNode> criticalPath = attackTree.findCriticalPath();
        assertNotNull(criticalPath);
        assertTrue(criticalPath.size() > 0);

        // Verificación de la ruta crítica esperada
        assertEquals(root, criticalPath.get(0));
        assertEquals(child1, criticalPath.get(1));
        assertEquals(child4, criticalPath.get(2)); // child4 tiene el mayor riesgo entre child3 y child4
    }
}