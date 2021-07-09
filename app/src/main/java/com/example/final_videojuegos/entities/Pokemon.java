package com.example.final_videojuegos.entities;

public class Pokemon {
    public String nombre;
    public String tipo;
    public String imagen;
    public String latitude;
    public String longitude;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLatitud() {
        return latitude;
    }

    public void setLatitud(String latitud) {
        this.latitude = latitud;
    }

    public String getLongitud() {
        return longitude;
    }

    public void setLongitud(String longitud) {
        this.longitude = longitud;
    }
}

