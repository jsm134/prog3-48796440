/**
 * @author Jose Soler Martinez	48796440P
 */
package modelo.excepciones;

/**
 * The Class ExcepcionEjecucion.
 */
public class ExcepcionEjecucion extends RuntimeException{
	
	/**
	 * Constructor de excepcion ejecucion.
	 *
	 * @param mensaje el mensaje de error
	 */
	public ExcepcionEjecucion(String mensaje) {
		super(mensaje);
	}
	
	/**
	 * Constructor de ExcepcionEjecucion.
	 *
	 * @param cause mensaje con la causa del problema
	 */
	public ExcepcionEjecucion(Throwable cause) {
		super(cause);
	}
}
