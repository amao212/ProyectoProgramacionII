package DataAccess;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Framework.AppException;


public class InventarioDAC extends SQLiteDataHelper {
    
    public ResultSet getAllInventario() throws AppException{
        String query ="SELECT * FROM INVENTARIO";

        try {
            Connection conn = openConnection();         // jdbc:sqlite:data\\TinderPet.db     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            return stmt.executeQuery(query);            // resultado
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getAllInventario()");
        }
    }

   

    
}



