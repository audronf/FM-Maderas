package controlador;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import dao.ProductoDao;
import excepciones.ClienteException;
import excepciones.ConnectionException;
import excepciones.ProductoException;
import excepciones.VentaException;
import negocio.Cliente;
import negocio.ItemVenta;
import negocio.Producto;
import negocio.Venta;
import views.ItemVentaView;
import views.ProductoView;

public class Controlador {
    private static Controlador instancia;
    
    public static Controlador getInstance(){
        if (instancia == null)
            instancia = new Controlador();
        return instancia;
    }
    //PRODUCTOS
    public void altaProducto(String codigo, String nombre, String categoria, float precioE, float precioC, float costo) throws ConnectionException, ProductoException
    {
    	Producto p=new Producto(codigo, nombre, categoria, precioE, precioC, costo);
    	p.save();
    }
    public Producto buscarProducto(String codigo) throws ConnectionException, ProductoException
    {
    	return ProductoDao.getInstance().findByID(codigo);
    }

    public void modificarProducto(String codigo, String nombre, String categoria, float precioE, float precioC, float costo) throws ConnectionException, ProductoException
    {
    	Producto p = buscarProducto(codigo);
    	p.setNombre(nombre);
    	p.setCategoria(categoria);
    	p.setPrecioEspVenta(precioE);
    	p.setPrecioCarpinteros(precioC);
    	p.setCosto(costo);
    	p.update();
    }
    // VENTAS
    public void registrarVenta(String cuit, List<List<String>> CodCant, String precio) throws ConnectionException, ProductoException, ClienteException, VentaException
    {
    	List<ItemVenta> items= new ArrayList<ItemVenta>();
    	for(List<String> lista: CodCant)
    	{
    		Producto p=ProductoDao.getInstance().findByID(lista.get(0));
    		int cant = Integer.valueOf(lista.get(1));
    		ItemVenta iv= new ItemVenta(p,cant);
    		items.add(iv);
    	}
    	Cliente c = ClienteDao.getInstance().findByCuit(cuit);
    	Venta v = new Venta(c, items, Float.valueOf(precio));
    	v.save();
    	v.saveIV();
    }
	public List<ProductoView> obtenerProductosBasicos() throws ConnectionException, ProductoException {
		List<Producto> productos=ProductoDao.getInstance().Basicos();
		List<ProductoView> resultado= new ArrayList<ProductoView>();
		for(Producto r : productos)
			resultado.add(r.toView());
		return resultado;
	}
	public List<ProductoView> obtenerProductosMedida() throws ConnectionException, ProductoException {
		List<Producto> productos=ProductoDao.getInstance().Medida();
		List<ProductoView> resultado= new ArrayList<ProductoView>();
		for(Producto r : productos)
			resultado.add(r.toView());
		return resultado;
	}
	public ItemVentaView obtenerItemView(String codigo, String cantidad) throws ConnectionException, ProductoException {
		Producto p=ProductoDao.getInstance().findByID(codigo);
		ItemVenta iv= new ItemVenta(p, Integer.valueOf(cantidad));
		return iv.toView();
	}
    
}
