package actividad.di4.pkg1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ProximasParadasController implements Initializable {

    @FXML
    private Button atras;
    @FXML
    private ComboBox paradas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        paradas.getItems().addAll(" ","Parada1", "Parada2", "Parada3", "Parada4", "Parada5");
    }

    public void handleBotonAtras(ActionEvent ecEvent) throws IOException {
        Stage ventana = (Stage) atras.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SeleccionParadas.fxml"));

        Scene scene = new Scene(root);

        ventana.setScene(scene);
        ventana.show();
    }

}
