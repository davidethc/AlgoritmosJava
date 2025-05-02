# 📘 Introducción a los Algoritmos

## ¿Qué es un algoritmo?

Un **algoritmo** es una secuencia finita y ordenada de pasos definidos que describen cómo resolver un problema o realizar una tarea. Es independiente del lenguaje de programación y puede representarse de muchas formas: texto, pseudocódigo, diagramas de flujo, etc.

Características esenciales de un algoritmo:

- **Entrada**: cero o más valores iniciales.
- **Salida**: al menos un resultado.
- **Definido**: cada paso debe ser claro y no ambiguo.
- **Finito**: debe completarse después de un número limitado de pasos.
- **Eficiente**: utiliza recursos computacionales de manera razonable.

---

## ⏱️ Análisis de Algoritmos

Analizar un algoritmo es estudiar su rendimiento, especialmente en términos de **tiempo de ejecución** y **uso de memoria**, bajo diferentes condiciones.

### Casos típicos de análisis:

- 🟢 **Mejor caso (Best Case)**: el escenario más favorable.
- 🔴 **Peor caso (Worst Case)**: el escenario más costoso.
- ⚪ **Caso promedio (Average Case)**: el comportamiento esperado con entradas aleatorias.

---

## 🧮 Notación Asintótica

La notación asintótica permite describir el crecimiento del tiempo o espacio requerido por un algoritmo conforme aumenta el tamaño de entrada.

- **O(n)** — **Big O**: Cota superior (peor caso).
- **Ω(n)** — **Omega**: Cota inferior (mejor caso).
- **Θ(n)** — **Theta**: Cota ajustada (caso promedio si coinciden los anteriores).

Ejemplo:

- Búsqueda lineal:
  - Mejor caso: Ω(1)
  - Peor caso: O(n)

---

## ⚙️ Principios y Técnicas Comunes

- **Divide y vencerás** (ej. MergeSort)
- **Algoritmos voraces** (ej. Kruskal)
- **Programación dinámica** (ej. Fibonacci con memoización)
- **Backtracking** (ej. Sudoku)
- **Ramificación y poda** (ej. problemas NP-completos)

---

## 🔍 Inducción Matemática

Método de demostración útil para probar que un algoritmo es correcto para todo `n`.

### Pasos:

1. **Base**: demostrar que se cumple para `n = 1` (u otro caso base).
2. **Hipótesis inductiva**: suponer que se cumple para `n = k`.
3. **Paso inductivo**: demostrar que se cumple para `n = k + 1`.

### Ejemplo: suma de los `n` primeros números naturales

Queremos probar que:

1 + 2 + 3 + ... + n = n(n + 1)/2

---

## ✏️ Ejemplo Clásico: Búsqueda Lineal

```python
def buscar(lista, objetivo):
    for i in range(len(lista)):
        if lista[i] == objetivo:
            return i
    return -1


📚 Bibliografía
Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). Introduction to Algorithms (3ra ed.). The MIT Press. ISBN: 9780262033848.

```
