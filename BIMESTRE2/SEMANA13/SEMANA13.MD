# Semana 13

# Algoritmos Divide y Vencerás – Casos Avanzados

## Temas Abordados

- Propósito didáctico
- Resolución del problema de la mediana
- Cálculo de la mediana en dos arreglos ordenados
- Operaciones con matrices
- Algoritmo de Strassen para multiplicación
- Ideas fundamentales
- Ejemplos prácticos

---

## Propósito Didáctico

Este módulo explora la aplicación del enfoque Divide y Vencerás en problemas de mayor complejidad computacional, que requieren eficiencia algorítmica avanzada. Se abordan dos casos principales:

- El cálculo de la mediana de dos arreglos ordenados.
- La multiplicación eficiente de matrices mediante el algoritmo de Strassen.

Ambos problemas ilustran el potencial del enfoque recursivo y estructurado para reducir la complejidad temporal frente a soluciones tradicionales.

---

## Resolución del Problema de la Mediana

### Cálculo de la Mediana en Dos Arreglos Ordenados

El objetivo es encontrar la mediana de dos arreglos ordenados sin fusionarlos completamente, logrando una complejidad O(log(min(n, m))), mucho más eficiente que el método ingenuo de O(n + m).

Este algoritmo utiliza búsqueda binaria sobre el arreglo más corto, dividiendo ambos arreglos en mitades y asegurando que los elementos a la izquierda de la partición sean menores o iguales que los de la derecha.

**Supuestos:**

- Ambos arreglos están ordenados de forma ascendente.
- Los tamaños pueden ser diferentes.
- Se busca la mediana de la unión hipotética de ambos arreglos.

**Puntos clave:**

- No se combinan los arreglos explícitamente.
- Se realiza una partición equilibrada en ambos arreglos.
- El objetivo es mantener que: maxIzquierda ≤ minDerecha en ambas particiones.

**Ejemplo de implementación en Java:**

```java
double encontrarMedianaDeArreglosOrdenados(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length)
        return encontrarMedianaDeArreglosOrdenados(nums2, nums1); // Asegura que nums1 sea el menor

    int x = nums1.length;
    int y = nums2.length;
    int low = 0, high = x;

    while (low <= high) {
        int partitionX = (low + high) / 2;
        int partitionY = (x + y + 1) / 2 - partitionX;

        int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
        int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

        int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
        int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
            if ((x + y) % 2 == 0)
                return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
            else
                return (double)Math.max(maxLeftX, maxLeftY);
        } else if (maxLeftX > minRightY) {
            high = partitionX - 1;
        } else {
            low = partitionX + 1;
        }
    }

    throw new IllegalArgumentException("Los arreglos de entrada no están ordenados correctamente");
}
```

---

## Operaciones con Matrices: Algoritmo de Strassen

El algoritmo de Strassen es una técnica avanzada para multiplicar matrices, que reduce la cantidad de multiplicaciones necesarias en comparación con el método tradicional. Utiliza el enfoque Divide y Vencerás para dividir las matrices en submatrices más pequeñas y combinar los resultados, logrando una complejidad menor que el algoritmo clásico.

**Ideas fundamentales:**

- Divide las matrices en bloques más pequeños.
- Realiza multiplicaciones y sumas de submatrices de manera recursiva.
- Reduce la cantidad de operaciones necesarias.

Este método es especialmente útil para matrices grandes y es un ejemplo destacado del poder del paradigma Divide y Vencerás en problemas de álgebra lineal.
