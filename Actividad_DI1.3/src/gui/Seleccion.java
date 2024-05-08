
package gui;
import javax.swing.JFrame;

public class Seleccion extends JFrame{
    
    public PanelSeleccion panel;
    
    public Seleccion(){
//        this.setSize(1920,1080);
        this.setSize(800,900);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Seleciona cosas");
        panel = new PanelSeleccion(this);
        this.add(panel);
        this.setResizable(false);
        
    }
}
