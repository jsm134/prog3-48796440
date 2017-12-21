/**
 * @author Jose Soler Martinez 48796440P
 */
package modelo;

import modelo.excepciones.*;

/**
 * La clase regla
 * Sirve para administrar y como base de regla30 y ReglaConway
 * mediante las cuales se aplican las reglas establecidas.
 *
 * @param <TipoCoordenada> tipo generico de la clase coordenada
 */
public abstract class Regla<TipoCoordenada extends Coordenada> {
	
	/**
	 * Constructor de regla.
	 */
	public Regla() {
		
	}
	
	/**
	 * Calcula siguiente estado celda.
	 *
	 * @param tablero variable que hace referencia al tablero
	 * @param posicion variable que hace referencia a la posicion
	 * @return variable que devuelve el estado de una celda
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 * @throws ExcepcionPosicionFueraTablero lanza una excepcion de posicion fuera tablero
	 */
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero<TipoCoordenada> tablero,TipoCoordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero;
}
