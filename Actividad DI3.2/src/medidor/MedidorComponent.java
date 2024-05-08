package medidor;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JProgressBar;

public class MedidorComponent extends JProgressBar implements Serializable {

    private int anchuraMax;
    private int altura;
    private int anchura;
    private BarraCuentaAtras barraEvent;
    private FinalBarra barrafinal;

    public MedidorComponent() {
        anchuraMax = 100;
        altura = 20;
        anchura = 100;
        setValue(anchura);
        setForeground(Color.blue);
    }

    public void restarCantidad(int cantidad) {
        setValue(anchura - cantidad);
        repaint();
        if (anchura <= 50) {
            barraEvent.capturarBarraCuentaAtras(new ProgresoMenor50(this));
        }
        if (anchura <= 25) {
            barrafinal.capturarProgresoMenor25(new ProgresoMenor25(this));
        }

    }

    public int getAnchuraMax() {
        return anchuraMax;
    }

    public void setAnchuraMax(int anchuraMax) {
        this.anchuraMax = anchuraMax;
        setMaximum(anchuraMax);
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
        setMinimum(altura);
        repaint();
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
        setValue(anchura);
        repaint();
    }

    public void removeFinCuentaAtrasListener(BarraCuentaAtras receptor) {
        this.barraEvent = null;
    }

    public void addProgresoMenor25(FinalBarra receptor) {
        this.barrafinal = receptor;
    }

    public void addProgresoMenor50(BarraCuentaAtras receptor) {
        this.barraEvent = receptor;
    }

    public void removeProgresoMenor25(FinalBarra receptor) {
        this.barrafinal = null;
    }

    public void removeProgresoMenor50(BarraCuentaAtras receptor) {
        this.barraEvent = null;
    }
}
