package org.example;

import java.util.random.RandomGenerator;
public class LanzamientoDados {
    private static final int NUMERO_LADOS = 6;
    private final NumerosAleatorios generadorAleatorio;

    public LanzamientoDados(NumerosAleatorios generadorAleatorio) {
        this.generadorAleatorio = generadorAleatorio;
    }

    public String asText() {
        int lanzado = generadorAleatorio.nextInt(NUMERO_LADOS) + 1;
        System.out.println(generadorAleatorio);
        return String.format("Lanzamiento: %d", lanzado);
    }
}