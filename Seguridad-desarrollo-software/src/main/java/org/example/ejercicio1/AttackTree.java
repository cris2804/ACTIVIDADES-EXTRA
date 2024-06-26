package org.example.ejercicio1;
import java.util.*;
class AttackTree {
    private AttackTreeNode root; // raiz
    public AttackTree(AttackTreeNode root) {
        // Asignar la raiiz
        this.root = root;
    }
    public double calculateTotalRisk() {
        return calculateRiskRecursively(root);// Calcular el riesgo total
    }
    private double calculateRiskRecursively(AttackTreeNode node) {
        double totalRisk = node.getRisk(); // Calcular el riesgo de este nodo
        for (AttackTreeNode child : node.getChildren()) {
            totalRisk += calculateRiskRecursively(child);// Calcular el riesgo de los descendientes
        }
        return totalRisk;
    }
    // Método para encontrar la ruta crítica
    public List<AttackTreeNode> findCriticalPath() {
        List<AttackTreeNode> path = new ArrayList<>();
        findCriticalPathRecursively(root, path);
        return path;
    }
    private double findCriticalPathRecursively(AttackTreeNode node, List<AttackTreeNode> path) {
        path.add(node); // Agregar el nodo actual a la ruta
        if (node.getChildren().isEmpty()) {
            return node.getRisk();// Si el nodo no tiene descendientes, devolver el riesgo
        }
        double maxRisk = 0;
        AttackTreeNode criticalChild = null;
        for (AttackTreeNode child : node.getChildren()) {
            double childRisk = findCriticalPathRecursively(child, new ArrayList<>());// Calcular el riesgo de los descendientes
            if (childRisk > maxRisk) {
                maxRisk = childRisk;
                criticalChild = child;
            }
        }
        if (criticalChild != null) { // Si hay un nodo criitico
            path.add(criticalChild); // Agregar el nodo critico a la ruta
        }
        return maxRisk + node.getRisk();// Calcular el riesgo total
    }
}