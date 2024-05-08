package conecta4fx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

public class Conecta4Controller implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label labe2;
    @FXML
    private Label labe3;
    private int contador = 0;
    @FXML
    private ComboBox<String> seleccionar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cambiarColorFondoLabel();
        seleccionar.getItems().addAll(" ", "Amarillo", "Azul", "Verde");
    }

    @FXML
    private void cambiarColorLabel() {
        // Cambia el color del Label a rojo
        label.setTextFill(Color.RED);

    }

    @FXML
    private void cambiarColorFondoLabel() {

        contador++;

        /*
         if (contador == 1) {
            label.setStyle("-fx-background-color: lightblue;");
        } else if (contador == 2) {
            label.setStyle("-fx-background-color: yellow;");
        } else {
            label.setStyle("-fx-background-color: lightgreen;");
        }
         */
        String seleccion = seleccionar.getValue();
        if (seleccion == "Amarillo") {
            label.setStyle("-fx-background-color: yellow;");
        } else if (seleccion == "Azul") {
            label.setStyle("-fx-background-color: blue;");
        } else if (seleccion == "Verde") {
            label.setStyle("-fx-background-color: lightgreen;");
        }
    }

    @FXML
    private void cambiarColorFondoLabel2() {

        String seleccion = seleccionar.getValue();
        if (seleccion == "Amarillo") {
            labe2.setStyle("-fx-background-color: yellow;");
        } else if (seleccion == "Azul") {
            labe2.setStyle("-fx-background-color: blue;");
        } else if (seleccion == "Verde") {
            labe2.setStyle("-fx-background-color: lightgreen;");
        }
    }

    @FXML
    private void cambiarColorFondoLabel3() {

        String seleccion = seleccionar.getValue();
        if (seleccion == "Amarillo") {
            labe3.setStyle("-fx-background-color: yellow;");
        } else if (seleccion == "Azul") {
            labe3.setStyle("-fx-background-color: blue;");
        } else if (seleccion == "Verde") {
            labe3.setStyle("-fx-background-color: lightgreen;");
        }
    }
}
