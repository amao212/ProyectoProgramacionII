package UserInterface.App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import BusinessLogic.ClienteBL;
import BusinessLogic.FacturaBL;
import BusinessLogic.InventarioBL;
import BusinessLogic.UsuarioBL;
import BusinessLogic.Entities.Cliente;
import BusinessLogic.Entities.Factura;
import BusinessLogic.Entities.Inventario;
import BusinessLogic.Entities.Usuario;
import Framework.AppException;

public class PRegistros extends JFrame {
    private JPanel panel1, panel2, panel5;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem1, menuItem2, menuItem4;

    public PRegistros() throws AppException {
        JFrame f = new JFrame("REGISTROS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        f.setResizable(false);

        JPanel panel = new JPanel();

        ImageIcon backgroundImg = new ImageIcon("ProyectoFS\\src\\UserInterface\\img\\registrosFondo.JPG");
        Image img = backgroundImg.getImage();
        Image scaledImg = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImg = new ImageIcon(scaledImg);
        JLabel background = new JLabel(scaledBackgroundImg);
        background.setBounds(0, 0, 500, 500);
        add(background);
//--------------------------------------------------------------------------------------------------------------------------------------------------


        // Crear los paneles
        panel1 = new JPanel(new BorderLayout());
        ClienteBL clienteBL = new ClienteBL();
        // Crear una tabla para mostrar los productos en el inventario
        String[] etique = { "Ci Cliente", "Nombre", "Apellido", "Direccion", "Correo" };
        Object[][] dat = new Object[clienteBL.getAllCliente().size()][8];
        int ind = 0;
        for (Cliente cliente : clienteBL.getAllCliente()) {
            dat[ind][0] = cliente.getCedula();
            dat[ind][1] = cliente.getNombre();
            dat[ind][2] = cliente.getApellido();
            dat[ind][3] = cliente.getDireccion();
            dat[ind][4] = cliente.getCorreo();
            

            ind++;
        }

        JTable table = new JTable(dat, etique);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setBackground(Color.GRAY);
        panel1.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(5, 4));

        // Crear un botón para agregar un nuevo producto al inventario
        JButton btnRegistrarCliente = new JButton("Registrar Cliente");
        JButton btnEliminarCliente = new JButton("Eliminar Cliente");
        JButton btnConsultarCliente = new JButton("Consultar Cliente");
        JButton btnRegresar = new JButton("Regresar Al Menu");
        JButton btnLimpiar1 = new JButton("Limpiar");

        JLabel lblCiCliente = new JLabel("Ci Cliente:");
        JLabel lblNombre = new JLabel("Nombre :");
        JLabel lblApellido = new JLabel("Apellido :");
        JLabel lblCorreo = new JLabel("Correo  :");
        JLabel lblDireccion = new JLabel("Direccion :");
        JLabel lblCreditos = new JLabel("Creditos :");
        JLabel lblvvvv = new JLabel("");

        lblCiCliente.setHorizontalAlignment(0);
        lblNombre.setHorizontalAlignment(0);
        lblDireccion.setHorizontalAlignment(0);
        lblApellido.setHorizontalAlignment(0);
        lblCorreo.setHorizontalAlignment(0);
        lblCreditos.setHorizontalAlignment(0);

        JTextField txtCiCliente = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtApellido = new JTextField();
        JTextField txtCorreo = new JTextField();
        JTextField txtDireccion = new JTextField();
        JTextField txtCreditos = new JTextField();

        bottomPanel.add(lblCiCliente);
        bottomPanel.add(txtCiCliente);
        bottomPanel.add(lblNombre);
        bottomPanel.add(txtNombre);
        bottomPanel.add(lblApellido);
        bottomPanel.add(txtApellido);
        bottomPanel.add(lblCorreo);
        bottomPanel.add(txtCorreo);
        bottomPanel.add(lblDireccion);
        bottomPanel.add(txtDireccion);
        bottomPanel.add(lblCreditos);
        bottomPanel.add(txtCreditos);

        bottomPanel.add(btnRegresar);
        bottomPanel.add(btnRegistrarCliente);
        bottomPanel.add(btnEliminarCliente);
        bottomPanel.add(btnLimpiar1);
        bottomPanel.add(lblvvvv);
        bottomPanel.add(btnConsultarCliente);

        bottomPanel.setBackground(Color.GRAY);
        panel1.add(bottomPanel, BorderLayout.SOUTH);
//--------------------------------------------------------------------------------------------------------------------------------------------------


        panel2 = new JPanel(new BorderLayout());
        UsuarioBL usuarioBL = new UsuarioBL();
        // Crear una tabla para mostrar los productos en el inventario
        String[] etiquetas = { "Usuario", "Contraseña", "nombre", "apellido", "Ci Empleado" };
        Object[][] dato = new Object[usuarioBL.obtenerDatos().size()][8];
        int inde = 0;
        for (Usuario usuario : usuarioBL.obtenerDatos()) {
            dato[inde][0] = usuario.getCredencial();
            dato[inde][1] = usuario.getPassword();
            dato[inde][2] = usuario.getNombre();
            dato[inde][3] = usuario.getApellido();
            dato[inde][4] = usuario.getCedula();

            inde++;
        }

        JTable table2 = new JTable(dato, etiquetas);
        JScrollPane scrollPane2 = new JScrollPane(table2);
        table2.setBackground(Color.GRAY);
        panel2.add(scrollPane2, 0);

        JPanel bottomPanel2 = new JPanel();
        bottomPanel2.setLayout(new GridLayout(5, 4));

        // Crear un botón para agregar un nuevo producto al inventario
        JButton btnRegistrarEmpleado = new JButton("Registrar Empleado");
        JButton btnEliminarEmpleado = new JButton("Eliminar Empleado");
        JButton btnConsultarEmpleado = new JButton("Consultar Empleado");
        JButton btnRegresar2 = new JButton("Regresar Al Menu");
        JButton btnLimpiar = new JButton("Limpiar");

        JLabel lblCiEmpleado = new JLabel("Ci Empleado:");
        JLabel lblNombreEmpleado = new JLabel("Nombre :");
        JLabel lblApellidoEmpleado = new JLabel("Apellido :");
        JLabel lblUsuario = new JLabel("Usuario");
        JLabel lblContrasena = new JLabel("Contraseña");
        JLabel lblva5 = new JLabel("");
       

        lblCiEmpleado.setHorizontalAlignment(0);
        lblNombreEmpleado.setHorizontalAlignment(0);
        lblApellidoEmpleado.setHorizontalAlignment(0);
        lblUsuario.setHorizontalAlignment(0);
        lblContrasena.setHorizontalAlignment(0);

        JTextField txtCiEmpleado = new JTextField();
        JTextField txtUsuario = new JTextField();
        JTextField txtContrasena = new JTextField();
        JTextField txtNombreEmpleado = new JTextField();
        JTextField txtApellidoEmpleado = new JTextField();

        bottomPanel2.add(lblCiEmpleado);
        bottomPanel2.add(txtCiEmpleado);
        bottomPanel2.add(lblNombreEmpleado);
        bottomPanel2.add(txtNombreEmpleado);
        bottomPanel2.add(lblApellidoEmpleado);
        bottomPanel2.add(txtApellidoEmpleado);
        bottomPanel2.add(lblUsuario);
        bottomPanel2.add(txtUsuario);
        bottomPanel2.add(lblContrasena);
        bottomPanel2.add(txtContrasena);
        bottomPanel2.add(lblva5);
        bottomPanel2.add(btnLimpiar);

        bottomPanel2.add(btnRegresar2);
        bottomPanel2.add(btnRegistrarEmpleado);
        bottomPanel2.add(btnEliminarEmpleado);
        bottomPanel2.add(btnConsultarEmpleado);

        bottomPanel2.setBackground(Color.GRAY);
        panel2.add(bottomPanel2, BorderLayout.SOUTH);

//--------------------------------------------------------------------------------------------------------------------------------------------------

        panel5 = new JPanel(new BorderLayout());
        FacturaBL facturaBL = new FacturaBL();
        setGridBagLayout();

        String[] titulo = { "IdFactura",
                "Usuario",
                "Cliente",
                "Inventario",
                "Estado",
                "Total",
                "FechaIngreso",
                "FechaModificado" };
        Object[][] datos = new Object[facturaBL.obtenerDatos().size()][8];
        int index = 0;
        for (Factura factura : facturaBL.obtenerDatos()) {
            datos[index][0] = factura.getIdFactura();
            datos[index][1] = factura.getUsuarioId();
            datos[index][2] = factura.getClienteIdCliente();
            datos[index][3] = factura.getIdFactura();
            datos[index][4] = factura.getEstadoFactura();
            datos[index][5] = factura.getTotalFactura();
            datos[index][6] = factura.getFechaIngresFactura();
            datos[index][7] = factura.getFechaModificacionFactura();
            index++;
        }

        JTable table5 = new JTable(datos, titulo);
        JScrollPane scrollPane5 = new JScrollPane(table5);
        table5.setBackground(Color.GRAY);
        panel5.add(scrollPane5, BorderLayout.CENTER);

        JPanel bottomPanel5 = new JPanel();
        bottomPanel5.setLayout(new GridLayout(3, 4));

//--------------------------------------------------------------------------------------------------------------------------------------------------


        // Crear la barra de menú
        menuBar = new JMenuBar();
        menu = new JMenu("Registros");
        menuBar.add(menu);

        // Crear elementos del menú para cada panel
        menuItem1 = new JMenuItem("Registro Clientes");
        menuItem2 = new JMenuItem("Registro Empleados");
        menuItem4 = new JMenuItem("Registro Facturas");

        // Agregar ActionListener a cada elemento del menú para cambiar de panel
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(panel1);
                revalidate();
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(panel2);
                revalidate();
            }
        });


        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(panel5);
                revalidate();
            }
        });

        // Agregar elementos del menú al menú
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem4);

        // Establecer la barra de menú en el frame
        setJMenuBar(menuBar);

        // Agregar el panel al JFrame
        f.add(panel);

        setLocationRelativeTo(null);

