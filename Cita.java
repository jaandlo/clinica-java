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

    @Override
    public String toString() {
        return "Cita{" +
                "id='" + id + '\'' +
                ", hora='" + hora + '\'' +
                ", día='" + dia + '\'' +
                ", estado=" + estado +
                ", veterinario=" + (veterinario != null ? veterinario.getNombre() : "N/A") +
                ", mascota=" + (mascota != null ? mascota.getNombre() : "N/A") +
                ", cliente=" + (cliente != null ? cliente.getNombre() : "N/A") +
                ", notas='" + notas + '\'' +
                '}';
    }

    
}