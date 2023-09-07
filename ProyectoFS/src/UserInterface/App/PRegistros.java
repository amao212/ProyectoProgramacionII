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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import BusinessLogic.FacturaBL;
import BusinessLogic.UsuarioBL;
import BusinessLogic.Entities.Factura;
import BusinessLogic.Entities.Usuario;
import Framework.AppException;

public class PRegistros extends JFrame{
        private JPanel panel1, panel2, panel3, panel4, panel5;
        private JMenuBar menuBar;
        private JMenu menu;
        private JMenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5;

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

        // Crear los paneles
        panel1 = new JPanel(new BorderLayout());
         // Crear una tabla para mostrar los productos en el inventario
        String[] columnNames = {"Producto", "Cantidad", "Precio"};
        Object[][] data = {
            {"Producto 1", 10, 20.0},
            {"Producto 2", 15, 15.5},
            {"Producto 3", 20, 10.0},
            {"Producto 1", 10, 20.0},
            {"Producto 2", 15, 15.5},
            {"Producto 3", 20, 10.0},
            {"Producto 1", 10, 20.0},
            {"Producto 2", 15, 15.5},
            {"Producto 3", 20, 10.0},
            
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setBackground(Color.GRAY);
        panel1.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(5,4));

        // Crear un botón para agregar un nuevo producto al inventario
        JButton btnRegistrarCliente = new JButton("Registrar Cliente");
        JButton btnEliminarCliente = new JButton("Eliminar Cliente");
        JButton btnConsultarCliente = new JButton("Consultar Cliente");
        JButton btnRegresar = new JButton("Regresar Al Menu");

        JLabel lblCiCliente      = new JLabel("Ci Cliente:");
        JLabel lblNombre   = new JLabel("Nombre :");
        JLabel lblApellido            = new JLabel("Apellido :");
        JLabel lblCorreo            = new JLabel("Correo  :");
        JLabel lblDireccion         = new JLabel("Direccion :");
        JLabel lblTelefono            = new JLabel("Telefono :");

        lblCiCliente.setHorizontalAlignment(0);
        lblNombre.setHorizontalAlignment(0);
        lblDireccion.setHorizontalAlignment(0);
        lblApellido.setHorizontalAlignment(0);
        lblCorreo.setHorizontalAlignment(0);           
        lblTelefono.setHorizontalAlignment(0);      

        JTextField txtCiCliente       = new JTextField();
        JTextField txtNombre    = new JTextField();
        JTextField txtApellido        = new JTextField();
        JTextField txtCorreo            = new JTextField();
        JTextField txtDireccion         = new JTextField();
        JTextField txtTelefono            = new JTextField();

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
        bottomPanel.add(lblTelefono);
        bottomPanel.add(txtTelefono);
    
        bottomPanel.add(btnRegresar);
        bottomPanel.add(btnRegistrarCliente);
        bottomPanel.add(btnEliminarCliente);
        bottomPanel.add(btnConsultarCliente);


        bottomPanel.setBackground(Color.GRAY);
        panel1.add(bottomPanel, BorderLayout.SOUTH);

        
        panel2 = new JPanel(new BorderLayout());
        UsuarioBL usuarioBL = new UsuarioBL();
         // Crear una tabla para mostrar los productos en el inventario
        String[] etiquetas = {"Usuario", "Contraseña", "nombre","apellido","cedula"};
        Object[][] dato = new Object[usuarioBL.obtenerDatos().size()][8];
        int inde = 0;
        for (Usuario usuario : usuarioBL.obtenerDatos()) {
            dato[inde][0]= usuario.getCredencial();
            dato[inde][1]= usuario.getPassword();
            dato[inde][2]= usuario.getNombre();
            dato[inde][3]= usuario.getApellido();
            dato[inde][4]= usuario.getCedula();

            inde ++;
        }

        JTable table2 = new JTable(dato, etiquetas);
        JScrollPane scrollPane2 = new JScrollPane(table2);
        table2.setBackground(Color.GRAY);
        panel2.add(scrollPane2, 0);

        JPanel bottomPanel2 = new JPanel();
        bottomPanel2.setLayout(new GridLayout(5,4));

        // Crear un botón para agregar un nuevo producto al inventario
        JButton btnRegistrarEmpleado = new JButton("Registrar Empleado");
        JButton btnEliminarEmpleado = new JButton("Eliminar Empleado");
        JButton btnConsultarEmpleado= new JButton("Consultar Empleado");
        JButton btnRegresar2 = new JButton("Regresar Al Menu");

        JLabel lblCiEmpleado      = new JLabel("Ci Empleado:");
        JLabel lblNombreEmpleado   = new JLabel("Nombre :");
        JLabel lblApellidoEmpleado            = new JLabel("Apellido :");
        JLabel lblUsuario = new JLabel("Usuario"); 
        JLabel lblContrasena = new JLabel("Contraseña");
        JLabel lblva5 = new JLabel(""); 
        JLabel lblva6 = new JLabel("");