//--------------------------------------------------------------------------------------------------------------------------------------------------

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PRegistros r;
                PMenu menu = new PMenu();
                dispose();

            }

        });
        btnRegistrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";
                String a1 =txtCiCliente.getText(); 
                String a2 =txtApellido.getText();
                String a3 =txtNombre.getText() ;
                String a4 =txtCorreo.getText() ;
                String a5 =txtDireccion.getText(); 
        
                if (a1.isEmpty() || a2.isEmpty() || a3.isEmpty() || a4.isEmpty() || a5.isEmpty() ) {

                        JOptionPane.showMessageDialog(null, "PARA REGISTRAR UN CLIENTE DEBE LLENAR TODOS LOS CAMPOS",
                                "Error", JOptionPane.ERROR_MESSAGE);
                }else{

                try {
                    Connection conn = DriverManager.getConnection(dbUrl);

                    // Supongamos que tienes campos para nombre de usuario y contraseñ ingresados
                    // por el usuario.

                    
                    String Cliente_Cedula = txtCiCliente.getText();
                    String Cliente_Apellido = txtApellido.getText();
                    String Cliente_Nombre = txtNombre.getText();
                    String Cliente_Correo = txtCorreo.getText();
                    String Cliente_Direccion = txtDireccion.getText();
                   

                    String checkUserQuery = "SELECT * FROM CLIENTE WHERE Cliente_Cedula = ?";
                    PreparedStatement checkUserStatement = conn.prepareStatement(checkUserQuery);
                    checkUserStatement.setString(1, Cliente_Cedula);
                    ResultSet resultSet = checkUserStatement.executeQuery();

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "El cliente ya está registrado.");
                    } else {
                        // Si el usuario no está registrado, agregarlo.
                        String insertUserQuery = "INSERT INTO CLIENTE (Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_FechaIngreso,Cliente_FechaMod) VALUES (?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
                        PreparedStatement insertUserStatement = conn.prepareStatement(insertUserQuery);
                        insertUserStatement.setString(1, Cliente_Nombre);
                        insertUserStatement.setString(2, Cliente_Apellido);
                        insertUserStatement.setString(3, Cliente_Cedula);
                        insertUserStatement.setString(4, Cliente_Direccion);
                        insertUserStatement.setString(5, Cliente_Correo);
                       

                        // Ejecutar la consulta INSERT para agregar el usuario.
                        int rowsAffected = insertUserStatement.executeUpdate();

                        if (rowsAffected > 0) {

                            JOptionPane.showMessageDialog(null, "Cliente agregado con éxito.");
                            txtCiCliente.setText("");
                            txtApellido.setText("");
                            txtNombre.setText("");
                            txtCorreo.setText("");
                            txtDireccion.setText("");
                            txtCreditos.setText("");    

                        } else {

                            JOptionPane.showMessageDialog(null, "No se pudo agregar el Cliente", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    conn.close();
                } catch (SQLException i) {
                    i.printStackTrace();
                }

            }}

        });

        btnEliminarCliente.addActionListener(new ActionListener(){
            

            @Override
            public void actionPerformed(ActionEvent e) {
                String a1 =txtCiCliente.getText();
                if (a1.isEmpty() ) {

                        JOptionPane.showMessageDialog(null, "PARA ELIMINAR UN CLIENTE DEBE LLENAR EL CAMPO CI CLIENTE",
                                "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                String clienteBorrar = txtCiCliente.getText();
                boolean clienteExists = checkClienteExists(clienteBorrar);

                if (clienteExists) {
                    boolean success = deleteCliente(clienteBorrar);

                    if (success) {
                        JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito.", "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el Cliente.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El Cliente no existe en la base de datos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                // Limpiar el campo de texto después de la eliminación.
                txtCiCliente.setText("");
            }} 
        
        });

        btnConsultarCliente.addActionListener(new ActionListener() {
            String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";
            

            @Override
            public void actionPerformed(ActionEvent e) {
                String a1 =txtCiCliente.getText();

                if (a1.isEmpty() ) {

                        JOptionPane.showMessageDialog(null, "PARA CONSULTAR UN CLIENTE DEBE LLENAR EL CAMPO CI CLIENTE",
                                "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                String clienteConsultar = txtCiCliente.getText();
                boolean clienteExists = checkClienteExists(clienteConsultar);

                if (clienteExists) {
                    try (Connection conn = DriverManager.getConnection(dbUrl)) {
                        String getUserQuery = "SELECT * FROM CLIENTE WHERE Cliente_Cedula = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
                        preparedStatement.setString(1, clienteConsultar);
                        ResultSet resultSet = preparedStatement.executeQuery();
            
                        if (resultSet.next()) {
                            String cn =resultSet.getString("Cliente_Nombre");
                            String cp =resultSet.getString("Cliente_Apellido");
                            String cc =resultSet.getString("Cliente_Cedula");
                            String cd =resultSet.getString("Cliente_Direccion");
                            String co =resultSet.getString("Cliente_Correo");
                            String cnc  =resultSet.getString("Cliente_NumeroCreditos");

                            txtCiCliente.setText(cc);
                            txtApellido.setText(cp);
                            txtNombre.setText(cn);
                            txtCorreo.setText(co);
                            txtDireccion.setText(cd);
                            txtCreditos.setText(cnc);                            

                            
                        }
                    } catch (SQLException o) {
                        o.printStackTrace();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "El cliente no existe en la base de datos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }}

        });

        btnLimpiar1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                            txtCiCliente.setText("");
                            txtApellido.setText("");
                            txtNombre.setText("");
                            txtCorreo.setText("");
                            txtDireccion.setText("");
                            txtCreditos.setText("");    
            }

        });
//--------------------------------------------------------------------------------------------------------------------------------------------------
        btnRegresar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PRegistros r;
                PMenu menu = new PMenu();
                dispose();

            }

        });

        btnRegistrarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";
                
                String b1 = txtCiEmpleado.getText();
                String b2 = txtApellidoEmpleado.getText();
                String b3 = txtNombreEmpleado.getText() ;
                String b4 = txtUsuario.getText();
                String b5 = txtContrasena.getText();

                if (b1.isEmpty() || b2.isEmpty() || b3.isEmpty() || b4.isEmpty() || b5.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "PARA REGISTRAR UN USUARIO DEBE LLENAR TODOS LOS CAMPOS",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                try {
                    Connection conn = DriverManager.getConnection(dbUrl);

                    // Supongamos que tienes campos para nombre de usuario y contraseñ ingresados
                    // por el usuario.

                    
                    String Usuario_Cedula = txtCiEmpleado.getText();
                    String Usuario_Apellido = txtApellidoEmpleado.getText();
                    String Usuario_Nombre = txtNombreEmpleado.getText();
                    String Usuario_Credencial = txtUsuario.getText();
                    String Usuario_PASSWORD = txtContrasena.getText();

                    String checkUserQuery = "SELECT * FROM USUARIO WHERE Usuario_Cedula = ?";
                    PreparedStatement checkUserStatement = conn.prepareStatement(checkUserQuery);
                    checkUserStatement.setString(1, Usuario_Cedula);
                    ResultSet resultSet = checkUserStatement.executeQuery();

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "El usuario ya está registrado.");
                    } else {
                        // Si el usuario no está registrado, agregarlo.
                        String insertUserQuery = "INSERT INTO USUARIO (Usuario_Credencial, Usuario_PASSWORD, Usuario_Nombre, Usuario_Apellido, Usuario_Cedula, Usuario_FechaIngreso, Usuario_FechaModificacion) VALUES (?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
                        PreparedStatement insertUserStatement = conn.prepareStatement(insertUserQuery);
                        insertUserStatement.setString(1, Usuario_Credencial);
                        insertUserStatement.setString(2, Usuario_PASSWORD);
                        insertUserStatement.setString(3, Usuario_Nombre);
                        insertUserStatement.setString(4, Usuario_Apellido);
                        insertUserStatement.setString(5, Usuario_Cedula);

                        // Ejecutar la consulta INSERT para agregar el usuario.
                        int rowsAffected = insertUserStatement.executeUpdate();

                        if (rowsAffected > 0) {

                            JOptionPane.showMessageDialog(null, "Usuario agregado con éxito.");
                            txtCiEmpleado.setText("");
                            txtApellidoEmpleado.setText("");
                            txtNombreEmpleado.setText("");
                            txtUsuario.setText("");
                            txtContrasena.setText("");

                        } else {

                            JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    conn.close();
                } catch (SQLException i) {
                    i.printStackTrace();
                }

            }}

        });

        btnEliminarEmpleado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String b1 = txtCiEmpleado.getText();

                if (b1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "PARA ELIMINAR UN USUARIO DEBE LLENAR EL CAMPO CI EMPLEADO",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                String usuarioBorrar = txtCiEmpleado.getText();
                boolean usuarioExists = checkUserExists(usuarioBorrar);

                if (usuarioExists) {
                    boolean success = deleteUser(usuarioBorrar);

                    if (success) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito.", "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario no existe en la base de datos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                // Limpiar el campo de texto después de la eliminación.
                txtCiEmpleado.setText("");
            }}
        });

        btnConsultarEmpleado.addActionListener(new ActionListener() {
            String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

            @Override
            public void actionPerformed(ActionEvent e) {

                String b1 = txtCiEmpleado.getText();

                if (b1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "PARA CONSULTAR UN USUARIO DEBE LLENAR EL CAMPO CI EMPLEADO",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                String usuarioConsultar = txtCiEmpleado.getText();
                boolean usuarioExists = checkUserExists(usuarioConsultar);

                if (usuarioExists) {
                    try (Connection conn = DriverManager.getConnection(dbUrl)) {
                        String getUserQuery = "SELECT * FROM USUARIO WHERE Usuario_Cedula = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
                        preparedStatement.setString(1, usuarioConsultar);
                        ResultSet resultSet = preparedStatement.executeQuery();
            
                        if (resultSet.next()) {
                            String u =resultSet.getString("Usuario_Credencial");
                            String p =resultSet.getString("Usuario_PASSWORD");
                            String n =resultSet.getString("Usuario_Nombre");
                            String a =resultSet.getString("Usuario_Apellido");

                            
                            txtApellidoEmpleado.setText(a);
                            txtNombreEmpleado.setText(n);
                            txtUsuario.setText(u);
                            txtContrasena.setText(p);

                            
                        }
                    } catch (SQLException o) {
                        o.printStackTrace();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "El usuario no existe en la base de datos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }}

        });

        btnLimpiar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                            txtCiEmpleado.setText("");
                            txtApellidoEmpleado.setText("");
                            txtNombreEmpleado.setText("");
                            txtUsuario.setText("");
                            txtContrasena.setText("");
            }

        });
        }
