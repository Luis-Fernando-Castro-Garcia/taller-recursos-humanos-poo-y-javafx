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

    //Metodos
    public VistaPrincipalView() {
        tabPane = new TabPane();
        construirPanelAsalariado();
        construirPanelPorHoras();
        construirPanelComisionista();
        construirTabRegistro();
    }

    private void construirPanelAsalariado() {
        Label lblSueldoFijo = new Label("Sueldo fijo mensual: ");
        txtSueldoFijo = new TextField();

        panelAsalariado = new VBox(10);
        panelAsalariado.getChildren().addAll(lblSueldoFijo,
                txtSueldoFijo
        );
    }

    private void construirPanelPorHoras() {
        Label lblCostoHora = new Label("Costo por hora: ");
        txtCostoHora = new TextField();

        Label lblHorasTrabajadas = new Label("Horas trabajadas: ");
        txtHorasTrabajadas = new TextField();

        panelPorHoras = new VBox(10);
        panelPorHoras.getChildren().addAll(lblCostoHora,
                txtCostoHora,
                lblHorasTrabajadas,
                txtHorasTrabajadas
        );
    }

    private void construirPanelComisionista() {
        Label lblVentasTotales = new Label("Ventas totales: ");
        txtVentasTotales = new TextField();

        Label lblPorcentajeComision = new Label("Porcentaje por comisión");
        txtPorcentajeComision = new TextField();

        panelComisionista = new VBox(10);
        panelComisionista.getChildren().addAll(lblVentasTotales,
                txtVentasTotales,
                lblPorcentajeComision,
                txtPorcentajeComision
        );
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

        contenedor.getChildren().addAll(lblNombre,
                txtNombre,
                lblDpi,
                txtDpi,
                lblTipo,
                cmbTipo,
                panelAsalariado,
                panelPorHoras,
                panelComisionista
        );

        Tab tabRegistro = new Tab("Registro");
        tabRegistro.setContent(contenedor);
        tabRegistro.setClosable(false);

        tabPane.getTabs().add(tabRegistro);
    }

    //Getters
    public TabPane getTabPane() {
        return tabPane;
    }

    public ComboBox<String> getCmbTipo() {
        return cmbTipo;
    }

    public VBox getPanelAsalariado() {
        return panelAsalariado;
    }

    public VBox getPanelPorHoras() {
        return panelPorHoras;
    }

    public VBox getPanelComisionista() {
        return panelComisionista;
    }

}
