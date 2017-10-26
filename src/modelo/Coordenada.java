package modelo;
import modelo.excepciones.*;
/**
 * Representa la clase Coordenada del proyecto, donde se realizan 
 * diferentes creaciones y modificaciones de las coordenadas.
 * @author José Soler Martínez
 * @version 1.0
 */
public class Coordenada {
	private int x;
	private int y;
	private static int NUMERO_COORDENADAS;
	/**
	 * Este es un constructor de coordenadas (x,y)
	 * @param x Número entero que representa el parámetro x de la coordenada
	 * @param y Número entero que representa la el parámetro y de la coordenada
	 * Finalmente se suma 1 en NUMERO_COORDENADAS por la nueva coordenada creada
	 */
	public Coordenada(int x, int y) throws ExcepcionCoordenadaIncorrecta{
		if(x<0 || y<0) {
			throw new ExcepcionCoordenadaIncorrecta();
		}else {
			this.x=x;
			this.y=y;
			NUMERO_COORDENADAS++;
		}
	}
	/**
	 * Este es un constructor de coordenadas (otra.x,otra.y)
	 * @param otra creación una coordenada <code>otra</code> con parámetros (x,y) para poder tener 2 coordenadas
	 * y así poder operarlas o trabajar con ellas (x,y) - (otra.x,otra.y)
	 * Finalmente se suma 1 en NUMERO_COORDENADAS por una nueva coordenada creada
	 */
	public Coordenada (Coordenada otra) throws ExcepcionArgumentosIncorrectos {
		if(otra == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else {
			this.x=otra.x;
			this.y=otra.y;
			NUMERO_COORDENADAS++;
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
		Coordenada other = (Coordenada) otro;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	/**
	 * Este es un getter del número de coordenadas existente.
	 * @return <code>NUMERO_COORDENADAS
	 */
	public static int getNumeroCoordenadas() {
		return NUMERO_COORDENADAS;
	}
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	/**
	 * Getter de un parámetro de la coordenada
	 * @return x
	 */
	public int getX() {
		return x;
	}
	/**
	 * Getter de un parámetro de la coordenada
	 * @return y
	 */
	public int getY() {
		return y;
	}
	/**
	 * Permite la suma de los parámetros (x,y)+(otra.x,otra.y) y la creación de una coordenada nueva
	 * @param otra segundo parámetro que se utiliza para operar
	 * @return new Coordenada(x+otra.x,y+otra.y): un puntero con dos parámetros que llama al método
	 * Coordenada(int x, int y)
	 * @throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos
	 */
	public Coordenada suma (Coordenada otra) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos {
		if(otra==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else {
			return new Coordenada (x+otra.x,y+otra.y);
		}
	}
	
}


