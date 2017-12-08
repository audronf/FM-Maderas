package negocio;

import java.time.LocalDate;

public class NotificacionCantidadTiempo extends Notificacion {

	private LocalDate fechaInicio;
	private int cantUnidades;
	
	public NotificacionCantidadTiempo(Producto producto, String mensaje, LocalDate fechaInicio, int cantUnidades) {
		super(producto, mensaje);
		this.fechaInicio = fechaInicio;
		this.cantUnidades = cantUnidades;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public int getCantUnidades() {
		return cantUnidades;
	}
	public void setCantUnidades(int cantUnidades) {
		this.cantUnidades = cantUnidades;
	}
	
	
}
