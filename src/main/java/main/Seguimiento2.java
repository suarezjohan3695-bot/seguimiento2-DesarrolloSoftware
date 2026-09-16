/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;
import Controladores.GestorCliente;
import Modelos.Cliente;

import java.util.Scanner;

/**
 *
 * @author morde
 */
public class Seguimiento2 {
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            procesarOpcion(opcion);
        } while (opcion == 0);

        System.out.println("Saliendo del sistema. ¡Hasta luego!");
        scanner.close();
    }

    private static Scanner scanner = new Scanner(System.in);
    private static GestorCliente gestorClientes = new GestorCliente();


    private static void mostrarMenu() {
        System.out.println(""" 
        ===== MENÚ PRINCIPAL - Biblioteca LibrosYMas =====
        --- Gestión de Libros ---
        1. Registrar libro
        2. Listar libros
       --- Gestión de Clientes ---
        3. Registrar cliente
        5. Mostrar información de un cliente
        --- Préstamos y Devoluciones ---
        6. Registrar préstamo
        7. Registrar devolución
        0. Salir
        Seleccione una opción: 
        """);

    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Intente de nuevo.");
            return -1;
        }
    }

    private static void procesarOpcion(int opcion) {
        int opcionS = scanner.nextInt();
        switch (opcionS) {
            case 1:



                break;              // Johan
            case 2:
                System.out.println("ola");;
                break;    // Johan
            case 3:
                System.out.println("ola");
                break;
            case 4:
                System.out.println("ola");
                break;
            case 5:
                System.out.println("ola");
                break;
            case 6:
                System.out.println("ola");
                break;
            case 7:
                System.out.println("ola");
                break;
            case 0:
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }

    }

    public static void agregarCliente () {

    }
}
