package com.mycompany.torneofutbol.modelos;

public class Administrador {

    private int id;
    private String usuario;
    private String nombre;
    private String apellidos;
    private String correo;

    public Administrador() {
    }

    public Administrador(int id, String usuario, String nombre, String apellidos, String correo) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