        lblCiEmpleado.setHorizontalAlignment(0);
        lblNombreEmpleado.setHorizontalAlignment(0);
        lblApellidoEmpleado.setHorizontalAlignment(0);
        lblUsuario.setHorizontalAlignment(0);
        lblContrasena.setHorizontalAlignment(0);   

        JTextField txtCiEmpleado      = new JTextField();
        JTextField txtUsuario      = new JTextField();
        JTextField txtContrasena      = new JTextField();
        JTextField txtNombreEmpleado  = new JTextField();
        JTextField txtApellidoEmpleado        = new JTextField();


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
        bottomPanel2.add(lblva6);

        bottomPanel2.add(btnRegresar2);
        bottomPanel2.add(btnRegistrarEmpleado);
        bottomPanel2.add(btnEliminarEmpleado);
        bottomPanel2.add(btnConsultarEmpleado);


        bottomPanel2.setBackground(Color.GRAY);
        panel2.add(bottomPanel2, BorderLayout.SOUTH);

        panel3 = new JPanel(new BorderLayout());

        // Crear una tabla para mostrar los productos en el inventario
        String[] columnNames3 = {"Producto", "Cantidad", "Precio"};
        Object[][] data3 = {
            {"Producto 1", 10, 20.0},
            {"Producto 2", 15, 15.5},
            {"Producto 3", 20, 10.0},
            {"Producto 1", 10, 20.0},
            {"Producto 2", 15, 15.5},
            {"Producto 3", 20, 10.0},
            {"Producto 1", 10, 20.0},
            {"Producto 2", 15, 15.5},
            {"Producto 3", 20, 10.0},
            
        };

        JTable table3 = new JTable(data3, columnNames3);
        JScrollPane scrollPane3 = new JScrollPane(table3);
        table3.setBackground(Color.GRAY);
        panel3.add(scrollPane3, BorderLayout.CENTER);

        JPanel bottomPanel3 = new JPanel();
        bottomPanel3.setLayout(new GridLayout(5,4));

        // Crear un botón para agregar un nuevo producto al inventario
        JButton btnAgregarProduto = new JButton("Agregar Producto");
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        JButton btnConsultarProducto = new JButton("Consultar Producto");
        JButton btnRegresar3 = new JButton("Regresar");

        JLabel lblIdProducto        = new JLabel("id Producto:");
        JLabel lblNombreProducto    = new JLabel("Nombre Producto:");
        JLabel lblPrecio            = new JLabel("Precio:");
        JLabel lblPVP               = new JLabel("Precio De Venta:");
        JLabel lblCantidad          = new JLabel("Cantidad :");
        JLabel lblva = new JLabel("");
        JLabel lblva31 = new JLabel("");

        lblIdProducto.setHorizontalAlignment(lblIdProducto.CENTER);
        lblNombreProducto.setHorizontalAlignment(lblNombreProducto.CENTER);
        lblPrecio.setHorizontalAlignment(lblPrecio.CENTER);
        lblPVP.setHorizontalAlignment(lblPVP.CENTER);           
        lblCantidad.setHorizontalAlignment(lblCantidad.CENTER);      

        JTextField txtIdProducto        = new JTextField();
        JTextField txtNombreProducto    = new JTextField();
        JTextField txtPrecio            = new JTextField();
        JTextField txtPVP               = new JTextField();
        JTextField txtCantidad          = new JTextField();

        bottomPanel3.add(lblIdProducto);
        bottomPanel3.add(txtIdProducto);
        bottomPanel3.add(lblNombreProducto);
        bottomPanel3.add(txtNombreProducto);
        bottomPanel3.add(lblPrecio);
        bottomPanel3.add(txtPrecio);
        bottomPanel3.add(lblPVP);
        bottomPanel3.add(txtPVP);
        bottomPanel3.add(lblCantidad);
        bottomPanel3.add(txtCantidad);
        bottomPanel3.add(lblva);
        bottomPanel3.add(lblva31);
        
        bottomPanel3.add(btnRegresar3);
        bottomPanel3.add(btnAgregarProduto);
        bottomPanel3.add(btnEliminarProducto);
        bottomPanel3.add(btnConsultarProducto);


        bottomPanel3.setBackground(Color.GRAY);
        panel3.add(bottomPanel3, BorderLayout.SOUTH);
        
        
        panel4 = new JPanel(new BorderLayout());

        // Crear una tabla para mostrar los productos en el inventario
        String[] columnNames4 = {"Producto", "Cantidad", "Precio"};
        Object[][] data4 = {
            {"Producto 1", 10, 20.0},
            {"Producto 2", 15, 15.5},
            {"Producto 3", 20, 10.0},
            {"Producto 1", 10, 20.0},
            {"Producto 2", 15, 15.5},
            {"Producto 3", 20, 10.0},
            {"Producto 1", 10, 20.0},
            {"Producto 2", 15, 15.5},
            {"Producto 3", 20, 10.0},
            
        };

        JTable table4 = new JTable(data4, columnNames4);
        JScrollPane scrollPane4 = new JScrollPane(table4);
        table4.setBackground(Color.GRAY);
        panel4.add(scrollPane4, BorderLayout.CENTER);

