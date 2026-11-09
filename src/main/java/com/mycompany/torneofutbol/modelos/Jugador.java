package com.mycompany.torneofutbol.modelos;

public class Jugador {

    private int id;
    private String nombre;
    private String apellidos;
    private int numero;
    private String posicion;

    public Jugador() {
    }

    public Jugador(int id, String nombre, String apellidos, int numero, String posicion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numero = numero;
        this.posicion = posicion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }
}
