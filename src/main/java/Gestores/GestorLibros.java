/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Modelos.Libro;

import java.util.ArrayList;

/**
 *
 * @author morde
 */
public class GestorLibros {

    ArrayList<Libro> libros;

    public GestorLibros() {
        libros = new ArrayList<Libro>();
    }

    @Override
    public String toString() {

        if (libros == null || libros.isEmpty()) {
            return "SIN LIBROS";

        }
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

        if (libro != null) {
            System.out.println("LIBRO CON CODIGO: " + aux.getCodigoLibro() + " YA EXISTE");
            System.out.println("");

        } else {
            Libro nuevo = new Libro(aux.getCodigoLibro(), aux.getTitulo(),
                    aux.getAutor(), aux.getEditorial(),
                    aux.getAnioPublicacion(), aux.getCategoria());

            libros.add(nuevo);
            System.out.println("LIBRO NUEVO CON CODIGO: " + nuevo.getCodigoLibro() + " REGISTRADO");
            System.out.println("");

        }
    }

    public Libro buscarLibro(int codigo) {
        for (Libro lb : libros) {
            if (codigo == lb.getCodigoLibro()) {
                System.out.println(toString());
                return lb;
            }
        }
        return null;
    }

    public void listadoLibrosDisponibles() {

        String listaDisponible = "Sin libros disponibles";

        if (libros == null || libros.isEmpty()) {
            System.out.println("Ningun libro registrado");
        }
        for (Libro lb : libros) {
            if (lb.getEstado().equals(Libro.Estado.Disponible)) {
                listaDisponible = "Titulo: " + lb.getTitulo() + "\n";
                listaDisponible += "Codigo: " + lb.getCodigoLibro() + "\n";

            }
        }

        System.out.println(listaDisponible);
        System.out.println("");
    }

    public void eliminarLibro(int codigo, String razon) {
        Libro lb = buscarLibro(codigo);

        if (lb == null) {
            System.out.println("Este libro no existe en el sistema");
        }
        lb.setEstado(Libro.Estado.Retirado);
        
        System.out.println("Este libro ha sido retirado del sistema por " + razon);

    }
}
