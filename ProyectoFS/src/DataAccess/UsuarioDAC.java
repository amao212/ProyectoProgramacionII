package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Framework.AppException;

public class UsuarioDAC extends SQLiteDataHelper{
    public ResultSet getAllData() throws AppException{
        String query =      "SELECT * "
                            +" FROM USUARIO a";



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
