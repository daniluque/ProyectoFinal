package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TablaJugadores {

	public static ResultSet dameListaCompleta() {
		return Conexion.ejecutarSentencia("select * from jugadores");
	}

	public static ResultSet dameListaPersonas() {
		return Conexion.ejecutarSentencia("select nombre,equipo,dorsal,posision,puntuacion,id_jornada from jugadores");
	}

	public static ResultSet filtrar(int jor) {
		return Conexion.ejecutarSentencia(
				"Select nombre,equipo,dorsal,posision,puntuacion,id_jornada from jugadores where id_jornada =" + jor);
	}

	public static void insertarJugador(String nombre, String numero, String seleccionado, int puntoseleccionado,
			String jornada) {
		Conexion.ejecutarUpdate("Insert into jugadores(nombre,dorsal,posision,puntuacion,id_jornada) " + "VALUES('"
				+ nombre + "'," + numero + ",'" + seleccionado + "','" + puntoseleccionado + "','" + jornada + "')");
	}

	public static int[] listaJornadas() throws SQLException {
		int longitudArray = 0;
		int b = 0;
		ResultSet resultado;
		resultado = Conexion.ejecutarSentencia("Select id_jornada from jugadores group by id_jornada");

		while (resultado.next()) {
			longitudArray++;
		}
		int[] solucion = new int[longitudArray];
		resultado.beforeFirst();

		while (resultado.next()) {
			solucion[b] = resultado.getInt("id_jornada");
			b++;
		}
		return solucion;
	}

	public static String[] listaJugadores() throws SQLException {

		int longitudArray = 0;
		int b = 0;
		ResultSet resultado;
		resultado = Conexion.ejecutarSentencia("Select nombre from jugadores group by nombre");

		while (resultado.next()) {
			longitudArray++;
		}
		String[] solucion = new String[longitudArray];
		resultado.beforeFirst();

		while (resultado.next()) {
			solucion[b] = resultado.getString("nombre");
			b++;
		}
		return solucion;
	}

	public static String[] listaPorteros() throws SQLException {

		int longitudArray = 0;
		int b = 0;
		ResultSet resultado;
		resultado = Conexion
				.ejecutarSentencia("Select nombre from jugadores where posision = 'portero' group by nombre");

		while (resultado.next()) {
			longitudArray++;
		}
		String[] solucion = new String[longitudArray];
		resultado.beforeFirst();

		while (resultado.next()) {
			solucion[b] = resultado.getString("nombre");
			b++;
		}
		return solucion;
	}

	public static String[] listaCentrocampistas() throws SQLException {

		int longitudArray = 0;
		int b = 0;
		ResultSet resultado;
		resultado = Conexion
				.ejecutarSentencia("Select nombre from jugadores where posision = 'centrocampista' group by nombre");

		while (resultado.next()) {
			longitudArray++;
		}
		String[] solucion = new String[longitudArray];
		resultado.beforeFirst();

		while (resultado.next()) {
			solucion[b] = resultado.getString("nombre");
			b++;
		}
		return solucion;
	}
	
	public static String[] listaDefensa() throws SQLException {

		int longitudArray = 0;
		int b = 0;
		ResultSet resultado;
		resultado = Conexion
				.ejecutarSentencia("Select nombre from jugadores where posision = 'defensa' group by nombre");

		while (resultado.next()) {
			longitudArray++;
		}
		String[] solucion = new String[longitudArray];
		resultado.beforeFirst();

		while (resultado.next()) {
			solucion[b] = resultado.getString("nombre");
			b++;
		}
		return solucion;
	}
	
	public static String[] listaDelanteros() throws SQLException {

		int longitudArray = 0;
		int b = 0;
		ResultSet resultado;
		resultado = Conexion
				.ejecutarSentencia("Select nombre from jugadores where posision = 'delantero' group by nombre");

		while (resultado.next()) {
			longitudArray++;
		}
		String[] solucion = new String[longitudArray];
		resultado.beforeFirst();

		while (resultado.next()) {
			solucion[b] = resultado.getString("nombre");
			b++;
		}
		return solucion;
	}
	
	public static void BorrarJugador(String jor) {
		Conexion.ejecutarUpdate("Delete from jugadores where id_jornada ="+jor);
	}
	
}
