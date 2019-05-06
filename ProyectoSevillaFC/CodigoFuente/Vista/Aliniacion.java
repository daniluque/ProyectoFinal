package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.TablaJugadores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class Aliniacion extends JFrame {

	private JPanel contentPane;
	public Aliniacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox portero = new JComboBox();
		portero.setBounds(20, 224, 86, 20);
		panel.add(portero);
		
		String listaPorteros [];
		try {
			listaPorteros = TablaJugadores.listaPorteros();
			for (int i = 0; i < listaPorteros.length; i++) {
				portero.addItem(listaPorteros[i]);
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
		JComboBox defensa1 = new JComboBox();
		defensa1.setBounds(126, 58, 94, 20);
		panel.add(defensa1);
		
		JComboBox defensa2 = new JComboBox();
		defensa2.setBounds(158, 173, 86, 20);
		panel.add(defensa2);
			
		JComboBox defensa3 = new JComboBox();
		defensa3.setBounds(158, 288, 86, 20);
		panel.add(defensa3);
				
		JComboBox defensa4 = new JComboBox();
		defensa4.setBounds(134, 381, 86, 20);
		panel.add(defensa4);
		
		
		String listaDefensa [];
		try {
			listaDefensa = TablaJugadores.listaDefensa();
			for (int i = 0; i < listaDefensa.length; i++) {
				defensa1.addItem(listaDefensa[i]);
				defensa2.addItem(listaDefensa[i]);
				defensa3.addItem(listaDefensa[i]);				
				defensa4.addItem(listaDefensa[i]);
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 11, 690, 446);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\34654\\Desktop\\campo-futbol.jpg"));
		panel.add(lblNewLabel);
		
		
		
	}
}