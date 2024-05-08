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
public class FXMLRegistrarUsuariosController implements Initializable {
    
    
   
    @FXML private TextField nombre;
    @FXML private TextField apellidos;
    @FXML private TextField nif;
    @FXML private Button enviar;
    @FXML private Button atras;
    @FXML private TextField mensaje;
    GestorDB basedatos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
   
        public FXMLRegistrarUsuariosController(){
        basedatos = new GestorDB("datos.db");
       
    }

        
public void handleRegistroUsuario() {
    String nombreUsuario = nombre.getText();
    String apellidosUsuario = apellidos.getText();
    String nifUsuario = nif.getText();

    if (!nombreUsuario.isEmpty() && !apellidosUsuario.isEmpty() && !nifUsuario.isEmpty()) {
        try {
            String resultado = basedatos.guardarUsuario(nombreUsuario, apellidosUsuario, nifUsuario);
            mensaje.setText(resultado);
            System.err.println("Se guardo correctamente en la base de datos");
        } catch (SQLException ex) {
            mensaje.setText("Error al guardar en la base de datos");
            ex.printStackTrace();
        }
    } else {
        mensaje.setText("Por favor, complete todos los campos.");
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