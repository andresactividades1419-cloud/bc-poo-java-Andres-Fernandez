package co.edu.sena.semana2;

/**
 * Clase que representa un Bacteriólogo en el Laboratorio Clínico Diagnóstico Plus
 * @author Andres Fernandez
 * @version 1.0
 */
public class Bacteriologo {
    // Atributos privados (4 mínimo)
    private String codigoBacteriologo;
    private String nombreCompleto;
    private String especialidad;
    private int pacientesAtendidos;
    private boolean disponible;
    private int aniosExperiencia;

    // Constructor
    public Bacteriologo(String codigoBacteriologo, String nombreCompleto,
                        String especialidad, int aniosExperiencia) {
        this.codigoBacteriologo = codigoBacteriologo;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.pacientesAtendidos = 0;
        this.disponible = true;
    }

    // Método void que imprime información
    public void mostrarDatos() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("       INFORMACIÓN DEL BACTERIÓLOGO");
        System.out.println("═══════════════════════════════════════");
        System.out.println("Código: " + codigoBacteriologo);
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Años de Experiencia: " + aniosExperiencia);
        System.out.println("Pacientes Atendidos Hoy: " + pacientesAtendidos);
        System.out.println("Estado: " + (disponible ? "DISPONIBLE" : "OCUPADO"));
        System.out.println("═══════════════════════════════════════\n");
    }

    // Método que registra atención a un paciente
    public void atenderPaciente(String nombrePaciente) {
        if (!disponible) {
            System.out.println("✗ El bacteriólogo está ocupado en este momento");
            return;
        }
        pacientesAtendidos++;
        System.out.println("✓ Bacteriólogo " + nombreCompleto +
                " está atendiendo a " + nombrePaciente);
        System.out.println("  Total atendidos hoy: " + pacientesAtendidos);
    }

    // Método que retorna si es bacteriólogo senior
    public boolean esSenior() {
        return aniosExperiencia >= 10;
    }

    // Método que calcula tarifa por examen según experiencia
    public double calcularTarifaPorExamen() {
        final double TARIFA_BASE = 50000.0;
        final double INCREMENTO_POR_ANIO = 5000.0;

        return TARIFA_BASE + (aniosExperiencia * INCREMENTO_POR_ANIO);
    }

    // Método adicional: reiniciar contador de pacientes (fin del día)
    public void reiniciarContadorDiario() {
        pacientesAtendidos = 0;
        System.out.println("✓ Contador de pacientes reiniciado para " + nombreCompleto);
    }

    // Getters
    public String getCodigoBacteriologo() {
        return codigoBacteriologo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getPacientesAtendidos() {
        return pacientesAtendidos;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    // Setters
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
        String estado = disponible ? "DISPONIBLE" : "OCUPADO";
        System.out.println("✓ Estado actualizado: " + estado);
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}