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
import Gestores.Persistencia;

/**
 *
 * @author morde
 */
public class Seguimiento2 {

    private static Scanner scanner = new Scanner(System.in);
    private static GestorCliente gestorClientes;
    private static GestorLibros gestorLibros;
    private static Persistencia persistencia;

    public static void main(String[] args) {

        gestorClientes = new GestorCliente();
        gestorLibros = new GestorLibros(gestorClientes.getClientes());

        persistencia = new Persistencia();
        persistencia.cargarLibros(gestorLibros);
        persistencia.cargarClientes(gestorClientes, gestorLibros);
        System.out.println("Carpeta de datos: " + persistencia.getCarpeta());
        System.out.println("Libros cargados: " + gestorLibros.getLibros().size());
        System.out.println("Clientes cargados: " + gestorClientes.getClientes().size());

        mostrarMenuPrincipal();

        System.out.println("Saliendo del sistema. ¡Hasta luego!");
        scanner.close();
    }

    private static int leerInt(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero valido.");
            }
        }
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            if (!linea.isEmpty()) {
                return linea;
            }
            System.out.println("Este campo no puede estar vacio.");
        }
    }

    public static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("""
                           --- MENU PRINCIPAL ---
                           
                           1. Menu gestion clientes
                           2. Menu gestion libros
                           3. Menu de prestamos y devoluciones
                           0. Salir 
                           
                           """);
            opcion = leerInt("Seleccione una opción: ");
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
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida. ");
            }

        } while (opcion != 0);
    }

    public static void mostrarMenuCliente() {
        int opcion;
        do {
            System.out.println(""" 
               
                --- Gestión de Clientes ---
                           
                1. Registrar cliente
                2. Buscar cliente
                3. Mostrar Información de un Cliente
                4. Listar Lista de Clientes
                5. Ver total pendiente x cliente
                0. Volver
                              
                """);
            opcion = leerInt("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    mostrarInfoCliente();
                    break;
                case 3:
                    mostrarInfoCliente();
                    break;
                case 4:
                    gestorClientes.listarClientes();
                    break;
                case 5:
                    verTotalPendiente();
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

    }

    public static void agregarCliente() {
        int id = leerInt("Ingrese el ID: ");
        String nombre = leerTexto("Nombre: ");
        String telefono = leerTexto("Telefono: ");
        String direccion = leerTexto("Direccion: ");

        Cliente nuevoCliente = new Cliente(id, nombre, telefono, direccion);
        gestorClientes.registrarCliente(nuevoCliente);
        persistencia.guardarClientes(gestorClientes.getClientes());
    }

    public static void mostrarInfoCliente() {
        int id = leerInt("Ingrese el ID del cliente: ");
        if (gestorClientes.buscarCliente(id) == null) {
            System.out.println("No existe un cliente con ese ID.");
            return;
        }
        gestorClientes.mostrarInformacion(id);
    }

    public static void verTotalPendiente() {
        int id = leerInt("Ingrese el ID del cliente: ");
        Cliente c = gestorClientes.buscarCliente(id);
        if (c == null) {
            System.out.println("No existe un cliente con ese ID.");
            return;
        }
        System.out.println("El cliente tiene un total pendiente en multas de:" + c.getTotalPendiente());

    }

    public static void mostrarMenuLibros() {
        int opcion;
        do {
            System.out.println("""
                               --- Gestion de libros ---
                               
                               1. Registrar un libro nuevo.
                               2. Ver libros disponibles
                               3. Ver todos los libros
                               4. Buscar libro
                               5. Eliminar libro
                               0. Volver
                               
                               
                               """);
            opcion = leerInt("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    gestorLibros.listadoLibrosDisponibles();
                    break;
                case 3:
                    System.out.println(gestorLibros.toString());
                    break;
                case 4:
                    int id = leerInt("Ingresa el codigo del libro a buscar: ");
                    Libro encontrado = gestorLibros.buscarLibro(id);
                    if (encontrado == null) {
                        System.out.println("No existe un libro con ese codigo.");
                    } else {
                        System.out.println("Codigo: " + encontrado.getCodigoLibro());
                        System.out.println("Titulo: " + encontrado.getTitulo());
                        System.out.println("Autor: " + encontrado.getAutor());
                        System.out.println("Estado: " + encontrado.getEstado());
                    }
                    break;

                case 5:
                    int codigo = leerInt("Ingresa el codigo del libro: ");
                    String razon = leerTexto("Explique brevemente la razon por la que se retira del sistema: ");
                    gestorLibros.eliminarLibro(codigo, razon);
                    persistencia.guardarLibros(gestorLibros.getLibros());   // <-- NUEVO
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalidad");
                    break;
            }
        } while (opcion != 0);
    }

    public static void registrarLibro() {

        int codigo = leerInt("Ingresa el codigo del libro: ");
        String titulo = leerTexto("Ingresa el titulo de la obra: ");
        String autor = leerTexto("Autor del libro: ");
        String edit = leerTexto("Ingresa la editorial de la obra: ");
        int anioP = leerInt("Ingresa el año de publicacion: ");

        Categoria categoria = null;
        do {
            System.out.println("""
                           En que categoria se encuentra el libro: 
                           
                           1. Literatura
                           2. Ciencia
                           3. Historia
                           4. Tecnologia 
                           
                           """);
            int opcionCategoria = leerInt("Seleccione una categoria: ");

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
                    break;
            }
        } while (categoria == null);

        Libro libroAux = new Libro(codigo, titulo, autor, edit, anioP, categoria);

        gestorLibros.registrarLibro(libroAux);
        persistencia.guardarLibros(gestorLibros.getLibros());
    }

    public static void mostrarMenuPrestamo() {
        int opcion;
        do {
            System.out.println("""
                           ---Prestamos y Devoluciones---
                           
                           1. Realizar prestamo libro
                           2. Realizar devolucion libro
                           0. Volver
                           """);

            opcion = leerInt("Seleccione una opcion: ");
            switch (opcion) {
                case 1:
                    realizarPrestamo();
                    break;
                case 2:
                    registrarDevolucion();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
        } while (opcion != 0);

    }

    private static void realizarPrestamo() {
        int id = leerInt("Ingrese el id del cliente: ");
        int codigo = leerInt("Ingrese el codigo del libro: ");

        Cliente cliente = gestorClientes.buscarCliente(id);
        Libro libro = gestorLibros.buscarLibro(codigo);

        if (cliente == null) {
            System.out.println("Este cliente no se encuentra registrado en el sistema.");
            if (leerInt("1. Registrar cliente  |  Otro numero: volver -> ") == 1) {
                agregarCliente();
            }
            return;
        }
        if (libro == null) {
            System.out.println("Libro no registrado en el sistema.");
            if (leerInt("1. Registrar libro  |  Otro numero: volver -> ") == 1) {
                registrarLibro();
            }
            return;
        }
        Prestamo prestamo = new Prestamo(cliente, libro);
        prestamo.registrarPrestamo(cliente, libro);
        persistencia.guardarClientes(gestorClientes.getClientes());
        persistencia.guardarLibros(gestorLibros.getLibros());
    }

    public static void registrarDevolucion() {
        int id = leerInt("Ingrese el id del cliente: ");
        int codigo = leerInt("Ingrese el codigo del libro en el sistema: ");

        Cliente cliente = gestorClientes.buscarCliente(id);
        Libro libro = gestorLibros.buscarLibro(codigo);

        if (cliente == null) {
            System.out.println("Este cliente no se encuentra registrado en el sistema.");
            return;
        }
        if (libro == null) {
            System.out.println("Libro no registrado en el sistema.");
            return;
        }

        Prestamo prestamo = new Prestamo(cliente, libro);
        prestamo.registrarDevolucion(cliente, libro);
        persistencia.guardarClientes(gestorClientes.getClientes());
        persistencia.guardarLibros(gestorLibros.getLibros());
    }
}
