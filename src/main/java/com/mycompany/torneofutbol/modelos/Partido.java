package com.mycompany.torneofutbol.modelos;

public class Partido {

    private int id;
    private int jornada;
    private String fecha;
    private String local;
    private String visitante;

    public Partido() {
    }

    public Partido(int id, int jornada, String fecha, String local, String visitante) {
        this.id = id;
        this.jornada = jornada;
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getJornada() { return jornada; }
    public void setJornada(int jornada) { this.jornada = jornada; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public String getVisitante() { return visitante; }
    public void setVisitante(String visitante) { this.visitante = visitante; }
}
