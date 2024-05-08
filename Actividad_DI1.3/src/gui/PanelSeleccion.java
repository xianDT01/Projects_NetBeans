package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSeleccion extends JPanel{

  private FrameUsuarios frameusuarios;
    private Coches coches;
    private VentaCoches ventacoches;
    private  Seleccion ventana;
    private BusquedaCoches busquedaCoches;
    private BusquedaFrameUsuarios busquedaFrameUsuarios;
    private BusquedaVentaCoche busquedaVentaCoche;
    private JLabel etiqueta;
    private JButton[] botones;

 public PanelSeleccion(Seleccion sel) {
    ventana = sel;
    frameusuarios = new FrameUsuarios(ventana);
    coches = new Coches(ventana);
    ventacoches = new VentaCoches(ventana);
    busquedaCoches= new BusquedaCoches(ventana);
    busquedaFrameUsuarios = new BusquedaFrameUsuarios(ventana);
    busquedaVentaCoche = new BusquedaVentaCoche(ventana);
    
    inicializaComponentes();
    setupComponentes();
    addComponentes();
    addHandlers();
}


    public void inicializaComponentes() {
        etiqueta = new JLabel("Seleciona algo :) ");
        botones = new JButton[6];
        for (int i = 0; i < 6; i++) {
            botones[i] = new JButton();

        }
        this.setLayout(null);
    }

    public void setupComponentes() {
        botones[0].setText("Frame Usuarios");
        botones[1].setText("Ventacohes");
        botones[2].setText("Coches");
        botones[3].setText("Buscar coche");
        botones[4].setText("BuscarFrameUsuario");
        botones[5].setText("BusquedaVentaCoche");
        
        etiqueta.setBounds(300,50,200,60);
        etiqueta.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botones[0].setBounds(300, 150, 200, 60);
        botones[1].setBounds(300, 260, 200, 60);
        botones[2].setBounds(300, 370, 200, 60);
        botones[3].setBounds(300, 480, 200, 60);
        botones[4].setBounds(300, 590, 200, 60);
        botones[5].setBounds(300, 700, 200, 60);
       
    }

    public void addComponentes() {
        this.add(etiqueta);
        for (int i = 0; i < 6; i++) {
            this.add(botones[i]);
        }
    }
   public void addHandlers(){
        //Boton 1
        
        botones[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frameusuarios.setVisible(true);
               ventana.setVisible(false);
              
         //Boton 2    
            }
        });{
       
   }
       
        // Boton 3
          botones[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ventacoches.setVisible(true);
               ventana.setVisible(false);
              
             
            }
        });{
       
   }

          botones[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               coches.setVisible(true);
               ventana.setVisible(false);
              
             
            }
        });{
       
            botones[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               busquedaCoches.setVisible(true);
               ventana.setVisible(false);
              
             
            }
        });{
            
           botones[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               busquedaFrameUsuarios.setVisible(true);
               ventana.setVisible(false);
              
             
            }
        });{
            
            botones[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               busquedaVentaCoche.setVisible(true);
               ventana.setVisible(false);
              
             
            }
        });{
        
    }
        
    }
     
    }
   }
   }
}
