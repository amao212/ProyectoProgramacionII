package UserInterface.App;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import com.itextpdf.text.Image;

public class PFacturacion extends JFrame {
    double sumaPrecioTotal = 0.0;
    double sumaPrecioS = 0.0;
    String usu;
    
    public PFacturacion() {
        // Crear una ventana JFrame
        JFrame frame = new JFrame("Sistema de Facturación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ;

        // Crear un panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Crear un panel superior para la información de la factura
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createTitledBorder("Información de la Factura"));
        topPanel.setLayout(new GridLayout(5, 2));

        JLabel nombreCajero1 = new JLabel("");
        JLabel idCajero1 = new JLabel("");
        JLabel vclbla = new JLabel("");
        JLabel vaclbl1 = new JLabel("");
        JLabel vaclb2 = new JLabel("");

        JLabel lblCi = new JLabel("CI:");
        JTextField txtCi = new JTextField();
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblApellido = new JLabel("Apellido:");
        JTextField txtApellido = new JTextField();
        JLabel lblCorreo = new JLabel("Correo:");
        JTextField txtCorreo = new JTextField();
        JLabel lblDireccion = new JLabel("Direccion:");
        JTextField txtDireccion = new JTextField();
        JLabel lblTelefono = new JLabel("");
        JLabel txtTelefono = new JLabel("");

        JButton btnConsultar = new JButton("Consultar Cliente");
        JButton btnRegistrar = new JButton("Registrar Cliente");
        JButton btnLimpiar = new JButton("Limpiar");

        lblCi.setHorizontalAlignment(0);
        lblNombre.setHorizontalAlignment(0);
        lblApellido.setHorizontalAlignment(0);
        lblCorreo.setHorizontalAlignment(0);
        lblTelefono.setHorizontalAlignment(0);
        lblDireccion.setHorizontalAlignment(0);

        topPanel.add(nombreCajero1);
        topPanel.add(vaclbl1);
        topPanel.add(vaclb2);

        topPanel.add(idCajero1);
        topPanel.add(lblCi);
        topPanel.add(txtCi);
        topPanel.add(lblNombre);
        topPanel.add(txtNombre);
        topPanel.add(lblApellido);
        topPanel.add(txtApellido);
        topPanel.add(lblCorreo);
        topPanel.add(txtCorreo);
        topPanel.add(lblDireccion);
        topPanel.add(txtDireccion);
        topPanel.add(lblTelefono);
        topPanel.add(txtTelefono);
        topPanel.add(btnLimpiar);
        topPanel.add(btnConsultar);
        topPanel.add(btnRegistrar);
        topPanel.add(vclbla);

        // Crear un panel central para la lista de productos
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
        centerPanel.setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        model.addColumn("Nombre Producto");
        model.addColumn("Precio Unitario");
        model.addColumn("Cantidad");
        model.addColumn("Precio Sin Iva");
        model.addColumn("Precio Total");

        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Crear un panel inferior para el total
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Total"));
        bottomPanel.setLayout(new GridLayout(8, 2));

        JLabel lblTotal = new JLabel("Total:");
        JTextField txtTotal = new JTextField(10);
        txtTotal.setEditable(false);
        JLabel lblSubtotal = new JLabel("Subtotal:");
        JTextField txtSubtotal = new JTextField();

        JLabel lblIva = new JLabel("Iva:");
        JTextField txtIva = new JTextField();
        JLabel lblDineroPago = new JLabel("Dinero :");
        JTextField txtDineroPago = new JTextField();
        JLabel lblFormaPago = new JLabel("Forma de Pago:");

        JLabel lblv2 = new JLabel("");
        JLabel lblv3 = new JLabel("");
        JLabel lblv4 = new JLabel("");
        JLabel lblv5 = new JLabel("");
        JLabel lblv6 = new JLabel("");
        JLabel lblv7 = new JLabel("");
        JLabel lblCambio = new JLabel("Cambio :");
        JTextField txtCambio = new JTextField();

        txtDineroPago.setBackground(Color.GREEN);
        txtCambio.setBackground(Color.CYAN);

        txtIva.setEditable(false);

        txtSubtotal.setEditable(false);

        txtCambio.setEditable(false);

        lblCambio.setHorizontalAlignment(0);

        lblDineroPago.setHorizontalAlignment(0);
        lblFormaPago.setHorizontalAlignment(0);
        lblIva.setHorizontalAlignment(0);
        lblTotal.setHorizontalAlignment(0);
        lblSubtotal.setHorizontalAlignment(0);

        JButton btnAgregarProducto = new JButton("Agregar Producto");
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        JButton btnCalcularValores = new JButton("CalcularValores");
        JButton btnImprimirFactura = new JButton("Imprimir Factura");

        JButton btnRegresarAlMenu = new JButton("Regresar Al Menu");
        JButton btnNuevaVenta = new JButton("Nueva Venta");

        JComboBox<String> txtBucadorProducto = new JComboBox<>();

        JRadioButton rbtnEfectivo = new JRadioButton("Efectivo", true);
        JRadioButton rbtnTransferencia = new JRadioButton("Tranferencia", false);
        rbtnEfectivo.setHorizontalAlignment(0);
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(rbtnEfectivo);
        grupo1.add(rbtnTransferencia);

        bottomPanel.add(txtBucadorProducto);
        bottomPanel.add(btnAgregarProducto);
        bottomPanel.add(btnEliminarProducto);

        bottomPanel.add(btnCalcularValores);
        bottomPanel.add(lblv5);
        bottomPanel.add(lblv6);

        bottomPanel.add(lblSubtotal);
        bottomPanel.add(txtSubtotal);
        bottomPanel.add(lblFormaPago);
        bottomPanel.add(lblv2);
        bottomPanel.add(lblIva);
        bottomPanel.add(txtIva);
        bottomPanel.add(rbtnEfectivo);
        bottomPanel.add(rbtnTransferencia);

        bottomPanel.add(lblTotal);
        bottomPanel.add(txtTotal);
        bottomPanel.add(lblv3);
        bottomPanel.add(lblv4);
        bottomPanel.add(lblDineroPago);
        bottomPanel.add(txtDineroPago);

        bottomPanel.add(btnRegresarAlMenu);

        bottomPanel.add(btnNuevaVenta);
        bottomPanel.add(lblCambio);
        bottomPanel.add(txtCambio);
        bottomPanel.add(btnImprimirFactura);
        rbtnTransferencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDineroPago.setEditable(false);
                txtCambio.setText("");
            }
        });

        topPanel.setBackground(Color.GRAY);
        centerPanel.setBackground(Color.GRAY);
        bottomPanel.setBackground(Color.GRAY);
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(obtenerDatosDesdeBD());
        txtBucadorProducto.setModel(comboBoxModel);
        txtDineroPago.setText("0.0");

        // Agregar los paneles al panel principal
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Agregar el panel principal al JFrame
        frame.add(mainPanel);

        // Hacer visible la ventana
        frame.setVisible(true);
        // ------------------------------------------------------------------------------------------------------------------------------------------------------

        // -------------------------------------------------------------------------------------------------------------------------------------------------------

        btnRegresarAlMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PRegistros r;
                PMenu menu = new PMenu();
                frame.dispose();
            }

        });

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";
                String a1 = txtCi.getText();
                String a2 = txtApellido.getText();
                String a3 = txtNombre.getText();
                String a4 = txtCorreo.getText();
                String a5 = txtDireccion.getText();

                if (a1.isEmpty() || a2.isEmpty() || a3.isEmpty() || a4.isEmpty() || a5.isEmpty()) {

                    JOptionPane.showMessageDialog(null, "PARA REGISTRAR UN CLIENTE DEBE LLENAR TODOS LOS CAMPOS",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    try {
                        Connection conn = DriverManager.getConnection(dbUrl);

                        // Supongamos que tienes campos para nombre de usuario y contraseñ ingresados
                        // por el usuario.

                        String Cliente_Cedula = txtCi.getText();
                        String Cliente_Apellido = txtApellido.getText();
                        String Cliente_Nombre = txtNombre.getText();
                        String Cliente_Correo = txtCorreo.getText();
                        String Cliente_Direccion = txtDireccion.getText();
                        String Cliente_NumeroCreditos = txtCi.getText();

                        String checkUserQuery = "SELECT * FROM CLIENTE WHERE Cliente_Cedula = ?";
                        PreparedStatement checkUserStatement = conn.prepareStatement(checkUserQuery);
                        checkUserStatement.setString(1, Cliente_Cedula);
                        ResultSet resultSet = checkUserStatement.executeQuery();

                        if (resultSet.next()) {
                            JOptionPane.showMessageDialog(null, "El cliente ya está registrado.");
                        } else {
                            // Si el usuario no está registrado, agregarlo.
                            String insertUserQuery = "INSERT INTO CLIENTE (Cliente_Nombre, Cliente_Apellido, Cliente_Cedula,Cliente_Direccion,Cliente_Correo,Cliente_NumeroCreditos,Cliente_FechaIngreso,Cliente_FechaMod) VALUES (?,?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
                            PreparedStatement insertUserStatement = conn.prepareStatement(insertUserQuery);
                            insertUserStatement.setString(1, Cliente_Nombre);
                            insertUserStatement.setString(2, Cliente_Apellido);
                            insertUserStatement.setString(3, Cliente_Cedula);
                            insertUserStatement.setString(4, Cliente_Direccion);
                            insertUserStatement.setString(5, Cliente_Correo);
                            insertUserStatement.setString(6, Cliente_NumeroCreditos);

                            // Ejecutar la consulta INSERT para agregar el usuario.
                            int rowsAffected = insertUserStatement.executeUpdate();

                            if (rowsAffected > 0) {

                                JOptionPane.showMessageDialog(null, "Cliente agregado con éxito.");
                                txtCi.setText("");
                                txtApellido.setText("");
                                txtNombre.setText("");
                                txtCorreo.setText("");
                                txtDireccion.setText("");

                            } else {

                                JOptionPane.showMessageDialog(null, "No se pudo agregar el Cliente", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        conn.close();
                    } catch (SQLException i) {
                        i.printStackTrace();
                    }

                }
            }

        });

        btnConsultar.addActionListener(new ActionListener() {
            String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

            @Override
            public void actionPerformed(ActionEvent e) {
                String b1 = txtCi.getText();

                if (b1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "PARA CONSULTAR UN CLIENTE DEBE LLENAR EL CAMPO CI EMPLEADO",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String clienteConsultar = txtCi.getText();
                    boolean clienteExists = checkClienteExists(clienteConsultar);

                    if (clienteExists) {
                        try (Connection conn = DriverManager.getConnection(dbUrl)) {
                            String getUserQuery = "SELECT * FROM CLIENTE WHERE Cliente_Cedula = ?";
                            PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
                            preparedStatement.setString(1, clienteConsultar);
                            ResultSet resultSet = preparedStatement.executeQuery();

                            if (resultSet.next()) {
                                String cn = resultSet.getString("Cliente_Nombre");
                                String cp = resultSet.getString("Cliente_Apellido");
                                String cc = resultSet.getString("Cliente_Cedula");
                                String cd = resultSet.getString("Cliente_Direccion");
                                String co = resultSet.getString("Cliente_Correo");

                                txtCi.setText(cc);
                                txtApellido.setText(cp);
                                txtNombre.setText(cn);
                                txtCorreo.setText(co);
                                txtDireccion.setText(cd);

                            }
                        } catch (SQLException o) {
                            o.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente no existe en la base de datos.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }
            }

        });

        btnLimpiar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtCi.setText("");
                txtApellido.setText("");
                txtNombre.setText("");
                txtCorreo.setText("");
                txtDireccion.setText("");

            }

        });
        btnAgregarProducto.addActionListener(new ActionListener() {
            String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

            @Override
            public void actionPerformed(ActionEvent e) {

                String b1 = txtBucadorProducto.getSelectedItem().toString();

                if (b1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "PARA ARGREGAR UN PRODUCTO DEBE LLENAR EL CAMPO CI EMPLEADO",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String productoConsultar = txtBucadorProducto.getSelectedItem().toString();
                    boolean productoExists = checkProductoExists(productoConsultar);

                    if (productoExists) {
                        try (Connection conn = DriverManager.getConnection(dbUrl)) {
                            String getUserQuery = "SELECT * FROM INVENTARIO WHERE Inventario_Nombre_Producto = ?";
                            PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
                            preparedStatement.setString(1, productoConsultar);
                            ResultSet resultSet = preparedStatement.executeQuery();

                            if (resultSet.next()) {
                                String n = resultSet.getString("Inventario_Nombre_Producto");
                                double c = resultSet.getDouble("Inventario_Costo_Producto");

                                // Verificar si el usuario ingresó un valor válido
                                int cantidad = obtenerCantidadValida(frame);
                                if (cantidad != -1) {

                                    double precio = c * cantidad;
                                    double p = c * cantidad * 0.12;
                                    double precioS = precio - p;

                                    model.addRow(new Object[] { n, c, cantidad, precioS, precio });

                                }
                            }
                        } catch (SQLException o) {
                            o.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El producto no existe en la base de datos.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }
            }

        });
        btnEliminarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow();

                if (filaSeleccionada != -1) {
                    // Eliminar la fila seleccionada de la DefaultTableModel
                    model.removeRow(filaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecciona una fila para eliminar.", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnCalcularValores.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Calcula la suma de la columna "Precio Total"
                double sumaPrecioTotal = calcularSumaColumna(model, "Precio Total");

                // Calcula la suma de la columna "Precio Sin Iva"
                double sumaPrecioSinIva = calcularSumaColumna(model, "Precio Sin Iva");

                // Formatea las sumas como Strings con dos decimales
                DecimalFormat df = new DecimalFormat("#.###");
                String sumaTotalFormateada = df.format(sumaPrecioTotal);
                String sumaSinIvaFormateada = df.format(sumaPrecioSinIva);

                double dinero = Double.parseDouble(txtDineroPago.getText());
                double d = dinero - sumaPrecioTotal;
                String dine = df.format(d);
                double iva = sumaPrecioTotal - sumaPrecioSinIva;
                String ivaa = df.format(iva);

                // Crea JTextFields para mostrar las sumas
                txtCambio.setText(dine);
                txtIva.setText(ivaa);
                txtTotal.setText(sumaTotalFormateada);
                txtSubtotal.setText(sumaSinIvaFormateada);

                sumaPrecioTotal = 0.0;
                sumaPrecioS = 0.0;
            }

        });
        btnNuevaVenta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                txtCi.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                txtDireccion.setText("");
                txtCorreo.setText("");
                txtTotal.setText("");
                txtSubtotal.setText("");
                txtIva.setText("");
                txtCambio.setText("");
                txtDineroPago.setText("");

                model.setRowCount(0);

            }
        });

        // --------------------------------------------------------------------------------------------------------------

        btnImprimirFactura.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String im1 = txtCi.getText();
                String im2 = txtNombre.getText();
                String im3 = txtApellido.getText();
                String im4 = txtDireccion.getText();
                String im5 = txtCorreo.getText();
                String im6 = txtTotal.getText();
                String im7 = txtSubtotal.getText();
                String im8 = txtIva.getText();

                if (im1.isEmpty() || im2.isEmpty() || im3.isEmpty() || im4.isEmpty() || im5.isEmpty() || im6.isEmpty()
                        || im7.isEmpty() || im8.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos los campos deben estar llenos. ", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String archivoPdf = txtCi.getText() + ".pdf"; // Nombre del archivo PDF de salida

                    try {
                        // Crear un nuevo documento PDF
                        com.itextpdf.text.Document documento = new com.itextpdf.text.Document();

                        // Crear un objeto PdfWriter para escribir en el archivo PDF
                        PdfWriter.getInstance(documento, new FileOutputStream(archivoPdf));

                        // Abrir el documento para escritura
                        documento.open();
                        // Obtener la fecha y hora actual
                        Date fechaHoraActual = new Date();

                        // Formatear la fecha y hora actual como una cadena
                        SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String fechaHoraFormateada = formatoFechaHora.format(fechaHoraActual);

                        try {
                            Image imagen = Image.getInstance("ProyectoFS\\src\\UserInterface\\img\\buhologo.jpg");
                            imagen.scaleAbsolute(200, 200);
                            imagen.setAbsolutePosition(0, 0);
                            documento.add(imagen);
                        } catch (MalformedURLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                        // Agregar contenido a la factura (personaliza esto según tus necesidades)
                        Paragraph encabezado = new Paragraph("Factura");
                        Paragraph detallesCliente = new Paragraph(
                                "Cédula:      " + txtCi.getText()
                                        + "\nCliente:      " + txtNombre.getText()
                                        + "\nDirección:  " + txtDireccion.getText()
                                        +"\nCorreo:      "+txtCorreo.getText());
                        Paragraph detallesFactura = new Paragraph("Fecha:        " + fechaHoraFormateada + "\n\n");

                        // Crear una tabla para la lista de productos
                        PdfPTable tablaProductos = new PdfPTable(5); // 5 columnas para Nombre Producto, Precio
                                                                     // Unitario, Cantidad, Precio Sin Iva, Precio Total
                        tablaProductos.setWidthPercentage(100);

                        // Agregar encabezados de la tabla
                        PdfPCell celdaNombre = new PdfPCell(new Phrase("Nombre Producto"));
                        PdfPCell celdaPrecioUnitario = new PdfPCell(new Phrase("Precio Unitario"));
                        PdfPCell celdaCantidad = new PdfPCell(new Phrase("Cantidad"));
                        PdfPCell celdaPrecioSinIva = new PdfPCell(new Phrase("Precio Sin Iva"));
                        PdfPCell celdaPrecioTotal = new PdfPCell(new Phrase("Precio Total"));

                        tablaProductos.addCell(celdaNombre);
                        tablaProductos.addCell(celdaPrecioUnitario);
                        tablaProductos.addCell(celdaCantidad);
                        tablaProductos.addCell(celdaPrecioSinIva);
                        tablaProductos.addCell(celdaPrecioTotal);

                        // Obtener los datos de la JTable existente y agregarlos a la tabla del PDF
                        int numRows = model.getRowCount();

                        for (int row = 0; row < numRows; row++) {
                            String nombreProducto = model.getValueAt(row, 0).toString();
                            String precioUnitario = model.getValueAt(row, 1).toString();
                            String cantidad = model.getValueAt(row, 2).toString();
                            String precioSinIva = model.getValueAt(row, 3).toString();
                            String precioTotal = model.getValueAt(row, 4).toString();

                            tablaProductos.addCell(nombreProducto);
                            tablaProductos.addCell(precioUnitario);
                            tablaProductos.addCell(cantidad);
                            tablaProductos.addCell(precioSinIva);
                            tablaProductos.addCell(precioTotal);
                        }

                        JRadioButton seleccionado = getSelectedRadioButton(grupo1);

                        // Obtiene el nombre o texto del botón de radio seleccionado
                        String nombreSeleccionado = seleccionado.getText();

                        Paragraph total = new Paragraph("Forma de pago:  " + nombreSeleccionado
                                + "\nSubTotal:           " + txtSubtotal.getText()
                                + "\nIva:                     " + txtIva.getText()
                                + "\nTotal:                  " + txtTotal.getText());

                        // Agregar los párrafos al documento
                        
                        documento.add(encabezado);
                        documento.add(detallesCliente);
                        documento.add(detallesFactura);
                        documento.add(tablaProductos);
                        documento.add(total);

                        // Cerrar el documento
                        documento.close();
                        JOptionPane.showMessageDialog(null, "Factura generada con éxito en " + archivoPdf);
                        
                    } catch (FileNotFoundException | DocumentException l) {
                        l.printStackTrace();
                    }

                    String url = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";
            
                    try {
                        Connection conexión = DriverManager.getConnection(url);
                        
                        // Paso 1: Obtener el idUsuario basado en el nombre de usuario
                        PInicioDeSesion i = new PInicioDeSesion();
                       
                        String Usuario_Cedula = i.obtenerUsu(usu);
                        String queryObtenerId = "SELECT Usuario_Id FROM USUARIO WHERE Usuario_Cedula = ?";
                        PreparedStatement preparedStatementObtenerId = conexión.prepareStatement(queryObtenerId);
                        preparedStatementObtenerId.setString(1, Usuario_Cedula);
                        
                        ResultSet resultado = preparedStatementObtenerId.executeQuery();
                        int Usuario_Id = -1; // Valor predeterminado en caso de que no se encuentre el usuario
                        
                        if (resultado.next()) {
                            Usuario_Id = resultado.getInt("Usuario_Id");
                        }

                        String Cliente_Cedula = txtCi.getText();
                        String queryObtener = "SELECT Cliente_Id_Cliente FROM CLIENTE WHERE Cliente_Cedula = ?";
                        PreparedStatement preparedStatementObtener = conexión.prepareStatement(queryObtener);
                        preparedStatementObtener.setString(1,Cliente_Cedula);
                        
                        ResultSet resultado1 = preparedStatementObtener.executeQuery();
                        int Cliente_Id_Cliente = -1; // Valor predeterminado en caso de que no se encuentre el usuario
                        
                        if (resultado1.next()) {
                            Cliente_Id_Cliente = resultado1.getInt("Cliente_Id_Cliente");
                        }
                        String Inventario_Id = "5";
                        String Total_Factura = txtTotal.getText();
                        // Paso 2: Insertar un nuevo cliente utilizando el idUsuario obtenido
                        String queryInsertarCliente = "INSERT INTO FACTURA (Usuario_Id, Cliente_Id_Cliente, Inventario_Id,Total_Factura, FechaIngreso_Factura,FechaModificacion_Factura) VALUES (?, ?, ?, ?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
                        PreparedStatement preparedStatementInsertarCliente = conexión.prepareStatement(queryInsertarCliente);
                        preparedStatementInsertarCliente.setInt(1, Usuario_Id); // Utiliza el idUsuario obtenido
                        preparedStatementInsertarCliente.setInt(2, Cliente_Id_Cliente);
                        preparedStatementInsertarCliente.setString(3, Inventario_Id);
                        preparedStatementInsertarCliente.setString(4, Total_Factura);
                        
                        // Ejecuta el query de inserción
                        preparedStatementInsertarCliente.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Factura agregado a la base de datos con éxito.");

                        
                        // Cierra las conexiones y los statements
                        preparedStatementObtenerId.close();
                        preparedStatementInsertarCliente.close();
                        conexión.close();
                    } catch (SQLException p) {
                        p.printStackTrace();
                    }





                }
                ;

            }

        });
        

    }
  
    // --------------------------------------------------------------------------------------------------------------

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

    private static boolean checkProductoExists(String Inventario_Nombre_Producto) {
        String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            String checkUserQuery = "SELECT * FROM INVENTARIO WHERE Inventario_Nombre_Producto = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(checkUserQuery);
            preparedStatement.setString(1, Inventario_Nombre_Producto);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // Si hay al menos una fila, el usuario existe.
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static int obtenerCantidadValida(JFrame frame) {
        while (true) {
            // Solicitar la cantidad de productos
            String cantidadStr = JOptionPane.showInputDialog(frame, "Ingrese la cantidad de productos:",
                    "Cantidad de Productos", JOptionPane.QUESTION_MESSAGE);

            // Verificar si el usuario ingresó un valor válido (entero positivo)
            try {
                int cantidad = Integer.parseInt(cantidadStr);
                if (cantidad > 0) {
                    return cantidad;
                } else {
                    JOptionPane.showMessageDialog(frame, "Ingrese un número entero positivo.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static String[] obtenerDatosDesdeBD() {
        // Aquí debes realizar la conexión a tu base de datos y obtener los datos que
        // deseas mostrar en el combo.

        String[] datosDeLaBD = null;

        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlite:ProyectoFS\\\\database\\\\SistemaFacturacion.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Inventario_Nombre_Producto FROM INVENTARIO");

            // Supongamos que obtienes una lista de nombres desde la base de datos.
            Vector<String> nombres = new Vector<>();

            while (resultSet.next()) {
                String nombre = resultSet.getString("Inventario_Nombre_Producto");
                nombres.add(nombre);
            }

            // Convierte el vector de nombres en un array de strings.
            datosDeLaBD = new String[nombres.size()];
            nombres.copyInto(datosDeLaBD);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return datosDeLaBD;
    }

    private static double calcularSumaColumna(DefaultTableModel model, String columna) {
        double suma = 0.0;
        int columnaIndex = model.findColumn(columna);

        for (int fila = 0; fila < model.getRowCount(); fila++) {
            Object valor = model.getValueAt(fila, columnaIndex);
            if (valor instanceof Double) {
                suma += (Double) valor;
            }
        }
        return suma;
    }

    private static JRadioButton getSelectedRadioButton(ButtonGroup group) {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return (JRadioButton) button;
            }
        }
        return null;
    }

    // --------------------------------------------------------------------------------------------------------------
    
}
