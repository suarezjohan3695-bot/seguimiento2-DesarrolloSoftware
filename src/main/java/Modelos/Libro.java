/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author morde
 */
public class Libro {
    
    private String codigoLibro;
    private String Titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    public  enum Categoria {Literatura, Ciencia, Historia, Tecnologia};
    public enum Estado {Disponible, Prestado, Retirado};

    public Libro(String codigoLibro, String Titulo, String autor, String editoria, int anioPublicacion) {
        this.codigoLibro = codigoLibro;
        this.Titulo = Titulo;
        this.autor = autor;
        this.editorial = editoria;
        this.anioPublicacion = anioPublicacion;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
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

    public String getEditoria() {
        return editorial;
    }

    public void setEditoria(String editoria) {
        this.editorial = editoria;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    
    
}
