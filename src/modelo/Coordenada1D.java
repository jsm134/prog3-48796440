/*
 * @author Jose Soler Martinez 48796440P
 */
package modelo;
import modelo.excepciones.*;

/**
 * La clase Coordenada1D
 * Crea una Coordenada de una dimension comprobando que se encuentre dentro de las directrices
 * Tambien se suman coordenadas de una dimension, proviene de la clase coordenada.
 */
public class Coordenada1D extends Coordenada {
	
	/** 
	 * Parametro x de la Coordenada. 
	 */
	private int x;

	/**
	 * Inicializa una nueva coordenada1D.
	 *
	 * @param x parametro que incluye la seccion de la coordenada x
	 * @throws ExcepcionCoordenadaIncorrecta lanza una excepcion de coordenada incorrecta
	 */
	public Coordenada1D(int x) throws ExcepcionCoordenadaIncorrecta{
		if(x<0) {
			throw new ExcepcionCoordenada1DIncorrecta(x);
		}else {
			this.x=x;
		}
	}

	/**
	 * Constructor de Coordenada1D a traves de un parametro.
	 *
	 * @param otra parametro pasado por referencia (coordenada x) llamado otra
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion argumentos incorrectos
	 */
	public Coordenada1D (Coordenada1D otra) throws ExcepcionArgumentosIncorrectos {
		if(otra == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else{
			this.x=otra.x;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
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
		Coordenada1D other = (Coordenada1D) otro;
		if (x != other.x)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + this.x + ")";
	}

	/**
	 * Getter del la coordenada x.
	 *
	 * @return la coordenada x
	 */
	public int getX() {
		return x;
	}
	
	@Override
	public Coordenada1D suma (Coordenada otra) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos {
		if(otra==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else {
			return new Coordenada1D (x+((Coordenada1D)otra).x);
		}
	}
	
}


