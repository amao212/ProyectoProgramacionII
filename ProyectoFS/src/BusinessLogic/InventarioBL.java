package BusinessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.Entities.Inventario;
import DataAccess.InventarioDAC;
import Framework.AppException;

public class InventarioBL {

    public List<Inventario> getAllInventario() throws AppException{
        try {
            InventarioDAC inventarioDAC = new InventarioDAC(); 
            List<Inventario> lstInventario = new ArrayList<Inventario>();

            ResultSet rs =  inventarioDAC.getAllInventario();
            while(rs.next())    {
                Inventario s = new Inventario(  rs.getInt   ("Inventario_Id"),
                                                rs.getInt   ("Inventario_Codigo_Producto"),
                                                rs.getInt   ("Inventario_Cantidad"),
                                                rs.getString("Inventario_Nombre_Producto"),
                                                rs.getString("Inventario_Estado"),
                                                rs.getString("Inventario_FechaIngreso"),
                                                rs.getString("Inventario_FechaModificacion"),
                                                rs.getFloat ("Inventario_Costo_Producto"),
                                                rs.getFloat ("Inventario_PVP_Producto")); 
                lstInventario.add(s);
            }
            return lstInventario; 
        } 
        catch (Exception e) {
            throw new AppException(e, getClass(),"GetAllInventario");
        }
    }  
    
}
