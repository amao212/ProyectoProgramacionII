package UserInterface.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PFacturacion extends JFrame {

    public PFacturacion() {
        // Crear una ventana JFrame
        JFrame frame = new JFrame("Sistema de Facturación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);

        // Crear un panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Crear un panel superior para la información de la factura
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createTitledBorder("Información de la Factura"));
        topPanel.setLayout(new GridLayout(5, 2));

        JLabel nombreCajero = new JLabel("Cajero:");
        JLabel idCajero = new JLabel("idCajero:");
        JLabel nombreCajero1 = new JLabel("");
        JLabel idCajero1 = new JLabel("");
        JLabel vaclbl = new JLabel("");


        JLabel lblCi = new JLabel("CI:");
        JTextField txtCi = new JTextField();
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombe = new JTextField();
        JLabel lblApellido = new JLabel("Apellido:");
        JTextField txtApellido = new JTextField();
        JLabel lblCorreo = new JLabel("Correo:");
        JTextField txtCorreo = new JTextField();
        JLabel lblDireccion = new JLabel("Direccion:");
        JTextField txtDireccion= new JTextField();
        JLabel lblTelefono = new JLabel("Telefono:");
        JTextField txtTelefono = new JTextField();

        JButton btnConsultar = new JButton("Consultar Cliente");
        JButton btnRegistrar = new JButton("Registrar Cliente");

        lblCi       .setHorizontalAlignment(0);
        lblNombre   .setHorizontalAlignment(0);
        lblApellido .setHorizontalAlignment(0);
        lblCorreo   .setHorizontalAlignment(0);
        lblTelefono .setHorizontalAlignment(0);
        lblDireccion.setHorizontalAlignment(0);
        nombreCajero.setHorizontalAlignment(0);
        idCajero    .setHorizontalAlignment(0);
        
        
        topPanel.add(nombreCajero);
        topPanel.add(nombreCajero1);
        topPanel.add(idCajero);
        topPanel.add(idCajero1);
        topPanel.add(lblCi);
        topPanel.add(txtCi);
        topPanel.add(lblNombre);
        topPanel.add(txtNombe);
        topPanel.add(lblApellido);
        topPanel.add(txtApellido);
        topPanel.add(lblCorreo);
        topPanel.add(txtCorreo);
        topPanel.add(lblDireccion);
        topPanel.add(txtDireccion);
        topPanel.add(lblTelefono);
        topPanel.add(txtTelefono);
        topPanel.add(vaclbl);
        topPanel.add(btnConsultar);
        topPanel.add(btnRegistrar);
        
        
        

        // Crear un panel central para la lista de productos
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
        centerPanel.setLayout(new BorderLayout());

        
        

        // Crear una tabla para mostrar los productos
        String[] columnas = {"Producto", "Cantidad", "Precio Unitario", "Subtotal"};
        Object[][] datos = {
            {"Producto 1", 2, 10.0, 20.0},
            {"Producto 2", 3, 15.0, 45.0},
            {"Producto 1", 2, 10.0, 20.0},
            {"Producto 2", 3, 15.0, 45.0},
            {"Producto 1", 2, 10.0, 20.0},
            {"Producto 2", 3, 15.0, 45.0},
            {"Producto 1", 2, 10.0, 20.0},

            // Agrega más filas según necesites
        };

        JTable tablaProductos = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        

        // Crear un panel inferior para el total
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Total"));
        bottomPanel.setLayout(new GridLayout(8,2));

        JLabel lblTotal = new JLabel("Total:");
        JTextField txtTotal = new JTextField(10);
        txtTotal.setEditable(false);
        JLabel lblSubtotal = new JLabel("Subtotal:");
        JTextField txtSubtotal = new JTextField();
        JLabel lblCreditos = new JLabel("Creditos:");
        JTextField txtCreditos = new JTextField();
        JLabel lblDescuento = new JLabel("Descuento:");
        JTextField txtDescuento = new JTextField();
        JLabel lblIva = new JLabel("Iva:");
        JTextField txtIva = new JTextField();
        JLabel lblDineroPago = new JLabel("Dinero :");
        JTextField txtDineroPago = new JTextField();
        JLabel lblFormaPago = new JLabel("Forma de Pago:");
        JLabel lblv1 = new JLabel("");
        JLabel lblv2 = new JLabel("");
        JLabel lblv3 = new JLabel("");
        JLabel lblv4 = new JLabel("");
        JLabel lblCambio = new JLabel("Cambio :");
        JTextField txtCambio = new JTextField();

        txtDineroPago.setBackground(Color.GREEN);
        txtCambio.setBackground(Color.CYAN);

        txtIva.setEditable(false);
        txtDescuento.setEditable(false);
        txtSubtotal.setEditable(false);
        txtCreditos.setEditable(false);
        txtCambio.setEditable(false);

        lblCambio       .setHorizontalAlignment(0);
        lblCreditos     .setHorizontalAlignment(0);
        lblDescuento    .setHorizontalAlignment(0);
        lblDineroPago   .setHorizontalAlignment(0);
        lblFormaPago    .setHorizontalAlignment(0);
        lblIva          .setHorizontalAlignment(0);
        lblTotal        .setHorizontalAlignment(0);
        lblSubtotal     .setHorizontalAlignment(0);
        
        
        
        JButton btnAgregarProducto = new JButton("Agregar Producto");
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        JButton btnImprimirFactura =  new JButton("Imprimir Factura");
        JButton btnUsarCreditos =  new JButton("Usar Creditos");
        JButton btnRegresarAlMenu =  new JButton("Regresar Al Menu");
        JButton btnNuevaVenta=  new JButton("Nueva Venta");
        
        
        
        JTextField txtBucadorProducto =  new JTextField("");
        

        JRadioButton rbtnEfectivo = new JRadioButton("Efectivo",true);
        JRadioButton rbtnTransferencia = new JRadioButton("Tranferencia",false);
        rbtnEfectivo.setHorizontalAlignment(0);
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(rbtnEfectivo);
        grupo1.add(rbtnTransferencia);

        
        bottomPanel.add(txtBucadorProducto);
        bottomPanel.add(btnAgregarProducto);
        bottomPanel.add(btnEliminarProducto);

        bottomPanel.add(lblv1);
        bottomPanel.add(lblCreditos);
        bottomPanel.add(txtCreditos);
        bottomPanel.add(lblSubtotal);
        bottomPanel.add(txtSubtotal);
        bottomPanel.add(lblDescuento);
        bottomPanel.add(txtDescuento);
        bottomPanel.add(lblIva);
        bottomPanel.add(txtIva);
        bottomPanel.add(lblDineroPago);
        bottomPanel.add(txtDineroPago);
        bottomPanel.add(lblTotal);
        bottomPanel.add(txtTotal);
        bottomPanel.add(lblCambio);
        bottomPanel.add(txtCambio);
        
        bottomPanel.add(lblv2);
        bottomPanel.add(lblv3);
        bottomPanel.add(lblFormaPago);
        bottomPanel.add(lblv4);

        bottomPanel.add(btnRegresarAlMenu);
        bottomPanel.add(btnUsarCreditos);
        
        
        bottomPanel.add(rbtnEfectivo);
        bottomPanel.add(rbtnTransferencia);

        bottomPanel.add(btnNuevaVenta);
        bottomPanel.add(btnImprimirFactura);

        topPanel.setBackground(Color.GRAY);
        centerPanel.setBackground(Color.GRAY);
        bottomPanel.setBackground(Color.GRAY);

        // Agregar los paneles al panel principal
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        // Agregar el panel principal al JFrame
        frame.add(mainPanel);

        // Hacer visible la ventana
        frame.setVisible(true);

        btnRegresarAlMenu.addActionListener(new ActionListener(){


            @Override
            public void actionPerformed(ActionEvent e) {
                PRegistros r;
                PMenu menu = new PMenu();
                frame.dispose();
            }
    
        });
    }

}
    

