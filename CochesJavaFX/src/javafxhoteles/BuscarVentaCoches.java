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
import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.stage.Stage;


public class BuscarVentaCoches implements Initializable {

    @FXML
    private Button atras;
    @FXML
    private TextField matricula;
    
    @FXML
    private TextField compradorNiFField;
   
    @FXML
    private Label mensaje;
    @FXML
    private Button enviar;

    GestorDB basedatos;

    public BuscarVentaCoches() {
        basedatos = new GestorDB("datos.db");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleBotonAtras(ActionEvent event) throws IOException {
        Stage ventana = (Stage) atras.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        ventana.show();
    }

@FXML
private void handleBuscarVentaCoche(ActionEvent event) throws SQLException {
    String matriculaCoche = matricula.getText();
    String compradorNiFField = this.compradorNiFField.getText();

    if (!matriculaCoche.isEmpty()) {
       
            String resultado = basedatos.cargarVentaPorMatriculaYComprador(matriculaCoche, compradorNiFField);

            if (!resultado.equals("nulo")) {
                mensaje.setText(resultado);
            } else {
                mensaje.setText("No se encontró ninguna venta para la matrícula: " + matriculaCoche);
            }
       
        
    } else {
        mensaje.setText("Campo vacío. Por favor, ingrese la matrícula del coche para buscar la venta.");
    }
}

  

}
