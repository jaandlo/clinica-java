public class Mascota {
    final private String nombre;
    final private String raza;
    final private int edad;
    private String historialMedico;

    public Mascota(String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.historialMedico = "";
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void agregarHistorialMedico(String entrada) {
        this.historialMedico += entrada + "\n";
    }

    @Override
    public String toString() {
        return """
                Información de la Mascota:
                    Nombre          : %s
                    Raza            : %s
                    Edad            : %d años
                    Historial Médico:
                """. formatted(
                getNombre(),
                getRaza(),
                getEdad()) + getHistorialMedico();

    }
}