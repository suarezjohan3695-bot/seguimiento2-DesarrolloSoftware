public class Cliente {
    private int idCliente;
    private String nombreC;
    private String telefono;
    private String direccion;
    private boolean tieneLibro;

    public Cliente() {
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

    public void marcarPrestamo(){
        if(tieneLibro) {
            System.out.println("El cliente ya cuenta con un libro");
            return;
        }
        this.tieneLibro = true;
    }

    public void registrarDevolucion(){
        if(tieneLibro) {
            System.out.println("El cliente no tiene libro");
        }
        this.tieneLibro=false;
    }


    public void informacionCliente (){

    }
}
