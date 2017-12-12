package negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import dao.VentaDao;
import excepciones.ConnectionException;
import excepciones.VentaException;

public class Venta {

	private int numero;
	private Cliente comprador;
	private List<ItemVenta> itemsVenta;
	private float precioReal;
	private LocalDate fecha;
	
	public Venta(Cliente comprador, List<ItemVenta> items, float precioReal) {
		super();
		this.comprador = comprador;
		this.itemsVenta = items;
		this.precioReal = precioReal;
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

	public List<ItemVenta> getItemsVenta() {
		return itemsVenta;
	}

	public void setItemsVenta(List<ItemVenta> itemsVenta) {
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

	public void save() throws ConnectionException, VentaException
	{
		VentaDao.getInstance().save(this);
	}
	public void saveIV() throws ConnectionException, VentaException
	{
		for(ItemVenta iv : itemsVenta)
		{
			iv.save(this);
		}
	}

	
	
}
