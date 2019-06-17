/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.clases;

/**
 *
 * @author 59398
 */
public class Texto {
     private String nombre;
    private int cantidad;
    /**
     * Constructor vacio
     */
    public Texto() {
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * ToString que imprime
     * @return 
     */
    @Override
    public String toString() {
        return "Palabras{" + "nombre=" + nombre + ", cantidad=" + cantidad + '}';
    } 
}

