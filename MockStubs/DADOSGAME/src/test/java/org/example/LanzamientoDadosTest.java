package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
public class LanzamientoDadosTest {

    @Test
    public void testLanzarDadoConStub() {
        // Utilizar el stub con un número fijo (por ejemplo, 3)
        NumerosAleatorios stub = new StubNumerosAleatorios(3);
        LanzamientoDados lanzamientoDados = new LanzamientoDados(stub);

        // Verificar que el resultado del lanzamiento es el número fijo + 1
        assertEquals("Lanzamiento: 4", lanzamientoDados.asText());
    }
}