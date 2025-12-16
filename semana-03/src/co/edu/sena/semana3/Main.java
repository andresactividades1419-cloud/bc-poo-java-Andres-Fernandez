package co.edu.sena.semana3;

/**
 * Clase principal para probar el sistema del laboratorio Diagnóstico Plus
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DIAGNÓSTICO PLUS - LABORATORIO CLÍNICO ===\n");

        try {
            // 1. Crear el laboratorio
            Laboratorio diagnosticoPlus = new Laboratorio();
            System.out.println("=== INFORMACIÓN DEL LABORATORIO ===");
            System.out.println(diagnosticoPlus.obtenerInformacionCompleta());

            // 2. Crear pacientes
            System.out.println("\n=== PACIENTES REGISTRADOS ===");
            Paciente paciente1 = new Paciente("123456789", "María González", 35);
            Paciente paciente2 = new Paciente("987654321", "Carlos Rodríguez", 28,
                    "Masculino", "3101234567",
                    "Calle 100 # 15-20", "O+", "carlos@email.com");
            Paciente paciente3 = new Paciente("555444333", "Ana López", 42,
                    "3205558888", "ana.lopez@email.com");

            System.out.println(paciente1);
            System.out.println(paciente2);
            System.out.println(paciente3);

            // 3. Crear exámenes
            System.out.println("\n=== EXÁMENES DISPONIBLES ===");
            Examen hemograma = new Examen("HEM-001", "Hemograma completo", "Sangre", 85000.0);
            Examen glucosa = new Examen("GLU-002", "Glucosa en ayunas", "Sangre", 45000.0,
                    "Medición de glucosa en sangre", 4, "Bioquímica");
            Examen urocultivo = new Examen("URO-003", "Urocultivo", "Orina", 120000.0);

            System.out.println(hemograma.mostrarInformacion());
            System.out.println(glucosa.mostrarInformacion());
            System.out.println(urocultivo.mostrarInformacion());

            // 4. Crear bacteriólogos
            System.out.println("\n=== BACTERIÓLOGOS ===");
            Bacteriologo bacter1 = new Bacteriologo("BAC-001", "Laura Martínez",
                    "Hematología", 8, "3151234567",
                    "laura@diagnosticoplus.com", true);
            Bacteriologo bacter2 = new Bacteriologo("BAC-002", "Pedro Gómez", "Microbiología");

            System.out.println(bacter1);
            System.out.println(bacter2);

            // 5. Crear órdenes de examen
            System.out.println("\n=== ÓRDENES DE EXAMEN ===");
            OrdenExamen orden1 = new OrdenExamen("ORD-000001", paciente1, hemograma,
                    "2024-01-15", "Dr. Juan Pérez", "Completado",
                    "Paciente en ayunas de 8 horas");
            OrdenExamen orden2 = new OrdenExamen("ORD-000002", paciente2, glucosa);
            orden2.setFechaOrden("2024-01-16");
            orden2.setMedicoSolicitante("Dra. Sandra Ruiz");

            System.out.println(orden1.generarResumen());
            System.out.println("\n" + orden2.generarResumen());

            // 6. Probar métodos adicionales
            System.out.println("\n=== CÁLCULOS Y ESTADÍSTICAS ===");
            System.out.println("Capacidad disponible hoy: " +
                    diagnosticoPlus.calcularCapacidadDisponible(120) + " pacientes");
            System.out.println("Costo con 10% descuento en hemograma: $" +
                    hemograma.calcularCostoConDescuento(10));
            System.out.println("¿Paciente 1 es mayor de edad? " + paciente1.esMayorDeEdad());
            System.out.println("Fecha estimada resultado orden 2: " +
                    orden2.calcularFechaResultado());

            // 7. Probar validaciones (manejo de excepciones)
            System.out.println("\n=== PRUEBA DE VALIDACIONES ===");
            try {
                Paciente pacienteInvalido = new Paciente("AB", "Juan123", -5);
            } catch (IllegalArgumentException e) {
                System.out.println("Error esperado 1: " + e.getMessage());
            }

            try {
                Examen examenInvalido = new Examen("ABC", "Examen", "Tipo", -1000);
            } catch (IllegalArgumentException e) {
                System.out.println("Error esperado 2: " + e.getMessage());
            }

            try {
                orden1.cambiarEstado("Estado inválido");
            } catch (IllegalArgumentException e) {
                System.out.println("Error esperado 3: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error crítico: " + e.getMessage());
        }

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}