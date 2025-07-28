package ec.edu.utpl.computacion.proava.clases.java1;
// dijastra
import java.util.*;

 class GrafoDirigido {

    static class Nodo implements Comparable<Nodo> {
        int id, distancia;

        Nodo(int id, int distancia) {
            this.id = id;
            this.distancia = distancia;
        }

        public int compareTo(Nodo otro) {
            return Integer.compare(this.distancia, otro.distancia);
        }
    }

    int V;
    List<List<Nodo>> adyacencia;
    int[] distancia;
    int[] previo;
    boolean[] visitado;

    public GrafoDirigido(int V) {
        this.V = V;
        adyacencia = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adyacencia.add(new ArrayList<>());
        }
        distancia = new int[V];
        previo = new int[V];
        visitado = new boolean[V];
    }

    void agregarArista(int origen, int destino, int peso) {
        adyacencia.get(origen).add(new Nodo(destino, peso));
    }

    void ejecutarDijkstra(int inicio) {
        Arrays.fill(distancia, Integer.MAX_VALUE);
        Arrays.fill(previo, -1);
        Arrays.fill(visitado, false);

        PriorityQueue<Nodo> cola = new PriorityQueue<>();
        distancia[inicio] = 0;
        cola.offer(new Nodo(inicio, 0));

        System.out.println("Ejecutando Dijkstra desde el nodo " + inicio);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            int u = actual.id;

            if (visitado[u]) continue;
            visitado[u] = true;

            System.out.println("Procesando nodo: " + u + " con distancia actual: " + distancia[u]);

            for (Nodo vecino : adyacencia.get(u)) {
                int v = vecino.id;
                int peso = vecino.distancia;

                if (!visitado[v] && distancia[u] + peso < distancia[v]) {
                    distancia[v] = distancia[u] + peso;
                    previo[v] = u;
                    cola.offer(new Nodo(v, distancia[v]));
                    System.out.println("Actualizando nodo " + v + ": nueva distancia = " + distancia[v] + ", padre = " + u);
                }
            }
        }
    }

    void mostrarResultados(int inicio) {
        System.out.println("\nDistancias mínimas desde el nodo " + inicio + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Nodo " + i + ": " + (distancia[i] == Integer.MAX_VALUE ? "inaccesible" : distancia[i]));
        }

        System.out.println("\nCaminos mínimos desde el nodo " + inicio + ":");
        for (int i = 0; i < V; i++) {
            if (distancia[i] == Integer.MAX_VALUE) {
                System.out.println("Nodo " + i + ": inaccesible");
                continue;
            }

            List<Integer> camino = new ArrayList<>();
            for (int at = i; at != -1; at = previo[at]) {
                camino.add(at);
            }
            Collections.reverse(camino);
            System.out.print("Camino a nodo " + i + ": ");
            for (int nodo : camino) {
                System.out.print(nodo + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido(6);
        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 15);
        grafo.agregarArista(1, 3, 12);
        grafo.agregarArista(2, 4, 10);
        grafo.agregarArista(3, 4, 2);
        grafo.agregarArista(3, 5, 1);
        grafo.agregarArista(4, 5, 5);

        grafo.ejecutarDijkstra(0); // desde nodo 0
        grafo.mostrarResultados(0);
    }
}
