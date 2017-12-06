package entradasalida.excepciones;

/**
 * La clase ExcepcionLectura.
 */
public class ExcepcionLectura extends Exception {
	
	/**
	 * Inicializa la excepcion lectura.
	 */
	public ExcepcionLectura() {
		super("Error: Excepcion Lectura");
	}
	
	/**
	 * Inicializa una excepcion lectura con una cadena pasada por parametro
	 *
	 * @param cadena la cadena de texto pasada por parametro
	 */
	public ExcepcionLectura(String cadena) {
		super(cadena);
	}
	
	/**
	 * Inicializa la excepcion lectura con un parametro de causa.
	 *
	 * @param causa lanza la causa del error
	 */
	public ExcepcionLectura(Throwable causa) {
		super(causa);
	}
}
