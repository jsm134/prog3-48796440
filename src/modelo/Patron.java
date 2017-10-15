/**
 * 
 */
package modelo;

import java.util.Collection;
/**
 * Clase Patron: clase que permite la creación de un patron, su nombre, la posicion en el tablero
 * creación de strings con el nombre del patron junto al tablero correspondiente y las posiciones
 * que adoptan las celdas de los patrones
 * @author José Soler Martínez 48796440P
 */
public class Patron {
	/**
	 * Atributo que almacena el nombre de un patron
	 */
	private String nombre;
	/**
	 * Atributo que almacena el tablero que va a utilizar ese patron
	 */
	private Tablero tablero;
	/**
	 * Constructor: permite guardar los valores en sus campos correspondiente
	 * @param nombre nombre del patron creado
	 * @param tablero tablero relacionado a dicho patron
	 */
	public Patron(String nombre, Tablero tablero) {
		this.nombre = nombre;
		this.tablero = tablero;
	}
	/**
	 * Getter: devuelve el nombre del patron 
	 * @return nombre nombre del patron
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Getter: permite conocer el estado de una celda del tablero
	 * @param posicion parametro pasado por referencia con la posicion de la celda
	 * @return tablero.getCelda(posicion) devuelve la existencia de una celda en dicha posicion
	 */
	public EstadoCelda getCelda(Coordenada posicion) {
		return tablero.getCelda(posicion);
	}
	/**
	 * Getter: permite obtener las posiciones de las celdas dentro de un tablero
	 * @return posiciones devuelve las posiciones de las celdas en un tablero
	 */
	public Collection<Coordenada> getPosiciones(){
		Collection<Coordenada> posiciones;
		if(tablero!=null) {
			posiciones=tablero.getPosiciones();
		}else {
			posiciones=null;
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
