# Semana 10

# Algoritmos Voraces – Grafos Dirigidos

## Temas Abordados

- Propósito
- Concepto de grafos dirigidos
- Uso de enfoques voraces
- Algoritmo de Dijkstra (teoría y pseudocódigo)

---

## Propósito

Profundizar en la aplicación de algoritmos voraces sobre grafos dirigidos, con énfasis en la resolución del problema de caminos más cortos desde un nodo fuente. Se busca comprender cómo la dirección de las aristas afecta el proceso de decisión y por qué algoritmos como Dijkstra son fundamentales en este contexto.

---

## Concepto de Grafos Dirigidos

Un grafo dirigido (o digrafo) está compuesto por:

- Un conjunto de vértices (nodos)
- Un conjunto de aristas dirigidas (conexiones con dirección)

Cada arista tiene un sentido: va desde un nodo origen hacia un nodo destino. Es decir, la existencia de una arista (A → B) no implica necesariamente la existencia de (B → A).

**Formas de representación:**

- Lista de adyacencia con pares ordenados (nodo, peso)
- Matriz de adyacencia donde A[i][j] representa el peso desde el nodo i al nodo j

**Aplicaciones comunes:**

- Redes de carreteras unidireccionales
- Flujos de datos
- Modelado de procesos o dependencias

---

## Uso de Enfoques Voraces en Grafos Dirigidos

En grafos dirigidos con pesos positivos, los algoritmos voraces permiten determinar rutas eficientes.

**Ventajas de este enfoque:**

- Selección local óptima: se elige el nodo con menor distancia conocida en cada paso.
- Sin retroceso: los nodos ya procesados no se vuelven a evaluar.
- Subestructura óptima: el camino más corto a un nodo pasa por otros caminos más cortos.
- Menor complejidad en comparación con métodos exhaustivos o backtracking.

Este tipo de algoritmo encuentra soluciones en tiempo polinomial, siempre que el grafo no tenga ciclos de peso negativo.

---

## Algoritmo de Dijkstra

El algoritmo de Dijkstra es una técnica voraz utilizada para hallar el camino más corto desde un nodo fuente a todos los demás nodos en un grafo dirigido con pesos no negativos.

**Requisitos:**

- El grafo debe tener pesos mayores o iguales a cero.
- Se requiere una estructura de prioridad (como una cola de prioridad o heap mínimo).

**Funcionamiento general:**

1. Inicializar las distancias mínimas a infinito (∞), excepto la del nodo de inicio, que se establece en 0.
2. Utilizar una cola de prioridad para explorar los nodos con menor distancia conocida.
3. En cada iteración, tomar el nodo más cercano aún no visitado y actualizar las distancias a sus vecinos si se encuentra un camino más corto.
4. Repetir hasta procesar todos los nodos.

---

## Pseudocódigo de Dijkstra

```python
def dijkstra(grafo, nodo_origen):
    distancias_minimas = {nodo: float('inf') for nodo in grafo}
    distancias_minimas[nodo_origen] = 0
    cola_de_prioridad = [(0, nodo_origen)]

    while cola_de_prioridad:
        dist_actual, nodo_actual = extraer_nodo_menor_distancia(cola_de_prioridad)

        for nodo_vecino, peso in grafo[nodo_actual]:
            nueva_distancia = dist_actual + peso
            if nueva_distancia < distancias_minimas[nodo_vecino]:
                distancias_minimas[nodo_vecino] = nueva_distancia
                insertar_en_cola(cola_de_prioridad, (nueva_distancia, nodo_vecino))

    return distancias_minimas
```
