
package combobox;

import java.util.EventListener;


public interface CountrySelectedListener extends EventListener{
    void countrySelected(CountrySelectedEvent event);
}
