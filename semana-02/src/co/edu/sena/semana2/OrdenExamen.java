package co.edu.sena.semana2;

import co.edu.sena.semana1.Paciente;

public class OrdenExamen {

    private co.edu.sena.semana1.Paciente paciente;
    private Examen examen;
    private String fecha;

    public OrdenExamen(Paciente paciente, Examen examen, String fecha) {
        this.paciente = paciente;
        this.examen = examen;
        this.fecha = fecha;
    }

    public double calcularCosto() {
        return examen.getPrecio();
    }

    public String obtenerResumen() {
        return paciente.obtenerInformacion() +
                "\n" + examen.obtenerInformacion() +
                "\nFecha: " + fecha +
                "\nCosto Total: $" + calcularCosto();
    }
}

