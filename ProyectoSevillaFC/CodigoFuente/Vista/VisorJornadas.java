package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.xdevapi.Statement;
import Modelo.Conexion;
import javax.swing.JTabbedPane;
import javax.swing.SingleSelectionModel;
import javax.swing.JButton;

public class VisorJornadas extends JFrame {

	private JPanel contentPane;
	
	
	
	public VisorJornadas() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTabbedPane tablaJornadas = new JTabbedPane(JTabbedPane.TOP);
		tablaJornadas.setBounds(10, 11, 414, 105);
		panel.add(tablaJornadas);
		
		JButton btnAadirJornada = new JButton("A\u00F1adir jornada");
		btnAadirJornada.setBounds(10, 143, 112, 23);
		panel.add(btnAadirJornada);
		
		try {
			
			
			
			
		}catch (Exception e) {
			
		}
		
	}

}
