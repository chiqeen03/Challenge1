package com.example.mnlgu.challenge1.model;

import java.io.Serializable;

public class Escuela implements Serializable{
    private String nombre, campus, telefono, direccion, correoElectronico, sitioWeb, imagenURL;

    public Escuela() {
    }

    public Escuela(String nombre, String campus, String telefono, String direccion, String correoElectronico, String sitioWeb, String imagenURL) {
        this.nombre = nombre;
        this.campus = campus;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.sitioWeb = sitioWeb;
        this.imagenURL = imagenURL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }
}
