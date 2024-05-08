
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
public class FXMLRegistroDeCochesController implements Initializable{
    
    @FXML private TextField Modelo;
    @FXML private TextField Matricula;
    @FXML private TextField PrecioInicial;
    @FXML private TextField VendedorNif;
    @FXML private TextField Estado;
    
    @FXML private Button enviar;
    @FXML private Button atras;
    @FXML private TextField mensaje;
    
    
    GestorDB basedatos;
        public FXMLRegistroDeCochesController(){
        basedatos = new GestorDB("datos.db");
       
    }
    public void handleRegistroCoche() {
    String modelo = Modelo.getText();
    String matricula = Matricula.getText();
    String precioInicial = PrecioInicial.getText();
    String vendedorNif = VendedorNif.getText();
    String estado = Estado.getText();

    if (!modelo.isEmpty() && !matricula.isEmpty() && !precioInicial.isEmpty() && !vendedorNif.isEmpty() && !estado.isEmpty()) {
        try {
            String resultado = basedatos.guardarCoche(modelo, matricula, precioInicial, estado, vendedorNif);
           mensaje.setText(resultado);
            System.out.println(resultado);
        } catch (SQLException ex) {
           
            ex.printStackTrace();
        }
    } else { 
        System.out.println("Por favor, complete todos los campos.");
    }
}
    
    

    public void handleBotonAtras(ActionEvent event) throws IOException {
        Stage ventan = (Stage) atras.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        ventan.setScene(scene);
        ventan.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
