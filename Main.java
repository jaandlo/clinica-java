import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
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
        // Crear un cliente con los datos ingresados
        
        System.out.println("ingrese datos de la mascota");
        System.out.print("Nombre de la mascota: ");
        String nombreMascota = sc.nextLine();
        System.out.print("Raza: ");
        String raza = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        
        Cliente cliente = new Cliente(idCliente, nombre, apellido, telefono, email);
        System.out.println("Información del Cliente:\n" + cliente);
        Mascota mascota = new Mascota(nombreMascota, raza, edad);
        System.out.println("Información de la Mascota:\n" + mascota);
        
        // Asignación de veterinario
        Veterinario veterinario = new Veterinario("LIC123", "Cardiología", "Juan", "Pérez", "555-1234", "juan.perez@clinica.com");
        System.out.println("Veterinario asignado:\n" + veterinario);
        // System.out.println("Información del Veterinario:" + vet);

        sc.close();
    }
}
