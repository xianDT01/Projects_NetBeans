/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.di4.pkg1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 *
 * @author DAMD1_Alu01
 */
public class CalcularRuta extends Application implements Initializable{
        @FXML
    private ComboBox ruta1;
        @FXML
    private ComboBox ruta2;
     @FXML
    private Button atras;
    @Override
    public void start(Stage primaryStage) throws Exception {
       
    }

   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ruta1.getItems().addAll(" ","ruta1", "ruta2", "ruta3", "ruta4", "ruta5");
       ruta2.getItems().addAll(" ","ruta1", "ruta2", "ruta3", "ruta4", "ruta5");
    }
     public  void handleBotonAtras(ActionEvent ecEvent) throws IOException{
        Stage ventana = (Stage) atras.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SeleccionParadas.fxml"));
      
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        ventana.show();
    }
}
