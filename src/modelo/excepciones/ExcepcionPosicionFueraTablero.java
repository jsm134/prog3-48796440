/**
 * @author Jose Soler Martinez	48796440P
 */
package modelo.excepciones;

import modelo.Coordenada;

/**
 * La clase ExcepcionPosicionFueraTablero.
 * lanza un error de excepcion fuera del tablero si la celda
 * no se encuentra en el interior del tablero
 */
public class ExcepcionPosicionFueraTablero extends Exception{
	
	/** Las dimensiones del tablero. */
	private Coordenada dimensiones;
	
	/** La coordenada a evaluar. */
	private Coordenada coordenada;
	
	/**
	 * Constructor de excepcion posicion fuera tablero.
	 *
	 * @param d las dimensiones del tablero
	 * @param c la coordenada para evaluar
	 */
	public ExcepcionPosicionFueraTablero(Coordenada d, Coordenada c) {
		dimensiones = d;
		coordenada = c;
	}
	
	/**
	 * Getter de coordenada.
	 *
	 * @return la coordenada
	 */
	public Coordenada getCoordenada() {
		return coordenada;
	}
	
	/**
	 * Getter de dimensiones.
	 *
	 * @return las dimensiones del tablero
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	
	@Override
	public String getMessage() {
		return "Error: Posicion Fuera del Tablero";
	}
}
