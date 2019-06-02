package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import Atxy2k.CustomTextField.RestrictedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;
import Modelo.TablaJugadores;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ingresar extends JFrame {

	private JPanel contentPane;
	
	private JTextField nombre;
	private JTextField numero;
	private JTextField jornada;
	
	public Ingresar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 392);
		contentPane = new JPanel();
		setTitle("Alta de jugador");

		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Image fav = miPantalla.getImage("CodigoFuente/imagenes/s.jpg");
		setIconImage(fav);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		nombre = new JTextField();
		nombre.setBounds(38, 173, 86, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		RestrictedTextField r1 = new RestrictedTextField(nombre," abcdefghijklmnñopqrstuvwxyzáíóúé");
		
		numero = new JTextField();
		numero.setBounds(163, 173, 46, 20);
		contentPane.add(numero);
		numero.setColumns(10);
		RestrictedTextField r2 = new RestrictedTextField(numero,"0123456789");
		r2.setLimit(2);
		
		
		
		JComboBox selec = new JComboBox();
		selec.addItem("Portero");
		selec.addItem("Defensa");
		selec.addItem("Centrocampista");
		selec.addItem("Delantero");
		selec.setBounds(248, 173, 99, 20);
		contentPane.add(selec);
			
		
		JComboBox puntos = new JComboBox();
		puntos.addItem(1);
		puntos.addItem(2);
		puntos.addItem(3);
		puntos.addItem(4);
		puntos.addItem(5);
		
		puntos.setBounds(401, 173, 49, 20);
		contentPane.add(puntos);
		JLabel titulo = new JLabel("Gesti\u00F3n de jugadores del club");
		titulo.setFont(new Font("Sylfaen", Font.BOLD, 16));
		titulo.setBounds(198, 11, 334, 69);
		contentPane.add(titulo);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(38, 148, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setBounds(163, 148, 46, 14);
		contentPane.add(lblDorsal);
		
		JLabel lblPosicion = new JLabel("Posicion");
		lblPosicion.setBounds(248, 148, 74, 14);
		contentPane.add(lblPosicion);
		
		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setBounds(401, 148, 46, 14);
		contentPane.add(lblPuntos);
		
		JLabel lblJornada = new JLabel("Jornada");
		lblJornada.setBounds(493, 148, 46, 14);
		contentPane.add(lblJornada);
		
		jornada = new JTextField();
		jornada.setBounds(493, 173, 74, 20);
		contentPane.add(jornada);
		jornada.setColumns(10);
		
		RestrictedTextField r3 = new RestrictedTextField(jornada,"0123456789");
		r3.setLimit(2);
		
		/*BOTON DE AÑADIR CON SU FUNCIONALIDAD*/
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String seleccionado = (String)selec.getSelectedItem();
					int puntoseleccionado = (int)puntos.getSelectedItem();
					TablaJugadores.insertarJugador(nombre.getText(), numero.getText(), seleccionado, 
					puntoseleccionado, jornada.getText());
					JOptionPane.showMessageDialog(null,"Añadido con exito");
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null,"ERROR");
				}
			}
		});
		btnAadir.setBounds(279, 293, 89, 23);
		contentPane.add(btnAadir);		
	}
}
