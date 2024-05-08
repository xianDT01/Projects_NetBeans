package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorCochesDB {
    private final Connection connect;

    public GestorCochesDB(String rutaDB) {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + rutaDB);
        } catch (SQLException e) {
            conn = null;
            System.out.println(e.getMessage());
        }
        connect = conn;
    }

    public synchronized String guardarCoche(String nombreVehiculo, String modelo, String matricula, String nifUsuario, String precioInicial) {
        Statement st = null;
        try {
            st = connect.createStatement();

            // Realiza la inserción del coche en la base de datos
            String sql = "INSERT INTO Coches (NombreVehiculo, Modelo, Matricula, NIFUsuario, PrecioInicial) " +
                         "VALUES ('" + nombreVehiculo + "', '" + modelo + "', '" + matricula + "', '" + nifUsuario + "', '" + precioInicial + "')";
            st.executeUpdate(sql);

            st.close();
            return "El coche se añadió correctamente";
        } catch (SQLException ex) {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return "Problemas detectados: No se pudo agregar el coche";
        }
    }
}
