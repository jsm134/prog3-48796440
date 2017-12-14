/**
 * @author Jose Soler Martinez	48796440P
 */
package modelo.d1;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * La clase ExcepcionCoordenada1DIncorrecta.
 * lanza una excepcion de coordenada1Dincorrecta
 * y su mensaje de error
 */
public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	/** La variable x. */
	private int x;
	
	/**
	 * Constructor de excepcion coordenada1Dincorrecta.
	 *
	 * @param x variable x pasada por parametro
	 */
	public ExcepcionCoordenada1DIncorrecta(int x) {
		this.x=x;
	}
	
	@Override
	public String getMessage() {
		return "Error la dimension 1D (" + x + ") no existe";
	}
	
	/**
	 * Getter de la variable x.
	 *
	 * @return la variable x
	 */
	public int getX() {
		return x;
	}
}
