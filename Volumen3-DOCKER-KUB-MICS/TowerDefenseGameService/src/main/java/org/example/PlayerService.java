package org.example;

public class PlayerService {
    private int score;  // Puntuacion del jugador
    private int baseHealth;  // Vida de la base del jugador

    // Constructor para inicializar la puntuacion y la vida de la base
    public PlayerService() {
        this.score = 0;
        this.baseHealth = 100;
    }

    // Metodo para obtener la puntuacion actual del jugador
    public int getScore() {
        return score;
    }

    // Metodo para obtener la vida actual de la base del jugador
    public int getBaseHealth() {
        return baseHealth;
    }
}
