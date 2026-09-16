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
    private static GestorCliente gC;
    public static void main(String[] args) {

       gC = new GestorCliente();

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
        ===== MENÚ PRINCIPAL -  ====
       --- Gestión de Clientes ---
        1. Registrar cliente
        2. Buscar cliente
        3. Mosgtrar Información de un Cliente
        4. Listar Lista de Clientes
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

        switch (opcion) {
            case 1:
                agregarCliente();
                break;
            case 2:
                System.out.println("ola");;
                break;
            case 3:
                System.out.println("ola");
                break;
            case 4:
                System.out.println("ola");
                break;
            case 0:
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }

    }

    public static void agregarCliente () {
        System.out.println("Ingrese el ID");
        int id = scanner.nextInt();

        System.out.println("Nombre:");
        String nombre = scanner.next();

        System.out.println("Telefono:");
        String telefono = scanner.next();

        System.out.println("Dirección:");
        String direccion = scanner.next();

        Cliente nuevoCliente = new Cliente(id, nombre, telefono, direccion);
        gestorClientes.registrarCliente(nuevoCliente);
        gestorClientes.mostrarInformacion(id);


    }
}
