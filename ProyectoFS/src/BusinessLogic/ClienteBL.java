package BusinessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.Entities.Cliente;
import DataAccess.ClienteDAC;
import Framework.AppException;

public class ClienteBL {
    


    public List<Cliente> getAllCliente() throws AppException{
        try {
            ClienteDAC ClienteDAC = new ClienteDAC(); 
            List<Cliente> lstCliente = new ArrayList<Cliente>();

            ResultSet rs =  ClienteDAC.getAllCliente();
            while(rs.next())    {
                Cliente c = new Cliente(  rs.getInt(   "Cliente_Id_Cliente"),
                                    rs.getString("Cliente_Nombre"),
                                    rs.getString("Cliente_Apellido"),
                                    rs.getString("Cliente_Cedula"),
                                    rs.getString("Cliente_Direccion"),
                                    rs.getString("Cliente_Correo"),
                                    rs.getString("Cliente_Estado"),
                                    rs.getInt("Cliente_NumeroCreditos"));

                lstCliente.add(c);
            }
            return lstCliente; 
        } 
        catch (Exception e) {
            throw new AppException(e,"GetAllCliente");
        }
    } 
    
}
