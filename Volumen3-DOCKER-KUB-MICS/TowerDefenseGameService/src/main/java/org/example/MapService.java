package org.example;

public class MapService {
    private char[][] grid;  // Matriz del mapa del juego

    // Constructor que inicializa el mapa con celdas vacias
    public MapService() {
        grid = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = ' ';  // Cada celda se inicializa como vacia
            }
        }
    }

    // Método para colocar una torre en una posición (x,y)
    public void placeTower(TowerService tower, int x, int y) {
        grid[x][y] = tower.getSymbol();  // Coloca el símbolo de la torre en la posición dada
    }

    // Método para representar el estado del mapa como una cadena de texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : grid) {
            for (char cell : row) {
                sb.append("[").append(cell).append("]");  // Agregar cada celda a la representación en cadena
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
