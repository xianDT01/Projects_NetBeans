/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package combobox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JComboBox;


public class CountryComboBoxBean extends JComboBox<String> implements ItemListener {

    private CountrySelectedListener listener;

    public CountryComboBoxBean() {
        super(new String[]{"USA", "Canada", "UK", "Germany", "France", "Spain", "Italy", "Japan", "China", "Russia"});
        this.addItemListener(this);
    }

    public void addCountrySelectedListener(CountrySelectedListener listener) {
        this.listener = listener;
    }

    public void removeCountrySelectedListener(CountrySelectedListener listener) {
        this.listener = null;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (listener != null) {
                listener.countrySelected(new CountrySelectedEvent(this, (String) this.getSelectedItem()));
            }
        }
    }
}
