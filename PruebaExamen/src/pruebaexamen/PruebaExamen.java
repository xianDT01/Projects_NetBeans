
package pruebaexamen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Xian Durán
 */
public class PruebaExamen extends Application {

     @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Formulario.fxml"));
   
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
 
    
}
