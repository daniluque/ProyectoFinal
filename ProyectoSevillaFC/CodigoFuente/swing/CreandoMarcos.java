package swing;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
public class CreandoMarcos {

	public static void main(String[] args) {
		
		miMarco marco1 = new miMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
	
	class miMarco extends JFrame{
		
		public miMarco() {
			setSize(500,300);
			setResizable(true);
			setTitle("Supreme - Not feik");
			//setExtendedState(Frame.MAXIMIZED_BOTH);
			Toolkit miPantalla = Toolkit.getDefaultToolkit();
			Dimension tamaño = miPantalla.getScreenSize();
			int alt = tamaño.height;
			int anc = tamaño.width;
			setSize(anc/2,alt/2);
			setLocation(anc/4,alt/4);
			Image fav = miPantalla.getImage("CodigoFuente/swing/Supreme-Logo.jpg");
			setIconImage(fav);			
		
		}
		
	}