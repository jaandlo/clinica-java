public class Cliente extends Persona {
    final private String idCliente;
    
    public Cliente(String idCliente, String nombre, String apellido, String telefono, String email) {
        super(nombre, apellido, telefono, email);
        this.idCliente = idCliente;
    }
    
    public String getIdCliente() { 
        return idCliente; 
    }
    
    @Override
    public String toString() { 
        return """
                Información del Cliente:
                    ID Cliente   : %s
                %s
                """.formatted(getIdCliente(), super.getInfoPersonal());
    }
}
