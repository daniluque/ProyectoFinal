package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.TablaJugadores;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Inicio extends JFrame {

	private JPanel contentPane;

	public Inicio() {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 708, 403);
		contentPane = new JPanel();
		setTitle("Inicio");
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Image fav = miPantalla.getImage("CodigoFuente/imagenes/s.jpg");
		setIconImage(fav);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVerJugadoresY = new JButton("VER JUGADORES Y PUNTOS");
		btnVerJugadoresY.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/icons8-b\u00FAsqueda-24.png")));
		btnVerJugadoresY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jugadores visor = new Jugadores();
				dispose();
				visor.setVisible(true);
				
				
			}
		});
		btnVerJugadoresY.setBounds(99, 56, 463, 88);
		contentPane.add(btnVerJugadoresY);
		
		JButton btnNewButton = new JButton("Hacer aliniación");
		btnNewButton.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/icons8-estadio-24.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aliniacion visor = new Aliniacion();
				dispose();
				visor.setVisible(true);
			}
		});
		btnNewButton.setBounds(99, 227, 199, 83);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exportar csv");
		btnNewButton_1.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/icons8-exportaci\u00F3n-de-base-de-datos-24.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs = TablaJugadores.dameListaCompleta();
				try {
					String extension = ".csv";
					String ruta = "CodigoFuente/ficheros/basededatos" + extension;
					FileWriter writer = new FileWriter(ruta);
					writer.write("id;nombre;equipo;dorsal;posicion;puntuacion;id_jornada\n");
					/* Siguiente linea escribe bbdd en fichero */
					while (rs.next()) {
						
						writer.write(rs.getString("id") +";"+rs.getString("nombre")+";"
								+rs.getString("equipo") + ";"+rs.getString("dorsal")+";"
								+rs.getString("posision") + ";"+rs.getString("puntuacion")+";"
								+rs.getString("id_jornada")+"\n");
					}
					writer.close();
					JOptionPane.showMessageDialog(null, "Fichero creado con exito");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnNewButton_1.setBounds(363, 227, 199, 83);
		contentPane.add(btnNewButton_1);
		
	}
}
