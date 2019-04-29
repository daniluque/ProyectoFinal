package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;

	public Inicio() {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 708, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVerJugadoresY = new JButton("VER JUGADORES Y PUNTOS");
		btnVerJugadoresY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jugadores visor = new Jugadores();
				dispose();
				visor.setVisible(true);
				
				
			}
		});
		btnVerJugadoresY.setBounds(99, 56, 199, 88);
		contentPane.add(btnVerJugadoresY);
		
		JButton jornadas = new JButton("Ver jornadas");
		jornadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VisorJornadas jornada = new VisorJornadas();
				dispose();
				jornada.setVisible(true);
			}
		});
		jornadas.setBounds(363, 56, 199, 88);
		contentPane.add(jornadas);
		
	}
}
