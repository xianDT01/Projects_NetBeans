
package pruebaexamen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Xian Durán
 */
public class Cosas {
    
        @FXML
    private Label miLabel;
        
        @FXML
    private TextField edadField;

    @FXML
    private Label resultadoLabel;    

    @FXML
    public void cambiarTexto() {
        miLabel.setText("¡Texto cambiado!");
    }
    
       @FXML
    public void comprobarEdad() {
        try {
            int edad = Integer.parseInt(edadField.getText());
            if (edad >= 18) {
                resultadoLabel.setText("Mayor de edad");
            } else {
                resultadoLabel.setText("Menor de edad");
            }
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Ingrese una edad válida");
        }
    }
    
}
