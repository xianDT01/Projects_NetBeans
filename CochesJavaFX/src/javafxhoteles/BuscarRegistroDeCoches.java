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

public class BuscarRegistroDeCoches implements Initializable {

    @FXML
    private Button atras;

    @FXML
    private Label mensaje;

    @FXML
    private TextField matriculaCoche;  

    @FXML
    private Button buscarButton;

    GestorDB basedatos;

    public BuscarRegistroDeCoches() {
        basedatos = new GestorDB("datos.db");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

 @FXML
    private void handleBuscar(ActionEvent event) {
        String matricula = matriculaCoche.getText();

        if (!matricula.isEmpty()) {
            try {
                String resultado = basedatos.cargarCoche(matricula, matricula);
                handleMostrarResultado(resultado);
            } catch (SQLException e) {
                mensaje.setText("Error de base de datos. Hubo un error al buscar el coche. " + e.getMessage());
            }
        } else {
            mensaje.setText("Campo Vacío. Por favor, ingrese la matrícula del coche.");
        }
    }
    @FXML
    private void handleMostrarResultado(String resultado) {
        if (resultado != null && !resultado.equals("nulo")) {
            mensaje.setText("Coche encontrado: " + resultado);
        } else {
            mensaje.setText("No se encontró ningún coche con la matrícula: " + matriculaCoche.getText());
        }
    }


    @FXML
    private void handleBotonAtras(ActionEvent event) throws IOException {
        Stage ventana = (Stage) atras.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        ventana.setScene(scene);
        ventana.show();
    }
}
