/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luiscastro.modelo;

public abstract class Empleado {

    private String nombre;
    private int dpi;

    //Constructor
    public Empleado(String nombre, int dpi) {
        this.nombre = nombre;
        this.dpi = dpi;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    //Metodos
    public abstract double calcularSueldo();

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", dpi=" + dpi + '}';
    }

}
