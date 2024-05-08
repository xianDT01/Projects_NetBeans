
package javafxhoteles;

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
    @FXML private Button botonesRegistrarUsuario;
    @FXML private Button botoneVentaCoches;
    @FXML private Button botonesCoches;
    @FXML private Button botonBuscarUsuario;
    @FXML private Button botonBuscarRegistroDeCoches;
    @FXML private Button botonBuscarVentaCoches;
    

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
    
       public void handleBotonRegistrarUsiario(ActionEvent ecEvent) throws IOException{
        Stage ventana = (Stage) botonesRegistrarUsuario.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RegistrarUsuarios.fxml"));
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        ventana.show();
    }
      
       public  void handleBotonVentacoches(ActionEvent ecEvent) throws IOException{
        Stage ventana = (Stage) botoneVentaCoches.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("VentaCoches.fxml"));
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        ventana.show();
    }
    
       public  void handleBotonCoches(ActionEvent ecEvent) throws IOException{
        Stage ventana = (Stage) botonesCoches.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RegistroDeCoches.fxml"));
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        ventana.show();
    }   
    
         @FXML
        public void handleBotonBuscarUsuario(ActionEvent event) throws IOException {
        Stage ventana = (Stage) botonBuscarVentaCoches.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BuscarUsuarios.fxml"));
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        ventana.show();
    }   
              @FXML
        public void handleBotonBuscarRegistroDeCoches(ActionEvent event) throws IOException {
        Stage ventana = (Stage) botonBuscarRegistroDeCoches.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BuscarRegistroDeCoches.fxml"));
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        ventana.show();
    }
        public void handleBotonBuscarVentaCohes(ActionEvent event) throws IOException {
        Stage ventana = (Stage) botonBuscarRegistroDeCoches.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BuscarVentaCoches.fxml"));
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        ventana.show();
    }  
      
    public void handleBotonSalir(ActionEvent event){
        Platform.exit();
        System.exit(0);
        
        
    }
        
    
}
