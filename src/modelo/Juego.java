/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Clase Juego: clase que coordina el resto de clases, con el tablero especificado
 * en su constructor, la regla a usar y lod distintos patrones cargados en el tablero y
 * registrados en el juego es capaz de hacer evolucionar las celdas.
 * @author José Soler Martínez 48796440P
 */
public class Juego {
	/**
	 * Atributo que guarda la ReglaConwey
	 */
	private ReglaConway regla;
	/**
	 * Atributo que guarda el total de patrones utilizados
	 */
	private ArrayList<Patron> patronesUsados;
	/**
	 * Atributo que guarda el tablero a utiliar
	 */
	private Tablero tablero;
	/**
	 * Constructor: inicialia los campos tablero y regla y los guarda con los parametros por refernecia
	 * @param tablero parametro por referencia que introduce el tablero a utilizar
	 * @param regla parametro pasado por referencia que guarda la ReglaConway correspondiente
	 */
	public Juego(Tablero tablero, ReglaConway regla) {
		this.tablero=tablero;
		this.regla=regla;
		patronesUsados=new ArrayList<Patron>();
	}
	/**
	 * Intenta la creacion de un patron en el tablero, guardandolo entre los patrones usados, en el caso de que no quepa manda un error
	 * @param p parametro por referencia que introduce el patron que se va a utilizar
	 * @param posicionInicial parametro por referencia que indica donde va a comenzar dicho patron
	 */
	public void cargaPatron(Patron p, Coordenada posicionInicial) {
		if(tablero.cargaPatron(p, posicionInicial)) {
			patronesUsados.add(p);
		}else {
			StringBuilder sb = new StringBuilder();
			sb.append("Error cargando plantilla ");
			sb.append(p.getNombre());
			sb.append(" en (");
			sb.append(posicionInicial.getX());
			sb.append(",");
			sb.append(posicionInicial.getY());
			sb.append(")");
			System.err.println(sb);
		}
	}
	/**
	 * Evoluciona todas las casillas del tablero siultaneamente usando el metodo calculaSiguienteEstadoCelda() de la Regla Conway
	 */
	public void actualiza() {
		HashMap<Coordenada, EstadoCelda> celdas = new HashMap<Coordenada, EstadoCelda>();
		Collection<Coordenada> coordenada;
		EstadoCelda next_status;
		
		coordenada=tablero.getPosiciones();
		
		for(Coordenada posicion : coordenada) {
			next_status=regla.calculaSiguienteEstadoCelda(tablero, posicion);
			celdas.put(posicion, next_status);
		}
		coordenada=celdas.keySet();
		for(Coordenada c: coordenada) {
			tablero.setCelda(c, celdas.get(c));
		}
	}
	/**
	 * Getter: devuelve el tablero que se va a utilizar
	 * @return tablero tablero que se va a utilizar para el juego de la vida
	 */
	public Tablero getTablero() {
		return tablero;
	}
	/**
	 * Getter: permite obtener los patrones utilizados durante el juego
	 * @return patronesUsados variable que guarda los patrones utilizados
	 */
	public ArrayList<Patron> getPatrones(){
		return patronesUsados;
	}
}
