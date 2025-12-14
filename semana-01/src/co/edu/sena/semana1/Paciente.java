package co.edu.sena.semana2;


/**
 * Clase que representa un Paciente en el Laboratorio Clínico Diagnóstico Plus
 * @author andres fernandez
 */
public class Paciente {
    // Atributos privados (5 mínimo)
    private String numeroIdentificacion;
    private String nombreCompleto;
    private int edad;
    private String telefono;
    private boolean tienePlanSalud;
    private String tipoSangre;
    private double saldoPendiente;
    
    // Constructor
    public Paciente(String numeroIdentificacion, String nombreCompleto, int edad, 
                   String telefono, String tipoSangre) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.telefono = telefono;
        this.tipoSangre = tipoSangre;
        this.tienePlanSalud = false;
        this.saldoPendiente = 0.0;
    }
    
    // Método void que imprime información
    public void mostrarInformacion() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("         INFORMACIÓN DEL PACIENTE");
        System.out.println("═══════════════════════════════════════");
        System.out.println("ID: " + numeroIdentificacion);
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Teléfono: " + telefono);
        System.out.println("Tipo de Sangre: " + tipoSangre);
        System.out.println("Plan de Salud: " + (tienePlanSalud ? "SÍ" : "NO"));
        System.out.println("Saldo Pendiente: $" + String.format("%.2f", saldoPendiente));
        System.out.println("═══════════════════════════════════════\n");
    }
    
    // Método que retorna valor calculado
    public double calcularDescuentoPlanSalud() {
        final double DESCUENTO_PLAN = 0.20; // 20% de descuento
        if (tienePlanSalud && saldoPendiente > 0) {
            return saldoPendiente * DESCUENTO_PLAN;
        }
        return 0.0;
    }
    
    // Método adicional: agregar saldo por exámenes
    public void agregarExamen(double costoExamen) {
        this.saldoPendiente += costoExamen;
        System.out.println("✓ Examen agregado. Nuevo saldo: $" + 
                         String.format("%.2f", saldoPendiente));
    }
    
    // Método adicional: realizar pago
    public boolean realizarPago(double monto) {
        if (monto <= 0) {
            System.out.println("✗ Error: El monto debe ser mayor a cero");
            return false;
        }
        if (monto > saldoPendiente) {
            System.out.println("✗ Error: El monto excede el saldo pendiente");
            return false;
        }
        saldoPendiente -= monto;
        System.out.println("✓ Pago realizado exitosamente. Saldo restante: $" + 
                         String.format("%.2f", saldoPendiente));
        return true;
    }
    
    // Método adicional: verificar si es adulto mayor
    public boolean esAdultoMayor() {
        return edad >= 60;
    }
    
    // Getter
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public double getSaldoPendiente() {
        return saldoPendiente;
    }
    
    public String getTipoSangre() {
        return tipoSangre;
    }
    
    // Setter
    public void setTienePlanSalud(boolean tienePlanSalud) {
        this.tienePlanSalud = tienePlanSalud;
        if (tienePlanSalud) {
            System.out.println("✓ Plan de salud activado para " + nombreCompleto);
        }
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setSaldoPendiente(double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }
}