package co.edu.sena.semana3;

/**
 * Clase que representa un examen de laboratorio
 */
public class Examen {
    private String codigoExamen;
    private String nombre;
    private String tipo;
    private double costo;
    private String descripcion;
    private int tiempoResultado; // en horas
    private String categoria;

    // Constructor completo
    public Examen(String codigoExamen, String nombre, String tipo, double costo,
                  String descripcion, int tiempoResultado, String categoria) {
        setCodigoExamen(codigoExamen);
        setNombre(nombre);
        setTipo(tipo);
        setCosto(costo);
        setDescripcion(descripcion);
        setTiempoResultado(tiempoResultado);
        setCategoria(categoria);
    }

    // Constructor básico
    public Examen(String codigoExamen, String nombre, String tipo, double costo) {
        this(codigoExamen, nombre, tipo, costo, "Sin descripción", 24, "General");
    }

    // Constructor mínimo
    public Examen(String codigoExamen) {
        this(codigoExamen, "Examen nuevo", "Sangre", 0.0);
    }

    // Getters
    public String getCodigoExamen() { return codigoExamen; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getCosto() { return costo; }
    public String getDescripcion() { return descripcion; }
    public int getTiempoResultado() { return tiempoResultado; }
    public String getCategoria() { return categoria; }

    // Setters con validación
    public void setCodigoExamen(String codigoExamen) {
        if (!validarCodigoExamen(codigoExamen)) {
            throw new IllegalArgumentException("Código de examen inválido");
        }
        this.codigoExamen = codigoExamen;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo no puede estar vacío");
        }
        this.tipo = tipo.trim();
    }

    public void setCosto(double costo) {
        if (costo < 0) {
            throw new IllegalArgumentException("Costo no puede ser negativo");
        }
        this.costo = costo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion != null ? descripcion.trim() : "Sin descripción";
    }

    public void setTiempoResultado(int tiempoResultado) {
        if (tiempoResultado < 1 || tiempoResultado > 168) {
            throw new IllegalArgumentException("Tiempo de resultado inválido (1-168 horas)");
        }
        this.tiempoResultado = tiempoResultado;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoría no puede estar vacía");
        }
        this.categoria = categoria.trim();
    }

    // Métodos privados auxiliares
    private boolean validarCodigoExamen(String codigo) {
        return codigo != null && codigo.matches("[A-Z]{3}-[0-9]{3}");
    }

    // Método público para mostrar información
    public String mostrarInformacion() {
        return "[" + codigoExamen + "] " + nombre + " - $" + costo + " - " + tiempoResultado + " horas";
    }

    // Método para calcular costo con descuento
    public double calcularCostoConDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("Porcentaje de descuento inválido");
        }
        return costo * (1 - porcentajeDescuento / 100);
    }
}