package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import Vista.Inicio;
public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 200, 682, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(passwordField.getText().equals("Hola")&& txtUsuario.getText().equals("1234") ) {
					System.out.println("Entraste");					
				}
			}

			
		});
		btnEntrar.setBounds(464, 147, 121, 46);
		contentPane.add(btnEntrar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(149, 147, 203, 25);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setBackground(Color.LIGHT_GRAY);
		txtpnUsuario.setText("Usuario");
		txtpnUsuario.setBounds(149, 116, 79, 20);
		contentPane.add(txtpnUsuario);
		
		JTextPane txtpnContrasea = new JTextPane();
		txtpnContrasea.setEditable(false);
		txtpnContrasea.setBackground(Color.LIGHT_GRAY);
		txtpnContrasea.setText("Contrase\u00F1a");
		txtpnContrasea.setBounds(149, 237, 79, 20);
		contentPane.add(txtpnContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 201, 203, 25);
		contentPane.add(passwordField);
	}
}
