public class Cita {
    public enum Estado {
        DISPONIBLE, AGENDADA, CONFIRMADA, COMPLETADA, CANCELADA
    }

    private final String id;
    private final String hora;
    private final String dia;
    private Veterinario veterinario = null;
    private Mascota mascota = null;
    private Cliente cliente = null;
    private Estado estado = Estado.DISPONIBLE;
    private String notas = "";
    private double costo = 0.0;

    public Cita(String id,String hora, String dia) {
        this.id = id;
        this.hora = hora;
        this.dia = dia;
    }

    public void asignarVeterinario(Veterinario veterinario){
        this.veterinario = veterinario;
    }

    public void asignarMascota(Mascota mascota){
        this.mascota = mascota;
    }

    public void asignarCliente(Cliente cliente){
        this.cliente = cliente;
        if (cliente != null) {
            this.estado = Estado.AGENDADA;
        }
    }

    public void asignarCosto(double costo) {
        this.costo = costo;
    }

    public void confirmarCita() {
        this.estado = Estado.CONFIRMADA;
    }

    public void completarCita(String notas) {
        this.estado = Estado.COMPLETADA;
        this.notas = notas;
    }

    public void cancelarCita() {
        this.estado = Estado.CANCELADA;
        this.cliente = null;
        this.veterinario = null;
        this.mascota = null;
        this.costo = 0.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getId() {
        return id;
    }

    public String getHoraDia() {
        return hora + " | " + dia;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getNotas() {
        return notas;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return """
                    Cita ID        : %s
                    Hora y Día     : %s
                    Veterinario    : %s
                    Mascota        : %s
                    Cliente        : %s
                    Estado         : %s
                    Costo          : $%.2f
                    Notas          : %s
                """. formatted(
                getId(),
                getHoraDia(),
                (veterinario != null) ? veterinario.getNombre() : "No asignado",
                (mascota != null) ? mascota.getNombre() : "No asignada",
                (cliente != null) ? cliente.getNombre() : "No asignado",
                getEstado(),
                getCosto(),
                getNotas());
    }

    
}