package com.clinicavet.clinica.legacy.Clinica_Veterinaria;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Clinica {
    private String nombre;
    private LocalTime apertura;
    private LocalTime cierre;
    private List<Servicio> servicios = new ArrayList<>();
    private List<Veterinario> veterinarios = new ArrayList<>();
    private List<Cita> citas = new ArrayList<>();
    // métodos: agregarServicio, registrarVeterinario, reservarCita (validar disponibilidad), buscarServicios...

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
    public List<Servicio> getServicios() {
        return servicios;
    }
    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }
    public List<Cita> getCitas() {
        return citas;
    }
    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }
    public void registrarVeterinario(Veterinario veterinario) {
        veterinarios.add(veterinario);
    }
    public void reservarCita(Cita cita) {
        citas.add(cita);
    }

    //Implementar validación en Clinica.reservarCita (horario de la clínica + evitar solapamiento por veterinario o capacidad).

    public boolean esHorarioValido(LocalTime hora) {
        return !hora.isBefore(apertura) && !hora.isAfter(cierre);
    }

    //Crear CitaManager (reservar, modificar, cancelar) y separación de lógica de negocio.
    public class CitaManager {
        public boolean reservarCita(Cita cita) {
            // Lógica para validar y reservar cita
            if (esHorarioValido(cita.getFechaHora().toLocalTime())) {
                citas.add(cita);
                return true;
            }
            return false;
        }
    }
}