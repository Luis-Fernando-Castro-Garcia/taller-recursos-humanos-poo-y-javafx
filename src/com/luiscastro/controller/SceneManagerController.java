/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luiscastro.controller;

import com.luiscastro.view.VistaPrincipalView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManagerController {

    private Stage stage;
    private VistaPrincipalView vista;

    public SceneManagerController(Stage stage) {
        this.stage = stage;
        this.vista = new VistaPrincipalView();
    }

    public void iniciar() {
        Scene scene = new Scene(vista.getTabPane(), 600, 400);
        stage.setTitle("Sistema de Recursos Humanos");
        stage.setScene(scene);
        stage.show();

        vista.getCmbTipo().setOnAction(e -> panelVisible());
        panelVisible();
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