//--------------------------------------------------------------------------------------------------------------------------------------------------


    public void setGridBagLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // GridBagConstraints.ponerComponentes
        gbc.gridy = 0;
        gbc.gridx = 0; // | fila, columna
        gbc.gridwidth = 3; // | celdas a unir
        // add(lblTitulo, gbc); //| agrega el control

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3; // | celdas a unir
        gbc.ipady = 150; // | tamaño alto
        gbc.ipadx = 450; // | tamaño ancho ... luego se debe restablecer a 1 o 0
        // pnlTabla.add(new Label("Loading data..."));
        // add(pnlTabla, gbc);

        gbc.ipady = 1; // | Restablecer el tamaño de fila y columna
        gbc.ipadx = 1;

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
    }



    private static boolean checkUserExists(String username) {
        String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            String checkUserQuery = "SELECT * FROM USUARIO WHERE Usuario_Cedula = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(checkUserQuery);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // Si hay al menos una fila, el usuario existe.
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean deleteUser(String username) {
        String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            String deleteQuery = "DELETE FROM USUARIO WHERE Usuario_Cedula = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
            preparedStatement.setString(1, username);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean checkClienteExists(String cedula) {
        String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            String checkUserQuery = "SELECT * FROM CLIENTE WHERE Cliente_Cedula = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(checkUserQuery);
            preparedStatement.setString(1, cedula);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // Si hay al menos una fila, el usuario existe.
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean deleteCliente(String cedula) {
        String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            String deleteQuery = "DELETE FROM CLIENTE WHERE Cliente_Cedula = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
            preparedStatement.setString(1, cedula);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
