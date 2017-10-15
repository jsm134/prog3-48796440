/**
 * 
 */
package modelo;

import java.util.Collection;

/**
 * @author José Soler Martínez
 *
 */
public class Patron {
	/**
	 * 
	 */
	private String nombre;
	/**
	 * 
	 */
	private Tablero tablero;
	/**
	 * 
	 * @param nombre
	 * @param tablero
	 */
	public Patron(String nombre, Tablero tablero) {
		this.nombre = nombre;
		this.tablero = tablero;
	}
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param posicion
	 * @return
	 */
	public EstadoCelda getCelda(Coordenada posicion) {
		return tablero.getCelda(posicion);
	}
	/**
	 * 
	 * @return
	 */
	public Collection<Coordenada> getPosiciones(){
		Collection<Coordenada> posiciones;
		if(tablero==null) {
			posiciones=null;
		}else {
			posiciones=tablero.getPosiciones();
		}
		return posiciones;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNombre());
		sb.append("\n");
		sb.append(tablero.toString());
		return sb.toString();
	}
}
