

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Xian Durán
 */
public class TemporizadorBean extends JLabel implements Serializable, ActionListener {
    
      private Timer t;
       private FinCuentaAtrasListener receptor;
    public TemporizadorBean() {
        tiempo = 5;
        t = new Timer (1000, this); 
        setText(Integer.toString(tiempo));
        setActivo(true);
        
    }
    
        private int tiempo;

    /**
     * Get the value of tiempo
     *
     * @return the value of tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Set the value of tiempo
     *
     * @param tiempo new value of tiempo
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
        setText(Integer.toString(tiempo));
        repaint();
    }
    
    public final void setActivo(boolean valor) {
    if (valor == true)
        t.start();
     else
        t.stop();
    }
    public boolean getActivo() {
        return t.isRunning();
       }

    @Override
    public void actionPerformed(ActionEvent e) {
        setText(Integer.toString(tiempo));
        repaint();
        tiempo--;
        if(tiempo == 0){
            setActivo(false);
            receptor.capturarFinCuentaAtras(new FinCuentaAtrasEvent(this));
        }
    }
    
        public void addFinCuentaAtrasListener(FinCuentaAtrasListener receptor){
        this.receptor = receptor;
        }
        public void removeFinCuentaAtrasListener(FinCuentaAtrasListener receptor){
        this.receptor=null;
        }

    
}
