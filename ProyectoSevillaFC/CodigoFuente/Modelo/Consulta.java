package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {
	
	static ResultSet resultado;
	static Statement consulta;
	
	public static ResultSet ejecutarSentencia(String sentencia, String nombreTabla) {
		try {
			resultado = consulta.executeQuery(sentencia);
			while(resultado.next()) {
				resultado.getString(nombreTabla);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public static void ejecutarUpdate (String sentencia) {
		try {
			consulta.executeUpdate(sentencia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
