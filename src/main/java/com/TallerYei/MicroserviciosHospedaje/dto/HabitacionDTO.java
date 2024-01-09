package com.TallerYei.MicroserviciosHospedaje.dto;

import java.io.Serializable;

public class HabitacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private int numeroHabitacion;
    private String tipoHabitacion;
    private double precio;
    private String estado;

    // Constructor por defecto
    public HabitacionDTO() {
    }

    // Constructor con todos los campos
    public HabitacionDTO(Long id, int numeroHabitacion, String tipoHabitacion, double precio, String estado) {
        this.id = id;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
        this.estado = estado;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Puedes agregar métodos adicionales según sea necesario
}
