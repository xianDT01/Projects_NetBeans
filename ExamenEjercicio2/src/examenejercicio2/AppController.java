package examenejercicio2;

import java.awt.event.MouseEvent;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AppController implements Initializable {

    @FXML
    private ImageView imagen;
    @FXML
    private ImageView imagen2;
    @FXML
    private ImageView imagen3;
    @FXML
    private ComboBox<String> comboBox;
    Image imageX = new Image(getClass().getResourceAsStream("/img/X.png"));
    Image imageO = new Image(getClass().getResourceAsStream("/img/O.png"));

    public AppController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox.getItems().addAll(" ", "X", "O");
    }

    @FXML
    public void cambiarImagen(MouseEvent event) {
        if (comboBox.getItems().contains("X")) {
            System.out.println("Contiene X");
            imagen.setImage(imageX);
        }
    }

    public void pruebas() {
        String seleccion = comboBox.getValue();
        if (seleccion.contains("X")) {
            System.out.println("Contiene X");
            imagen.setImage(imageX);
        } else if (seleccion.contains("O")) {
            System.out.println("Contiene O");
            imagen.setImage(imageO);
        }
    }
        public void pruebas2() {
        String seleccion = comboBox.getValue();
        if (seleccion.contains("X")) {
            System.out.println("Contiene X");
            imagen2.setImage(imageX);
        } else if (seleccion.contains("O")) {
            System.out.println("Contiene O");
            imagen2.setImage(imageO);
        }
    }
}
