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
public class Libro {

    public enum Categoria {
        Literatura, Ciencia, Historia, Tecnologia
    };

    public enum Estado {
        Disponible, Prestado, Retirado
    };

    private int codigoLibro;
    private String Titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    private ArrayList<Cliente> reservas;

    private Estado estado = Estado.Disponible;
    private Categoria categoria;

    public Libro(int codigoLibro, String Titulo, String autor, String editorial, int anioPublicacion, Categoria categoria) {
        this.codigoLibro = codigoLibro;
        this.Titulo = Titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.categoria = categoria;
    }

    public String aLinea() {
        return codigoLibro + ";" + Titulo + ";" + autor + ";" + editorial + ";"
                + anioPublicacion + ";" + categoria + ";" + estado;
    }

    public static Libro desdeLinea(String linea) {
        String[] p = linea.split(";");
        Libro libro = new Libro(Integer.parseInt(p[0]), p[1], p[2], p[3],
                Integer.parseInt(p[4]), Categoria.valueOf(p[5]));
        libro.setEstado(Estado.valueOf(p[6]));
        return libro;
    }
    

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(int codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Cliente> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Cliente> reservas) {
        this.reservas = reservas;
    }
    

}
