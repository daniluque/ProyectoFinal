package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import Modelo.Conexion;
import Modelo.TablaJugadores;

import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Jugadores extends JFrame {

	private JPanel contentPane;

	private JTable tabla;
	// Esta clase abre la ventana de los jugadores con sus botones

	public Jugadores(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		tabla = new JTable();
		tabla.setEnabled(false);
		tabla.setBounds(22, 22, 561, 338);
		panel.add(tabla);

		/**
		 * Creamos el objeto con las columnas y le pasamos el modelo por defecto junto a
		 * un scroll
		 */
		Object[][] data = new Object[0][0];
		String[] datos = { "Nombre", "Equipo", "Dorsal", "Posicion", "Puntuacion", "Jornada" };
		DefaultTableModel modelo = new DefaultTableModel(data, datos);
		tabla.setModel(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setEnabled(false);
		
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		getContentPane().add(scroll, BorderLayout.NORTH);
		/* HACEMOS LA CONSULTA */
		try {
			ResultSet rs = TablaJugadores.dameListaPersonas();
			while (rs.next()) {
				Object[] fila = new Object[6];
				for (int i = 0; i < 6; i++)
					fila[i] = rs.getObject(i + 1);
				modelo.addRow(fila);
			}

		} catch (Exception e) {
			System.out.println("Ha ocurrido un error\nVisite el log.");
		}

		/**
		 * Boton que me abre la ventana de ingresar
		 */
		JButton insertar = new JButton("Insertar Jugador");
		insertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingresar ingreso = new Ingresar();
				dispose();
				ingreso.setVisible(true);
			}
		});
		insertar.setBounds(10, 11, 131, 23);
		panel.add(insertar);

		/**
		 *Me genera un fichero en MD donde me recoje las cosas ma
		 *importante
		 */
		JButton informe = new JButton("Generar informe");
		informe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = TablaJugadores.dameListaCompleta();
				try {
					String extension = ".md";
					String ruta = "CodigoFuente/ficheros/fichero" + extension;
					FileWriter writer = new FileWriter(ruta);
					writer.write("# Lista de Jugadores y Datos\n\n");
					writer.write("## Id\tNombre\tPuntos\n");
					/* Siguiente linea escribe bbdd en fichero */
					while (rs.next()) {

						writer.write("- *" + rs.getString("id") + "*\t");
						writer.write("*" + rs.getString("nombre") + "*\t");
						writer.write("*" + rs.getString("puntuacion") + "*\t\n\n");
					}
					writer.close();
					JOptionPane.showMessageDialog(null, "Fichero creado con exito");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		informe.setBounds(208, 11, 146, 23);
		panel.add(informe);

		/**
		 * Texto de el filtro
		 */
		JLabel lblFiltrarPorJornada = new JLabel("Filtrar por jornada");
		lblFiltrarPorJornada.setBounds(415, 15, 99, 14);
		panel.add(lblFiltrarPorJornada);

		/**
		 * Añado los Items a el combobox de seleccion de jornada
		 * 
		 */
		JComboBox filtrojornada = new JComboBox();
		int[] listaJornadas;
		try {
			listaJornadas = TablaJugadores.listaJornadas();
			for (int i = 0; i < listaJornadas.length; i++) {
				filtrojornada.addItem(listaJornadas[i]);
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error");
		}
		filtrojornada.setBounds(524, 12, 34, 20);
		panel.add(filtrojornada);

		/**
		 * El boton que al clikar nos filtra por la jornada que queramos
		 */
		JButton buscar = new JButton("OK");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					/*Recojo el numero de la jornada siempre dentro del TRY*/
					int jor = (int) filtrojornada.getSelectedItem();
					/* Nueva Consulta */
					ResultSet rs = TablaJugadores.filtrar(jor);
					/* Limpiar la tabla */
					int filas = modelo.getRowCount();
					for (int i = 0; i < filas; i++)
						modelo.removeRow(0);

					/* Fin de la consulta */
					while (rs.next()) {
						Object[] fila = new Object[6];
						for (int i = 0; i < 6; i++)
							fila[i] = rs.getObject(i + 1);
						modelo.addRow(fila);

					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error");
				}

			}

		});
		buscar.setBounds(568, 11, 47, 23);
		panel.add(buscar);
	}

}
