/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.clases.Texto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author QuezadaBryam
 */
public class ControladorTextoIngresado {

    String ruta = "archivito.txt";
    private String linea;
    private List<Texto> lista;

    public ControladorTextoIngresado() {
        lista = new ArrayList<>();
    }

    //metodo implementado para la escritura del archivo
    public void Escritura(String palabra) throws IOException {
        try {
            FileWriter archivo = new FileWriter(ruta, true);

            BufferedWriter escritura = new BufferedWriter(archivo);
            escritura.append(palabra);
            escritura.newLine();

            escritura.append(palabra);

            escritura.close();
            archivo.close();
        } catch (IOException ex) {
            System.out.println("\n" + "Error al escribir");
        }

    }
    //metodo implementado para la lectura del archivos
    public void Lectura() {
        try {

            FileReader archivo = new FileReader(ruta);
            BufferedReader lectura = new BufferedReader(archivo);
            String linea = " ";

            while (linea != null) {
                linea = lectura.readLine();
                if (linea != null) {
                    System.out.println(linea);
                }

            }

        } catch (FileNotFoundException ex1) {
            System.out.println("Archivo " + ruta + "no encontrada");
        } catch (IOException ex) {
            System.out.println("error al leer");
        }
    }

    //metodo implementado para la lectura de linea
    private void leerLinea() {
        String palabras[] = linea.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            compararPalabra(palabras[i].toLowerCase());
        }

    }
    
    //metodo que compara las palabras repetidas
    private void compararPalabra(String palabra) {
        int con = 0;
        for (Texto palabralista : lista) {
            if (palabralista.getNombre().equals(palabra)) {
                palabralista.setCantidad(palabralista.getCantidad() + 1);
                con = 1;
                break;
            }
        }
        if (con == 0) {
            Texto newPalabra = new Texto();
            newPalabra.setNombre(palabra);
            newPalabra.setCantidad(1);
            lista.add(newPalabra);
        }
    }

    //metodo que guarda el resultado
    public void guardaResultado() throws IOException {
        Collections.sort(lista, new Comparator<Texto>() {
            public int compare(Texto p1, Texto p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });
        try {
            String ruta2 = "Resultado.txt";
            FileWriter archivo = new FileWriter(ruta2, false);

            BufferedWriter escritura = new BufferedWriter(archivo);
            for (Texto palabraEscribir : lista) {
                escritura.append(palabraEscribir.getNombre() + "   veces repetidas:" + palabraEscribir.getCantidad());
                escritura.newLine();
            }

            escritura.close();
            archivo.close();

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Error de Escritura");
        }
    }

    public void LecturaResultado(String ruta1) throws IOException {
        linea = "";
        try {
            FileReader archivo = new FileReader(ruta1);
            BufferedReader lectura = new BufferedReader(archivo);
            while (linea != null) {
                linea = lectura.readLine();
                if (linea != null) {
                    leerLinea();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe");
        } catch (IOException e) {
            System.out.println("Error al momento de escribir");
        }

    }
}
