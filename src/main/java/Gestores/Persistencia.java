package Gestores;

import Modelos.Cliente;
import Modelos.Libro;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {
    private final Path carpeta;
    private final Path archivoLibros;
    private final Path archivoClientes;
    private final Path archivoPrestamos;

    public Persistencia() {
        String dir = System.getenv("DATA_DIR");
        if (dir == null || dir.isBlank()) {
            dir = "data";
        }
        carpeta = Paths.get(dir).toAbsolutePath();
        archivoLibros = carpeta.resolve("libros.txt");
        archivoClientes = carpeta.resolve("clientes.txt");
        archivoPrestamos = carpeta.resolve("prestamos.txt");
    }

    public Path getCarpeta() {
        return carpeta;
    }

    public void cargarLibros(GestorLibros gl) {
        for (String linea : leerLineas(archivoLibros)) {
            gl.getLibros().add(Libro.desdeLinea(linea));
        }
    }

    public void guardarLibros(List<Libro> libros) {
        List<String> lineas = new ArrayList<>();
        for (Libro l : libros) {
            lineas.add(l.aLinea());
        }
        escribirLineas(archivoLibros, lineas);
    }

    public void guardarClientes(List<Cliente> clientes) {
        List<String> lineas = new ArrayList<>();
        for (Cliente c : clientes) {
            lineas.add(c.aLinea());
        }
        escribirLineas(archivoClientes, lineas);
    }

    public void cargarClientes(GestorCliente gc, GestorLibros gl) {
        for (String linea : leerLineas(archivoClientes)) {
            gc.getClientes().add(Cliente.desdeLinea(linea, gl));
        }
    }

    private List<String> leerLineas(Path archivo) {
        if (Files.notExists(archivo)) {
            return new ArrayList<>();
        }
        try {
            List<String> lineas = new ArrayList<>();
            for (String linea : Files.readAllLines(archivo, StandardCharsets.UTF_8)) {
                if (!linea.isBlank()) {
                    lineas.add(linea.trim());
                }
            }
            return lineas;
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer " + archivo, e);
        }
    }

    private void escribirLineas(Path archivo, List<String> lineas) {
        try {
            Files.createDirectories(carpeta);
            Files.write(archivo, lineas, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo escribir " + archivo, e);
        }
    }
}
