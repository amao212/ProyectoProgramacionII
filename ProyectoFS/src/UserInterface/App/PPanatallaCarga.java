package UserInterface.App;

import javax.swing.*;
import java.awt.*;


public class PPanatallaCarga extends JWindow {
    private JWindow jw;
    private final String direccion = "ProyectoFS\\src\\UserInterface\\img\\splash3.gif";
    private final static int time = 5000;

    /**
     * Constructor para la pantalla de carga.
     * Crea la panatalla de panatalla de carga (Splash)
     */
    public PPanatallaCarga() {
        jw = new JWindow();
        var image = new ImageIcon(direccion);
        jw.getContentPane().add(new JLabel("", image, SwingConstants.CENTER));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jw.setBounds(  (int) ((screenSize.getWidth() - image.getIconWidth()) / 2),
        (int) ((screenSize.getHeight() - image.getIconHeight()) / 2),
        image.getIconWidth(),       image.getIconHeight());


    }
    /** Valida si hay un tiempo de carga / mantiene la pantalla visible por un tiempo definido
     * @param elapsedTime tiempo de presentación de la pantalla de carga
     */
    public void cargarPantallaDeCarga(int elapsedTime) {
        jw.setVisible(true);
        try {
            Thread.sleep(elapsedTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jw.setVisible(false);
        jw.dispose();
    }

    /**
     * Muestra la pantalla de carga (Splash)
     */
    public static void mostrarPantallaDeCargaP(){
        var splash = new PPanatallaCarga();
        splash.cargarPantallaDeCarga(time);
    }
}
