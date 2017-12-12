package views;

public class ProductoView {

	private String codigo;
	private String nombre;
	private String categoria;
	private float precioEspVenta;
	private float precioCarpinteros;
	private float costo;
	
	public ProductoView(String codigo, String nombre, String categoria, float precioEspVenta, float precioCarpinteros,
			float costo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precioEspVenta = precioEspVenta;
		this.precioCarpinteros = precioCarpinteros;
		this.costo = costo;
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getPrecioEspVenta() {
		return precioEspVenta;
	}
	public void setPrecioEspVenta(float precioEspVenta) {
		this.precioEspVenta = precioEspVenta;
	}
	public float getPrecioCarpinteros() {
		return precioCarpinteros;
	}
	public void setPrecioCarpinteros(float precioCarpinteros) {
		this.precioCarpinteros = precioCarpinteros;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	@Override
	public String toString() {
		return codigo + " " + nombre;
	}
	
	
}