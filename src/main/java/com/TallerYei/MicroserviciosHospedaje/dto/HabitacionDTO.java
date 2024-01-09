package com.TallerYei.MicroserviciosHospedaje.dto;

import java.io.Serializable;

public class HabitacionDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String numeroHabitacion;
    private String tipoHabitacion;
    private double precio;
    private String estado;

    public HabitacionDTO() {

    }

    public HabitacionDTO(String numeroHabitacion, String tipoHabitacion, double precio, String estado) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
        this.estado = estado;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
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
}
