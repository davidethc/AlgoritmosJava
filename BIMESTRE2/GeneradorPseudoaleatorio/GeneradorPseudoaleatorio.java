package ec.edu.utpl.computacion.proava.clases.java1;

import java.util.Random;
import java.util.Scanner;

public class GeneradorPseudoaleatorio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random generador = new Random();

        System.out.print("Ingrese la cantidad de números pseudoaleatorios a generar: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese el límite máximo (ej. 100): ");
        int limite = scanner.nextInt();

        System.out.println("\nNúmeros Pseudoaleatorios Generados:");

        for (int i = 1; i <= cantidad; i++) {
            int numero = generador.nextInt(limite + 1); // genera entre 0 y limite
            System.out.println("Número " + i + ": " + numero);
        }

        System.out.println("\nFin del programa.");
    }
}
