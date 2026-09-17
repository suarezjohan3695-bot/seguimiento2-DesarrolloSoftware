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
    private static Scanner scanner = new Scanner(System.in);
    private static GestorCliente gestorClientes = new GestorCliente();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();

        } while (!scanner.hasNextInt());

        System.out.println("Saliendo del sistema. ¡Hasta luego!");
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println(""" 
                ===== MENÚ PRINCIPAL ====
                --- Gestión de Clientes ---
                1. Registrar cliente
                2. Buscar cliente
                3. Mostrar Información de un Cliente
                4. Listar Lista de Clientes
                0. Salir
                Seleccione una opción: 
                """);
        int opcion = scanner.nextInt();


    switch (opcion) {
        case 1:
            agregarCliente();
            break;
        case 2:
            buscarClienteMenu();
            break;
        case 3:
            mostrarInfoCliente();
            break;
        case 4:
            gestorClientes.listarClientes();
            break;
        case 0:
            break;
        default:
            System.out.println("Opción no válida. Intente de nuevo.");
    }


    }
    
    public static void agregarCliente() {
        System.out.println("Ingrese el ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Teléfono:");
        String telefono = scanner.nextLine();

        System.out.println("Dirección:");
        String direccion = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(id, nombre, telefono, direccion);
        gestorClientes.registrarCliente(nuevoCliente);
        do {
            System.out.println("""
                    
                    """);
            System.out.println("""
                    1. Volver al menu
                    2. Menu Libros
                    
                    """);
            if (scanner.nextInt() == 1) {
                mostrarMenu();
            } else if (scanner.nextInt() == 2) {
                System.out.println("FALTA AQUI");
            } else {
                System.out.println("Ingresa un valor valido");
            }
        }while(scanner.nextInt() != 1 || scanner.nextInt() != 2);

    }

    public static void buscarClienteMenu() {
        System.out.println("Ingrese el ID que quiere buscar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        gestorClientes.mostrarInformacion(id);
        do {
            System.out.println("""
                    
                    """);
            System.out.println("""
                    1. Volver al menu
                    2. Menu Libros
                    
                    """);
            if (scanner.nextInt() == 1) {
                mostrarMenu();
            } else if (scanner.nextInt() == 2) {
                System.out.println("FALTA AQUI");
            } else {
                System.out.println("Ingresa un valor valido");
            }
        }while(scanner.nextInt() != 1 || scanner.nextInt() != 2);
    }

    public static void mostrarInfoCliente() {
        System.out.println("Ingrese el ID del cliente:");
        int id = scanner.nextInt();
        scanner.nextLine();

        gestorClientes.mostrarInformacion(id);
        do {
            System.out.println("""
                    
                    """);
            System.out.println("""
                    1. Volver al menu
                    2. Menu Libros
                    
                    """);
            if (scanner.nextInt() == 1) {
                mostrarMenu();
            } else if (scanner.nextInt() == 2) {
                System.out.println("FALTA AQUI");
            } else {
                System.out.println("Ingresa un valor valido");
            }
        }while(scanner.nextInt() != 1 || scanner.nextInt() != 2);
    }
}
