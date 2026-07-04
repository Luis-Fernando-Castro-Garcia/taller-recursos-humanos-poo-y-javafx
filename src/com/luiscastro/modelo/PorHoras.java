/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luiscastro.modelo;

public class PorHoras extends Empleado {

    private double costoHora;
    private double horasTrabajadas;

    //Constructor
    public PorHoras(double costoHora, double horasTrabajadas, String nombre, int dpi) {
        super(nombre, dpi);
        this.costoHora = costoHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    //Getters y Setters
    public double getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(double costoHora) {
        this.costoHora = costoHora;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    //Metodos
    @Override
    public double calcularSueldo() {
        return costoHora * horasTrabajadas;
    }
}
