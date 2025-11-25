import java.time.LocalDateTime;

public class Cita {
    public enum Estado { RESERVADA, CONFIRMADA, CANCELADA, COMPLETADA }
    private String id;
    private Cliente cliente;
    private Mascota mascota;
    private Servicio servicio;
    private LocalDateTime fechaHora;
    private Estado estado;
    public Cita(String id, Cliente cliente, Mascota mascota, Servicio servicio, LocalDateTime fechaHora) {
        this.id = id; this.cliente = cliente; this.mascota = mascota; this.servicio = servicio; this.fechaHora = fechaHora; this.estado = Estado.RESERVADA;
    }
    // getters/setters y métodos para cambiar estado
    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Mascota getMascota() { return mascota; }
    public Servicio getServicio() { return servicio; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Cita{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente.getNombre() +
                ", mascota=" + mascota.getNombre() +
                ", servicio=" + servicio.getDescripcion() +
                ", fechaHora=" + fechaHora +
                ", estado=" + estado +
                '}';
    }
}