# Semana 12

# Algoritmos Divide y Vencerás – Ordenamiento

## Temas Abordados

- Propósito fundamental
- Definición de "Divide y Vencerás"
- Algoritmos de ordenación principales
- Merge Sort
- Quick Sort
- Nociones clave
- Beneficios de la estrategia
- Fragmento de código ilustrativo

---

## Propósito Fundamental

Esta unidad tiene como objetivo brindar una comprensión profunda y aplicada del paradigma Divide y Vencerás, enfocado en algoritmos de ordenación como Merge Sort y Quick Sort. Se analizan sus mecanismos, rendimiento, ventajas y escenarios de uso, permitiendo dominar herramientas algorítmicas esenciales para estructuras de datos y algoritmos.

---

## Definición de "Divide y Vencerás"

Se trata de una estrategia en el diseño de algoritmos que consiste en dividir un problema complejo en subproblemas más simples, resolverlos recursivamente y luego combinar las soluciones parciales para obtener la solución final.

**Etapas principales:**

1. Dividir: fraccionar el problema en subproblemas más pequeños.
2. Conquistar: resolver los subproblemas de manera recursiva.
3. Combinar: integrar las soluciones de los subproblemas para resolver el problema principal.

---

## Algoritmos de Ordenación Principales

### Merge Sort

Merge Sort (ordenamiento por mezcla) divide repetidamente el arreglo en mitades hasta llegar a subarreglos de un solo elemento. Luego, fusiona estas partes de manera ordenada hasta reconstruir el arreglo completo.

**Características:**

- Complejidad O(n log n) en todos los casos (mejor, promedio y peor).
- Es estable (mantiene el orden relativo de elementos iguales).
- Requiere espacio adicional para las fusiones.

**Ejemplo de implementación en Java:**

```java
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    // Combina dos subarreglos ordenados
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] izquierda = new int[n1];
        int[] derecha = new int[n2];

        for (int i = 0; i < n1; ++i)
            izquierda[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            derecha[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (izquierda[i] <= derecha[j]) {
                arr[k] = izquierda[i];
                i++;
            } else {
                arr[k] = derecha[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k++] = izquierda[i++];
        }

        while (j < n2) {
            arr[k++] = derecha[j++];
        }
    }
}
```

---

### Quick Sort

Quick Sort (ordenamiento rápido) también utiliza el paradigma Divide y Vencerás. Selecciona un elemento pivote y divide el arreglo en dos partes: los menores al pivote y los mayores. Luego, aplica el mismo proceso recursivamente a cada subarreglo.

**Características:**

- Complejidad promedio O(n log n), pero en el peor caso puede ser O(n²).
- Generalmente más rápido que Merge Sort en la práctica para arreglos grandes.
- No es estable, pero es in-place (no requiere espacio adicional significativo).

---

## Beneficios de la Estrategia Divide y Vencerás

- Permite resolver problemas complejos de manera eficiente.
- Facilita la implementación recursiva y la paralelización.
- Es la base de muchos algoritmos fundamentales en informática.
