package co.edu.sena.semana3;

/**
 * Clase que representa a un bacteriólogo del laboratorio Diagnóstico Plus
 */
public class Bacteriologo {
    private String idBacteriologo;
    private String nombre;
    private String especialidad;
    private int anosExperiencia;
    private String telefono;
    private String email;
    private boolean activo;

    // Constructor completo
    public Bacteriologo(String idBacteriologo, String nombre, String especialidad,
                        int anosExperiencia, String telefono, String email, boolean activo) {
        setIdBacteriologo(idBacteriologo);
        setNombre(nombre);
        setEspecialidad(especialidad);
        setAnosExperiencia(anosExperiencia);
        setTelefono(telefono);
        setEmail(email);
        setActivo(activo);
    }

    // Constructor básico
    public Bacteriologo(String idBacteriologo, String nombre, String especialidad) {
        this(idBacteriologo, nombre, especialidad, 0, "Sin teléfono",
                nombre.toLowerCase().replace(" ", ".") + "@diagnosticoplus.com", true);
    }

    // Getters
    public String getIdBacteriologo() { return idBacteriologo; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public int getAnosExperiencia() { return anosExperiencia; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public boolean isActivo() { return activo; }

    // Setters con validación
    public void setIdBacteriologo(String idBacteriologo) {
        if (!validarIdBacteriologo(idBacteriologo)) {
            throw new IllegalArgumentException("ID de bacteriólogo inválido (formato BAC-XXX)");
        }
        this.idBacteriologo = idBacteriologo;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty() || contieneNumeros(nombre)) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre.trim();
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("Especialidad no puede estar vacía");
        }
        this.especialidad = especialidad.trim();
    }

    public void setAnosExperiencia(int anosExperiencia) {
        if (anosExperiencia < 0 || anosExperiencia > 50) {
            throw new IllegalArgumentException("Años de experiencia deben estar entre 0 y 50");
        }
        this.anosExperiencia = anosExperiencia;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.equals("Sin teléfono") && !validarTelefono(telefono)) {
            throw new IllegalArgumentException("Teléfono inválido");
        }
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        if (email != null && !validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Métodos privados auxiliares
    private boolean validarIdBacteriologo(String id) {
        return id != null && id.matches("BAC-[0-9]{3}");
    }

    private boolean contieneNumeros(String texto) {
        return texto.matches(".*\\d.*");
    }

    private boolean validarTelefono(String telefono) {
        return telefono.matches("\\+?[0-9]{7,15}");
    }

    private boolean validarEmail(String email) {
        return email.contains("@") && email.contains(".") && email.length() >= 5;
    }

    @Override
    public String toString() {
        return nombre + " (" + especialidad + ") - " + (activo ? "Activo" : "Inactivo");
    }
}
