package BusinessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.Entities.Cliente;
import DataAccess.ClienteDAC;
import Framework.AppException;

public class ClienteBL {
    
    public Integer getMaxIdCliente() {
        try {
            ResultSet rs =   new ClienteDAC().getMaxIdCliente();
            return  rs.getInt("maxIdCliente"); 
        } 
        catch (Exception e) {
            return 0;
        }
    } 

    public List<Cliente> getAllCliente() throws AppException{
        try {
            ClienteDAC ClienteDAC = new ClienteDAC(); 
            List<Cliente> lstCliente = new ArrayList<Cliente>();

            ResultSet rs =  ClienteDAC.getAllCliente();
            while(rs.next())    {
                Cliente c = new Cliente(  rs.getInt(   "IdCliente"),
                                    rs.getString("Nombre"),
                                    rs.getString("Apellido"),
                                    rs.getString("Cedula"),
                                    rs.getString("Direccion"),
                                    rs.getString("Correo"),
                                    rs.getString("Estado"),
                                    rs.getInt("Créditos"));

                lstCliente.add(c);
            }
            return lstCliente; 
        } 
        catch (Exception e) {
            throw new AppException(e,"GetAllCliente");
        }
    } 
    
    public Cliente getClienteById(int idCliente) throws AppException{
        try {
            ClienteDAC ClienteDAC = new ClienteDAC(); 
            ResultSet rs =  ClienteDAC.getClienteById(idCliente);
            if(rs.next())    
                return new Cliente(  rs.getInt("IdCliente"),
                                    rs.getString("Nombre"),
                                    rs.getString("Apellido"),
                                    rs.getString("Cedula"),
                                    rs.getString("Direccion"),
                                    rs.getString("Correo"),
                                    rs.getString("Estado"),
                                    rs.getInt("Créditos"));

            return null;
        } 
        catch (Exception e) {
            throw new AppException(e, getClass(),"GetAllCliente");
        }
    } 

    public boolean createCliente(Cliente c) throws AppException{
        return new ClienteDAC().insertCliente(c.getNombre());
    } 
    public boolean updateCliente(Cliente c) throws AppException{
        return new ClienteDAC().updateCliente(c.getIdCliente(), c.getNombre());
    } 
    public boolean deleteCliente(int IdCliente) throws AppException{
        return new ClienteDAC().deleteCliente(IdCliente);
    } 


    
}
