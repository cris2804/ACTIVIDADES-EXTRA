package org.example;
import java.util.Random;

public class NumerosGeneradosAleatoriamente implements NumerosAleatorios {
    private final Random random;

    public NumerosGeneradosAleatoriamente() {
        this.random = new Random();
    }

    @Override
    public int nextInt(int upperBoundExclusive) {
        return random.nextInt(upperBoundExclusive); // upperBoundExclusive no incluye el límite superior
    }
}