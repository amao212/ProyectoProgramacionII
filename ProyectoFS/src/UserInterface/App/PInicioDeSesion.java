package UserInterface.App;

import javax.swing.*;

import UserInterface.CustomerControl.BuLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PInicioDeSesion extends JFrame {
    private JPanel panel;
    private JLabel lblUsuario;
    private JTextField txtUsuario;
    private JLabel lblClave;
    private JPasswordField txtContraseña;
    private JButton btnIngresar;
    private JLabel lblEspacio1;

    /**
     * Constructor para inicio de sesión.
     * Crea la panatalla de inicio de sesión.
     */
    public PInicioDeSesion() {
        setTitle("SISTEMA DE FACTURACION BUHO");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        ImageIcon backgroundImg = new ImageIcon("ProyectoFS\\src\\UserInterface\\img\\login.JPG");
        Image img = backgroundImg.getImage();
        Image scaledImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImg = new ImageIcon(scaledImg);
        JLabel background = new JLabel(scaledBackgroundImg);
        background.setBounds(0, 0, 500, 500);
        add(background);

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(5, 2));

        lblUsuario = new BuLabel("Usuario :", Color.BLACK, new Font("MesloLGL Nerd Font", Font.BOLD, 20));
        panel.add(lblUsuario);

        txtUsuario = new JTextField(15);
        panel.add(txtUsuario);

        lblEspacio1 = new JLabel("");
        panel.add(lblEspacio1);

        lblEspacio1 = new JLabel("");
        panel.add(lblEspacio1);

        lblClave = new BuLabel("Contraseña :", Color.BLACK, new Font("MesloLGL Nerd Font", Font.BOLD, 20));
        panel.add(lblClave);

        txtContraseña = new JPasswordField(15);
        panel.add(txtContraseña);

        lblEspacio1 = new JLabel("");
        panel.add(lblEspacio1);

        lblEspacio1 = new JLabel("");
        panel.add(lblEspacio1);

        btnIngresar = new JButton("Login");
        panel.add(btnIngresar);

        background.setLayout(new GridBagLayout());
        background.add(panel);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

                try {
                    Connection conn = DriverManager.getConnection(dbUrl);
                    String username = txtUsuario.getText();
                    char[] arrayC = txtContraseña.getPassword();
                    String password = new String(arrayC);

                    String sql = "SELECT * FROM USUARIO WHERE Usuario_Credencial=? AND Usuario_PASSWORD=?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {

                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                        dispose();
                        PMenu menu = new PMenu();

                        // Aquí puedes redirigir al usuario a la parte principal de tu aplicación.
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "El usuario o la contraseña son incorrectos, inténtalo de nuevo");
                        // Aquí puedes mostrar un mensaje de error en la interfaz de usuario.
                    }

                    conn.close();
                } catch (SQLException a) {
                    a.printStackTrace();
                }
            }

        });
    }

    /**
     * Muestra la pantalla del inicio de sesión.
     */
    public static void mostrarInicio() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PInicioDeSesion().setVisible(true);
            }
        });
    }
}
