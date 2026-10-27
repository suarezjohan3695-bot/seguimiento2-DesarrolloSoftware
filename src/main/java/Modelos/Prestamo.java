/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Gestores.GestorLibros;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author morde
 */
public class Prestamo {
    
    private Cliente cliente;
    private Libro libro;
    private LocalDate fecha;
    private LocalDate fechaLimite;
    private double multa;
    
    public Prestamo(Cliente cliente, Libro libro) {
        this.cliente = cliente;
        this.libro = libro;
        this.fecha = LocalDate.now();
        this.fechaLimite = fecha.plusDays(8);
        this.multa = calcularMulta();
        
    }

    //La fecha en la que el cliente devuelve el libro, es igual a LocalDate.now();
    // 2000 COP es el valor que tiene cada dia extra sin devolver el libro.
    public double calcularMulta() {
        int dias = 0;
        if (LocalDate.now().isAfter(fechaLimite)) {
            dias = (int) ChronoUnit.DAYS.between(fechaLimite, LocalDate.now());            
        }
        double multa = dias * 2000;
        cliente.acumularMulta(multa);
        return multa;
    }
    
    public void registrarPrestamo(Cliente cliente, Libro libro) {
        if (!cliente.isTieneLibro() && libro.getEstado().equals(Libro.Estado.Disponible)) {
            
            System.out.println("El cliente con id: " + cliente.getIdCliente()
                    + ", tiene prestado el libro con codigo " + libro.getCodigoLibro() + ", con fecha: "
                    + fecha);
            
            cliente.setTieneLibro(true);
            cliente.setLibroPrestado(libro);
            libro.setEstado(Libro.Estado.Prestado);
        } else if (cliente.isTieneLibro()) {
            System.out.println("El cliente solo puede tener un libro prestado");
            
        } else {
            System.out.println("Este libro no esta disponible para prestar");
        }
    }
    
    public void registrarDevolucion(Cliente cliente, Libro libro) {
        
        if (libro.getEstado().equals(Libro.Estado.Disponible)) {
            System.out.println("Este libro no esta prestado");
        }
        if (cliente.getLibroPrestado().getCodigoLibro() != libro.getCodigoLibro()) {
            System.out.println("Este libro no lo tiene el cliente");
        }
        
        cliente.setTieneLibro(false);
        cliente.setLibroPrestado(null);
        libro.setEstado(Libro.Estado.Disponible);
        System.out.println("Libro devuelto con exito");
        
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
