package controlador;

import dao.ProductoDao;
import excepciones.ConnectionException;
import excepciones.ProductoException;
import negocio.Producto;

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
    public void registrarVenta()//No tengo ni la menor idea qué tendría como parámetro este método, tiene que ser lo que reciba de la pantallas
    							// el cuit del cliente seguro pero también tiene que tener la lista de productos con sus respectivdas cantidades.
    							// Cuando hagamos la pantalla de registrar ventas si es que la hacemos lo termino de hacer.
    {
    	//TODO
    }
    
}
