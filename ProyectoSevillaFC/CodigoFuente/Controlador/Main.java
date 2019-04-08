package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import Modelo.Conexion;
import Vista.VisorJugadores;

public class Main {

	private Conexion bd;
	private VisorJugadores tabla;
	private DefaultTableModel modelo;

	public Main(){
		
		try {
	   		 // Se instancian las clases necesarias
	   		 bd = new Conexion();
	   		 modelo = new DefaultTableModel();
	   		 tabla = new VisorJugadores();

	   		 // Se comienza.
	   		 bd.recibirConexion();
	   		 tabla.creaYMuestraVentana();

	   		 // Bucle infinito, cada segundo se reconsulta la base de datos
	   		 // y se muestran los resultados en pantalla
	   		 while (true) {
	   			 ResultSet rs = bd.dameListaPersonas();
	   			 Conversor.rellena(rs, modelo);
	   			 tabla.tomaDatos(modelo);
	   			 Thread.sleep(1000);
	   		 }
	   	 } catch (Exception e) {
	   		 e.printStackTrace();
	   	 }


	}
	public static void main(String[] args) {
		new Main();
	}
}
