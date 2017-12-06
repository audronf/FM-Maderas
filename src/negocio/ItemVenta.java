package negocio;

public class ItemVenta {

	private Producto producto;
	private int cantidad;
	private Venta venta;
	
	public ItemVenta(Producto producto, int cantidad, Venta venta) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.venta = venta;
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
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
}
