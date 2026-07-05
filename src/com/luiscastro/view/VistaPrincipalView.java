/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luiscastro.view;

import com.luiscastro.modelo.Empleado;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VistaPrincipalView {

    private TabPane tabPane;
    private TextField txtNombre;
    private TextField txtDpi;
    private ComboBox<String> cmbTipo;
    private Label lblTotal;

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
    private Button btnCalcularTotal;

    //Tablas
    private TableView<Empleado> tablaEmpleado;
    private TableColumn<Empleado, String> colNombre;
    private TableColumn<Empleado, Integer> colDpi;
    private TableColumn<Empleado, Double> colSueldo;

    //Metodos
    public VistaPrincipalView() {
        tabPane = new TabPane();
        construirPanelAsalariado();
        construirPanelPorHoras();
        construirPanelComisionista();
        construirTabRegistro();
        construirTabResumen();
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

        btnAgregar = new Button("Agregar empleado");

        contenedor.getChildren().addAll(lblNombre,
                txtNombre,
                lblDpi,
                txtDpi,
                lblTipo,
                cmbTipo,
                panelAsalariado,
                panelPorHoras,
                panelComisionista,
                btnAgregar
        );

        Tab tabRegistro = new Tab("Registro");
        tabRegistro.setContent(contenedor);
        tabRegistro.setClosable(false);

        tabPane.getTabs().add(tabRegistro);
    }

    private void construirTabResumen() {
        colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(datos
                -> new SimpleStringProperty(datos.getValue().getNombre())
        );

        colDpi = new TableColumn<>("Dpi");
        colDpi.setCellValueFactory(datos
                -> new SimpleIntegerProperty(datos.getValue().getDpi()).asObject()
        );

        colSueldo = new TableColumn<>("Sueldo");
        colSueldo.setCellValueFactory(datos
                -> new SimpleDoubleProperty(datos.getValue().calcularSueldo()).asObject()
        );

        tablaEmpleado = new TableView<>();
        tablaEmpleado.getColumns().addAll(colNombre, colDpi, colSueldo);
        tablaEmpleado.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        btnCalcularTotal = new Button("Calcular Total");
        lblTotal = new Label("Total: Q0.00");
        lblTotal.setId("lblTotal");

        VBox contenedor = new VBox(10, tablaEmpleado, btnCalcularTotal, lblTotal);
        contenedor.setPadding(new Insets(15));

        Tab tabResumen = new Tab("Resumen");
        tabResumen.setContent(contenedor);
        tabResumen.setClosable(false);

        tabPane.getTabs().add(tabResumen);
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

    public Button getBtnAgregar() {
        return btnAgregar;
    }

    public TextField getTxtNombre() {
        return txtNombre;
    }

    public TextField getTxtDpi() {
        return txtDpi;
    }

    public TextField getTxtSueldoFijo() {
        return txtSueldoFijo;
    }

    public TextField getTxtCostoHora() {
        return txtCostoHora;
    }

    public TextField getTxtHorasTrabajadas() {
        return txtHorasTrabajadas;
    }

    public TextField getTxtVentasTotales() {
        return txtVentasTotales;
    }

    public TextField getTxtPorcentajeComision() {
        return txtPorcentajeComision;
    }

    public Label getLblTotal() {
        return lblTotal;
    }

    public Button getBtnCalcularTotal() {
        return btnCalcularTotal;
    }

    public TableView<Empleado> getTablaEmpleado() {
        return tablaEmpleado;
    }
}
