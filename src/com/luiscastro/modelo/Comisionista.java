/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luiscastro.modelo;

public class Comisionista extends Empleado {

    private double ventasTotales;
    private double porcentajeComision;

    //Constructor
    public Comisionista(double ventasTotales, double porcentajeComision, String nombre, int dpi) {
        super(nombre, dpi);
        this.ventasTotales = ventasTotales;
        this.porcentajeComision = porcentajeComision;
    }

    //Getters y Setters
    public double getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(double ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    //Metodos
    @Override
    public double calcularSueldo() {
        return ventasTotales * (porcentajeComision / 100.0);
    }
}
