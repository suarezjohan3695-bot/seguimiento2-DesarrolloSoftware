package com.mycompany.seguimiento2;
import java.util.List;

public class GestorCliente {
    private Arraylist<Cliente> clientes;


    public void controladorCliente() {
        this.clientes = new Arraylist<Cliente>();
    }


    public Cliente buscarCliente(int documento) {
        for (Cliente aux : clientes) {
            if (aux.getIdCliente() == (documento)) {
                return aux;
            }
        }
        return null;
    }

    public boolean registrarCliente(int idCliente, String nombreC, String telefono, String direccion, boolean tieneLibro) {
        if (buscarCliente(idCliente) != null) {
            System.out.println("Ya existe un cliente registrado con ese documento.");
            return false;
        }
        Cliente nuevoCliente = new Cliente(idCliente, nombreC, telefono, direccion, tieneLibro);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado exitosamente.");
        return true;
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("----- Lista de Clientes -----");
        for (Cliente c : clientes) {
            c.mostrarInformacion();
            System.out.println("------------------------------");
        }
    }

    public boolean existeCliente(int idCliente) {
        return buscarCliente(idCliente) != null;
    }

    public boolean puedeRecibirPrestamo(int idCliente) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("El cliente no está registrado en el sistema.");
            return false;
        }
        if (cliente.isTieneLibro()) {
            System.out.println("El cliente ya tiene un libro prestado.");
            return false;
        }
        return true;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

}


