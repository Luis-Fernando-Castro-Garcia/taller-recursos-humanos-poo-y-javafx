/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luiscastro.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VistaPrincipalView {

    //Campos normales
    private TabPane tabPane;
    private TextField txtNombre;
    private TextField txtDpi;
    private ComboBox<String> cmbTipo;

    //Campos dinámicos por cada modelo
    //Asalariado
    private VBox panelAsalariado;
    private TextField txtSueldoFijo;

    //PorHoras
    private VBox panelPorHoras;
    private TextField txtCostoHora;
    private TextField txtHorasTrabajadas;

    //Comisionista
    private VBox panelComisionista;
    private TextField txtVentasTotales;
    private TextField txtPorcentajeComision;

    //Botones
    private Button btnAgregar;

    public VistaPrincipalView() {
        tabPane = new TabPane();
        construirTabRegistro();
    }

    private void construirTabRegistro() {
        VBox contenedor = new VBox(10);
        contenedor.setPadding(new Insets(15));

        Label lblNombre = new Label("Nombre:");
        txtNombre = new TextField();

        Label lblDpi = new Label("DPI:");
        txtDpi = new TextField();

        Label lblTipo = new Label("Tipo de empleado");
        cmbTipo = new ComboBox<>();
        cmbTipo.getItems().addAll("Asalariado", "PorHoras", "Comisionista");
        cmbTipo.setValue("Asalariado");

        contenedor.getChildren().addAll(lblNombre, txtNombre, lblDpi, txtDpi, lblTipo, cmbTipo);
        Tab tabRegistro = new Tab("Registro");
        tabRegistro.setContent(contenedor);
        tabRegistro.setClosable(false);

        tabPane.getTabs().add(tabRegistro);
    }

    //Getters y Setters
    public TabPane getTabPane() {
        return tabPane;
    }

}
