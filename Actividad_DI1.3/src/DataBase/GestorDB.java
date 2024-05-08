package DataBase;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorDB {
    
   private final Connection connect;
   
   public GestorDB (String rutaDB){
       Connection conn;
       try{
           conn = DriverManager.getConnection("jdbc:sqlite:" + rutaDB);
       }catch (SQLException e){
           conn = null;
           System.out.println(e.getMessage());
       }
       connect = conn;
   }
 
    public synchronized  String cargarUsuario (String nombre) throws SQLException{
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM usuarios Where nombre= '" + nombre + "'");
        while (rs.next()){
            if(rs.getString("nombre").equals(nombre)){
                st.close();
                return nombre;
            }
        }
        st.close();
       return "nulo";
    }
    public synchronized String guardarUsuario( String nombre,String apellido, String Nif) throws SQLException{
        Statement st = connect.createStatement();
        if(cargarUsuario(nombre).equals("nulo")){
            
            st.executeUpdate("Insert Into Usuarios(NOMBRE,APELLIDOS,NIF) VALUES('"+ nombre+"','"+ apellido+"','" + Nif +"')");
            st.close();
            return  "El usuario se añadio correctamente";
        }else if(cargarUsuario(nombre).equals(apellido)){
            st.close();
            return "Problemas detectados: El usuario ya esta en la base de datos";
        }else{
            st.close();
        return "Problemas detectados: Se ha producido in error desconocido" ;
        }
         
      
    }
    
    // Coche ******************************************************************

public synchronized String cargarCoche(String matricula, String vendedorNIF) throws SQLException {
    Statement st = connect.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM Coches WHERE MATRICULA = '" + matricula + "' AND VendedorNIF = '" + vendedorNIF + "'");
    while (rs.next()) {
        if (rs.getString("MATRICULA").equals(matricula) && rs.getString("VendedorNIF").equals(vendedorNIF)) {
            st.close();
            return matricula;
        }
    }
    st.close();
    return "nulo";
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
    Statement st = connect.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM Ventas WHERE CocheMatricula = '" + cocheMatricula + "' AND CompradorNIF = '" + compradorNIF + "'");
    while (rs.next()) {
        if (rs.getString("CocheMatricula").equals(cocheMatricula) && rs.getString("CompradorNIF").equals(compradorNIF)) {
            st.close();
            return "Venta Coche Matrícula: " + cocheMatricula + ", Comprador NIF: " + compradorNIF + ", Precio Final: " + rs.getDouble("PrecioFinal");
        }
    }
    st.close();
    return "nulo";
}

public synchronized String guardarVenta(String cocheMatricula, String compradorNIF, double precioFinal, String fechaVenta) throws SQLException {
    Statement st = connect.createStatement();
    st.executeUpdate("INSERT INTO Ventas (CocheMatricula, CompradorNIF, PrecioFinal, FechaVenta) VALUES ('" + cocheMatricula + "', '" + compradorNIF + "', " + precioFinal + ", '" + fechaVenta + "')");
    st.close();
    return "Venta registrada correctamente";
}
}
