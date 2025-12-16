package co.edu.sena.semana3;

/**
 * Clase que representa el laboratorio Diagnóstico Plus
 */
public class Laboratorio {
    private String nombre;
    private String direccion;
    private String telefono;
    private int capacidadPacientesDiarios;
    private int numeroBacteriologos;
    private String horarioAtencion;
    private boolean activo;

    // Constructor completo
    public Laboratorio(String nombre, String direccion, String telefono,
                       int capacidadPacientesDiarios, int numeroBacteriologos,
                       String horarioAtencion, boolean activo) {
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setCapacidadPacientesDiarios(capacidadPacientesDiarios);
        setNumeroBacteriologos(numeroBacteriologos);
        setHorarioAtencion(horarioAtencion);
        setActivo(activo);
    }

    // Constructor básico
    public Laboratorio(String nombre, String direccion) {
        this(nombre, direccion, "601-1234567", 150, 10, "7:00 AM - 7:00 PM", true);
    }

    // Constructor mínimo
    public Laboratorio() {
        this("Diagnóstico Plus", "Calle 72 # 12-34, Chapinero, Bogotá");
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public int getCapacidadPacientesDiarios() { return capacidadPacientesDiarios; }
    public int getNumeroBacteriologos() { return numeroBacteriologos; }
    public String getHorarioAtencion() { return horarioAtencion; }
    public boolean isActivo() { return activo; }

    // Setters con validación
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("Dirección no puede estar vacía");
        }
        this.direccion = direccion.trim();
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !validarTelefono(telefono)) {
            throw new IllegalArgumentException("Teléfono inválido");
        }
        this.telefono = telefono;
    }

    public void setCapacidadPacientesDiarios(int capacidad) {
        if (capacidad < 0 || capacidad > 1000) {
            throw new IllegalArgumentException("Capacidad inválida (0-1000 pacientes)");
        }
        this.capacidadPacientesDiarios = capacidad;
    }

    public void setNumeroBacteriologos(int numero) {
        if (numero < 0 || numero > 100) {
            throw new IllegalArgumentException("Número de bacteriólogos inválido (0-100)");
        }
        this.numeroBacteriologos = numero;
    }

    public void setHorarioAtencion(String horario) {
        if (horario == null || horario.trim().isEmpty()) {
            throw new IllegalArgumentException("Horario no puede estar vacío");
        }
        this.horarioAtencion = horario.trim();
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Métodos privados auxiliares
    private boolean validarTelefono(String telefono) {
        return telefono.matches("[0-9-]{7,15}");
    }

    // Métodos públicos
    public String obtenerInformacionCompleta() {
        return nombre + "\n" +
                "Dirección: " + direccion + "\n" +
                "Teléfono: " + telefono + "\n" +
                "Horario: " + horarioAtencion + "\n" +
                "Capacidad: " + capacidadPacientesDiarios + " pacientes/día\n" +
                "Bacteriólogos: " + numeroBacteriologos + "\n" +
                "Estado: " + (activo ? "Abierto" : "Cerrado");
    }

    // Calcular capacidad disponible
    public int calcularCapacidadDisponible(int pacientesAtendidos) {
        if (pacientesAtendidos < 0) {
            throw new IllegalArgumentException("Pacientes atendidos no puede ser negativo");
        }
        int disponible = capacidadPacientesDiarios - pacientesAtendidos;
        return Math.max(disponible, 0);
    }
}