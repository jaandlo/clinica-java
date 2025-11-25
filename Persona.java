public class Persona {
    final private String nombre;
    final private String apellido;
    final private String telefono;
    final private String email;

    public Persona(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getInfoPersonal() {
        return String.format(
                "    Nombre   : %s\n    Apellido : %s\n    Teléfono : %s\n    Email    : %s",
                getNombre(),
                getApellido(),
                getTelefono(),
                getEmail());
    }

    @Override
    public String toString() {
        return """
                Información general:
                %s
                """.formatted(getInfoPersonal());
    }

}
