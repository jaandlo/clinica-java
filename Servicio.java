public class Servicio {
    public enum Tipo {
        GENERAL, VACUNACION, CONTROL, URGENCIA, OTRO
    }

    private String id;
    private String descripcion;
    private double costo;
    private int duracionMinutos;
    private Tipo tipo;
    private Veterinario responsable;

    public Servicio(String id, String descripcion, double costo, int duracionMinutos, Tipo tipo,
            Veterinario responsable) {
        this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
        this.duracionMinutos = duracionMinutos;
        this.tipo = tipo;
        this.responsable = responsable;
    }

    // getters...
    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
    public void serviciosDisponibles() {
        for (Tipo t : Tipo.values()) {
            System.out.println("- " + t);
        }
    }


    @Override
    public String toString() {
        return "Servicio{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                ", duracionMinutos=" + duracionMinutos +
                ", tipo=" + tipo +
                ", responsable=" + responsable.getNombre() +
                '}';
    }
}