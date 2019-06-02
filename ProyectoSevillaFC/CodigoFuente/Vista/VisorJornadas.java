package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JTable;

public class VisorJornadas extends JFrame {

	private JPanel contentPane;
	
	
	
	public VisorJornadas() {
		this.setMinimumSize(new Dimension(800,600));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 764, 482);
		getContentPane().add(panel);
		
		
	}
}
