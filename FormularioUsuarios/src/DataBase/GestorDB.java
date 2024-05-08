
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
 
    public synchronized  String cargarUsuario (String username) throws SQLException{
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Usuarios Where NOMBREUSUARIO= '" + username + "'");
        while (rs.next()){
            if(rs.getString("NOMBREUSUARIO").equals(username)){
                st.close();
                return username;
            }
        }
        st.close();
       return "nulo";
    }
    public synchronized String guardarUsuario(String username, String passwd, String nombre,String Apellidos, String Nif) throws SQLException{
        Statement st = connect.createStatement();
        if(cargarUsuario(username).equals("nulo")){
            
            st.executeUpdate("Insert Into Usuarios(NOMBREUSUARIO,CONTRASINAL,NOMBRE,APELLIDOS,NIF) VALUES('"+ username +"','" +passwd+ "','" + Apellidos+"','"+ nombre+"','" + Nif +"')");
            st.close();
            return  "El usuario se añadio correctamente";
        }else if(cargarUsuario(username).equals(username)){
            st.close();
            return "Problemas detectados: El usuario ya esta en la base de datos";
        }else{
            st.close();
        return "Problemas detectados: Se ha producido in error desconocido" ;
        }
           
      
    }


}
