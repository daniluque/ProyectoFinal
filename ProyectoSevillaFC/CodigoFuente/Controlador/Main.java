package Controlador;

import java.io.LineNumberInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import Modelo.Conexion;
import Modelo.TablaJugadores;
import Vista.Inicio;


public class Main {	
	public static void main(String[] args) throws SQLException {
		/*Creamos la conexion en main para solo hacerlo una vez*/
		Conexion.recibirConexion();	
		
		/*LLamamos a la primera ventana desde aqui 
		 * para que ninguna necesite tener un main
		 * esta llama a la primera y despues se van llamando unas
		 * a otras.*/
		Inicio frame = new Inicio();
		frame.setVisible(true);
	   	 
		
		
	}
	
}
