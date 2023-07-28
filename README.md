# Java-Excepciones-Aprenda-a-crear-lanzar-y-controlar-excepciones
## Proyecto inicial del entrenamiento
El proyecto inicial de este entrenamiento es el proyecto implementado en el entrenamiento anterior. Por lo tanto, caso hayas realizado el entrenamiento anterior, puedes proseguir con el mismo proyecto.

En caso que no hayas realizado el entrenamiento anterior te aconsejamos hacerlo para aprovechar mejor el contenido de este curso, de todas formas puedes descargar el proyecto completo de los 3 capítulos anteriores [aquí](https://github.com/alura-es-cursos/java-herencia-polimorfismo/tree/clase-7 "aquí").

## Haga lo que hicimos en el aula: Pila de ejecución

¡Vamos a comenzar con nuestro proyecto!

1. Comience por crear el proyecto en eclipse llamado java-stack.

2. Luego, cree la clase Flujo y copie el siguiente código a la clase:

```java
public class Flujo {

        public static void main(String[] args) {
            System.out.println("Inicio del main");
            metodo1();
            System.out.println("Fin del main");
        }

        private static void metodo1() {
            System.out.println("Inicio del metodo1");
            metodo2();
            System.out.println("Fin del metodo1");
        }

        private static void metodo2() {
            System.out.println("Inicio del metodo2");
            for(int i = 1; i <= 5; i++) {
                System.out.println(i);
            }
            System.out.println("Fin del metodo2");
        }
}
```

Ahora, veamos la pila de ejecución. Como se muestra en el video, cree un punto de interrupción (*Breakpoint*), por ejemplo, en la línea que llama al *método1(*). Ejecute el programa en modo de depuración y use los comandos *Step into* y *Step Over*. Preste atención a la pila de ejecución.

### ¿Qué aprendimos?

En esta clase aprendimos:

- Qué es, para qué sirve y cómo funciona la pila de ejecución.
- Qué es la depuración (debug) y para qué sirve.
- Cómo utilizar Eclipse y su perspectiva de debug.
- Cómo cambiar entre perspectivas de Eclipse.
Hagas clic [aquí](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Exception.html "aquí") para acceder a la documentación oficial y obtener más información sobre la clase Exception.

## Tratamiento de excepciones

Ahora forzaremos una excepción en nuestra clase *Flujo* del proyecto *Java-stack*.

1.  Dentro del for del metodo2(), haga lo siguiente:

```java
for(int i = 1; i <= 5; i++) {
        System.out.println(i);
        int a = i / 0;
}
```
¡Esto debe retornarnos un *ArithmeticException*!

2. Para evitar que la excepción caiga en nuestra pila, usemos el bloque *try* y *catch*:

```java
try{
        int a = i / 0;
} catch(ArithmeticException ex) {
        System.out.println("ArithmeticException");
}
```

3. Sin embargo, podemos usar *try* y *catch* al llamar a *metodo2()*, dentro de *metodo1()*, de la siguiente manera:

```java
try {
        metodo2();
} catch(ArithmeticException ex) {
        System.out.println("ArithmeticException");
}
```

4. Podemos subir una vez más nuestro *try* y *catch* para nuestro método *main*, en el momento de llamar al *método1()*. Además, podemos definir algunas cosas de nuestra excepción, como recibir el mensaje:

```java
try {
        metodo1();
} catch(ArithmeticException ex) {
        String msg = ex.getMessage();
        System.out.println("ArithmeticException " + msg);
}
```

5. Otra cosa que podemos hacer es rastrear nuestra excepción:

```java
try {
        metodo1();
} catch(ArithmeticException ex) {
        String msg = ex.getMessage();
        System.out.println("ArithmeticException " + msg);
        ex.printStackTrace();
}
```

6. Ahora, hagamos otra prueba. Para hacer esto, cree la clase *Cuenta* de la siguiente manera:

```java
public class Cuenta {
        void depositar() {
        }
}
```

7. Y, dentro del método *metodo2()*, haremos la siguiente prueba:

```java
for(int i = 1; i <= 5; i++) {
        System.out.println(i);
        Cuenta c = null;
        c.depositar();
}
```

8. Pero la excepción causada es una *NullPointerException*, para capturar esta excepción, debemos ponerla dentro de catch en el método *main*:

```java
try {
        metodo1();
} catch(ArithmeticException | NullPointerException ex) {
        String msg = ex.getMessage();
        System.out.println("Exception " + msg);
        ex.printStackTrace();
}
```

## ¿Qué aprendimos?

En esta clase aprendemos:

- Qué son las excepciones, para qué sirven y por qué se utilizarlas.
- Cómo analizar el seguimiento de excepciones o *stacktrace*.
- Manejar excepciones con bloques *try-catch*.
- Manejar una excepción lanzada dentro del bloque *catch*.
- Manejar múltiples excepciones con más de un bloque catcho usando *Multi-Catch* usando el *pipe* (|).