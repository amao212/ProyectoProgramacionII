package UserInterface.App;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.CustomerControl.BuButton;
import UserInterface.CustomerControl.BuLabel;

public class PMenu {
    public PMenu(){
        // Crear un JFrame
        JFrame frame = new JFrame("Menú");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400); // Tamaño del frame
        frame.setResizable(false);

        // Crear un JPanel para contener los botones con disposición vertical
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,3,200,20)); 
        
        

        // Crear tres botones y agregarlos al panel
        JButton btnRegistros = new JButton("Registros");
        JButton btnInventario = new JButton("Inventario");
        JButton btnNuevaFac = new JButton("Nueva Factura");
        JButton vacio = new JButton();
        JLabel encabezado = new BuLabel("Menu:", Color.BLUE, new Font("MesloLGL Nerd Font", Font.BOLD ,  20)); 
        vacio.setVisible(false);

        encabezado.setHorizontalAlignment(0);

          
        panel.add(vacio);
        panel.add(encabezado);
        panel.add(btnRegistros);
        panel.add(btnInventario);
        panel.add(btnNuevaFac);


        // Establecer el color de fondo del JPanel en gris
        panel.setBackground(Color.DARK_GRAY);

        // Agregar el panel al JFrame
        frame.add(panel);

        // Obtener el tamaño de la pantalla principal
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle pantallaPrincipal = ge.getMaximumWindowBounds();

        // Establecer la ubicación del JFrame en el centro de la pantalla principal
        int x = (pantallaPrincipal.width - frame.getWidth()) / 2;
        int y = (pantallaPrincipal.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        // Hacer visible el JFrame
        frame.setVisible(true);
    
    }
    
}
