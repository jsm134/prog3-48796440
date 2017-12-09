/*
 * @author Jose Soler Martinez 48796440P
 * 
 */
package entradasalida.excepciones;

/**
 * La clase ExcepcionGeneracion.
 */
public class ExcepcionGeneracion extends Exception {
	
	/**
	 * Inicializa la excepcion generacion.
	 */
	public ExcepcionGeneracion() {
		super("Error: Excepcion Generacion");
	}
	
	/**
	 * Inicializa la excepcion generacion con una cadena pasada por referencia.
	 *
	 * @param cadena la cadena que muestra el error
	 */
	public ExcepcionGeneracion(String cadena) {
		super(cadena);
	}
	
	/**
	 * Inicializa una excepcion generacion con un parametro de tipo throwable.
	 *
	 * @param causa la causa del error
	 */
	public ExcepcionGeneracion(Throwable causa) {
		super(causa);
	}
}
