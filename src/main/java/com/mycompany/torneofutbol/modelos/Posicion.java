package com.mycompany.torneofutbol.modelos;

public class Posicion {

    private int id;
    private String equipo;
    private int puntos;
    private int jugados;
    private int diferencia;

    public Posicion() {
    }

    public Posicion(int id, String equipo, int puntos, int jugados, int diferencia) {
        this.id = id;
        this.equipo = equipo;
        this.puntos = puntos;
        this.jugados = jugados;
        this.diferencia = diferencia;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEquipo() { return equipo; }
    public void setEquipo(String equipo) { this.equipo = equipo; }

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    public int getJugados() { return jugados; }
    public void setJugados(int jugados) { this.jugados = jugados; }

    public int getDiferencia() { return diferencia; }
    public void setDiferencia(int diferencia) { this.diferencia = diferencia; }
}
