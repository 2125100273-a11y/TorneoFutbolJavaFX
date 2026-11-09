package com.mycompany.torneofutbol.modelos;

public class Equipo {

    private int id;
    private String nombre;
    private String ciudad;
    private String entrenador;

    public Equipo() {
    }

    public Equipo(int id, String nombre, String ciudad, String entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.entrenador = entrenador;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getEntrenador() { return entrenador; }
    public void setEntrenador(String entrenador) { this.entrenador = entrenador; }
}
