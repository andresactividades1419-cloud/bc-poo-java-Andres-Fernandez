package co.edu.sena.semana2;

import co.edu.sena.semana1.Paciente;

public class Main {
    public static void main(String[] args) {

        // Crear paciente
        co.edu.sena.semana1.Paciente paciente1 = new Paciente(
                "Laura Gómez",
                "1098765432",
                29
        );

        // Crear examen
        Examen examen1 = new Examen(
                "Hemograma Completo",
                45000,
                "Sangre"
        );

        // Crear orden de examen
        OrdenExamen orden1 = new OrdenExamen(
                paciente1,
                examen1,
                "2025-03-20"
        );

        // Laboratorio (gestor)
        Laboratorio laboratorio = new Laboratorio("Diagnóstico Plus");
        laboratorio.agregarOrden(orden1);

        // Mostrar resultados
        laboratorio.mostrarOrdenes();
        System.out.println("Total de órdenes: " + laboratorio.contarOrdenes());
    }
}


