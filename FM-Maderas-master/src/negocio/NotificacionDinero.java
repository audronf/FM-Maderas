package negocio;

public class NotificacionDinero extends Notificacion {

	private int cantidadUnidades;
	private float porcentajeDinero;
	
	public NotificacionDinero(Producto producto, String mensaje, int cantidadUnidades, float porcentajeDinero) {
		super(producto, mensaje);
		this.cantidadUnidades = cantidadUnidades;
		this.porcentajeDinero = porcentajeDinero;
	}

	public int getCantidadUnidades() {
		return cantidadUnidades;
	}

	public void setCantidadUnidades(int cantidadUnidades) {
		this.cantidadUnidades = cantidadUnidades;
	}

	public float getPorcentajeDinero() {
		return porcentajeDinero;
	}

	public void setPorcentajeDinero(float porcentajeDinero) {
		this.porcentajeDinero = porcentajeDinero;
	}
	
	
	
}
