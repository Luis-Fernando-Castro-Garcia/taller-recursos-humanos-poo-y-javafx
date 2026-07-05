/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luiscastro.controller;

import com.luiscastro.view.VistaPrincipalView;
import com.luiscastro.modelo.Empleado;
import com.luiscastro.modelo.Asalariado;
import com.luiscastro.modelo.PorHoras;
import com.luiscastro.modelo.Comisionista;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SceneManagerController {

    private Stage stage;
    private VistaPrincipalView vista;
    private ObservableList<Empleado> listaEmpleados;

    public SceneManagerController(Stage stage) {
        this.stage = stage;
        this.vista = new VistaPrincipalView();
        this.listaEmpleados = FXCollections.observableArrayList();
    }

    public void iniciar() {
        Scene scene = new Scene(vista.getTabPane(), 600, 400);
        stage.setTitle("Sistema de Recursos Humanos");
        stage.setScene(scene);
        stage.show();

        vista.getTablaEmpleado().setItems(listaEmpleados);

        vista.getCmbTipo().setOnAction(e -> panelVisible());
        panelVisible();

        vista.getBtnAgregar().setOnAction(e -> agregarEmpleado());

        vista.getBtnCalcularTotal().setOnAction(e -> calcularTotal());
    }

    private void calcularTotal() {
        double total = 0;
        for (Empleado emp : listaEmpleados) {
            total += emp.calcularSueldo();
        }

        vista.getLblTotal().setText("Total: Q" + total);
    }

    private void agregarEmpleado() {
        String nombre = vista.getTxtNombre().getText();
        int dpi = Integer.parseInt(vista.getTxtDpi().getText());

        switch (vista.getCmbTipo().getValue()) {
            case "Asalariado" -> {
                double sueldo = Double.parseDouble(vista.getTxtSueldoFijo().getText());
                Asalariado nuevo = new Asalariado(sueldo, nombre, dpi);
                listaEmpleados.add(nuevo);
            }
            case "PorHoras" -> {
                double costoHora = Double.parseDouble(vista.getTxtCostoHora().getText());
                double horasTrabajadas = Double.parseDouble(vista.getTxtHorasTrabajadas().getText());
                PorHoras nuevo = new PorHoras(costoHora, horasTrabajadas, nombre, dpi);
                listaEmpleados.add(nuevo);
            }
            case "Comisionista" -> {
                double ventasTotales = Double.parseDouble(vista.getTxtVentasTotales().getText());
                double porcentajeComision = Double.parseDouble(vista.getTxtPorcentajeComision().getText());
                Comisionista nuevo = new Comisionista(ventasTotales, porcentajeComision, nombre, dpi);
                listaEmpleados.add(nuevo);
            }
        }

        vista.getTxtNombre().clear();
        vista.getTxtDpi().clear();
        vista.getTxtSueldoFijo().clear();
        vista.getTxtCostoHora().clear();
        vista.getTxtHorasTrabajadas().clear();
        vista.getTxtVentasTotales().clear();
        vista.getTxtPorcentajeComision().clear();
    }

    private void panelVisible() {
        vista.getPanelAsalariado().setVisible(false);
        vista.getPanelAsalariado().setManaged(false);
        vista.getPanelPorHoras().setVisible(false);
        vista.getPanelPorHoras().setManaged(false);
        vista.getPanelComisionista().setVisible(false);
        vista.getPanelComisionista().setManaged(false);

        switch (vista.getCmbTipo().getValue()) {
            case "Asalariado" -> {
                vista.getPanelAsalariado().setVisible(true);
                vista.getPanelAsalariado().setManaged(true);
            }
            case "PorHoras" -> {
                vista.getPanelPorHoras().setVisible(true);
                vista.getPanelPorHoras().setManaged(true);
            }
            case "Comisionista" -> {
                vista.getPanelComisionista().setVisible(true);
                vista.getPanelComisionista().setManaged(true);
            }
        }
    }
}
