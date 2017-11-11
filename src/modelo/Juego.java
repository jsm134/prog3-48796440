/**
 * @author Jose Soler Martinez 48796440P
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * La clase Juego.
 * Permite la creacion de un nuevo juego, la carga de patrones y la actualizacion
 * de cada uno de los movimientos de las celdas
 */
public class Juego {

	/** Parametro regla. */
	private Regla regla;

	/** Vector de los patrones usados. */
	private ArrayList<Patron> patronesUsados;
	
	/** Variable que guarda el tablero. */
	private Tablero tablero;

	/**
	 * Constructor de un nuevo juego.
	 *
	 * @param tablero parametro pasado por referencia tablero
	 * @param regla parametro pasado por referencia regla
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 */
	public Juego(Tablero tablero, Regla regla) throws ExcepcionArgumentosIncorrectos {
		if(tablero != null && regla != null) {
			this.tablero=tablero;
			this.regla=regla;
			patronesUsados=new ArrayList<Patron>();
		}else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}

	/**
	 * Modulo que permite la carga de un patron.
	 *
	 * @param p variable p de la clase patron
	 * @param posicionInicial variable que hace referencia a la posicion inicial del patron
	 * @throws ExcepcionEjecucion lanza una excepcion de ejecucion
	 * @throws ExcepcionPosicionFueraTablero lanza una excepcion de posicion fuera tablero
	 */
	public void cargaPatron(Patron p, Coordenada posicionInicial) throws ExcepcionEjecucion, ExcepcionPosicionFueraTablero {
		tablero.cargaPatron(p, posicionInicial);
		patronesUsados.add(p);
	}

	/**
	 * Modulo que actualiza el patron.
	 *
	 * @throws ExcepcionEjecucion lanza una excepcion de ejecucion
	 */
	public void actualiza() throws ExcepcionEjecucion {
		HashMap<Coordenada, EstadoCelda> celdas = new HashMap<Coordenada, EstadoCelda>();
		Collection<Coordenada> coordenada;
		EstadoCelda next_status;
		try {
			coordenada=tablero.getPosiciones();
			
			for(Coordenada posicion : coordenada) {
				next_status=regla.calculaSiguienteEstadoCelda(tablero, posicion);
				celdas.put(posicion, next_status);
			}
			coordenada=celdas.keySet();
			for(Coordenada c: coordenada) {
				tablero.setCelda(c, celdas.get(c));
			}
		}catch(ExcepcionPosicionFueraTablero p) {
			throw new ExcepcionEjecucion(p);
		}
	}

	/**
	 * Getter de tablero.
	 *
	 * @return el tablero
	 */
	public Tablero getTablero() {
		return tablero;
	}

	/**
	 * getter de patrones.
	 *
	 * @return los patrones usados
	 */
	public ArrayList<Patron> getPatrones(){
		return patronesUsados;
	}
}
