import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Clinica {
    private final String nombre;
    private final LocalTime apertura;
    private final LocalTime cierre;
    private final List<Cita> citas = new ArrayList<>();

    public Clinica(String nombre, LocalTime apertura, LocalTime cierre) {
        this.nombre = nombre;
        this.apertura = apertura;
        this.cierre = cierre;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalTime getApertura() {
        return apertura;
    }

    public LocalTime getCierre() {
        return cierre;
    }

    public List<Cita> showCitasDisponibles() {
        for (Cita cita : citas) {
            if (cita.getCliente() == null) {
                System.out.println("("+cita.getId()+") Cita disponible: " + cita.getHoraDia());
            }
        }
        return citas;
    }

    public void showCitasFull() {
        for (Cita cita : citas) {
            System.out.println(cita);
        }
    }

    public void showCitasAgendadas() {
        for (Cita cita : citas) {
            if (cita.getCliente() != null) {
                System.out.println("Cita agendada: " + cita);
            }
        }
    }

    public void asignarCita(String idCita, Veterinario veterinario, Mascota mascota, Cliente cliente) {
        for (Cita cita : citas) {
            if (cita.getId().equals(idCita)) {
                cita.asignarVeterinario(veterinario);
                cita.asignarMascota(mascota);
                cita.asignarCliente(cliente);
                break;
            }
        }
    }

    public void ModificarCita(String idCita, Veterinario veterinario, Mascota mascota, Cliente cliente) {
        for (Cita cita : citas) {
            if (cita.getId().equals(idCita)) {
                cita.asignarVeterinario(veterinario);
                cita.asignarMascota(mascota);
                cita.asignarCliente(cliente);
                break;
            }
        }
    }

    public void cancelarCita(String idCita) {
        for (Cita cita : citas) {
            if (cita.getId().equals(idCita)) {
                cita.cancelarCita();
                break;
            }
        }
    }

    public void confirmarCita(String idCita) {
        for (Cita cita : citas) {
            if (cita.getId().equals(idCita)) {
                cita.confirmarCita();
                break;
            }
        }
    }

    public void completarCita(String idCita, String notas) {
        for (Cita cita : citas) {
            if (cita.getId().equals(idCita)) {
                cita.completarCita(notas);
                break;
            }
        }
    }

    public void mostrarSeguimientoCita(String idCita) {
        for (Cita cita : citas) {
            if (cita.getId().equals(idCita)) {
                System.out.println("=========================================");
                System.out.println("Seguimiento de Cita:");
                System.out.println(cita);
                System.out.println("=========================================");
                return;
            }
        }
        System.out.println("Cita no encontrada.");
    }

    public void mostrarCitasPorEstado(Cita.Estado estado) {
        System.out.println("=========================================");
        System.out.println("Citas con estado: " + estado);
        System.out.println("=========================================");
        boolean encontradas = false;
        for (Cita cita : citas) {
            if (cita.getEstado() == estado) {
                System.out.println(cita);
                encontradas = true;
            }
        }
        if (!encontradas) {
            System.out.println("No hay citas con este estado.");
        }
        System.out.println("=========================================");
    }

    public void inicializarCitas() {
        citas.clear();

        this.citas.add(new Cita("1","9:00 AM", "Lunes"));
        this.citas.add(new Cita("2","10:30 AM", "Martes"));
        this.citas.add(new Cita("3","11:45 AM", "Miércoles"));
        this.citas.add(new Cita("4","2:00 PM", "Jueves"));
        this.citas.add(new Cita("5","3:30 PM", "Viernes"));
        this.citas.add(new Cita("6","4:15 PM", "Sábado"));
    }

    public void gestionarCita(String opcion, String idCita, Veterinario veterinario, Mascota mascota, Cliente cliente) {
        if (opcion.equals("1")) {
            ModificarCita(idCita, veterinario, mascota, cliente);
            System.out.println("Cita modificada con éxito:");
            showCitasAgendadas();
        } else if (opcion.equals("2")) {
            cancelarCita(idCita);
            System.out.println("Cita cancelada con éxito:");
            showCitasDisponibles();
        } else if (opcion.equals("3")) {
            System.out.println("Cita confirmada con éxito:");
            showCitasAgendadas();
        }
    }
}
