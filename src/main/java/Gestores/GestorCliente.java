package Gestores;
import Modelos.Cliente;

import java.util.ArrayList;
import java.util.List;

public class GestorCliente {

    private ArrayList<Cliente> clientes;


    public GestorCliente() {
        this.clientes = new ArrayList<Cliente>();
    }

    public Cliente buscarCliente(int documento) {
        for (Cliente aux : clientes) {
            if (aux.getIdCliente() == documento) {
                return aux;
            }
        }
        return null;
    }

    public boolean registrarCliente(Cliente aux) {
        if (buscarCliente(aux.getIdCliente()) != null) {
            System.out.println("Ya existe un cliente registrado con ese documento.");
            return false;
        }
        Cliente nuevoCliente = new Cliente(aux.getIdCliente(), aux.getNombreC(), aux.getTelefono(), aux.getDireccion());
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
            mostrarInformacion(c.getIdCliente());
            System.out.println("------------------------------");
        }

    }

    public void mostrarInformacion (int idCliente){
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null){
            System.out.println("Documento:" + cliente.getIdCliente());
            System.out.println("Nombre Cliente:" + cliente.getNombreC());
            System.out.println("Telefono:" + cliente.getTelefono());
            System.out.println("Direccion:" +cliente.getDireccion());
            System.out.println("¿Tiene libro?" + (cliente.isTieneLibro()? "Si" : "No"));
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

}


