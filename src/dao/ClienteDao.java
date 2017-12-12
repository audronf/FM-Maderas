package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import excepciones.ClienteException;
import excepciones.ConnectionException;

import negocio.Cliente;


public class ClienteDao {
	private static ClienteDao instancia;
	
	private ClienteDao(){
	}
	
	public static ClienteDao getInstance(){
		if (instancia==null)
			instancia = new ClienteDao();
		return instancia;
	}
	
public Cliente findByCuit(String cuit) throws ConnectionException, ClienteException {
	Connection con = AdminConexion.getInstance().obtenerConexion();
	Cliente c= null;
	try{
		PreparedStatement pstm = con.prepareStatement("select * from Clientes where cuitCliente=?");
		pstm.setString(1, cuit);
		ResultSet rs = pstm.executeQuery();
		if(rs.next())
		{
			c= new Cliente(rs.getString("cuitCliente"), rs.getString("nombre"), rs.getString("domicilio"), rs.getString("telefono"), rs.getString("email "));
			
		}
		else
			throw new ClienteException("No existe el cliente");
		return c;
	}
	catch(SQLException e){
		throw new ClienteException("Error al recuperar el cliente");
	}
}
}