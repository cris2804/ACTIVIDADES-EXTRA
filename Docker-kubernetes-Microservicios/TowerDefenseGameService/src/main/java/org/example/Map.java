package org.example;

import java.util.List;

public class Map {
    private char[][] grid;
    public Map() {
        grid = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = ' ';
            }
        }
    }
    public void placeTower(Tower tower, int x, int y) {
        grid[x][y] = tower.getSymbol();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : grid) {
            for (char cell : row) {
                sb.append("[").append(cell).append("]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}