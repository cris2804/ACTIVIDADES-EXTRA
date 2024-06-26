package org.example;

public class Main {
    public static void main(String[] args) {
//        // Ejemplo con generador aleatorio real
        NumerosAleatorios generadorReal = new NumerosGeneradosAleatoriamente();
        LanzamientoDados lanzamientoReal = new LanzamientoDados(generadorReal);
        System.out.println(lanzamientoReal.asText());
//
        // Ejemplo con stub para pruebas
        NumerosAleatorios generadorStub = new StubNumerosAleatorios(3);
        LanzamientoDados lanzamientoPrueba = new LanzamientoDados(generadorStub);
        System.out.println(lanzamientoPrueba.asText());
        // Ejecutar y mostrar el resultado del lanzamiento de los dados
        for (int i = 0; i < 10; i++) {
            System.out.println(lanzamientoReal.asText());
        }
    }
}