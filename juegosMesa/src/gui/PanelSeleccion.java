package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSeleccion extends JPanel {

    private Sudoku miSudoku;
    private TresRaya miTresRaya;
    private Conecta4 miConecta4;
    private Seleccion ventana;
    private JLabel etiqueta;
    private JButton[] botones;

    public PanelSeleccion(Seleccion sel) {
        ventana = sel;
        miSudoku = new Sudoku(ventana);
        miTresRaya = new TresRaya(ventana);
        miConecta4 = new Conecta4(ventana);

        inicializaComponentes();
        setupComponentes();
        addComponentes();
        addHandlers();
        generaAyuda();
    }

    public void inicializaComponentes() {
        etiqueta = new JLabel("Selecciona juego:");
        botones = new JButton[4];
        for (int i = 0; i < 4; i++) {
            botones[i] = new JButton();
        }
        this.setLayout(null);
    }

    public void setupComponentes() {
        botones[0].setText("Sudoku");
        botones[1].setText("Tres en raya");
        botones[2].setText("Conecta 4");
        botones[3].setText("Ayuda");
        etiqueta.setBounds(300, 50, 200, 60);
        etiqueta.setFont(new java.awt.Font("Tahoma", 0, 24));
        botones[0].setBounds(300, 150, 200, 60);
        botones[1].setBounds(300, 260, 200, 60);
        botones[2].setBounds(300, 370, 200, 60);
        botones[3].setBounds(300, 480, 200, 60);
    }

    public void addComponentes() {
        this.add(etiqueta);
        for (int i = 0; i < 4; i++) {
            this.add(botones[i]);
        }
    }

    public void addHandlers() {
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
                miTresRaya.setVisible(true);
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

    private void generaAyuda() {
        try {
            File archivo = new File("ayuda/help_set.hs");
            URL helpSetURL = archivo.toURI().toURL();
            HelpSet miHelpSet = new HelpSet(getClass().getClassLoader(), helpSetURL);
            HelpBroker miHelpBroker = miHelpSet.createHelpBroker();
//Aquí asignamos la ayuda a los elementos de la interfaz
            miHelpBroker.enableHelpOnButton(botones[3], "presentacion", miHelpSet);
            miHelpBroker.enableHelpKey(this, "presentacion", miHelpSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
