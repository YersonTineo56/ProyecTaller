package com.TallerYei.MicroserviciosHospedaje.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private String nombre;
    private String apellido;
    private String usuario;
    private String correo;
    private String clave;  // Agregamos la clave en el DTO

    // Constructores, getters y setters

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombre, String apellido, String usuario, String correo, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.correo = correo;
        this.clave = clave;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
