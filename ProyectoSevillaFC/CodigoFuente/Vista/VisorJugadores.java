package Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.Main;
import Modelo.Conexion;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SingleSelectionModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class VisorJugadores extends JFrame {
	private JTextField name;
	private JTextField dorsal;
	//Esta clase abre la ventana de los jugadores con sus botones
	
	public VisorJugadores() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		this.setMinimumSize(new Dimension(800,600));
		/*Creo el modelo con su metodo Default*/
		DefaultTableModel modelo = new DefaultTableModel();
		/*Lo aplico al JPanel*/
		tabla = new JTable(modelo);
		
		/*Le añado los campos del nombre*/
		modelo.addColumn("Nombre");
		modelo.addColumn("Dorsal");
		modelo.addColumn("Puntos");
		tabla.setBounds(42, 25, 646, 137);
		/*Creamo variable interna de ResultSet y llamamos a la funcion
		 * que nos realiza la consulta que nos tiene que deolver un return ResulSet(Tipo Static)*/
		ResultSet rs = Conexion.dameListaPersonas();
		try {
			while(rs.next()) {
				Object [] fila = new Object[3];
				 for (int i=0;i<3;i++)
				      fila[i] = rs.getObject(i+1);
				 modelo.addRow(fila); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(tabla);
		
		
		name = new JTextField();
		name.setBounds(142, 198, 105, 23);
		panel.add(name);
		name.setColumns(10);
		
		dorsal = new JTextField();
		dorsal.setBounds(265, 199, 32, 22);
		panel.add(dorsal);
		dorsal.setColumns(10);
	
		JButton insertJugador = new JButton("A\u00F1adir Jugador");
		insertJugador.setBounds(10, 197, 122, 23);
		insertJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Las comillas simples indica que el campo de la bbd es texto*/
			Conexion.ejecutarUpdate("Insert into jugadores(nombre,dorsal) "
			+ "VALUES('"+name.getText()+"',"+dorsal.getText()+")");
			
			}
		});
		panel.add(insertJugador);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(142, 173, 46, 14);
		panel.add(lblNombre);
			
		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setBounds(265, 173, 46, 14);
		panel.add(lblDorsal);
		
		
		
	}
	private Object[][] datosFila = { { "Tomas Vaclik", 10, 1, "Portero" },
			{ "Pablo Sarabia", 10, 17, "Centro Campista" } };
	private String[] nombreColumnas = { "Nombre", "Puntos", "Dorsal", "Posicion" };
	private JTable tabla;
}
