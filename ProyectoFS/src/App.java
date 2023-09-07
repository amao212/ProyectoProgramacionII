
import DataAccess.SQLiteDataHelper;
import UserInterface.App.PFacturacion;
import UserInterface.App.PInicioDeSesion;
import UserInterface.App.PInventario;
import UserInterface.App.PMenu;
import UserInterface.App.PPanatallaCarga;
import UserInterface.App.PRegistros;

public class App {
    public static void main(String[] args) throws Exception {
        //PPanatallaCarga.mostrarPantallaDeCargaP();
        //PInicioDeSesion.mostrarInicio();
        //PMenu menu = new PMenu();
        //PFacturacion p = new PFacturacion();
        PInventario in = new PInventario();
        in.setVisible(true);
        PRegistros r = new PRegistros();
        r.setVisible(true);
        //SQLiteDataHelper.openConnection();

    }
}
