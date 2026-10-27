package Modelos;

import Gestores.GestorLibros;

public class Cliente {

    private int idCliente;
    private String nombreC;
    private String telefono;
    private String direccion;
    private boolean tieneLibro;
    private Libro libroPrestado;
    private double totalPendiente;
   

    public Cliente(int idCliente, String nombreC, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.nombreC = nombreC;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tieneLibro = false;
        this.libroPrestado = null;
        this.totalPendiente = 0;

    }

    public String aLinea() {
        String codigoLibro = (libroPrestado == null) ? "" : String.valueOf(libroPrestado.getCodigoLibro());
        return idCliente + ";" + nombreC + ";" + telefono + ";" + direccion + ";" + codigoLibro;
    }

    public static Cliente desdeLinea(String linea, GestorLibros gl) {
        String[] p = linea.split(";", -1);
        Cliente cliente = new Cliente(Integer.parseInt(p[0]), p[1], p[2], p[3]);
        if (!p[4].isEmpty()) {
            Libro libro = gl.buscarLibro(Integer.parseInt(p[4]));
            if (libro != null) {
                cliente.setLibroPrestado(libro);
                cliente.setTieneLibro(true);
            }
        }
        return cliente;
    }

    public void acumularMulta(double monto){
        double multaNueva = getTotalPendiente() + monto;
        setTotalPendiente(multaNueva);
    }
    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isTieneLibro() {
        return tieneLibro;
    }

    public void setTieneLibro(boolean tieneLibro) {
        this.tieneLibro = tieneLibro;
    }

    public Libro getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Libro libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    public double getTotalPendiente() {
        return totalPendiente;
    }

    public void setTotalPendiente(double totalPendiente) {
        this.totalPendiente = totalPendiente;
    }

    
}
