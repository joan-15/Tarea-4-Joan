package com.joan.joan_tarea_4;

public class Dato {
    private String primerNombre;
    private String apellido;
    private int añoNacimiento;

    public Dato() {
        // Constructor vacío requerido por Firebase
    }

    public Dato(String primerNombre, String apellido, int añoNacimiento) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.añoNacimiento = añoNacimiento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }
}

