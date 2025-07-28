# Semana 14

# Algoritmos Probabilistas

## Temas Abordados

- Propósito de la unidad
- Definición de algoritmos probabilistas
- Análisis del tiempo esperado
- Ejemplo de búsqueda aleatoria
- Exploración de algoritmos numéricos
- Método de Monte Carlo
- Otras técnicas numéricas
- Conceptos fundamentales

---

## Propósito de la Unidad

Esta unidad tiene como objetivo comprender el funcionamiento, análisis y aplicaciones de los algoritmos que incorporan componentes aleatorios en su ejecución. En particular:

- Analizar su comportamiento no determinista y su tiempo esperado de ejecución.
- Estudiar técnicas numéricas como el método de Monte Carlo, ampliamente utilizado para simulaciones, estimaciones estadísticas y problemas complejos donde los métodos deterministas resultan poco eficientes o inviables.
- Introducir la idea de que el azar puede ser una herramienta poderosa y eficiente en el diseño de algoritmos.

---

## Definición de Algoritmos Probabilistas

Son algoritmos que emplean aleatoriedad como parte de su lógica de decisión, lo que significa que, dadas las mismas entradas, pueden producir resultados diferentes o tomar trayectorias distintas en distintas ejecuciones.

**Tipos principales:**

- Algoritmos Las Vegas: siempre devuelven una solución correcta, pero el tiempo de ejecución es variable debido al uso de aleatoriedad. Ejemplo: QuickSort aleatorizado.
- Algoritmos Monte Carlo: suelen ejecutarse en tiempo fijo o acotado, pero la respuesta puede ser incorrecta con baja probabilidad, controlable mediante repeticiones o configuraciones. Ejemplo: Prueba de primalidad probabilista de Miller-Rabin.

---

## Análisis del Tiempo Esperado

El tiempo esperado representa el promedio ponderado del tiempo que un algoritmo probabilista requiere para finalizar, considerando todas las posibles trayectorias aleatorias que podría seguir.

Este análisis es fundamental porque, aunque algunos algoritmos pueden parecer ineficientes en el peor caso, su desempeño promedio suele ser mucho mejor.

**Fórmula básica:**

E[T] = Σ (P_i \* T_i)

donde:

- P_i es la probabilidad de que ocurra la trayectoria i
- T_i es el tiempo de ejecución correspondiente a esa trayectoria

---

## Ejemplo: Búsqueda Aleatoria

Un ejemplo sencillo de algoritmo probabilista es la búsqueda aleatoria, donde los elementos de un arreglo se revisan en posiciones al azar hasta encontrar el valor deseado.

**Implementación en Java:**

```java
import java.util.Random;

public class BusquedaAleatoriaEjemplo {
    public int realizarBusquedaAleatoria(int[] arreglo, int valorObjetivo) {
        Random generadorAleatorio = new Random();
        int contadorIntentos = 0;
        boolean[] visitados = new boolean[arreglo.length];

        while (true) {
            int indiceAleatorio = generadorAleatorio.nextInt(arreglo.length);
            contadorIntentos++;

            if (!visitados[indiceAleatorio]) {
                visitados[indiceAleatorio] = true;
                if (arreglo[indiceAleatorio] == valorObjetivo) {
                    return contadorIntentos;
                }
            }

            // Si todos fueron visitados y no se encontró
            if (contadorIntentos >= arreglo.length) {
                System.out.println("Todos los elementos han sido inspeccionados.");
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        BusquedaAleatoriaEjemplo buscador = new BusquedaAleatoriaEjemplo();
        int[] datos = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int objetivo = 50;
        int intentos = buscador.realizarBusquedaAleatoria(datos, objetivo);

        if (intentos != -1) {
            System.out.println("Elemento " + objetivo + " encontrado en " + intentos + " intentos.");
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
}
```

---

## Método de Monte Carlo y Otras Técnicas Numéricas

El método de Monte Carlo es una técnica probabilista utilizada para resolver problemas numéricos mediante simulaciones aleatorias. Es ampliamente empleado en estimaciones estadísticas, integración numérica y simulación de sistemas complejos.

Otras técnicas numéricas probabilistas incluyen métodos para resolver ecuaciones, optimización y análisis de sistemas donde los métodos deterministas no son prácticos.
