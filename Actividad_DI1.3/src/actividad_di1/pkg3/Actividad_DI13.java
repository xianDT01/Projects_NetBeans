package actividad_di1.pkg3;
import gui.BusquedaCoches;
import gui.BusquedaFrameUsuarios;
import gui.BusquedaVentaCoche;
import gui.Coches;
import gui.FrameUsuarios;
import gui.Seleccion;
import gui.VentaCoches;


public class Actividad_DI13 {

    public static void main(String[] args) {
         
      Seleccion sel = new Seleccion();
       sel.setVisible(true);
       VentaCoches venta = new VentaCoches(sel);
       /*
        BusquedaFrameUsuarios bs = new BusquedaFrameUsuarios();
        bs.setVisible(true);
        
        BusquedaCoches bc = new BusquedaCoches();
        bc.setVisible(true);
        
        BusquedaVentaCoche bco = new BusquedaVentaCoche();
        bco.setVisible(true);
       */
           /*
        Coches coche = new Coches(sel);
        coche.setVisible(true);
*/
        /*
        VentaCoches venta = new VentaCoches(sel);
        venta.setVisible(true);
         
    */
       
        
    }
    
}
