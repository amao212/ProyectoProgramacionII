package BusinessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.Entities.Factura;
import DataAccess.FacturaDAC;
import Framework.AppException;

public class FacturaBL {
    
    public List<Factura> obtenerDatos() throws AppException{
        try {
            List <Factura> lstFactura = new ArrayList<Factura>();
            ResultSet rs = new FacturaDAC().getAllData();
            while (rs.next()) {
                Factura f = new Factura(rs.getInt("Id_Factura"),
                                        rs.getString("Usuario_Id"),
                                        rs.getString("Cliente_Id_Cliente"),
                                        rs.getString("Inventario_Id"),
                                        rs.getString("Estado_Factura"),
                                        rs.getString("Total_Factura"),
                                        rs.getString("FechaIngreso_Factura"),
                                        rs.getString("FechaModificacion_Factura"));
                lstFactura.add(f);
            }
            return lstFactura;
        } catch (Exception e) {
            throw new AppException(e, getClass(),"obtenerDatos");
        }
        
    }
}
