package examenfx;

import com.sun.org.apache.bcel.internal.generic.Select;
import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TresEnRayaController implements Initializable {

  

    @FXML
    private ImageView imagen;
    @FXML
    private ImageView imagen2;
    @FXML
    private ImageView imagen3;
    @FXML
    private ImageView imagen4;
    @FXML
    private ImageView imagen5;
    @FXML
    private ImageView imagen6;
    @FXML
    private ImageView imagen7;
    @FXML
    private ImageView imagen8;
    @FXML
    private ImageView imagen9;

    @FXML
    private ComboBox<String> seleccionar;
 
   Image image1 = new Image(getClass().getResourceAsStream("/img/X.png"));
    Image image2 = new Image(getClass().getResourceAsStream("/img/O.png"));

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        seleccionar.getItems().addAll(" ", "X", "O");

    }

    public void resultado() {
        String seleccion = seleccionar.getValue();
        if (seleccion.contains("X")) {
            imagen.setImage(image1);
        } else if (seleccion.contains("O")) {
            imagen.setImage(image2);
        }

    }

    public void resultado2() {
        String seleccion = seleccionar.getValue();
        if (seleccion.contains("X")) {
            imagen2.setImage(image1);
        } else if (seleccion.contains("O")) {
            imagen2.setImage(image2);
        }

    }

    public void resultado3() {
        String seleccion = seleccionar.getValue();
        if (seleccion.contains("X")) {
            imagen3.setImage(image1);
        } else if (seleccion.contains("O")) {
            imagen3.setImage(image2);
        }
    }

    public void resultado4() {
        String seleccion = seleccionar.getValue();
        if (seleccion.contains("X")) {
            imagen4.setImage(image1);
        } else if (seleccion.contains("O")) {
            imagen4.setImage(image2);
        }
    }

    public void resultado5() {
        String seleccion = seleccionar.getValue();
        if (seleccion.contains("X")) {
            imagen5.setImage(image1);
        } else if (seleccion.contains("O")) {
            imagen5.setImage(image2);
        }
    }

    public void resultado6() {
        String seleccion = seleccionar.getValue();
        if (seleccion.contains("X")) {
            imagen6.setImage(image1);
        } else if (seleccion.contains("O")) {
            imagen6.setImage(image2);
        }
    }

    public void resultado7() {
        String seleccion = seleccionar.getValue();
        if (seleccion.contains("X")) {
            imagen7.setImage(image1);
        } else if (seleccion.contains("O")) {
            imagen7.setImage(image2);
        }
    }

    public void resultado8() {
        String seleccion = seleccionar.getValue();
        if (seleccion.contains("X")) {
            imagen8.setImage(image1);
        } else if (seleccion.contains("O")) {
            imagen8.setImage(image2);
        }
    }

    public void resultado9() {
        String seleccion = seleccionar.getValue();
        if (seleccion.contains("X")) {
            imagen9.setImage(image1);
        } else if (seleccion.contains("O")) {
            imagen9.setImage(image2);
        }
    }

}
