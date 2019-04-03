package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.Consulta;

import javax.swing.JTabbedPane;
import javax.swing.SingleSelectionModel;

public class VisorJugadores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public VisorJugadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabla = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabla, BorderLayout.CENTER);
		DefaultTableModel modelo = new DefaultTableModel();
		
		//Cambiar a consulta con un parametro
		ResultSet rs = Consulta.ejecutarSentencia("select * from jugadores", "nombre");
		modelo.setColumnIdentifiers(new Object[] {"Nombres","Apellidos"});
		
		try {
			while(rs.next()) {
			modelo.addRow(new Object[] {rs.getString("nombre"),rs.getString("Apellidos")});
			}
			tabla.setModel((SingleSelectionModel) modelo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
