public class Mascota {
    final private String nombre;
    final private String especie;
    final private String raza;
    final private int edad;

    public Mascota(String nombre, String especie ,String raza, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
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

    public String getEspecie() {
        return especie;
    }

    @Override
    public String toString() {
        return """
                Información de la Mascota:
                    Nombre          : %s
                    especie         : %s
                    Raza            : %s
                    Edad            : %d años
                """. formatted(
                getNombre(),
                getEspecie(),
                getRaza(),
                getEdad());

    }
}