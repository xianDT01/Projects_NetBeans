/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package toggle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JToggleButton;


public class ToggleButtonBean extends JToggleButton implements Serializable, ItemListener { //ItemListener también para JCheckBox, JRadioButton

    public ToggleButtonBean() {
        super("Sin pulsar");
        this.addItemListener(this);
        this.setBackground(Color.GREEN);
    }

    /*
 itemStateChanged es un método de la interfaz ItemListener.
Propósito: Este método se llama automáticamente cada vez que se produce un cambio de estado en el componente al que está escuchando. 
Por ejemplo, en un JToggleButton, se llama cuando el botón cambia entre seleccionado (pulsado) y no seleccionado (no pulsado).
Parámetro: Recibe un objeto ItemEvent, que contiene información sobre el evento, incluyendo el nuevo estado del componente 
    (seleccionado o no seleccionado).
    
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            this.setText("Pulsado");
            this.setBackground(Color.PINK);
            this.setFont(new Font("Times New Roman", Font.BOLD, 16));
        } else {
            this.setText("Sin pulsar");
            this.setBackground(Color.GREEN);
            this.setFont(new Font("Times New Roman", Font.ITALIC, 10));
        }
    }
    /*
    ItemListener es una interfaz en el paquete java.awt.event. Se utiliza para recibir eventos de cambio de estado.
    extiende JToggleButton e implementa ItemListener, lo que significa que tu botón personalizado puede manejar
    eventos de cambio de estado por sí mismo. Al sobrescribir itemStateChanged, defines qué sucede cuando el estado del botón cambia.
    
    Al agregar this.addItemListener(this); en el constructor, estás registrando el botón para recibir sus propios eventos de cambio de
    estado. Así, cada vez que se pulsa o se suelta el botón, itemStateChanged se activa y ejecuta el código que definiste para
    responder a esos cambios.
    
    
     */

}
