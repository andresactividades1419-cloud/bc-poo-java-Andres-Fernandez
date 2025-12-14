package co.edu.sena.semana2;

public class Examen {

    private String nombre;
    private double precio;
    private String tipo;

    public Examen(String nombre, double precio, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String obtenerInformacion() {
        return "Examen: " + nombre +
                " | Tipo: " + tipo +
                " | Precio: $" + precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }
}

