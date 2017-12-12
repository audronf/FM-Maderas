package views;

import negocio.Producto;

public class ItemVentaView {
	private String codigo;
	private String nombre;
	private String categoria;
	private int cantidad;
	
	public ItemVentaView(Producto producto, int cantidad) {
		this.codigo = producto.getCodigo();
		this.nombre = producto.getNombre();
		this.categoria = producto.getCategoria();
		this.cantidad = cantidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		if(categoria.equalsIgnoreCase("Con medida"))
			return codigo+ " "+ nombre+ "; Pies Cuadrados: " + cantidad;
		else
			return codigo+ " "+ nombre+ "; Cantidad: " + cantidad;
	}
	
	
	
}
