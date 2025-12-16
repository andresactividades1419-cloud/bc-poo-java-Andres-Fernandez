package co.edu.sena.semana3;

/**
 * Clase que representa una orden de examen médico
 */
public class OrdenExamen {
    private String numeroOrden;
    private Paciente paciente;
    private Examen examen;
    private String fechaOrden;
    private String medicoSolicitante;
    private String estado;
    private String observaciones;

    // Constructor completo
    public OrdenExamen(String numeroOrden, Paciente paciente, Examen examen,
                       String fechaOrden, String medicoSolicitante, String estado,
                       String observaciones) {
        setNumeroOrden(numeroOrden);
        setPaciente(paciente);
        setExamen(examen);
        setFechaOrden(fechaOrden);
        setMedicoSolicitante(medicoSolicitante);
        setEstado(estado);
        setObservaciones(observaciones);
    }

    // Constructor básico
    public OrdenExamen(String numeroOrden, Paciente paciente, Examen examen) {
        this(numeroOrden, paciente, examen, "Sin fecha", "Sin médico", "Pendiente",
                "Sin observaciones");
    }

    // Constructor con fecha
    public OrdenExamen(String numeroOrden, Paciente paciente, Examen examen, String fechaOrden) {
        this(numeroOrden, paciente, examen, fechaOrden, "Sin médico", "Pendiente",
                "Sin observaciones");
    }

    // Getters
    public String getNumeroOrden() { return numeroOrden; }
    public Paciente getPaciente() { return paciente; }
    public Examen getExamen() { return examen; }
    public String getFechaOrden() { return fechaOrden; }
    public String getMedicoSolicitante() { return medicoSolicitante; }
    public String getEstado() { return estado; }
    public String getObservaciones() { return observaciones; }

    // Setters con validación
    public void setNumeroOrden(String numeroOrden) {
        if (!validarNumeroOrden(numeroOrden)) {
            throw new IllegalArgumentException("Número de orden inválido");
        }
        this.numeroOrden = numeroOrden;
    }

    public void setPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente no puede ser nulo");
        }
        this.paciente = paciente;
    }

    public void setExamen(Examen examen) {
        if (examen == null) {
            throw new IllegalArgumentException("Examen no puede ser nulo");
        }
        this.examen = examen;
    }

    public void setFechaOrden(String fechaOrden) {
        if (fechaOrden == null || fechaOrden.trim().isEmpty()) {
            throw new IllegalArgumentException("Fecha no puede estar vacía");
        }
        this.fechaOrden = fechaOrden.trim();
    }

    public void setMedicoSolicitante(String medicoSolicitante) {
        if (medicoSolicitante == null || medicoSolicitante.trim().isEmpty()) {
            throw new IllegalArgumentException("Médico solicitante no puede estar vacío");
        }
        this.medicoSolicitante = medicoSolicitante.trim();
    }

    public void setEstado(String estado) {
        if (!validarEstado(estado)) {
            throw new IllegalArgumentException("Estado inválido");
        }
        this.estado = estado;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones != null ? observaciones.trim() : "Sin observaciones";
    }

    // Métodos privados auxiliares
    private boolean validarNumeroOrden(String numero) {
        return numero != null && numero.matches("ORD-[0-9]{6}");
    }

    private boolean validarEstado(String estado) {
        return estado != null && (estado.equals("Pendiente") ||
                estado.equals("Procesando") ||
                estado.equals("Completado") ||
                estado.equals("Cancelado"));
    }

    // Métodos públicos
    public String generarResumen() {
        return "Orden #" + numeroOrden + "\n" +
                "Paciente: " + paciente.getNombre() + "\n" +
                "Examen: " + examen.getNombre() + "\n" +
                "Costo: $" + examen.getCosto() + "\n" +
                "Estado: " + estado + "\n" +
                "Fecha: " + fechaOrden;
    }

    // Cambiar estado de la orden
    public void cambiarEstado(String nuevoEstado) {
        setEstado(nuevoEstado);
    }

    // Calcular fecha estimada de resultado
    public String calcularFechaResultado() {
        // Lógica simple: agregar horas del tiempo de resultado
        return fechaOrden + " + " + examen.getTiempoResultado() + " horas";
    }
}
