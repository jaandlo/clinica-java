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

    @Override
    public String toString() {
        return """
                Información general:
                    Nombre   : %s
                    Apellido : %s
                    Teléfono : %s
                    Email    : %s
                """.formatted(
                getNombre(),
                getApellido(),
                getTelefono(),
                getEmail());
    }

}
