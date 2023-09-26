package com.l20291026.myfirstapplication.usuario.model;

public class Usuario {
    private String Usuario;

    private String pass;

    private  String nombre;

    private int edad;

    private String email;

    public Usuario(String usuario, String pass, String nombre, int edad, String email) {
        Usuario = usuario;
        this.pass = pass;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getPass() {
        return pass;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }
}
