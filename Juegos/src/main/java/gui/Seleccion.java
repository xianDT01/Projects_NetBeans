
package gui;
import javax.swing.JFrame;

public class Seleccion extends JFrame{
    
    public PanelSeleccion panel;
    
    public Seleccion(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Seleciona de juegos");
        panel = new PanelSeleccion(this);
        this.add(panel);
        this.setResizable(false);
        
    }
}
