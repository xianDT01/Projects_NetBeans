

package combobox;

import java.util.EventObject;


public class CountrySelectedEvent extends EventObject{
    private final String selectedCountry;
    
    public CountrySelectedEvent(Object source, String selectedCountry) {
        super(source);
        this.selectedCountry = selectedCountry;
    }
    public String getSelectedCountry() {
        return selectedCountry;
    }
    

}
