/**
 * @author Jose Soler Martinez 48796440P
 */
package modelo;

import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * La clase Patron.
 *
 * @param <TipoCoordenada> tipo generico de la clase coordenada
 */
public class Patron <TipoCoordenada extends Coordenada>{

	/** La variable nombre. */
	private String nombre;

	/** La variable tablero. */
	private Tablero<TipoCoordenada> tablero;

	/**
	 * Constructor de un patron.
	 *
	 * @param nombre variable que guarda el nombre del patron
	 * @param tablero variable que guarda el tablero
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 */
	public Patron(String nombre, Tablero<TipoCoordenada> tablero) throws ExcepcionArgumentosIncorrectos{
		if(nombre != null && tablero != null) {
			this.nombre = nombre;
			this.tablero = tablero;
		}else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}

	/**
	 * Getter de nombre.
	 *
	 * @return el nombre del tablero
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Getter de celda.
	 *
	 * @param posicion variable pasada por referencia que indica posicion en el tablero
	 * @return la celda
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 * @throws ExcepcionPosicionFueraTablero lanza una excepcion de posicion fuera tablero
	 */
	public EstadoCelda getCelda(TipoCoordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero {
		return tablero.getCelda(posicion);
	}

	/**
	 * Getter de posiciones.
	 *
	 * @return las posiciones en el tablero
	 */
	public Collection<TipoCoordenada> getPosiciones(){
		Collection<TipoCoordenada> posiciones;
		if(tablero!=null) {
			posiciones=tablero.getPosiciones();
		}else {
			posiciones=null;
		}
		return posiciones;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNombre());
		sb.append("\n");
		sb.append(tablero.toString());
		return sb.toString();
	}
}
