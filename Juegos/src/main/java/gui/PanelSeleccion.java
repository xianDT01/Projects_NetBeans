package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSeleccion extends JPanel{

    private Sudoku miSudoku;
    private TresEnraya miTreRaya;
    private Conecta4 miConecta4;
    private  Seleccion ventana;
    private JLabel etiqueta;
    private JButton[] botones;

    public PanelSeleccion(Seleccion sel) {
        
        miSudoku = new Sudoku(sel);
        miTreRaya = new TresEnraya(ventana);
        miConecta4 = new Conecta4(ventana);
         ventana = sel;
        inicializaComponentes();
        setupComponentes();
        addComponentes();
         addHandlers();

    }

    public void inicializaComponentes() {
        etiqueta = new JLabel("Seleciona Juego: ");
        botones = new JButton[3];
        for (int i = 0; i < 3; i++) {
            botones[i] = new JButton();

        }
        this.setLayout(null);
    }

    public void setupComponentes() {
        botones[0].setText("Sudoku");
        botones[1].setText("TresEnRaya");
        botones[2].setText("Conecta 4");
        etiqueta.setBounds(300,50,200,60);
        etiqueta.setFont(new java.awt.Font("Segoe UI", 0, 24));
        botones[0].setBounds(300, 150, 200, 60);
        botones[1].setBounds(300, 260, 200, 60);
        botones[2].setBounds(300, 370, 200, 60);
    }

    public void addComponentes() {
        this.add(etiqueta);
        for (int i = 0; i < 3; i++) {
            this.add(botones[i]);
        }
    }
    public void addHandlers() {
        // Boton 1
        botones[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miSudoku.setVisible(true);
                ventana.setVisible(false);
            }
        });

        
        botones[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miTreRaya.setVisible(true);
                ventana.setVisible(false);
            }
        });

        
        botones[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miConecta4.setVisible(true);
                ventana.setVisible(false);
            }
        });
    }
}