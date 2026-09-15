package com.mycompany.seguimiento2;

import java.util.ArrayList;
import java.util.List;

public class GestorCliente {
    private Arraylist<Cliente> clientes;


    public void controladorCliente() {
        this.clientes = new Arraylist<Cliente>();
    }


    public Cliente buscarCliente(int documento) {
        for (Cliente aux : clientes) {
            if (aux.getIdCliente() == (documento)) {
                return aux;
            }
        }
        return null;
    }
}


