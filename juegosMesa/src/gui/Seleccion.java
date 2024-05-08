package gui;

import java.awt.Color;
import javax.swing.JFrame;

public class Seleccion extends JFrame{
    PanelSeleccion panel;
    
    public Seleccion(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Selección de juegos");
        panel = new PanelSeleccion(this);
        panel.setBackground(new Color(13, 217, 67));
        this.add(panel);
        this.setResizable(false);
    }
    
}
