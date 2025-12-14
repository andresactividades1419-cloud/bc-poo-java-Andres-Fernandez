package co.edu.sena.semana2;

import java.util.ArrayList;

public class Laboratorio {

    private String nombre;
    private ArrayList<OrdenExamen> ordenes;

    public Laboratorio(String nombre) {
        this.nombre = nombre;
        this.ordenes = new ArrayList<>();
    }

    public void agregarOrden(OrdenExamen orden) {
        ordenes.add(orden);
    }

    public void mostrarOrdenes() {
        for (OrdenExamen orden : ordenes) {
            System.out.println("----- ORDEN DE EXAMEN -----");
            System.out.println(orden.obtenerResumen());
            System.out.println("--------------------------");
        }
    }

    public int contarOrdenes() {
        return ordenes.size();
    }
}

