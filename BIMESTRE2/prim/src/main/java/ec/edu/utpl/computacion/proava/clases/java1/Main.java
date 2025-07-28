package ec.edu.utpl.computacion.proava.clases.java1;

import java.util.*;
// prim
// Clase que representa un Grafo no dirigido
class Grafo {

    static class Arista {
        int destino;
        int peso;

        Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    int cantidadVertices;
    List<List<Arista>> listaAdyacencia;

    // Constructor del grafo
    Grafo(int cantidadVertices) {
        this.cantidadVertices = cantidadVertices;
        listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < cantidadVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    // Agregar una arista (no dirigido)
    void agregarArista(int origen, int destino, int peso) {
        listaAdyacencia.get(origen).add(new Arista(destino, peso));
        listaAdyacencia.get(destino).add(new Arista(origen, peso));
    }

    // Algoritmo de Prim
    void encontrarArbolMinimo() {
        boolean[] visitado = new boolean[cantidadVertices];
        int[] padre = new int[cantidadVertices];
        int[] pesoMinimo = new int[cantidadVertices];
        Arrays.fill(pesoMinimo, Integer.MAX_VALUE);
        Arrays.fill(padre, -1);

        PriorityQueue<int[]> cola = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pesoMinimo[0] = 0;
        cola.offer(new int[]{0, 0});

        System.out.println("Paso a paso del algoritmo de Prim:");

        while (!cola.isEmpty()) {
            int actual = cola.poll()[0];
            if (visitado[actual]) continue;
            visitado[actual] = true;

            System.out.println("Nodo seleccionado: " + actual);

            for (Arista arista : listaAdyacencia.get(actual)) {
                int vecino = arista.destino;
                int peso = arista.peso;

                if (!visitado[vecino] && peso < pesoMinimo[vecino]) {
                    pesoMinimo[vecino] = peso;
                    padre[vecino] = actual;
                    cola.offer(new int[]{vecino, peso});
                    System.out.println("Se actualiza: nodo " + vecino + " con nuevo padre " + actual + " y peso " + peso);
                }
            }
        }

        int costoTotal = 0;
        System.out.println("\nÁrbol de Recubrimiento Mínimo:");
        for (int i = 1; i < cantidadVertices; i++) {
            System.out.println("Arista " + padre[i] + " - " + i + " peso: " + pesoMinimo[i]);
            costoTotal += pesoMinimo[i];
        }
        System.out.println("Costo total del árbol: " + costoTotal);
    }

    // Método main automático
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);
        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 15);
        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(1, 3, 25);
        grafo.agregarArista(2, 3, 20);
        grafo.agregarArista(2, 5, 5);
        grafo.agregarArista(3, 4, 30);
        grafo.agregarArista(4, 5, 12);

        grafo.encontrarArbolMinimo();
    }
}
