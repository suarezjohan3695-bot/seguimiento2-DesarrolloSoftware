/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

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
    public String toString(){
        StringBuilder infoLibro = new StringBuilder();
        for(Libro lb : libros){
           //Informacion completa del libro en formato de texto 
        infoLibro.append("Codigo: ").append(lb.getCodigoLibro());
        infoLibro.append("Titulo obra: ").append(lb.getTitulo());
        infoLibro.append("Autor: ").append(lb.getAutor());
        infoLibro.append("Editorial: ").append(lb.getEditorial());
        infoLibro.append("año Publicacion: ").append(lb.getAnioPublicacion());
        infoLibro.append("Categoria: ").append(lb.getCategoria());
        infoLibro.append("Estado: ").append(lb.getEstado());
                }
       return infoLibro.toString();
        
    }
        
 // CRUD Libros
    
    public void registrarLibro(Libro aux) {
        for (Libro l : libros) {
            if (l.getCodigoLibro() == aux.getCodigoLibro()) {
                System.out.println("Libro ya existente, no se puede registrar");
            } else {
                Libro nuevo = new Libro(aux.getCodigoLibro(), aux.getTitulo(), aux.getAutor(), aux.getEditorial(),
                        aux.getAnioPublicacion(), aux.getEstado(), aux.getCategoria());

                libros.add(nuevo);

                System.out.println("Libro nuevo registrado con exito");
            }
        }
    }

    public Libro buscarLibro(int codigo) {
        for (Libro lb : libros) {
            if (codigo == lb.getCodigoLibro()) {
                return lb;
            }
        }
        return null;
    }
    public String listadoLibros(){
        String listaDisponible = null;
        for(Libro lb : libros){
            if(lb.getEstado().equals(Libro.Estado.Disponible)){
                listaDisponible = "Titulo: " + lb.getTitulo() + "\n";
                listaDisponible += "Codigo: " + lb.getCodigoLibro() + "\n";
                        
                
            }
        }
        return listaDisponible;
    }
    

}
