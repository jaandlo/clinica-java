import java.util.Scanner;
import java.util.List;

public class GestorMenus {
    private Clinica clinica;
    private Scanner sc;
    private Veterinario veterinarioSeleccionado;

    public GestorMenus(Clinica clinica, Scanner sc) {
        this.clinica = clinica;
        this.sc = sc;
    }

    public void menuCliente() {
        System.out.println("\n=========================================");
        System.out.println("MENÚ CLIENTE");
        System.out.println("=========================================\n");

        Cliente cliente = obtenerDatosCliente();
        clinica.registrarCliente(cliente);
        System.out.println("\n✓ " + cliente);

        Mascota mascota = obtenerDatosMascota();
        clinica.registrarMascota(mascota);
        System.out.println("✓ " + mascota);

        veterinarioSeleccionado = seleccionarVeterinario();
        String idCita = seleccionarCita();

        clinica.asignarCita(idCita, veterinarioSeleccionado, mascota, cliente);
        System.out.println("✓ Cita agendada con éxito:\n");
        clinica.showCitasAgendadas();

        procesarOpcionesCliente(cliente, mascota, idCita);
    }

    public void menuClinica() {
        System.out.println("\n=========================================");
        System.out.println("MENÚ PERSONAL DE LA CLÍNICA");
        System.out.println("=========================================");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nOpciones del Veterinario:");
            System.out.println("1. Ver todas las citas");
            System.out.println("2. Ver citas agendadas");
            System.out.println("3. Confirmar cita");
            System.out.println("4. Completar cita (agregar notas)");
            System.out.println("5. Ver seguimiento de cita");
            System.out.println("6. Ver citas por estado");
            System.out.println("7. Ver registros de la clínica");
            System.out.println("8. Volver al menú principal");
            System.out.print("Ingrese su opción: ");
            String opcion = sc.nextLine();

            continuar = procesarOpcionClinica(opcion);
        }
    }

    private Cliente obtenerDatosCliente() {
        System.out.println("Ingrese sus datos:");
        System.out.print("ID Cliente: ");
        String idCliente = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        return new Cliente(idCliente, nombre, apellido, telefono, email);
    }

    private Mascota obtenerDatosMascota() {
        System.out.println("\n=========================================");
        System.out.println("Ingrese datos de la mascota:");
        System.out.print("Nombre: ");
        String nombreMascota = sc.nextLine();
        System.out.print("Especie: ");
        String especie = sc.nextLine();
        System.out.print("Raza: ");
        String raza = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        return new Mascota(nombreMascota, especie, raza, edad);
    }

    private Veterinario seleccionarVeterinario() {
        System.out.println("\n=========================================");
        System.out.println("Especialidades disponibles:");
        List<Veterinario> vets = clinica.getVeterinarios();
        for (int i = 0; i < vets.size(); i++) {
            System.out.println((i + 1) + ". " + vets.get(i).getNombre() + " - " + vets.get(i).getEspecialidad());
        }
        System.out.print("Seleccione veterinario (número): ");
        int indexVet = Integer.parseInt(sc.nextLine()) - 1;
        return vets.get(indexVet);
    }

    private String seleccionarCita() {
        System.out.println("\n=========================================");
        System.out.println("Seleccione una cita disponible:");
        System.out.println("=========================================");
        clinica.showCitasDisponibles();
        System.out.println("=========================================");
        System.out.print("Ingrese el ID de la cita: ");
        System.out.println("\nAgendando cita...");
        return sc.nextLine();
    }

    private void procesarOpcionesCliente(Cliente cliente, Mascota mascota, String idCita) {
        System.out.println("\n=========================================");
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Modificar cita");
        System.out.println("2. Cancelar cita");
        System.out.println("3. Volver al menú principal");
        System.out.print("Ingrese su opción: ");
        String opcion = sc.nextLine();

        switch (opcion) {
            case "1" -> modificarCitaCliente(cliente, mascota, idCita);
            case "2" -> cancelarCitaCliente();
            case "3" -> System.out.println("Volviendo al menú principal...\n");
            default -> System.out.println("Opción inválida.");
        }
    }

    private void modificarCitaCliente(Cliente cliente, Mascota mascota, String idCita) {
        System.out.println("\n=========================================");
        System.out.println("Citas agendadas:");
        clinica.showCitasAgendadas();
        System.out.println("=========================================");
        System.out.print("Ingrese el ID de la cita a modificar: ");
        String idModificar = sc.nextLine();
        veterinarioSeleccionado = seleccionarVeterinario();
        clinica.ModificarCita(idModificar, veterinarioSeleccionado, mascota, cliente);
        System.out.println("✓ Cita modificada con éxito:\n");
        clinica.showCitasAgendadas();
    }

    private void cancelarCitaCliente() {
        System.out.println("\n=========================================");
        System.out.println("Citas agendadas:");
        clinica.showCitasAgendadas();
        System.out.println("=========================================");
        System.out.print("Ingrese el ID de la cita a cancelar: ");
        String idCancelar = sc.nextLine();
        clinica.cancelarCita(idCancelar);
        System.out.println("✓ Cita cancelada con éxito.\n");
    }

    private boolean procesarOpcionClinica(String opcion) {
        switch (opcion) {
            case "1" -> {
                System.out.println("\n=========================================");
                clinica.showCitasFull();
                System.out.println("=========================================");
                return true;
            }
            case "2" -> {
                System.out.println("\n=========================================");
                clinica.showCitasAgendadas();
                System.out.println("=========================================");
                return true;
            }
            case "3" -> {
                System.out.println("\n=========================================");
                clinica.showCitasAgendadas();
                System.out.println("=========================================");
                System.out.print("Ingrese el ID de la cita a confirmar: ");
                String idConfirmar = sc.nextLine();
                clinica.confirmarCita(idConfirmar);
                System.out.println("✓ Cita confirmada con éxito:");
                clinica.mostrarSeguimientoCita(idConfirmar);
                return true;
            }
            case "4" -> {
                System.out.println("\n=========================================");
                clinica.mostrarCitasPorEstado(Cita.Estado.CONFIRMADA);
                System.out.println("=========================================");
                System.out.print("Ingrese el ID de la cita a completar: ");
                String idCompletar = sc.nextLine();
                System.out.print("Ingrese las notas de la consulta: ");
                String notas = sc.nextLine();
                clinica.completarCita(idCompletar, notas);
                System.out.println("✓ Cita completada con éxito:");
                clinica.mostrarSeguimientoCita(idCompletar);
                return true;
            }
            case "5" -> {
                System.out.print("Ingrese el ID de la cita: ");
                String idSeguimiento = sc.nextLine();
                clinica.mostrarSeguimientoCita(idSeguimiento);
                return true;
            }
            case "6" -> {
                System.out.println("\nEstados disponibles:");
                for (Cita.Estado estado : Cita.Estado.values()) {
                    System.out.println("- " + estado);
                }
                System.out.print("Ingrese el estado a consultar: ");
                String estadoStr = sc.nextLine().toUpperCase();
                try {
                    Cita.Estado estado = Cita.Estado.valueOf(estadoStr);
                    clinica.mostrarCitasPorEstado(estado);
                } catch (IllegalArgumentException e) {
                    System.out.println("Estado inválido.");
                }
                return true;
            }
            case "7" -> {
                clinica.mostrarRegistros();
                return true;
            }
            case "8" -> {
                System.out.println("Volviendo al menú principal...\n");
                return false;
            }
            default -> {
                System.out.println("Opción inválida.");
                return true;
            }
        }
    }
}
