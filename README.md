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

### lanzando una excepción
¡Lancemos nuestra primera excepción! Para hacer esto, siga los pasos a continuación:

1. En el proyecto *Java-stack*, haga una copia de la clase *Flujo*, renombrándola como *FlujoConTratamiento*.

2. En la clase *FlujoConTratamiento*, en el método2, elimine por completo el bucle *for*.

3. Crear una instancia de *ArithmeticException*:

`ArithmeticException exception = new ArithmeticException();`

4. Ahora, lanza la excepción:

```java
private static void metodo2() {
        System.out.println("Inicio del metodo2");
        ArithmeticException exception = new ArithmeticException();
        throw exception;
}
```

5. No es necesario guardar la excepción en una referencia, puede lanzarla directamente en una línea:

```java
private static void metodo2() {
        System.out.println("Inicio del metodo2");
        throw new ArithmeticException();
}
```

6. Y también puede enviar un mensaje como parámetro al constructor de la excepción:

```java
private static void metodo2() {
        System.out.println("Inicio del metodo2");
        throw new ArithmeticException("Surgió un error");
}
```

7. En la siguiente clase, verá cómo crear su propia excepción.

#### ¿Qué aprendimos?

En esta clase aprendemos:

- Cómo lanzar excepciones.
- Cómo asignar un mensaje a la excepción.

### Checked e Unchecked

1. Primero, creamos la clase MiExcepcion * que hereda de *RuntimeException:

```java
public class MiExcepcion extends RuntimeException {

}
```

2. En la clase MiExcepcion, crearemos un constructor que recibe un mensaje de tipo *String* y se lo pasa al constructor de la clase padre *RuntimeException*:

```java
public class MiExcepcion extends RuntimeException {
        public MiExcepcion (String msg) {
            super(msg);
        }
}
```

3. Ahora lanzaremos nuestra excepción dentro de *metodo2()*, en la clase Flujo. Reemplacemos el *throw* actual con lo siguiente:

```java
throw new MiExcepcion("Surgió un error");
```

4. También necesitamos agregar el tipo *MiExcepcion* dentro del *catch* en la clase Flujo:

````java
try {
        metodo1();
} catch(ArithmeticException | NullPointerException | MiExcepcion ex) {
        String msg = ex.getMessage();

        System.out.println("Exception " + msg);
        ex.printStackTrace();
}
```

5. Ahora cambie la clase *MiExcepcion* para extender la clase *Exception* (dejando checked):

```java
public class MiExcepcion extends Exception {  //checked
}
```

6. En la clase Flujo, haga que el código se compile nuevamente y use la excepción *MiExcepcion* en el *metodo1()* y *metodo2()*:

```java
private static void metodo1() throws MiExcepcion {
    System.out.println("Inicio del metodo1");
    metodo2();
    System.out.println("Fin del metodo1");
}

private static void metodo2() throws MiExcepcion {
    System.out.println("Inicio del metodo2");
    throw new MiExcepcion ("Surgió un error");
    // System.out.println("Fin del metodo2");            
}
```
### Opcional: Probando error

En el proyecto *java-stack*, si aún no lo ha creado, cree una nueva clase *FlujoConError* con el siguiente contenido:

```java
public class FlujoConError {

    public static void main(String[] args) { 
        System.out.println("Inicio del main"); 
        try{
            metodo1();
        } catch(ArithmeticException | NullPointerException ex) {
            String msg = ex.getMessage(); 
            System.out.println("Exception " + msg);
            ex.printStackTrace();
        }

        System.out.println("Fin del main");
    }

    private static void metodo1() { 
        System.out.println("Inicio del metodo1"); 
        metodo2();
        System.out.println("Fin del metodo1");
    }

    private static void metodo2() { 
        System.out.println("Inicio del metodo 2"); 
        metodo2();
        System.out.println("Fin del metodo 2");
    }
}
```

Observe que *metodo2()* se llama a sí mismo. Esto también se llama recursividad. Al ejecutar la clase FlujoConError recibimos un Error. ¿Recuerdas por qué?

### ¿Qué aprendimos?

Si hiciste el ejercicio ¿será Miguel comprendió la clase ?, recordará lo que aprendimos. Para solucionarlo aún más, enumeramos los temas de esta clase:

- Existe una gran jerarquía de clases que representan excepciones. Por ejemplo, *ArithmeticException* es hija de *RuntimeException*, que hereda de *Exception*, que a su vez es hija de la clase de excepciones más ancestral, *Throwable*. Conocer bien esta jerarquía significa saber cómo usar las excepciones en su aplicación.
- *Throwable* es la clase que debe extenderse para poder lanzar un objeto en la pila (usando la palabra reservada *throw*)
- Es en la clase *Throwable* donde tenemos casi todo el código relacionado con las excepciones, incluyendo *getMessage()* e *printStackTrace ()*. El resto de la jerarquía tiene solo algunas sobrecargas de constructores para comunicar mensajes específicos.
- La jerarquía que comenzó con la clase *Throwable* se divide en excepciones y errores. Las excepciones se utilizan en los códigos de aplicación. Los errores son utilizados exclusivamente por la máquina virtual.
- Las clases que heredan de *Error* se utilizan para informar errores en la máquina virtual. Los desarrolladores de aplicaciones no deben crear errores que hereden de *Error*.
- *StackOverflowError* es un error de máquina virtual para informar que la pila de ejecución no tiene más memoria.
- Las excepciones se dividen en dos categorías amplias: las que el compilador comprueba obligatoriamente y las que no.
- Los primeros se denominan checked y se crean por pertenecer a una jerarquía que no pasa *RuntimeException*.
- Los segundos están *unchecked* y se crean como descendientes de *RuntimeException*.