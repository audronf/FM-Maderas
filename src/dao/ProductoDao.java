package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import excepciones.ConnectionException;
import excepciones.ProductoException;
import negocio.Producto;



public class ProductoDao {
		private static ProductoDao instancia;
		
		private ProductoDao(){
		}
		
		public static ProductoDao getInstance(){
			if (instancia==null)
				instancia = new ProductoDao();
			return instancia;
		}
		
	public Producto findByID(String codigo) throws ConnectionException, ProductoException{
		Connection con = AdminConexion.getInstance().obtenerConexion();
		Producto producto= null;
		try{
			PreparedStatement pstm = con.prepareStatement("select * from Productos where codProd=?");
			pstm.setString(1, codigo);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				producto = new Producto(rs.getString("codigo"), rs.getString("nombre"), rs.getString("categoria"), rs.getFloat("precioEsperado"), rs.getFloat("precioCarpinteros"), rs.getFloat("costoAlDia"));
			}
			else
				throw new ProductoException("No existe ese producto");
			return producto;
		}
		catch(SQLException e){
			throw new ProductoException("Error al recuperar el producto");
		}

	}

	public void save(Producto p) throws ConnectionException, ProductoException{
		Connection con = AdminConexion.getInstance().obtenerConexion();

		try{
			PreparedStatement pstm = con.prepareStatement("insert into Productos values (?,?,?,?,?,?");
			pstm.setString(1, p.getCodigo());
			pstm.setString(2, p.getNombre());
			pstm.setString(3, p.getCategoria());
			pstm.setFloat(4, p.getPrecioEspVenta());
			pstm.setFloat(5, p.getPrecioCarpinteros());
			pstm.setFloat(6, p.getCosto());
			pstm.execute();

		}
		catch(SQLException e){
			throw new ProductoException("Error al crear el producto");
		}

	}
	public void update(Producto p) throws ConnectionException, ProductoException{
		Connection con = AdminConexion.getInstance().obtenerConexion();

		try{
			PreparedStatement pstm = con.prepareStatement("update productos set(?,?,?,?,?) where codProd=?");
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getCategoria());
			pstm.setFloat(3, p.getPrecioEspVenta());
			pstm.setFloat(4, p.getPrecioCarpinteros());
			pstm.setFloat(5, p.getCosto());
			pstm.setString(6, p.getCodigo());
			pstm.execute();

		}
		catch(SQLException e){
			throw new ProductoException("Error al modificar el producto");
		}

	}

	public List<Producto> Basicos() throws ConnectionException, ProductoException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		List<Producto> resultado = new ArrayList<Producto>();
		Producto p;
		try{
			PreparedStatement stm = con.prepareStatement("select * from Productos where categoria='Basico'");
			stm.setString(1, "Basico");
			ResultSet rs = stm.executeQuery();
			rs.next();
			while(rs.getRow()!=0)
			{
				p = new Producto(rs.getString("codigo"), rs.getString("nombre"), rs.getString("categoria"), rs.getFloat("precioEsperado"), rs.getFloat("precioCarpinteros"), rs.getFloat("costoAlDia"));
				resultado.add(p);
				rs.next();
			}
			return resultado;

		}
		catch(SQLException e){
			throw new ProductoException("Error al recuperar los productos");
		}

	}
	public List<Producto> Medida() throws ConnectionException, ProductoException {
		Connection con = AdminConexion.getInstance().obtenerConexion();
		List<Producto> resultado = new ArrayList<Producto>();
		Producto p;
		try{
			PreparedStatement stm = con.prepareStatement("select * from Productos where categoria='Con Medida'");
			ResultSet rs = stm.executeQuery();
			rs.next();
			while(rs.getRow()!=0)
			{
				p = new Producto(rs.getString("codigo"), rs.getString("nombre"), rs.getString("categoria"), rs.getFloat("precioEsperado"), rs.getFloat("precioCarpinteros"), rs.getFloat("costoAlDia"));
				resultado.add(p);
				rs.next();
			}
			return resultado;

		}
		catch(SQLException e){
			throw new ProductoException("Error al recuperar los productos");
		}

	}
}

