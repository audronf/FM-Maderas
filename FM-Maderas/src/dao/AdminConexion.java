package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import excepciones.ConnectionException;

public class AdminConexion {

	private static AdminConexion instancia; //Singleton 
	
	private AdminConexion() throws ConnectionException{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			throw new ConnectionException("No es posible conectarse , consulte al administrador");
		}

	}
	
	public static AdminConexion getInstance() throws ConnectionException{
		if (instancia == null)
			instancia = new AdminConexion();
		return instancia;
	}
	
	public Connection obtenerConexion() throws ConnectionException{
		Connection conexion = null;
		String url, usu, pwd;
		url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=";
		usu = "";
		pwd = "";
		try {
			conexion = DriverManager.getConnection(url, usu, pwd);
		} catch (SQLException e) {
			throw new ConnectionException("Los datos de conexion ingresados no son validos");
		}
		return conexion;
	}
}
