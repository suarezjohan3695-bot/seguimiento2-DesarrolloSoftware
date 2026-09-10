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
    
    public  enum Categoria {Literatura, Ciencia, Historia, Tecnologia};
    public enum Estado {Disponible, Prestado, Retirado};
    
    private String codigoLibro;
    private String Titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    
    private Estado estado;
    private Categoria categoria;

    public Libro(String codigoLibro, String Titulo, String autor, String editorial, int anioPublicacion, Estado estado, Categoria categoria) {
        this.codigoLibro = codigoLibro;
        this.Titulo = Titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.estado = estado;
        this.categoria = categoria;
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
    
    

    
    
    
}
