/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Controladores.Inventario;

/**
 *
 * @author morde
 */
public class Prestamo {

    private Cliente cliente;
    private Libro libro;

    public Prestamo(Cliente cliente, Libro libro) {
        this.cliente = cliente;
        this.libro = libro;
    }

    public void registrarPrestamo(Cliente cliente, Libro libro) {
        if (!cliente.isTieneLibro() && libro.getEstado().equals(Libro.Estado.Disponible)) {

            System.out.println("El cliente con id: " + cliente.getIdCliente()
                    + "Tiene prestado el libro con codigo " + libro.getCodigoLibro());

            cliente.setTieneLibro(true);
            cliente.setLibroPrestado(libro);
            libro.setEstado(Libro.Estado.Prestado);
        } else if (cliente.isTieneLibro()) {
            System.out.println("El cliente solo puede tener un libro prestado");

        } else{
            System.out.println("Este libro no esta disponible para prestar");
        }
    }
    
    public void registrarDevolucion(Cliente cliente, Libro libro){
        if(cliente.getLibroPrestado().getCodigoLibro() == libro.getCodigoLibro()){
            cliente.setTieneLibro(false);
            cliente.setLibroPrestado(null);
            libro.setEstado(Libro.Estado.Disponible);
            System.out.println("Libro devuelto con exito");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

}
