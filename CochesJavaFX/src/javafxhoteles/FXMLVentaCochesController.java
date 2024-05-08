/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxhoteles;

import DataBase.GestorDB;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Xian Durán
 */



public class FXMLVentaCochesController implements Initializable {
    
    GestorDB basedatos;
    @FXML private Button  enviar;
    @FXML private Button atras;
    
    @FXML private TextField CocheMatricula;
    @FXML private TextField CompradorNif;
    @FXML private TextField PrecioFinal;
    @FXML private TextField FechaVenta;
    @FXML private TextField mensaje;
    
    
   public FXMLVentaCochesController(){
        basedatos = new GestorDB("datos.db");
       
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
       @FXML
       private void handleRegistroVentaCoche() {
        String cocheMatricula = CocheMatricula.getText(); 
        String compradorNIF = CompradorNif.getText(); 
        double precioFinal = Double.parseDouble(PrecioFinal.getText()); 
        String fechaVenta = FechaVenta.getText();

        if (!cocheMatricula.isEmpty() && !compradorNIF.isEmpty() && !fechaVenta.isEmpty()) {
            try {
                String resultado = basedatos.guardarVenta(cocheMatricula, compradorNIF, precioFinal, fechaVenta);
                mensaje.setText(resultado);
            } catch (SQLException ex) {
                mensaje.setText("Error: " + ex.getMessage());
            }
        } else {
            mensaje.setText("Por favor, complete todos los campos obligatorios.");
        }
    }
       
        public void handleBotonAtras(ActionEvent event) throws IOException {
        Stage ventan = (Stage) atras.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        ventan.setScene(scene);
        ventan.show();

    }
    
}
