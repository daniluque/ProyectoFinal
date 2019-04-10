package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TablaJugadores {
	
	static	Connection conexion;
	
	public ResultSet listaJugadores() {
		
	   	 ResultSet rs = null;
	   	 try {
	   		 // Se crea un Statement, para realizar la consulta
	   		 Statement s = conexion.createStatement();

	   		 // Se realiza la consulta. Los resultados se guardan en el
	   		 // ResultSet rs
	   		 rs = s.executeQuery("select * from jugadores");
	   	 } catch (Exception e) {
	   		 e.printStackTrace();
	   	 }
	   	 return rs;
	    }
}
