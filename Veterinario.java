public class Veterinario extends Persona {
    final private String licencia;
    final private String especialidad;

    public Veterinario(String licencia, String especialidad, String nombre, String apellido, String telefono,
            String email) {
        super(nombre, apellido, telefono, email);
        this.licencia = licencia;
        this.especialidad = especialidad;
    }

    public String getLicencia() {
        return licencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return """
                Información del Veterinario:
                    Licencia     : %s
                    Especialidad : %s
                %s
                """.formatted(getLicencia(), getEspecialidad(), super.getInfoPersonal());
    }
}