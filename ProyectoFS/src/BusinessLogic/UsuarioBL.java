package BusinessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.Entities.Usuario;
import DataAccess.UsuarioDAC;
import Framework.AppException;

public class UsuarioBL {
    public List<Usuario> obtenerDatos() throws AppException{
        try {
            List <Usuario> lstUsuario = new ArrayList<Usuario>();
            ResultSet rs = new UsuarioDAC().getAllData();
            while (rs.next()) {
                Usuario f = new Usuario(rs.getInt("Usuario_Id"),
                                        rs.getString("Usuario_Credencial"),
                                        rs.getString("Usuario_PASSWORD"),
                                        rs.getString("Usuario_Nombre"),
                                        rs.getString("Usuario_Apellido"),
                                        rs.getString("Usuario_Cedula"),
                                        rs.getString("Usuario_Estado"),
                                        rs.getString("Usuario_FechaIngreso"),
                                        rs.getString("Usuario_FechaModificacion"));
                lstUsuario.add(f);
            }
            return lstUsuario;
        } catch (Exception e) {
            throw new AppException(e, getClass(),"obtenerDatos");
        }

    }

}
