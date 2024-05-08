/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
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
import javafx.stage.Stage;


public class ActividadDI41 extends Application implements Initializable {

      @FXML
    private Button inicio;
   @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SeleccionIdioma.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
        public  void handleBotonIdioma(ActionEvent ecEvent) throws IOException{
        Stage ventana = (Stage) inicio.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SeleccionIdioma.fxml"));
      
        Scene scene = new Scene(root);
        
        ventana.setScene(scene);
        ventana.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    
}
