package UserInterface.App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import BusinessLogic.InventarioBL;
import BusinessLogic.Entities.Inventario;
import Framework.AppException;

public class PInventario extends JFrame {
    private InventarioBL inventarioBL = new InventarioBL();
    String[] columnNames = {"Codigo Producto", "Producto", "Cantidad", "PVP","PRECIO C" };
    Object[][] data;

    public PInventario() throws AppException {

        JFrame frame = new JFrame("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        showTable();

        JPanel panel = new JPanel(new BorderLayout());

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setBackground(Color.GRAY);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(5, 4));

        // Crear un botón para agregar un nuevo producto al inventario
        JButton btnAgregarProduto = new JButton("Agregar Producto");
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        JButton btnConsultarProducto = new JButton("Consultar Producto");
        JButton btnRegresar = new JButton("Regresar");
        JButton btnLimpiar = new JButton("Limpiar");

        JLabel lblIdProducto = new JLabel("id Producto:");
        JLabel lblNombreProducto = new JLabel("Nombre Producto:");
        JLabel lblPrecio = new JLabel("Precio:");
        JLabel lblPVP = new JLabel("Precio De Venta:");
        JLabel lblCantidad = new JLabel("Cantidad :");
        JLabel lblva = new JLabel("");
        

        lblIdProducto.setHorizontalAlignment(lblIdProducto.CENTER);
        lblNombreProducto.setHorizontalAlignment(lblNombreProducto.CENTER);
        lblPrecio.setHorizontalAlignment(lblPrecio.CENTER);
        lblPVP.setHorizontalAlignment(lblPVP.CENTER);
        lblCantidad.setHorizontalAlignment(lblCantidad.CENTER);

        JTextField txtIdProducto = new JTextField();
        JTextField txtNombreProducto = new JTextField();
        JTextField txtPrecio = new JTextField();
        JTextField txtPVP = new JTextField();
        JTextField txtCantidad = new JTextField();

        bottomPanel.add(lblIdProducto);
        bottomPanel.add(txtIdProducto);
        bottomPanel.add(lblNombreProducto);
        bottomPanel.add(txtNombreProducto);
        bottomPanel.add(lblPrecio);
        bottomPanel.add(txtPrecio);
        bottomPanel.add(lblPVP);
        bottomPanel.add(txtPVP);
        bottomPanel.add(lblCantidad);
        bottomPanel.add(txtCantidad);
        bottomPanel.add(lblva);
        bottomPanel.add(btnLimpiar);

        bottomPanel.add(btnRegresar);
        bottomPanel.add(btnAgregarProduto);
        bottomPanel.add(btnEliminarProducto);
        bottomPanel.add(btnConsultarProducto);

        bottomPanel.setBackground(Color.GRAY);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Agregar el panel al frame
        add(panel);

        setLocationRelativeTo(null); // Centrar el frame en la pantalla

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PRegistros r;
                PMenu menu = new PMenu();
                dispose();

            }

        });
        
        btnAgregarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";
                
                String b1 = txtIdProducto.getText();
                String b2 = txtNombreProducto.getText();
                String b3 = txtPrecio.getText() ;
                String b4 = txtPVP.getText();
                String b5 = txtCantidad.getText();

                if (b1.isEmpty() || b2.isEmpty() || b3.isEmpty() || b4.isEmpty() || b5.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "PARA AGREGAR UN PRODUCTO DEBE LLENAR TODOS LOS CAMPOS",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                try {
                    Connection conn = DriverManager.getConnection(dbUrl);

                    // Supongamos que tienes campos para nombre de usuario y contraseñ ingresados
                    // por el usuario.

                    
                    String Inventario_Codigo_Producto = txtIdProducto.getText();
                    String Inventario_Nombre_Producto = txtNombreProducto.getText();
                    String Inventario_Costo_Producto = txtPrecio.getText();
                    String Inventario_PVP_Producto = txtPVP.getText();
                    String Inventario_Cantidad = txtCantidad.getText();

                    String checkUserQuery = "SELECT * FROM INVENTARIO WHERE Inventario_Codigo_Producto = ?";
                    PreparedStatement checkUserStatement = conn.prepareStatement(checkUserQuery);
                    checkUserStatement.setString(1, Inventario_Codigo_Producto);
                    ResultSet resultSet = checkUserStatement.executeQuery();

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "El PRODUCTO ya está registrado.");
                    } else {
                        // Si el usuario no está registrado, agregarlo.
                        String insertUserQuery = "INSERT INTO INVENTARIO (Inventario_Codigo_Producto, Inventario_Nombre_Producto, Inventario_Costo_Producto, Inventario_Cantidad, Inventario_PVP_Producto, Inventario_FechaIngreso, Inventario_FechaModificacion) VALUES (?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
                        PreparedStatement insertUserStatement = conn.prepareStatement(insertUserQuery);
                        insertUserStatement.setString(1, Inventario_Codigo_Producto);
                        insertUserStatement.setString(2, Inventario_Nombre_Producto);
                        insertUserStatement.setString(3, Inventario_Costo_Producto);
                        insertUserStatement.setString(4, Inventario_Cantidad);
                        insertUserStatement.setString(5, Inventario_PVP_Producto);
               

                        // Ejecutar la consulta INSERT para agregar el usuario.
                        int rowsAffected = insertUserStatement.executeUpdate();

                        if (rowsAffected > 0) {

                            JOptionPane.showMessageDialog(null, "Producto agregado con éxito.");
                            txtIdProducto.setText("");
                            txtNombreProducto.setText("");
                            txtPrecio.setText("");
                            txtPVP.setText("");
                            txtCantidad.setText("");

                        } else {

                            JOptionPane.showMessageDialog(null, "No se pudo agregar el producto", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    conn.close();
                } catch (SQLException i) {
                    i.printStackTrace();
                }

            }}

        });

        btnEliminarProducto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String b1 = txtIdProducto.getText();

                if (b1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "PARA ELIMINAR UN PRODUCTO DEBE LLENAR EL CAMPO CI EMPLEADO",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                String productoBorrar = txtIdProducto.getText();
                boolean productoExists = checkProductoExists(productoBorrar);

                if (productoExists) {
                    boolean success = deleteProducto(productoBorrar);

                    if (success) {
                        JOptionPane.showMessageDialog(null, "Producto eliminado con éxito.", "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el Producto.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El Producto no existe en la base de datos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                // Limpiar el campo de texto después de la eliminación.
                txtIdProducto.setText("");
            }}
        });

        btnConsultarProducto.addActionListener(new ActionListener() {
            String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

            @Override
            public void actionPerformed(ActionEvent e) {

                String b1 = txtIdProducto.getText();

                if (b1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "PARA CONSULTAR UN PRODUCTO DEBE LLENAR EL CAMPO CI EMPLEADO",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                String productoConsultar = txtIdProducto.getText();
                boolean productoExists = checkProductoExists(productoConsultar);

                if (productoExists) {
                    try (Connection conn = DriverManager.getConnection(dbUrl)) {
                        String getUserQuery = "SELECT * FROM INVENTARIO WHERE Inventario_Codigo_Producto = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
                        preparedStatement.setString(1, productoConsultar);
                        ResultSet resultSet = preparedStatement.executeQuery();
            
                        if (resultSet.next()) {
                            String n =resultSet.getString("Inventario_Nombre_Producto");
                            String c =resultSet.getString("Inventario_Costo_Producto");
                            String ca =resultSet.getString("Inventario_Cantidad");
                            String p =resultSet.getString("Inventario_PVP_Producto");

                            
                            txtNombreProducto.setText(n);
                            txtPrecio.setText(c);
                            txtCantidad.setText(ca);
                            txtPVP.setText(p);

                            
                        }
                    } catch (SQLException o) {
                        o.printStackTrace();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "El producto no existe en la base de datos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }}

        });

        btnLimpiar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                            txtIdProducto.setText("");
                            txtNombreProducto.setText("");
                            txtCantidad.setText("");
                            txtPrecio.setText("");
                            txtPVP.setText("");
            }

        });
        

    }

    public void showTable() throws AppException {
        data = new Object[inventarioBL.getAllInventario().size()][5];
        int index3 = 0;
        for (Inventario s : inventarioBL.getAllInventario()) {
            data[index3][0] = s.getCodigoProduto();
            data[index3][1] = s.getNombreProduto();
            data[index3][2] = s.getCantidadProducto();
            data[index3][3] = s.getPvpProducto();
            data[index3][4] = s.getCostoProducto();
            
            index3++;
        }
    }

    private static boolean checkProductoExists(String Codigo_Producto) {
        String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            String checkUserQuery = "SELECT * FROM INVENTARIO WHERE Inventario_Codigo_Producto = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(checkUserQuery);
            preparedStatement.setString(1, Codigo_Producto);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // Si hay al menos una fila, el usuario existe.
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean deleteProducto(String Codigo_Producto) {
        String dbUrl = "jdbc:sqlite:ProyectoFS\\database\\SistemaFacturacion.db";

        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            String deleteQuery = "DELETE FROM INVENTARIO WHERE Inventario_Codigo_Producto = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
            preparedStatement.setString(1, Codigo_Producto);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
