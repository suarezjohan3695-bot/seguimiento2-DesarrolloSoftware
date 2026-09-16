package Modelos;

public class Cliente {

    private int idCliente;
    private String nombreC;
    private String telefono;
    private String direccion;
    private boolean tieneLibro = false;
    private Libro libroPrestado = null;

    public Cliente(int idCliente, String nombreC, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.nombreC = nombreC;
        this.telefono = telefono;
        this.direccion = direccion;

    }

   

    public void mostrarInformacion() {
        System.out.println("Documento:" + idCliente);
        System.out.println("Nombre Cliente:" + nombreC);
        System.out.println("Telefono:" + telefono);
        System.out.println("Direccion:" + direccion);
        System.out.println("¿Tiene libro?" + ((tieneLibro) ? "Si" : "No"));
    }

    public void DeterminarLibroPrestado() {
        if (!tieneLibro ) {
            libroPrestado = null;
        }
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

}
