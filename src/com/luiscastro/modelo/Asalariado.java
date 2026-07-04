/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luiscastro.modelo;

public class Asalariado extends Empleado {

    private double sueldoFijoMensual;

    //Constructor
    public Asalariado(double sueldoFijoMensual, String nombre, int dpi) {
        super(nombre, dpi);
        this.sueldoFijoMensual = sueldoFijoMensual;
    }

    //Getters y Setters
    public double getSueldoFijoMensual() {
        return sueldoFijoMensual;
    }

    public void setSueldoFijoMensual(double sueldoFijoMensual) {
        this.sueldoFijoMensual = sueldoFijoMensual;
    }

    //Metodos
    @Override
    public double calcularSueldo() {
        return sueldoFijoMensual;
    }

}
