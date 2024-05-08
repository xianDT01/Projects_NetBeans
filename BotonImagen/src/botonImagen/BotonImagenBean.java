package botonImagen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonImagenBean extends JButton implements Serializable {

    private ImageIcon imagenPorDefecto;
    private ImageIcon imagenPulsada;
    private BotonImageListener listener;

    public BotonImagenBean() {
        imagenPorDefecto = new ImageIcon(getClass().getResource("/img/Guardar_Sin_Pulsar.jpg"));
        imagenPulsada = new ImageIcon(getClass().getResource("/img/Guardar_Pulsado.jpg"));

        this.setIcon(imagenPorDefecto);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(imagenPulsada);
                fireEvent();
            }
        });

    }

    public ImageIcon getImagenPorDefecto() {
        return imagenPorDefecto;
    }

    public void setImagenPorDefecto(ImageIcon imagenPorDefecto) {
        this.imagenPorDefecto = imagenPorDefecto;
    }

    public ImageIcon getImagenPulsada() {
        return imagenPulsada;
    }

    public void setImagenPulsada(ImageIcon imagenPulsada) {
        this.imagenPulsada = imagenPulsada;
    }

    public void addBotonImageListener(BotonImageListener newListener) {
        this.listener = newListener;
    }

    public void removeBotonImageListener() {
    this.listener = null;
}

    private void fireEvent() {
        if (listener != null) {
            BotonImagenEvent event = new BotonImagenEvent(this);
            listener.botonImageChanged(event);
        }
    }

}
