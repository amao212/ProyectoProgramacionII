package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Framework.AppException;

public class ClienteDAC extends SQLiteDataHelper {

    public ResultSet getMaxIdCliente() throws AppException{
        String query =" SELECT  COUNT(*) maxIdCliente"
                     +" FROM    CLIENTE"
                     +" WHERE   Estado ='A' ";

        try {
            Connection conn = openConnection();             
            Statement  stmt = conn.createStatement();      
            return stmt.executeQuery(query);            
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getMaxIdCliente()");
        }
    }

    public ResultSet getAllCliente() throws AppException{
        String query =  "SELECT  Cliente_Id_Cliente" +
                              ", Cliente_Nombre " + 
                              ", Cliente_Apellido" + 
                              ", Cliente_Cedula" + 
                              ", Cliente_Direccion" + 
                              ", Cliente_Correo" + 
                              ", Cliente_Estado" + 
                              ", Cliente_NumeroCreditos " + 
                              " FROM CLIENTE WHERE ESTADO = 'A' " ;

        try {
            Connection conn = openConnection();            
            Statement  stmt = conn.createStatement();     
            return stmt.executeQuery(query);            
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getAllCliente()");
        }
    }

    public ResultSet getClienteById(int IdCliente) throws AppException  {
        String query =  "SELECT  Cliente_Id_Cliente" +
                              ", Cliente_Nombre " + 
                              ", Cliente_Apellido" + 
                              ", Cliente_Cedula" + 
                              ", Cliente_Direccion" + 
                              ", Cliente_Correo" + 
                              ", Cliente_Estado" + 
                              ", Cliente_NumeroCreditos " + 
                              " FROM CLIENTE WHERE ESTADO = 'A' " +
                              " AND    Cliente_Id_Cliente = ? ";
        try {
            Connection          conn = openConnection(); 
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, IdCliente);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            //System.out.println(sql);
            throw new AppException(e, getClass(), "getClienteById()");
        }
    }

    public ResultSet getClienteByNombre(String nombreCliente) throws AppException  {
        String query =  "SELECT  Cliente_Id_Cliente" +
                              ", Cliente_Nombre " + 
                              ", Cliente_Apellido" + 
                              ", Cliente_Cedula" + 
                              ", Cliente_Direccion" + 
                              ", Cliente_Correo" + 
                              ", Cliente_NumeroCreditos " + 
                              " FROM CLIENTE WHERE ESTADO = 'A' " +
                            " AND     Cliente_Nombre = ? ";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, nombreCliente);
            return pstmt.executeQuery();
        } 
        catch (SQLException e) {
            //System.out.println(sql);
            throw new AppException(e, getClass(), "getClienteById()");
        }
    }

    public boolean insertCliente(String nombreCliente) throws AppException  {
        String query = " INSERT INTO CLIENTE (Cliente_Nombre) VALUES (?)";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, nombreCliente);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getClienteById()");
        }
    }

    public boolean updateCliente(int IdCliente, String nombreCliente) throws AppException  {
        String query = " UPDATE CLIENTE SET Cliente_Nombre = ? WHERE Cliente_Id_Cliente = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, nombreCliente);
            pstmt.setInt(2, IdCliente);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getClienteById()");
        }
    }
    public boolean deleteCliente(int IdCliente) throws AppException  {
        String query = " UPDATE CLIENTE SET Estado = ? WHERE Cliente_Id_Cliente = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, IdCliente);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new AppException(e, getClass(), "getClienteById()");
        }
    }
}
