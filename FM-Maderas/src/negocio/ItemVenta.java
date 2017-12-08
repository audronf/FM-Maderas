package negocio;

import dao.VentaDao;
import excepciones.ConnectionException;
import excepciones.VentaException;

// asd
public class ItemVenta {

	private Producto producto;
	private int cantidad;
	
	public ItemVenta(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void save(Venta v) throws ConnectionException, VentaException {
		VentaDao.getInstance().saveIV(this, v);
		
	}
	
	
}
