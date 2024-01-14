package com.TallerYei.MicroserviciosHospedaje.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;

    // Constructores, getters y setters

    // Constructor vacío necesario para Spring
    public ClienteDTO() {
    }

    // Constructor con parámetros
    public ClienteDTO(String nombre, String apellido, String direccion, String telefono, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
