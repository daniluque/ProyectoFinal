package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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


public class VisorJugadores extends JFrame {
	
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisorJugadores frame = new VisorJugadores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	private JPanel contentPane;
	private static final long serialVersionUID = 4049634590287015989L;
	/** La tabla */	
	private JTable tabla;
	/** La ventana */	
	private JFrame ventana;
	/** El scroll para la tabla */	
	private JScrollPane scroll;

	/*public VisorJugadores() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		// TABLA
		JTable tabla = new JTable(datosFila, nombreColumnas);
		contentPane.add(tabla, BorderLayout.CENTER);
		add(new JScrollPane(tabla), BorderLayout.CENTER);

	}*/
	 public void creaYMuestraVentana()
		{
	    	ventana = new JFrame("Contenido base de datos");
	    	if (tabla == null)
	        	tabla = new JTable();
	    	scroll = new JScrollPane(tabla);
	    	ventana.getContentPane().add(scroll);
	    	ventana.pack();
	    	ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    	ventana.setVisible(true);
	    	JButton botonInfo = new JButton("Generar Informe");
		}

		/**
	 	* Mete el modelo que recibe en la tabla.
	 	* @param modelo
	 	*/
		public void tomaDatos(DefaultTableModel modelo){
	    	if (tabla == null)
	        	tabla = new JTable();
	    	tabla.setModel(modelo);
		}

	
	/*private String[] nombreColumnas = { "Nombre", "Puntos", "Dorsal", "Posicion" };
	private Object[][] datosFila = { { "Tomas Vaclik", 10, 1, "Portero" },
			{ "Pablo Sarabi", 10, 17, "Centro Campista" } };*/
	
	
	
}
