/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package main;

import Gestores.GestorCliente;
import Gestores.GestorLibros;
import Modelos.Cliente;
import Modelos.Libro;
import Modelos.Libro.Categoria;
import Modelos.Prestamo;

import java.util.Scanner;

/**
 *
 * @author morde
 */
public class Seguimiento2 {

    private static Scanner scanner = new Scanner(System.in);
    private static GestorCliente gestorClientes;
    private static GestorLibros gestorLibros;
    private static Prestamo prestamo;

    public static void main(String[] args) {

        gestorClientes = new GestorCliente();
        gestorLibros = new GestorLibros();


        do {
            mostrarMenuPrincipal();

        } while (!scanner.hasNextInt());

        System.out.println("Saliendo del sistema. ¡Hasta luego!");
        scanner.close();
    }

    public static void mostrarMenuPrincipal() {
        do {
            System.out.println("""
                           --- MENU PRINCIPAL ---
                           
                           1. Menu gestion clientes
                           2. Menu gestion libros
                           3. Menu de prestamos y devoluciones
                           
                           """);
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    mostrarMenuCliente();
                    break;
                case 2:
                    mostrarMenuLibros();
                    break;
                case 3:
                    mostrarMenuPrestamo();
                    break;
                default:
                    System.out.println("Opcion invalida. ");
            }

        } while (!scanner.hasNextInt());
    }

    public static void mostrarMenuCliente() {
        do {
            System.out.println(""" 
               
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
                    scanner.next();
                    break;
            }
        } while (!scanner.hasNextInt());

    }

    public static void mostrarDiferentesMenus() {
        do {

            System.out.println("""
                    1. Menu Clientes
                    2. Menu Libros
                    3. Menu Prestamo                                     
                               """);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarMenuCliente();
                    break;
                case 2:
                    mostrarMenuLibros();
                    break;
                case 3:
                    mostrarMenuPrestamo();
                    break;
                default:
                    System.out.println("Opcion invalida");
                    scanner.next();
                    break;

            }
        } while (!scanner.hasNextInt());

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
        System.out.println("");

        mostrarDiferentesMenus();

    }

    public static void buscarClienteMenu() {
        System.out.println("Ingrese el ID que quiere buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        gestorClientes.mostrarInformacion(id);
        mostrarDiferentesMenus();
    }

    public static void mostrarInfoCliente() {
        System.out.println("Ingrese el ID del cliente:");
        int id = scanner.nextInt();
        scanner.nextLine();

        gestorClientes.mostrarInformacion(id);
        mostrarDiferentesMenus();
    }

    public static void mostrarMenuLibros() {

        do {
            System.out.println("""
                               --- Gestion de libros ---
                               
                               1. Registrar un libro nuevo.
                               2. Ver libros disponibles
                               3. Ver todos los libros
                               4. Buscar libro
                               5. Eliminar libro
                               
                               
                               """);

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;

                case 2:
                    gestorLibros.listadoLibrosDisponibles();
                    mostrarMenuPregunta();
                    break;

                case 3:
                    System.out.println(gestorLibros.toString());
                    mostrarMenuPregunta();
                    break;

                case 4:
                    System.out.println("Ingresa el codigo del libro a buscar: ");
                    int id = scanner.nextInt();
                    gestorLibros.buscarLibro(id);
                    mostrarMenuPregunta();
                    break;

                case 5:
                    System.out.println("Ingresa el codigo del libro: ");
                    int codigo = scanner.nextInt();
                    scanner.next();
                    System.out.println("Explique brevemente la razon del porque se retira del sistema: ");
                    String razon = scanner.nextLine();
                    gestorLibros.eliminarLibro(codigo, razon);
                    mostrarMenuPregunta();
                default:
                    System.out.println("Opcion invalidad");
                    scanner.next();

            }
        } while (!scanner.hasNextInt());
    }

    public static void mostrarMenuPregunta() {
        do {
            System.out.println("""
                               Que quieres hacer? 
                               
                               1. Menu Clientes
                               2. Volver menu libros
                               3. Realizar un prestamo
                               4. Salir
                               
                               """);

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    mostrarMenuCliente();
                    break;
                case 2:
                    mostrarMenuLibros();
                    break;
                case 3:
                    mostrarMenuPrestamo();
                    break;
                case 4:
                    scanner.close();
                    break;
                default:
                    System.out.println("Opcion invalida. Ingresa un valor del 1 al 3");
                    scanner.next();
                    break;

            }
        } while (!scanner.hasNextInt());
    }

    public static void registrarLibro() {

        System.out.println("Ingresa el codigo del libro: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingresa el Titulo de la obra: ");
        String titulo = scanner.nextLine();
        System.out.println("Autor del libro: ");
        String Autor = scanner.nextLine();
        System.out.println("Ingresa la editorial de la obra: ");
        String edit = scanner.nextLine();
        System.out.println("Ingresa el año de publicacion: ");
        int anioP = scanner.nextInt();
        scanner.nextLine();
        Categoria categoria = null;
        do {
            System.out.println("""
                           En que categoria se encuentra el libro: 
                           
                           1. Literatura
                           2. Ciencia
                           3. Historia
                           4. Tecnologia 
                           
                           """);
            int opcionCategoria = scanner.nextInt();

            switch (opcionCategoria) {
                case 1:
                    categoria = Categoria.Literatura;
                    break;
                case 2:
                    categoria = Categoria.Ciencia;
                    break;
                case 3:
                    categoria = Categoria.Historia;
                    break;
                case 4:
                    categoria = Categoria.Tecnologia;
                    break;
                default:
                    System.out.println("NO es una categoria valida");
                    scanner.next();
            }
        } while (categoria == null);

        Libro libroAux = new Libro(codigo, titulo, Autor, edit, anioP, categoria);

        gestorLibros.registrarLibro(libroAux);

        mostrarMenuPregunta();

    }

    public static void mostrarMenuPrestamo() {
        System.out.println("""
                           ---Prestamos y Devoluciones---
                           
                           1. Realizar prestamo libro
                           2. Realizar devolucion libro
                           3. menu principal
                           4. Salir
                           """);

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                realizarPrestamo();
                break;
            case 2:
                registrarDevolucion();
                break;
            case 3:
                mostrarMenuPrincipal();
                break;
            case 4:
                scanner.close();
                break;
            default:
                System.out.println("Opcion Invalida");
                scanner.next();
                break;

        }
    }

    private static void realizarPrestamo() {
        System.out.println("Ingrese el id del cliente: ");
        int id = scanner.nextInt();
        System.out.println("Ingrese el codigo del libro: ");
        int codigo = scanner.nextInt();

        Cliente cliente = gestorClientes.buscarCliente(id);
        Libro libro = gestorLibros.buscarLibro(codigo);

        if (cliente == null) {
            System.out.println("Este cliente no se encuentra registrado en el sistema");
            System.out.println("""
                               1. registrar cliente
                               2. Realizar nuevo prestamo
                               """);
            int opc = scanner.nextInt();
            if (opc == 1) {
                agregarCliente();
            } else if (opc == 2) {
                realizarPrestamo();
            } else {
                mostrarMenuPrestamo();
            }

        }
        if (libro == null) {
            System.out.println("Libro no registrado: ");
            System.out.println("""
                               1. registrar libro
                               2. Realizar nuevo prestamo
                               """);
            int opc = scanner.nextInt();
            if (opc == 1) {
                registrarLibro();
            } else if (opc == 2) {
                realizarPrestamo();
            } else {
                mostrarMenuPrestamo();
            }

        }
prestamo = new Prestamo(cliente, libro);
        prestamo.registrarPrestamo(cliente, libro);
        System.out.println("");
        mostrarDiferentesMenus();
    }

    public static void registrarDevolucion() {
        System.out.println("Ingrese el id del cliente: ");
        int id = scanner.nextInt();
        System.out.println("Ingrese el codigo del libro en el sistema: ");
        int codigo = scanner.nextInt();

        Cliente cliente = gestorClientes.buscarCliente(id);
        Libro libro = gestorLibros.buscarLibro(codigo);

        if (cliente == null) {
            System.out.println("Este cliente no se encuentra registrado en el sistema");
            System.out.println("""
                               1. registrar cliente
                               2. Realizar nuevo prestamo
                               """);
            int opc = scanner.nextInt();
            if (opc == 1) {
                agregarCliente();
            } else if (opc == 2) {
                realizarPrestamo();
            } else {
                mostrarMenuPrestamo();
            }

        }
        if (libro == null) {
            System.out.println("Libro no registrado en el sistema: ");
            System.out.println("""
                               1. registrar libro
                               2. Realizar nuevo prestamo
                               """);
            int opc = scanner.nextInt();
            if (opc == 1) {
                registrarLibro();
            } else if (opc == 2) {
                realizarPrestamo();
            } else {
                mostrarMenuPrestamo();
            }

        }
        prestamo.registrarDevolucion(cliente, libro);
        System.out.println("");
        mostrarDiferentesMenus();

    }
}
