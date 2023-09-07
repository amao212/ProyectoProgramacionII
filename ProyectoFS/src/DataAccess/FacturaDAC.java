package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Framework.AppException;

public class FacturaDAC extends SQLiteDataHelper {
    public ResultSet getAllData() throws AppException{
        // String query =      "SELECT Id_Factura, b.Usuario_Id, c.Cliente_Nombre, d. Inventario_Nombre_Producto"
        //                     +" FROM FACTURA a"
        //                     +" JOIN USUARIO b  ON a.Usuario_Id = b.Usuario_Id"
        //                     +" JOIN CLIENTE c 	ON a.Cliente_Id_Cliente = c.Cliente_Id_Cliente"
        //                     +" JOIN INVENTARIO d 	ON a.Inventario_Id = d.Inventario_Id";
        String query = "SELECT * FROM FACTURA";

        try{
            Connection conn = openConnection();
            Statement stmt  = conn.createStatement();
            return stmt.executeQuery(query);
        }
        catch(SQLException e){
            throw new AppException(e, getClass(),"getAllData");
        }
    
    }
}
