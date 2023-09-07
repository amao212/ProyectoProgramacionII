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
                                        rs.getInt("usuario_Id"),
                                        rs.getInt("cliente_Id_Cliente"),
                                        rs.getInt("inventario_Id"),
                                        rs.getString("estado_Factura"),
                                        rs.getString("total_Factura"),
                                        rs.getString("fechaIngreso_Factura"),
                                        rs.getString("fechaModificacion_Factura"));
                lstFactura.add(f);
            }
            return lstFactura;
        } catch (Exception e) {
            throw new AppException(e, getClass(),"obtenerDatos");
        }
        
    }
}