        JPanel bottomPanel4 = new JPanel();
        bottomPanel4.setLayout(new GridLayout(3,4));

        // Crear un botón para agregar un nuevo producto al inventario
        JButton btnAgregarCreditos = new JButton("Agregar Creditos");
        JButton btnEliminarCreditos= new JButton("Eliminar Creditos");
        JButton btnConsultarCreditos = new JButton("Consultar Creditos");
        JButton btnRegresar4 = new JButton("Regresar");

        JLabel lblCiCliente2        = new JLabel("Ci Cliente:");
        JLabel lblCantidadCreditos   = new JLabel("Cantidad Creditos:");
        JLabel lblva7 = new JLabel(""); 
        JLabel lblva8 = new JLabel("");
        JLabel lblva9 = new JLabel(""); 
        JLabel lblva10 = new JLabel("");

        

        lblCiCliente2.setHorizontalAlignment(lblCiCliente2.CENTER);
        lblCantidadCreditos.setHorizontalAlignment(lblCantidadCreditos.CENTER);      

        JTextField txtCiCliente2        = new JTextField();
        JTextField txtCantidadCreditos    = new JTextField();


        bottomPanel4.add(lblCiCliente2);
        bottomPanel4.add(txtCiCliente2);
        bottomPanel4.add(lblCantidadCreditos);
        bottomPanel4.add(txtCantidadCreditos);
        bottomPanel4.add(lblva7);
        bottomPanel4.add(lblva8);
        bottomPanel4.add(lblva9);
        bottomPanel4.add(lblva10);
        bottomPanel4.add(btnRegresar4);
        bottomPanel4.add(btnAgregarCreditos);
        bottomPanel4.add(btnEliminarCreditos);
        bottomPanel4.add(btnConsultarCreditos);


        bottomPanel4.setBackground(Color.GRAY);
        panel4.add(bottomPanel4, BorderLayout.SOUTH);


        
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
                            "FechaModificado"};
        Object[][] datos = new Object[facturaBL.obtenerDatos().size()][8];
        int index = 0;
        for (Factura factura : facturaBL.obtenerDatos()) {
            datos[index][0]= factura.getIdFactura();
            datos[index][1]= factura.getUsuarioId();
            datos[index][2]= factura.getClienteIdCliente();
            datos[index][3]= factura.getIdFactura();
            datos[index][4]= factura.getEstadoFactura();
            datos[index][5]= factura.getTotalFactura();
            datos[index][6]= factura.getFechaIngresFactura();
            datos[index][7]= factura.getFechaModificacionFactura();
            index ++;
        }

        JTable table5 = new JTable(datos, titulo);
        JScrollPane scrollPane5 = new JScrollPane(table5);
        table5.setBackground(Color.GRAY);
        panel5.add(scrollPane5, BorderLayout.CENTER);

        JPanel bottomPanel5 = new JPanel();
        bottomPanel5.setLayout(new GridLayout(3,4));

        // Crear la barra de menú
        menuBar = new JMenuBar();
        menu = new JMenu("Registros");
        menuBar.add(menu);

        // Crear elementos del menú para cada panel
        menuItem1 = new JMenuItem("Registro Clientes");
        menuItem2 = new JMenuItem("Registro Empleados");
        menuItem3 = new JMenuItem("Registro Inventario");
        menuItem4 = new JMenuItem("Registro Creditos");
        menuItem5 = new JMenuItem("Registro Facturas");

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

        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(panel3);
                revalidate();
            }
        });

        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(panel4);
                revalidate();
            }
        });

        menuItem5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(panel5);
                revalidate();
            }
        });

        // Agregar elementos del menú al menú
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menu.add(menuItem5);

        

        // Establecer la barra de menú en el frame
        setJMenuBar(menuBar);
       

        // Agregar el panel al JFrame
        f.add(panel);

        setLocationRelativeTo(null);
        
    }

    public void setGridBagLayout(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();

        // GridBagConstraints.ponerComponentes
        gbc.gridy = 0;       gbc.gridx=0;  //| fila,  columna
        gbc.gridwidth=3;                   //| celdas a unir
        //add(lblTitulo, gbc);               //| agrega el control

        gbc.gridy = 1;       gbc.gridx=0;   
        gbc.gridwidth=1;                     
        add(new JLabel("■ Sección de datos: "), gbc);  
        
        gbc.gridy = 2;       gbc.gridx=0;
        gbc.gridwidth=3;                   //| celdas a unir
        gbc.ipady = 150;                   //| tamaño alto
        gbc.ipadx = 450;                   //| tamaño ancho ... luego se debe restablecer a 1 o 0
        //pnlTabla.add(new Label("Loading data..."));
        //add(pnlTabla, gbc);

        gbc.ipady = 1;                    //| Restablecer el tamaño de fila y columna
        gbc.ipadx = 1;

        gbc.gridy = 4;       gbc.gridx=0; 
        gbc.gridwidth=1;    
    }
    
}
