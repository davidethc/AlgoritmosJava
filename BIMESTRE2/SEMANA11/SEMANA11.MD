# Semana 11

# Algoritmos Divide y Vencerás

## Temas Abordados

- Propósito
- Fundamentos de Divide y Vencerás
- Mecanismo de la Búsqueda Binaria
- Implementación en Java

---

## Propósito

Comprender el uso y los beneficios del paradigma algorítmico Divide y Vencerás, aplicándolo en el diseño y análisis del algoritmo de búsqueda binaria. El objetivo es optimizar la localización de elementos en estructuras de datos ordenadas, mejorando la eficiencia en tareas de búsqueda frecuentes.

---

## Fundamentos de Divide y Vencerás

Divide y Vencerás (Divide and Conquer) es una estrategia que resuelve problemas complejos dividiéndolos en subproblemas más simples y similares al original. Este enfoque sigue tres pasos principales:

1. **Dividir:** El problema se separa en uno o más subproblemas más pequeños y manejables.
2. **Conquistar:** Se resuelven los subproblemas recursivamente. Si los subproblemas son lo suficientemente simples, se resuelven directamente.
3. **Combinar:** Se integran las soluciones parciales para formar la solución completa al problema original.

Este paradigma es eficiente y se utiliza en algoritmos clásicos como:

- Búsqueda binaria
- Merge Sort (ordenamiento por mezcla)
- Quick Sort (ordenamiento rápido)
- Exponentiación rápida
- Algoritmo de Karatsuba para multiplicación de enteros grandes

---

## Mecanismo de la Búsqueda Binaria

La búsqueda binaria es un algoritmo eficiente para localizar un valor dentro de un arreglo ordenado. Utiliza el principio de Divide y Vencerás, ya que en cada paso reduce a la mitad el espacio de búsqueda.

**Proceso general:**

1. Calcular el índice medio del arreglo o del rango actual.
2. Comparar el valor medio con el valor buscado:
   - Si son iguales, se retorna la posición.
   - Si el valor buscado es menor, se repite la búsqueda en la mitad izquierda.
   - Si es mayor, se repite en la mitad derecha.
3. Repetir hasta encontrar el valor o agotar el rango.

**Complejidad computacional:**

- Mejor caso: O(1) (el valor está en el medio)
- Peor y caso promedio: O(log n)
  Esto se debe a que en cada iteración se reduce el tamaño del problema a la mitad.

**Condición clave:**
El arreglo debe estar ordenado de forma creciente o decreciente, según la lógica implementada.

---

## Implementación de Ejemplo en Java

```java
public class BusquedaBinaria {
    public static int buscarElemento(int[] arregloOrdenado, int valorBuscado) {
        int limiteInferior = 0;
        int limiteSuperior = arregloOrdenado.length - 1;

        while (limiteInferior <= limiteSuperior) {
            int puntoMedio = limiteInferior + (limiteSuperior - limiteInferior) / 2;

            if (arregloOrdenado[puntoMedio] == valorBuscado) {
                return puntoMedio;
            } else if (arregloOrdenado[puntoMedio] < valorBuscado) {
                limiteInferior = puntoMedio + 1;
            } else {
                limiteSuperior = puntoMedio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] miArreglo = {2, 4, 6, 8, 10, 12, 14, 16};
        int elementoAEncontrar = 10;
        int resultadoIndice = buscarElemento(miArreglo, elementoAEncontrar);

        if (resultadoIndice != -1) {
            System.out.println("El elemento " + elementoAEncontrar + " fue hallado en el índice: " + resultadoIndice);
        } else {
            System.out.println("El elemento " + elementoAEncontrar + " no está presente en el arreglo.");
        }
    }
}
```
