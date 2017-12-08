package negocio;

import java.time.LocalDate;

public class NotificacionSinVenta extends Notificacion {

	private LocalDate fechaUltimaVenta;

	public NotificacionSinVenta(Producto producto, String mensaje, LocalDate fechaUltimaVenta) {
		super(producto, mensaje);
		this.fechaUltimaVenta = fechaUltimaVenta;
	}

	public LocalDate getFechaUltimaVenta() {
		return fechaUltimaVenta;
	}

	public void setFechaUltimaVenta(LocalDate fechaUltimaVenta) {
		this.fechaUltimaVenta = fechaUltimaVenta;
	}
	
	
}
