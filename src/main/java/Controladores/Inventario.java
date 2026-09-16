/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Libro;

import java.util.ArrayList;

/**
 *
 * @author morde
 */
public class Inventario {

    ArrayList<Libro> libros;

    public Inventario() {
        libros = new ArrayList<Libro>();
    }

    @Override
    public String toString() {
        StringBuilder infoLibro = new StringBuilder();
        for (Libro lb : libros) {
            //Informacion completa del libro en formato de texto 
            infoLibro.append("Codigo: ").append(lb.getCodigoLibro()).append("\n");
            infoLibro.append("Titulo obra: ").append(lb.getTitulo()).append("\n");
            infoLibro.append("Autor: ").append(lb.getAutor()).append("\n");
            infoLibro.append("Editorial: ").append(lb.getEditorial()).append("\n");
            infoLibro.append("año Publicacion: ").append(lb.getAnioPublicacion()).append("\n");
            infoLibro.append("Categoria: ").append(lb.getCategoria()).append("\n");
            infoLibro.append("Estado: ").append(lb.getEstado()).append("\n");
        }
        return infoLibro.toString();

    }

    // CRUD Libros
    public void registrarLibro(Libro aux) {
        
        Libro libro = buscarLibro(aux.getCodigoLibro());
        
            if (libro.getCodigoLibro() == aux.getCodigoLibro()) {
                System.out.println("Libro ya existente, no se puede registrar");
            } else {
                Libro nuevo = new Libro(aux.getCodigoLibro(), aux.getTitulo(),
                        aux.getAutor(), aux.getEditorial(),
                        aux.getAnioPublicacion(), aux.getEstado(), aux.getCategoria());

                libros.add(nuevo);

                System.out.println("Libro nuevo registrado con exito");
            }
        }
    

    public Libro buscarLibro(int codigo) {
        for (Libro lb : libros) {
            if (codigo == lb.getCodigoLibro()) {
                System.out.println("Estado: " + lb.getEstado());
                return lb;
            }
        }
        return null;
    }

    public String listadoLibrosDisponibles() {

        String listaDisponible = null;
        for (Libro lb : libros) {
            if (lb.getEstado().equals(Libro.Estado.Disponible)) {
                listaDisponible = "Titulo: " + lb.getTitulo() + "\n";
                listaDisponible += "Codigo: " + lb.getCodigoLibro() + "\n";

            }
        }
        return listaDisponible;
    }

    public void eliminarLibro(Libro libro) {
        Libro lb = buscarLibro(libro.getCodigoLibro());

        if (lb == null) {
            System.out.println("Este libro no existe en el sistema");
        }
        libros.remove(lb);
        System.out.println("Este libro ha sido eliminado del sistema por decision del admin.");

    }
}
