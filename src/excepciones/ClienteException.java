package excepciones;

public class ClienteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5681818342699360460L;
	public ClienteException(String mensaje){
		super(mensaje);
	}
}