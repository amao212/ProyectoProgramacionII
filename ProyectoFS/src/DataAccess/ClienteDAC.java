package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Framework.AppException;

public class ClienteDAC extends SQLiteDataHelper {

    public ResultSet getAllCliente() throws AppException{
        String query =      "SELECT * "
                             +" FROM CLIENTE a";


        try {
            Connection conn = openConnection();            
            Statement  stmt = conn.createStatement();     
            return stmt.executeQuery(query);            
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getAllCliente()");
        }
    }



}
