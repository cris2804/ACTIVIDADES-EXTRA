package org.example;

public class TowerService {
    private char symbol;  // Símbolo que representa la torre en el mapa "T"

    // Constructor
    public TowerService(char symbol) {
        this.symbol = symbol;
    }

    // Método para obtener el símbolo de la torre
    public char getSymbol() {
        return symbol;
    }
}
