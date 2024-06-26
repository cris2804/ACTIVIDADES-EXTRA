package org.example;

public class StubNumerosAleatorios implements NumerosAleatorios {
    private final int numeroFijo;

    public StubNumerosAleatorios(int numeroFijo) {
        this.numeroFijo = numeroFijo;
    }

    @Override
    public int nextInt(int upperBoundExclusive) {
        return numeroFijo;
    }
}