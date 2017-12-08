package negocio;

import java.time.LocalDate;

public class Notificacion {

	private LocalDate fecha;
	private Producto producto;
	private String mensaje;
	
	public Notificacion(Producto producto, String mensaje) {
		super();
		this.producto = producto;
		this.mensaje = mensaje;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
