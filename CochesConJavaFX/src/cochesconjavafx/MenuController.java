
package cochesconjavafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MenuController implements Initializable {

    @FXML private Button botonesReservas; 
    @FXML private Button botonSalir;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public  void handleBotonReservas(ActionEvent ecEvent) throws IOException{
        Stage ventana = (Stage) botonesReservas.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
      
        Scene scene = new Scene(root);
        
        ventana.setScene(scene);
        ventana.show();
    }
    
    public void handleBotonSalir(ActionEvent event){
        Platform.exit();
        System.exit(0);
        
        
    }
        
    
}
