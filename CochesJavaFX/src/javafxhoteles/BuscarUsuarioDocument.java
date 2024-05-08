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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BuscarUsuarioDocument implements Initializable {

    @FXML
    private Button atras;
    @FXML
    private TextField nombre;
    @FXML
    private Label mensaje;
    @FXML
    private Button enviar;

    GestorDB basedatos;

    public BuscarUsuarioDocument() {
        basedatos = new GestorDB("datos.db");
    }

  
    @FXML
    public void handleBotonAtras(ActionEvent event) throws IOException {
        Stage ventana = (Stage) atras.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        ventana.show();
    }

    @FXML
    public void handleBotonBuscar(ActionEvent event) {
        handleMostrarResultado(event);
    }

    @FXML
private void handleMostrarResultado(ActionEvent event) {
    String nombreUsuario = nombre.getText();

    try {
        String resultado = basedatos.cargarUsuario(nombreUsuario);
        if (resultado != null) {
            mensaje.setText("Usuario encontrado: " + resultado);
        } else {
            mensaje.setText("No se encontró ningún usuario con el nombre: " + nombre.getText());
        }
    } catch (SQLException e) {
        mensaje.setText("Error de base de datos. Hubo un error al buscar el usuario." + e.getMessage());
    }
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

  
}
