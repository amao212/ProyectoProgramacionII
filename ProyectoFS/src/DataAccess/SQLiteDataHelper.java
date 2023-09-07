package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Framework.AppException;

public abstract class SQLiteDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:database\\SistemaFacturacion.db"; //null;
    private static Connection conn = null;
    public SQLiteDataHelper(){
        // if (!dbPathConnection.isEmpty())
        //  leer el archivo de conexcion
        //     SQLiteDataHelper.DBPathConnection = dbPathConnection;
    }
    
    protected static synchronized Connection openConnection() throws AppException{
        try {
            if(conn == null)
                conn = DriverManager.getConnection(DBPathConnection);
            System.out.println("Coneccion a la base de datos con exito.");
        } catch (SQLException e) {
            throw new AppException(e,"SQLiteDataHelper","Fallo la coneccion a la base de datos");
        } 
        return conn;
    }
    protected static void closeConnection() throws AppException{
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            throw new AppException(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
        }
    }
}
