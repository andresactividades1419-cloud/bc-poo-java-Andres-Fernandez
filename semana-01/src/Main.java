/**
 * Programa de demostración del Sistema de Laboratorio Clínico Diagnóstico Plus
 * Ubicación: Bogotá, Localidad de Chapinero
 * autor Andres Fernandez
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║     LABORATORIO CLÍNICO DIAGNÓSTICO PLUS              ║");
        System.out.println("║     Bogotá - Localidad de Chapinero                   ║");
        System.out.println("║     Sistema de Gestión de Pacientes y Bacteriólogos   ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        // ==========================================
        // CREACIÓN DE PACIENTES (2 objetos mínimo)
        // ==========================================
        System.out.println(">>> REGISTRO DE PACIENTES <<<\n");

        Paciente paciente1 = new Paciente(
                "1035789456",
                "María González Rodríguez",
                45,
                "3201234567",
                "O+"
        );

        Paciente paciente2 = new Paciente(
                "52456789",
                "Carlos Alberto Díaz",
                62,
                "3157894561",
                "A+"
        );

        // Mostrar información de pacientes
        paciente1.mostrarInformacion();
        paciente2.mostrarInformacion();

        // ==========================================
        // CREACIÓN DE BACTERIÓLOGOS (2 objetos mínimo)
        // ==========================================
        System.out.println("\n>>> REGISTRO DE BACTERIÓLOGOS <<<\n");

        Bacteriologo bact1 = new Bacteriologo(
                "BACT001",
                "Dra. Laura Patricia Sánchez",
                "Hematología",
                12
        );

        Bacteriologo bact2 = new Bacteriologo(
                "BACT002",
                "Dr. Andrés Felipe Martínez",
                "Microbiología",
                5
        );

        // Mostrar información de bacteriólogos
        bact1.mostrarDatos();
        bact2.mostrarDatos();

        // ==========================================
        // DEMOSTRACIÓN DE MÉTODOS - PACIENTES
        // ==========================================
        System.out.println("\n>>> OPERACIONES CON PACIENTES <<<\n");

        // Activar plan de salud para paciente 1
        System.out.println("--- Activando plan de salud para " +
                paciente1.getNombreCompleto() + " ---");
        paciente1.setTienePlanSalud(true);

        // Agregar exámenes
        System.out.println("\n--- Agregando exámenes a pacientes ---");
        paciente1.agregarExamen(150000.0);
        paciente1.agregarExamen(80000.0);
        paciente2.agregarExamen(200000.0);

        // Calcular descuento
        System.out.println("\n--- Calculando descuentos ---");
        double descuento1 = paciente1.calcularDescuentoPlanSalud();
        System.out.println("Descuento para " + paciente1.getNombreCompleto() +
                ": $" + String.format("%.2f", descuento1));

        double descuento2 = paciente2.calcularDescuentoPlanSalud();
        System.out.println("Descuento para " + paciente2.getNombreCompleto() +
                ": $" + String.format("%.2f", descuento2));

        // Realizar pagos
        System.out.println("\n--- Procesando pagos ---");
        paciente1.realizarPago(100000.0);
        paciente2.realizarPago(200000.0);

        // Verificar adulto mayor
        System.out.println("\n--- Verificación de Adulto Mayor ---");
        System.out.println(paciente1.getNombreCompleto() + " es adulto mayor: " +
                paciente1.esAdultoMayor());
        System.out.println(paciente2.getNombreCompleto() + " es adulto mayor: " +
                paciente2.esAdultoMayor());

        // ==========================================
        // DEMOSTRACIÓN DE MÉTODOS - BACTERIÓLOGOS
        // ==========================================
        System.out.println("\n\n>>> OPERACIONES CON BACTERIÓLOGOS <<<\n");

        // Atender pacientes
        System.out.println("--- Atención de Pacientes ---");
        bact1.atenderPaciente(paciente1.getNombreCompleto());
        bact1.atenderPaciente("Pedro Ramírez");
        bact1.atenderPaciente("Ana María López");

        bact2.atenderPaciente(paciente2.getNombreCompleto());
        bact2.atenderPaciente("Luis García");

        // Verificar si es senior
        System.out.println("\n--- Verificación de Experiencia ---");
        System.out.println(bact1.getNombreCompleto() + " es Senior: " +
                bact1.esSenior());
        System.out.println(bact2.getNombreCompleto() + " es Senior: " +
                bact2.esSenior());

        // Calcular tarifa por examen
        System.out.println("\n--- Cálculo de Tarifas por Examen ---");
        System.out.println(bact1.getNombreCompleto() +
                " - Tarifa: $" + String.format("%.2f", bact1.calcularTarifaPorExamen()));
        System.out.println(bact2.getNombreCompleto() +
                " - Tarifa: $" + String.format("%.2f", bact2.calcularTarifaPorExamen()));

        // Cambiar disponibilidad
        System.out.println("\n--- Cambio de Estado de Disponibilidad ---");
        bact1.setDisponible(false);
        bact1.atenderPaciente("Intento de atención"); // No debería poder atender
        bact1.setDisponible(true);

        // ==========================================
        // RESUMEN FINAL
        // ==========================================
        System.out.println("\n\n╔═══════════════════════════════════════════════════════╗");
        System.out.println("║                    RESUMEN FINAL                      ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        paciente1.mostrarInformacion();
        paciente2.mostrarInformacion();

        bact1.mostrarDatos();
        bact2.mostrarDatos();

        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║          Sistema finalizado exitosamente              ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
    }
}