package UserInterface.App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PInventario extends JFrame {

    public PInventario(){
       
       JFrame frame = new JFrame("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        

        JPanel panel = new JPanel(new BorderLayout());

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
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(5,4));

        // Crear un botón para agregar un nuevo producto al inventario
        JButton btnAgregarProduto = new JButton("Agregar Producto");
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        JButton btnConsultarProducto = new JButton("Consultar Producto");
        JButton btnRegresar = new JButton("Regresar");

        JLabel lblIdProducto        = new JLabel("id Producto:");
        JLabel lblNombreProducto    = new JLabel("Nombre Producto:");
        JLabel lblPrecio            = new JLabel("Precio:");
        JLabel lblPVP               = new JLabel("Precio De Venta:");
        JLabel lblCantidad          = new JLabel("Cantidad :");
        JLabel lblva = new JLabel("");
        JLabel lblva1 = new JLabel("");

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
        bottomPanel.add(lblva1);
        
        bottomPanel.add(btnRegresar);
        bottomPanel.add(btnAgregarProduto);
        bottomPanel.add(btnEliminarProducto);
        bottomPanel.add(btnConsultarProducto);


        bottomPanel.setBackground(Color.GRAY);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Agregar el panel al frame
        add(panel);

        setLocationRelativeTo(null); // Centrar el frame en la pantalla
        
        
    }
    
        
    
}
