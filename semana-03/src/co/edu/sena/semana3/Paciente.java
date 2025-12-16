package co.edu.sena.semana3;

/**
 * Clase que representa a un paciente del laboratorio
 */
public class Paciente {
    private String identificacion;
    private String nombre;
    private int edad;
    private String genero;
    private String telefono;
    private String direccion;
    private String tipoSangre;
    private String email;

    // Constructor completo
    public Paciente(String identificacion, String nombre, int edad, String genero,
                    String telefono, String direccion, String tipoSangre, String email) {
        setIdentificacion(identificacion);
        setNombre(nombre);
        setEdad(edad);
        setGenero(genero);
        setTelefono(telefono);
        setDireccion(direccion);
        setTipoSangre(tipoSangre);
        setEmail(email);
    }

    // Constructor básico
    public Paciente(String identificacion, String nombre, int edad) {
        this(identificacion, nombre, edad, "No especificado", "Sin teléfono",
                "Sin dirección", "No determinado", "sin-email@diagnostico.com");
    }

    // Constructor con contacto
    public Paciente(String identificacion, String nombre, int edad, String telefono, String email) {
        this(identificacion, nombre, edad, "No especificado", telefono,
                "Sin dirección", "No determinado", email);
    }

    // Getters
    public String getIdentificacion() { return identificacion; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getGenero() { return genero; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public String getTipoSangre() { return tipoSangre; }
    public String getEmail() { return email; }

    // Setters con validación
    public void setIdentificacion(String identificacion) {
        if (!validarIdentificacion(identificacion)) {
            throw new IllegalArgumentException("Identificación inválida");
        }
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty() || contieneNumeros(nombre)) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre.trim();
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("Edad debe estar entre 0 y 120 años");
        }
        this.edad = edad;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("Género no puede estar vacío");
        }
        this.genero = genero.trim();
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.equals("Sin teléfono") && !validarTelefono(telefono)) {
            throw new IllegalArgumentException("Teléfono inválido");
        }
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("Dirección no puede estar vacía");
        }
        this.direccion = direccion.trim();
    }

    public void setTipoSangre(String tipoSangre) {
        if (tipoSangre == null || tipoSangre.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo de sangre no puede estar vacío");
        }
        this.tipoSangre = tipoSangre.trim();
    }

    public void setEmail(String email) {
        if (email != null && !validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    // Métodos privados auxiliares
    private boolean validarIdentificacion(String id) {
        return id != null && id.length() >= 5 && id.length() <= 15;
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

    // Métodos públicos
    @Override
    public String toString() {
        return nombre + " (" + identificacion + ") - " + edad + " años";
    }

    public String obtenerInformacionContacto() {
        return "Tel: " + telefono + " | Email: " + email + " | Dir: " + direccion;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }
}
