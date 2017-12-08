package negocio;

import java.time.LocalDate;
import java.util.Vector;

public class Venta {

	private int numero;
	private Cliente comprador;
	private Vector<ItemVenta> itemsVenta;
	private float precioReal;
	private LocalDate fecha;
	
	public Venta(Cliente comprador) {
		super();
		this.comprador = comprador;
		this.itemsVenta = new Vector<ItemVenta>();
		this.fecha = LocalDate.now();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public Vector<ItemVenta> getItemsVenta() {
		return itemsVenta;
	}

	public void setItemsVenta(Vector<ItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}

	public float getPrecioReal() {
		return precioReal;
	}

	public void setPrecioReal(float precioReal) {
		this.precioReal = precioReal;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

		

	
	
}
