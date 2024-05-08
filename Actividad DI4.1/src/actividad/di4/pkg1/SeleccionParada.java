
package actividad.di4.pkg1;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author DAMD1_Alu01
 */
public class SeleccionParada {
    @FXML
    private Button proximasParadas;
  
      
    @FXML
    private Button exit;
    
        @FXML
    private Button ayuda;
        
            @FXML
    private Button atras;
        @FXML
    private Button calcularRuta;
      public  void handleBotonProximasParadas(ActionEvent ecEvent) throws IOException{
        Stage ventana = (Stage) proximasParadas.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ProximasParadas.fxml"));
      
        Scene scene = new Scene(root);
        
        ventana.setScene(scene);
        ventana.show();
    }
        public  void handleBotonCalcularRuta(ActionEvent ecEvent) throws IOException{
        Stage ventana = (Stage) calcularRuta.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CalcularRuta.fxml"));
      
        Scene scene = new Scene(root);
        
        ventana.setScene(scene);
        ventana.show();
    }
    
        public  void handleBotonAyuda(ActionEvent ecEvent) throws IOException{
        Stage ventana = (Stage) ayuda.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ayuda.fxml"));
      
        Scene scene = new Scene(root);
        
        ventana.setScene(scene);
        ventana.show();
    }   
        
       public  void handleBotonAtras(ActionEvent ecEvent) throws IOException{
        Stage ventana = (Stage) atras.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SeleccionIdioma.fxml"));
      
        Scene scene = new Scene(root);
        
        ventana.setScene(scene);
        ventana.show();
    }      
        
        public void handleBotonSalir(ActionEvent event){
        Platform.exit();
        System.exit(0);
           
    }   

}
