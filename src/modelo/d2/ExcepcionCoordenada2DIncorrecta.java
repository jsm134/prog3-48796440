/**
 * @author Jose Soler Martinez	48796440P
 */
package modelo.d2;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * La clase ExcepcionCoordenada2DIncorrecta.
 * lanza una ExcepcionCoordenada2DIncorrecta
 * ademas de un mensaje de error
 */
public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	
	/** La variable x. */
	private int x;
	
	/** La variable y. */
	private int y;
	
	/**
	 * Constructor de excepcioncoordenada2Dincorrecta.
	 *
	 * @param x la variable x pasada como parametro
	 * @param y la variable y pasada como parametro
	 */
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Getter de la variable x.
	 *
	 * @return la variable x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Getter de la variable y.
	 *
	 * @return la variable y
	 */
	public int getY() {
		return y;
	}
	
	@Override
	public String getMessage() {
		return "La coordenada 2D (" + x + "," + y + ") es incorrecta";
	}
}
