import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Clinica clinica = new Clinica("Clínica Veterinaria Salud Animal", java.time.LocalTime.of(8, 0), java.time.LocalTime.of(20, 0));
        clinica.inicializarCitas();
        System.out.println("Bienvenido a " + clinica.getNombre());
        System.out.println("=========================================");



        System.out.println("Sistema de Gestión de Clínica Veterinaria");
        System.out.println("=========================================");
        System.out.println("ingrese datos del cliente");
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

        System.out.println("=========================================");
        System.out.println("=========================================");

        // Crear un cliente con los datos ingresados
        
        System.out.println("ingrese datos de la mascota");
        System.out.print("Nombre de la mascota: ");
        String nombreMascota = sc.nextLine();
        System.out.print("Especie: ");
        String especie = sc.nextLine();
        System.out.print("Raza: ");
        String raza = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());

        Cliente cliente = new Cliente(idCliente, nombre, apellido, telefono, email);
        System.out.println("Información del Cliente:\n" + cliente);
        Mascota mascota = new Mascota(nombreMascota, especie, raza, edad);
        System.out.println("Información de la Mascota:\n" + mascota);

        System.out.println("Tipos de servicios disponibles:");
        System.out.println("=========================================");
        for (Servicio.Tipo tipo : Servicio.Tipo.values()) {
            System.out.println("- " + tipo);
        }

        System.out.println("=========================================");
        System.out.print("Seleccione el tipo de servicio (escriba el nombre exactamente como aparece arriba): ");
        String tipoServicio = sc.nextLine();
        System.out.println("Servicio seleccionado: " + tipoServicio);
        System.out.println("=========================================");
        
        // Instaciar veterinarios disponibles
        Veterinario veterinario = new Veterinario("LIC123", "CardiologíA", "Juan", "Pérez", "555-1234", "juan.perez@clinica.com");
        Veterinario veterinario2 = new Veterinario("LIC124", "General", "Pablo", "Roa", "555-7234", "pablo.roa91@clinica.com");
        Veterinario veterinario3 = new Veterinario("LIC125", "Oncología", "Ana", "Gomez", "555-5678", "an.goz@clinica.com");

        System.out.println("Seleccione una cita disponible:");
        System.out.println("=========================================");
        clinica.showCitasDisponibles();
        System.out.println("=========================================");
        System.out.print("Ingrese el ID de la cita seleccionada: ");
        String idSeleccionado = sc.nextLine();
        System.out.println("Cita seleccionada correctamente");
        System.out.println("=========================================");

        while (true) {
            System.out.println("Seleccione un veterinario:");
            System.out.println("1. " + veterinario.getNombre() + " - " + veterinario.getEspecialidad());
            System.out.println("2. " + veterinario2.getNombre() + " - " + veterinario2.getEspecialidad());
            System.out.println("3. " + veterinario3.getNombre() + " - " + veterinario3.getEspecialidad());
            System.out.print("Ingrese el número del veterinario seleccionado: ");
            String opcionVet = sc.nextLine();

            if (opcionVet.equals("1")) {
                veterinario = veterinario;
                break;
            } else if (opcionVet.equals("2")) {
                veterinario = veterinario2;
                break;
            } else if (opcionVet.equals("3")) {
                veterinario = veterinario3;
                break;
            } else {
                System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
        System.out.println("=========================================");

        System.out.println("Agendando cita...");
        System.out.println("=========================================");
        System.out.println("Cita agendada con éxito:");

        clinica.asignarCita(idSeleccionado, veterinario, mascota, cliente);
        clinica.showCitasAgendadas();

        System.out.println("=========================================");
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Modificar cita");
        System.out.println("2. Cancelar cita");
        System.out.println("3. Confirmar cita");
        System.out.println("4. Salir");
        System.out.print("Ingrese su opción: ");
        String opcion = sc.nextLine();

        if (opcion.equals("1")) {
            System.out.println("=========================================");
            System.out.println("Citas agendadas:");
            clinica.showCitasAgendadas();
            System.out.println("=========================================");
            System.out.print("Ingrese el ID de la cita a modificar: ");
            String idModificar = sc.nextLine();

            while (true) {
                System.out.println("Seleccione un veterinario:");
                System.out.println("1. " + veterinario.getNombre() + " - " + veterinario.getEspecialidad());
                System.out.println("2. " + veterinario2.getNombre() + " - " + veterinario2.getEspecialidad());
                System.out.println("3. " + veterinario3.getNombre() + " - " + veterinario3.getEspecialidad());
                System.out.print("Ingrese el número del veterinario: ");
                String opcionVetMod = sc.nextLine();

                if (opcionVetMod.equals("1")) {
                    veterinario = veterinario;
                    break;
                } else if (opcionVetMod.equals("2")) {
                    veterinario = veterinario2;
                    break;
                } else if (opcionVetMod.equals("3")) {
                    veterinario = veterinario3;
                    break;
                } else {
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }
            }

            clinica.gestionarCita(opcion, idModificar, veterinario, mascota, cliente);

        } else if (opcion.equals("2")) {
            System.out.println("=========================================");
            System.out.println("Citas agendadas:");
            clinica.showCitasAgendadas();
            System.out.println("=========================================");
            System.out.print("Ingrese el ID de la cita a cancelar: ");
            String idCancelar = sc.nextLine();
            clinica.gestionarCita(opcion, idCancelar, veterinario, mascota, cliente);
        } else if (opcion.equals("3")) {
            clinica.gestionarCita(opcion, idSeleccionado, veterinario, mascota, cliente);
        }

        sc.close();
    }
}
