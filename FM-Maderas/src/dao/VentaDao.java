package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excepciones.ConnectionException;
import excepciones.VentaException;
import negocio.ItemVenta;
import negocio.Venta;

public class VentaDao {

		private static VentaDao instancia;		
		private VentaDao(){
		}
		
		public static VentaDao getInstance(){
			if (instancia==null)
				instancia = new VentaDao();
			return instancia;
		}
		
		public void save(Venta v) throws ConnectionException, VentaException{
			Connection con = AdminConexion.getInstance().obtenerConexion();
			PreparedStatement pstm;
			try{
				pstm = con.prepareStatement("insert into Ventas (comprador, precio, fecha) values (?,?,?)");
				pstm.setString(1, v.getComprador().getCuit()); //Ojo porque en el script de bd el cuit en la tabla venta esta puesto como int
				pstm.setFloat(2, v.getPrecioReal());
				pstm.setDate(3, Date.valueOf(v.getFecha()));
				pstm.execute();
				Statement stm1; //Yo se que lo que viene ahora es rarisimo pero confia en mi
				Statement stm2;
				stm1 = con.createStatement();
				ResultSet rs = stm1.executeQuery("select * from Ventas");
				rs.next();
				int aux = 0;
				while(rs.getRow()!=0){
					aux++;
					rs.next();
				}
				stm2 = con.createStatement();
				ResultSet rs2 = stm2.executeQuery("select * from Ventas");
				aux=aux-1;
				rs2.next();
				while(aux!=0){
					rs2.next();
					aux=aux-1;
				}
				v.setNumero(rs2.getInt("nroVenta"));
				for(ItemVenta iv : v.getItemsVenta())
				{
					iv.save(v);
				}
			}
			catch(SQLException e){
				throw new VentaException("Error al crear la venta");
			}

		}

		public void saveIV(ItemVenta iv, Venta v) throws ConnectionException, VentaException {
			Connection con = AdminConexion.getInstance().obtenerConexion();
			PreparedStatement pstm;
			try{
				pstm = con.prepareStatement("insert into ItemsVenta values (?,?,?)");
				pstm.setInt(1, v.getNumero());
				pstm.setString(2, iv.getProducto().getCodigo());
				pstm.setInt(3, iv.getCantidad());
				pstm.execute();
			}
			catch(SQLException e){
				throw new VentaException("Error al crear la venta (items)");
			}
		}
}
