import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Clinica clinica = inicializarClinica();
        GestorMenus gestor = new GestorMenus(clinica, sc);
        
        mostrarBienvenida(clinica);
        procesarMenuPrincipal(gestor, clinica, sc);
        
        sc.close();
    }

    private static Clinica inicializarClinica() {
        Clinica clinica = new Clinica("Clínica Veterinaria Salud Animal", 
                java.time.LocalTime.of(8, 0), java.time.LocalTime.of(20, 0));
        clinica.inicializarCitas();
        
        // Registrar veterinarios
        clinica.registrarVeterinario(new Veterinario("LIC123", "Cardiología", "Juan", "Pérez", "555-1234", "juan.perez@clinica.com"));
        clinica.registrarVeterinario(new Veterinario("LIC124", "General", "Pablo", "Roa", "555-7234", "pablo.roa91@clinica.com"));
        clinica.registrarVeterinario(new Veterinario("LIC125", "Oncología", "Ana", "Gomez", "555-5678", "an.goz@clinica.com"));
        
        return clinica;
    }

    private static void mostrarBienvenida(Clinica clinica) {
        System.out.println("\n✓ Bienvenido a " + clinica.getNombre());
        System.out.println("=========================================\n");
    }

    private static void procesarMenuPrincipal(GestorMenus gestor, Clinica clinica, Scanner sc) {
        boolean salir = false;
        while (!salir) {
            System.out.println("¿Quién eres?");
            System.out.println("1. Cliente");
            System.out.println("2. Personal de la Clínica");
            System.out.println("3. Ver Registros");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> gestor.menuCliente();
                case "2" -> gestor.menuClinica();
                case "3" -> clinica.mostrarRegistros();
                case "4" -> {
                    System.out.println("\n¡Gracias por usar el sistema! Adiós.");
                    salir = true;
                }
                default -> System.out.println("Opción inválida.\n");
            }
        }
    }
}
