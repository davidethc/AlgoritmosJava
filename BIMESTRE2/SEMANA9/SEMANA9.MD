# Semana 09

# Algoritmos Voraces

## Temas Abordados

- Propósito
- Rasgos principales
- Grafos no dirigidos
- Árbol de Expansión Mínima (MST)
- Algoritmo de Kruskal (explicación y código)

---

## Propósito

Analizar las características esenciales y aplicaciones clave de los algoritmos voraces, enfocándose en su uso sobre grafos no dirigidos. Se pretende entender en qué situaciones este enfoque resulta adecuado, cómo se diferencia de otros métodos (como la programación dinámica o el backtracking), y de qué manera permite obtener soluciones eficientes, ya sean óptimas o aproximadas, en problemas complejos.

---

## Características de los Algoritmos Voraces

Los algoritmos voraces resuelven problemas construyendo la solución paso a paso, eligiendo en cada etapa la alternativa que parece más conveniente en ese momento, sin reconsiderar decisiones anteriores.

| Rasgo                    | Descripción                                                                      |
| ------------------------ | -------------------------------------------------------------------------------- |
| Selección local óptima   | En cada paso se toma la mejor decisión posible sin prever consecuencias futuras. |
| Sin retroceso            | No se deshacen decisiones; no hay backtracking ni prueba y error.                |
| Subestructura óptima     | Los subproblemas contribuyen a una solución global óptima.                       |
| Eficiencia computacional | Suelen ser más rápidos que otros enfoques más generales.                         |
| Aplicación limitada      | No todos los problemas pueden resolverse con este método.                        |

**Cuándo aplicar algoritmos voraces:**

- Cuando el problema cumple con subestructura óptima y elección voraz.
- En situaciones donde se prioriza rapidez y simplicidad, y se acepta una solución aproximada si no es posible garantizar la óptima.

---

## Grafos No Dirigidos

Un grafo no dirigido es una estructura formada por vértices conectados mediante aristas bidireccionales. Muchos problemas de optimización sobre grafos pueden resolverse eficazmente con técnicas voraces, por ejemplo:

- Construcción de árboles de expansión mínima (MST)
- Búsqueda de caminos más cortos desde un nodo fuente (Dijkstra)
- Asignación eficiente de recursos (Algoritmo de Huffman)
- Coloración de grafos (enfoque heurístico)

---

## Árbol de Expansión Mínima (MST)

Un árbol de expansión mínima conecta todos los vértices de un grafo no dirigido, sin formar ciclos y con el menor peso total posible.

### Algoritmos principales:

- Kruskal: selecciona las aristas de menor peso que no generen ciclos.
- Prim: construye el árbol añadiendo el nodo más cercano aún no incluido.

---

## Algoritmo de Kruskal – Explicación

1. Ordenar todas las aristas del grafo por peso ascendente.
2. Inicializar una estructura de conjuntos disjuntos (Union-Find) para controlar la formación de ciclos.
3. Recorrer las aristas ordenadas e incluir cada una si no forma un ciclo.
4. Detenerse cuando el árbol tenga n−1 aristas (siendo n el número de nodos).

---

## Pseudocódigo Alternativo de Kruskal

```java
funcion kruskal(Grafo G):
    MST = {}  // Árbol de expansión mínima
    inicializarConjuntosDisjuntos(G.vertices)
    ordenarAristasPorPeso(G.aristas)

    para cada arista en G.aristas:
        si (no estanConectados(arista.origen, arista.destino)):
            MST.agregar(arista)
            unir(arista.origen, arista.destino)

    devolver MST
```
