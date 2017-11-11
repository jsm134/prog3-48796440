/**
 * @author Jose Soler Martinez
 */
package modelo;
import modelo.excepciones.*;

/**
 * La clase Coordenada2D.
 * Crea una Coordenada de una dimension comprobando que se encuentre dentro de las directrices
 * Tambien se suman coordenadas de una dimension, proviene de la clase coordenada.
 */
public class Coordenada2D extends Coordenada {
	
	/** Parametro x de la coordenada. */
	private int x;
	
	/** Parametro y de la coordenada. */
	private int y;

	/**
	 * Constructor de una coordenada2D.
	 *
	 * @param x parametro x de la coordenada
	 * @param y parametro y de la coordenada
	 * @throws ExcepcionCoordenadaIncorrecta lanza una excepcion de coordenada incorrecta en el caso de que los parametros no sean correctos
	 */
	public Coordenada2D(int x, int y) throws ExcepcionCoordenadaIncorrecta{
		if(x<0 || y<0) {
			throw new ExcepcionCoordenada2DIncorrecta(x,y);
		}else {
			this.x=x;
			this.y=y;
		}
	}

	/**
	 * Constructor de una coordenada2D.
	 *
	 * @param otra variable pasada como parametro que se usa para crear la variable
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 */
	public Coordenada2D (Coordenada2D otra) throws ExcepcionArgumentosIncorrectos {
		if(otra == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else{
			this.x=otra.x;
			this.y=otra.y;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object otro) {
		if (this == otro)
			return true;
		if (otro == null)
			return false;
		if (getClass() != otro.getClass())
			return false;
		Coordenada2D other = (Coordenada2D) otro;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

	/**
	 * Getter del parametro x.
	 *
	 * @return la coordenada x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter del parametro y.
	 *
	 * @return la coordenada y
	 */
	public int getY() {
		return y;
	}

	@Override
	public Coordenada2D suma (Coordenada otra) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos {
		if(otra==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else {
			return new Coordenada2D (x+((Coordenada2D)otra).x,y+((Coordenada2D)otra).y);
		}
	}
	
}


