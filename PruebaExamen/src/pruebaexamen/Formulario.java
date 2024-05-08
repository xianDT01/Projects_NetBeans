/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaexamen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Xian Durán
 */
public class Formulario {
       @FXML
    private TextField nombreField;

    @FXML
    private TextField edadField;

    @FXML
    private TextField correoField;

    @FXML
    private Label resultadoLabel;

@FXML
public void verificarDatos() {
    boolean datosCompletos = !nombreField.getText().isEmpty() && !edadField.getText().isEmpty()
            && !correoField.getText().isEmpty();

    if (datosCompletos) {
        if (correoField.getText().contains("@")) {
            resultadoLabel.setText("Todos los datos están completos y el correo es válido."+ nombreField.getText() );
            
        } else {
            resultadoLabel.setText("El correo electrónico debe contener '@'.");
        }
    } else {
        resultadoLabel.setText("Por favor, complete todos los campos.");
    }
}

}
