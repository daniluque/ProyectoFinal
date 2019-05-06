package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	static 	String timezone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static	String dbName = "sevilladb";
	static	String url = "jdbc:mysql://localhost:3306/"+dbName+timezone;
	static	String user = "root";
	static	String pass = "13101996";
	static	Connection conexion;
	static Statement consulta;
	static ResultSet resultado;

	public static void recibirConexion() {
		try {
			conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexion establecida");
			//Preparamos la consulta
			consulta = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error");
			e.printStackTrace();
		}
	}
	
	public static void cerrarConexion() {
		try {
			consulta.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ejecutarUpdate (String sentencia) {
		try {
			consulta.executeUpdate(sentencia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ResultSet ejecutarSentencia(String sentencia) {
		 ResultSet rs = null;
		try {			
			Statement s = conexion.createStatement();
			 rs = s.executeQuery(sentencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
			
}
