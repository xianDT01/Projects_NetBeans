package DataBase;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorDB {
    
   private final Connection connect;
   
public GestorDB(String rutaDB) {
    Connection conn;
    try {
        conn = DriverManager.getConnection("jdbc:sqlite:" + rutaDB);
        System.out.println("Conexión a la base de datos establecida con éxito.");
    } catch (SQLException e) {
        conn = null;
        System.out.println("Error al conectar a la base de datos: " + e.getMessage());
    }
    connect = conn;
}


   public synchronized String cargarUsuario(String nombreUsuario) throws SQLException {
    String resultado = null;
    try (Statement st = connect.createStatement()) {
        ResultSet rs = st.executeQuery("SELECT * FROM Usuarios WHERE nombre = '" + nombreUsuario + "'");
        if (rs.next()) {
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String nif = rs.getString("nif");

            resultado = "Nombre: " + nombre + ", Apellidos: " + apellidos + ", NIF: " + nif;
        }
    } catch (SQLException ex) {
        throw ex;
    }

    return resultado;
}
   
public synchronized String guardarUsuario(String nombre, String apellido, String Nif) throws SQLException {
    Statement st = connect.createStatement();
    
    String resultadoCargarUsuario = cargarUsuario(nombre);
    
    if (resultadoCargarUsuario == null) {
        st.executeUpdate("Insert Into Usuarios(NOMBRE,APELLIDOS,NIF) VALUES('" + nombre + "','" + apellido + "','" + Nif + "')");
        st.close();
        return "El usuario se añadió correctamente";
    } else if (resultadoCargarUsuario.equals(apellido)) {
        st.close();
        return "Problemas detectados: El usuario ya está en la base de datos";
    } else {
        st.close();
        return "Problemas detectados: Se ha producido un error desconocido";
    }
}



   
    // Coche ******************************************************************

public synchronized String cargarCoche(String matricula, String vendedorNIF) throws SQLException {
    String resultado = "nulo";

    try (Statement st = connect.createStatement()) {
        ResultSet rs = st.executeQuery("SELECT * FROM Coches WHERE MATRICULA = '" + matricula + "' AND VendedorNIF = '" + vendedorNIF + "'");
        
        if (rs.next()) {
            String modelo = rs.getString("MODELO");
            String precioInicial = rs.getString("PRECIO_INICIAL");
            String estado = rs.getString("ESTADO");

            resultado = "Coche Matrícula: " + matricula + "\n" +
                    "Modelo: " + modelo + "\n" +
                    "Precio Inicial: " + precioInicial + "\n" +
                    "Estado: " + estado + "\n" +
                    "Vendedor NIF: " + vendedorNIF;
        }
    } catch (SQLException ex) {
        throw ex;
    }

    return resultado;
}


public synchronized String guardarCoche(String modelo, String matricula, String precioInicial, String estado, String vendedorNIF) throws SQLException {
    Statement st = connect.createStatement();
    if (cargarCoche(matricula, vendedorNIF).equals("nulo")) {
        st.executeUpdate("INSERT INTO Coches(MODELO, MATRICULA, PRECIO_INICIAL, ESTADO, VendedorNIF) VALUES('" + modelo + "','" + matricula + "','" + precioInicial + "','" + estado + "','" + vendedorNIF + "')");
        st.close();
        return "El coche se añadió correctamente";
    } else {
        st.close();
        return "Problemas detectados: El coche ya está en la base de datos para el vendedor con NIF: " + vendedorNIF;
    }
}

// Ventas ****************************************************  
    
 
public synchronized String cargarVentaPorMatriculaYComprador(String cocheMatricula, String compradorNIF) throws SQLException {
    String resultado = "nulo";
    
    try (Statement st = connect.createStatement()) {
        ResultSet rs = st.executeQuery("SELECT * FROM Ventas WHERE CocheMatricula = '" + cocheMatricula + "' AND CompradorNIF = '" + compradorNIF + "'");
        
        if (rs.next()) {
            resultado = "Venta Coche Matrícula: " + cocheMatricula + ", Comprador NIF: " + compradorNIF + ", Precio Final: " + rs.getDouble("PrecioFinal");
        }
    } catch (SQLException ex) {
       
        throw ex;
    }

    return resultado;
}




public synchronized String guardarVenta(String cocheMatricula, String compradorNIF, double precioFinal, String fechaVenta) throws SQLException {
    Statement st = connect.createStatement();
    st.executeUpdate("INSERT INTO Ventas (CocheMatricula, CompradorNIF, PrecioFinal, FechaVenta) VALUES ('" + cocheMatricula + "', '" + compradorNIF + "', " + precioFinal + ", '" + fechaVenta + "')");
    st.close();
    return "Venta registrada correctamente";
}
}
