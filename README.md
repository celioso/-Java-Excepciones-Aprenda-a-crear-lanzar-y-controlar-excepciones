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