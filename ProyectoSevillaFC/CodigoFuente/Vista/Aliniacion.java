package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.TablaJugadores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class Aliniacion extends JFrame {

	private JPanel contentPane;

	public Aliniacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 504);
		contentPane = new JPanel();
		setTitle("Aliniación");
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Image fav = miPantalla.getImage("CodigoFuente/imagenes/s.jpg");
		setIconImage(fav);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JComboBox portero = new JComboBox();
		portero.setBounds(20, 224, 86, 20);
		panel.add(portero);

		String listaPorteros[];
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

		String listaDefensa[];
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

		JComboBox centro1 = new JComboBox();
		centro1.setBounds(335, 112, 75, 20);
		panel.add(centro1);

		JComboBox centro2 = new JComboBox();
		centro2.setBounds(335, 224, 75, 20);
		panel.add(centro2);

		JComboBox centro3 = new JComboBox();
		centro3.setBounds(335, 347, 75, 20);
		panel.add(centro3);

		String listaCentro[];
		try {
			listaCentro = TablaJugadores.listaCentrocampistas();
			for (int i = 0; i < listaCentro.length; i++) {
				centro1.addItem(listaCentro[i]);
				centro2.addItem(listaCentro[i]);
				centro3.addItem(listaCentro[i]);

			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error");
		}

		JComboBox del1 = new JComboBox();
		del1.setBounds(513, 58, 68, 20);
		panel.add(del1);

		JComboBox del2 = new JComboBox();
		del2.setBounds(524, 224, 75, 20);
		panel.add(del2);

		JComboBox del3 = new JComboBox();
		del3.setBounds(513, 381, 68, 20);
		panel.add(del3);

		String listaDelanteros[];
		try {
			listaDelanteros = TablaJugadores.listaDelanteros();
			for (int i = 0; i < listaDelanteros.length; i++) {
				del1.addItem(listaDelanteros[i]);
				del2.addItem(listaDelanteros[i]);
				del3.addItem(listaDelanteros[i]);

			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error");
		}

		JButton save = new JButton("Guardar");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					String aliniacion[] = new String[11];

					String por = (String) portero.getSelectedItem();
					aliniacion[0] = por;
					String def1 = (String) defensa1.getSelectedItem();
					String def2 = (String) defensa2.getSelectedItem();
					String def3 = (String) defensa3.getSelectedItem();
					String def4 = (String) defensa4.getSelectedItem();
					aliniacion[1] = def1;
					aliniacion[2] = def2;
					aliniacion[3] = def3;
					aliniacion[4] = def4;
					String cen1 = (String) centro1.getSelectedItem();
					String cen2 = (String) centro2.getSelectedItem();
					String cen3 = (String) centro3.getSelectedItem();
					aliniacion[5] = cen1;
					aliniacion[6] = cen2;
					aliniacion[7] = cen3;
					String d1 = (String) del1.getSelectedItem();
					String d2 = (String) del2.getSelectedItem();
					String d3 = (String) del3.getSelectedItem();
					aliniacion[8] = d1;
					aliniacion[9] = d2;
					aliniacion[10] = d3;

					String extension = ".txt";
					String ruta = "CodigoFuente/ficheros/aliniacion" + extension;
					FileWriter writer = new FileWriter(ruta);
					writer.write("Aliniacion de la Proxima semana\n");
					writer.write("\tJUGADORES TITULARES\n");
					/* Guardamos el Array en el fichero */
					for (int i = 0; i < aliniacion.length; i++) {
						writer.write(aliniacion[i]+"\n");
					}

					writer.close();
					JOptionPane.showMessageDialog(null, "Fichero creado con exito");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		save.setBounds(592, 421, 89, 23);
		panel.add(save);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 11, 690, 446);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\34654\\Desktop\\campo-futbol.jpg"));
		panel.add(lblNewLabel);

	}
}
