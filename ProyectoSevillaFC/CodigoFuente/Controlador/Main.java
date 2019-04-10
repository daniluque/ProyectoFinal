package Controlador;

import java.io.LineNumberInputStream;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import Modelo.Conexion;
import Modelo.TablaJugadores;
import Vista.Inicio;
import Vista.VisorJugadores;

public class Main {	
	
	public static void main(String[] args) {	
		Conexion.recibirConexion();
		
		Inicio frame = new Inicio();
		frame.setVisible(true);
		
		
	}
	
}
