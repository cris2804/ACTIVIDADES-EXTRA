# Mocks y stubs

fecha de realizacion : 

![Untitled](Mimages/Untitled.png)

# Simuladro de lanzamiento de dados:

Se requiere desarrollar una aplicación en Java que simule el lanzamiento de dados. La aplicación deberá
ser capaz de mostrar el resultado de lanzar un dado de seis caras de manera aleatoria. El diseño debe
ser lo suficientemente flexible como para permitir el cambio de la fuente de números aleatorios sin
modificar la lógica central del lanzamiento, facilitando tanto las pruebas unitarias como la adaptación a
diferentes entornos de ejecución.

**Descripción de la solución propuesta:**

**Paso1:**

Crear una interfaz `NumerosAleatorios` que defina un método para obtener números aleatorios dentro de un rango específico

Interfaz `NumerosAleatorios`

```java
package org.example;

public interface NumerosAleatorios {

    int nextInt( int upperBoundExclusive );
}

```

**Paso 2:**

: Modificar la clase LanzamientoDados para que utilice la interfaz NumerosAleatorios,inyectando la dependencia a través del constructor

Clase `LanzamientoDados` :

```java
package org.example;

import java.util.random.RandomGenerator;

public class LanzamientoDados {
    private final int NUMERO_LADOS = 6;
    private  final RandomGenerator random ;
    public LanzamientoDados(NumerosAleatorios aleatorios){
        this.random = (RandomGenerator) aleatorios;
    }
    public String asText(){
        int lanzado = random.nextInt(NUMERO_LADOS) + 1;
        return String.format("Lanzamiento: %d",lanzado);

    }
    }

```

**Paso 3**

Desarrollar un stub de NumerosAleatorios para usar en pruebas unitarias, permitiendo controlar los resultados de los lanzamientos.

Crearemos la clase `StubNumerosAleatorios` que  funcionara como stub , adicionalmente creamos las respectivas pruebas unitarios :

```java
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
```

**Paso 4:**

Escribir pruebas unitarias para LanzamientoDados utilizando el stub para asegurar que la lógica del lanzamiento funciona como se espera bajo condiciones controladas.

la prueba unitaria para usar el stub es el sgt : 

```java
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
```

**Paso 5:** 

Implementar una clase NumerosGeneradosAleatoriamente que utilice un generador de números aleatorios real y que cumpla con la interfaz NumerosAleatorios.

```java
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
```

**Paso 6:**

 Integrar y probar la clase LanzamientoDados en una aplicación de producción,inyectando la implementación real de NumerosAleatorios.

Para ello implemntaremos el sgte codigo en la `main.java`

```java
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
```

tiene como salida lo siguiente : 

![Untitled](Mimages/Untitled%201.png)

Creamos la siguiente prueba unitaria `LanzamientoDadosTest`

```java
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
```

## Sistema de notificaciones por email

Desarrollar una aplicación en Java que gestione el envío de notificaciones por correo electrónico a los
usuarios. Es crucial que la aplicación verifique que los correos electrónicos se envíen con los parámetros
correctos sin necesidad de interactuar con un servidor de correo real durante las pruebas.

**Requisitos funcionales:**

1. Envío de Correo Electrónico: La aplicación debe permitir enviar un correo electrónico con un
destinatario, tema y texto especificados.
2. Verificación de Interacciones: Debe ser posible verificar que se ha llamado al método de envío
de correo electrónico con los argumentos correctos.
3. Facilidad de Pruebas: La arquitectura debe permitir la inyección de dependencias para facilitar
las pruebas, utilizando mocks para simular la interacción con el sistema de correo electrónico.

**Requisitos no funcionales:**

1. Extensibilidad: El sistema debe ser extensible para soportar diferentes tipos de notificaciones en
el futuro.
2. Mantenibilidad: El código debe ser fácil de mantener y comprender, aplicando principios SOLID
y patrones de diseño adecuados.

- Paso 1: Definir una interfaz `MailServer` que abstraiga el envío de correos electrónicos.

```java
package org.example;

public interface MailServer {

    void sendEmail(String email, String message); 
}

```

El metodo SendEmail es el se encargara del envio de correos electronicos.

- Paso 2: Crear una clase `UserNotifications` que dependa de la interfaz MailServer para enviar
correos.

```java
package org.example;

public class UserNotifications implements MailServer {

    @Override
    public void sendEmail(String email, String message) {
        System.out.println("Sending email to " + email + " with message: " + message);
    }
}

```

- Paso 3: Implementar un mock de MailServer que registre las llamadas a su método sendEmail y capture los valores de los parámetros enviados.

```java
package org.example;

import java.util.ArrayList;
import java.util.List;

public class MockMailServer implements MailServer {
    //clase Email para capturar los parametros de sendEmail
    public static class Email{
        public String email;
        public String message;
        public Email(String email, String message){
            this.email = email;
            this.message = message;
        }
    }
    //lista para almenecar las llamdas a senEmail
    private List<Email> emails = new ArrayList<Email>();
    @Override
    public void sendEmail(String email, String message) {
        emails.add(new Email(email, message));
    }

    public List<Email> getEmails() {
        return emails;
    }
    public void clearEmails(){
        emails.clear();
    }

}

```

- Paso 4: Escribir pruebas unitarias para UserNotifications utilizando el mock para verificar que los
correos se envíen correctamente.

Usando jacoco

![Untitled](Mimages/Untitled%202.png)