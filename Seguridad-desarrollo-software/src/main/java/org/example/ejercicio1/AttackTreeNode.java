package org.example.ejercicio1;

import java.util.*;

public class AttackTreeNode {
    private String description; // Descripción del ataque
    private double estimatedCost; // Costo estimado
    private double probabilityOfSuccess;// Probabilidad de exito
    private List<AttackTreeNode> children; // Hijos del ataque
    public AttackTreeNode(String description, double estimatedCost, double probabilityOfSuccess) {
        // Constructor
        this.description = description;
        this.estimatedCost = estimatedCost;
        this.probabilityOfSuccess = probabilityOfSuccess;
        this.children = new ArrayList<>();
    }
    public void addChild(AttackTreeNode child) {
        children.add(child);// Agregar un hijo
    }
    public List<AttackTreeNode> getChildren() {
        return children;// Obtener los hijos
    }
    public double getRisk() {
        return estimatedCost * probabilityOfSuccess;// Obtener el riesgo
    }
    public String getDescription() {
        return description;// Obtener la descripción
    }

}
