package com.mycompany.torneofutbol.modelos;

public class Resultado {

    private int id;
    private String partido;
    private int golesLocal;
    private int golesVisitante;

    public Resultado() {
    }

    public Resultado(int id, String partido, int golesLocal, int golesVisitante) {
        this.id = id;
        this.partido = partido;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPartido() { return partido; }
    public void setPartido(String partido) { this.partido = partido; }

    public int getGolesLocal() { return golesLocal; }
    public void setGolesLocal(int golesLocal) { this.golesLocal = golesLocal; }

    public int getGolesVisitante() { return golesVisitante; }
    public void setGolesVisitante(int golesVisitante) { this.golesVisitante = golesVisitante; }
}
