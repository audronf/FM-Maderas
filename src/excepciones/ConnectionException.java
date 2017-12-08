package excepciones;

public class ConnectionException extends Exception {

	private static final long serialVersionUID = 2746418119275495282L;
	public ConnectionException(String mensaje){
		super(mensaje);
	}
}
