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
 *
 * @param <TipoCoordenada> tipo generico de la clase coordenada
 */
public class Juego<TipoCoordenada extends Coordenada> {

	/** Parametro regla. */
	private Regla<TipoCoordenada> regla;

	/** Vector de los patrones usados. */
	private ArrayList<Patron<TipoCoordenada>> patronesUsados;
	
	/** Variable que guarda el tablero. */
	private Tablero<TipoCoordenada> tablero;

	/**
	 * Constructor de un nuevo juego.
	 *
	 * @param tablero parametro pasado por referencia tablero
	 * @param regla parametro pasado por referencia regla
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 */
	public Juego(Tablero<TipoCoordenada> tablero, Regla<TipoCoordenada> regla) throws ExcepcionArgumentosIncorrectos {
		if(tablero != null && regla != null) {
			this.tablero=tablero;
			this.regla=regla;
			patronesUsados=new ArrayList<Patron<TipoCoordenada>>();
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
	public void cargaPatron(Patron<TipoCoordenada> p, TipoCoordenada posicionInicial) throws ExcepcionEjecucion, ExcepcionPosicionFueraTablero {
		tablero.cargaPatron(p, posicionInicial);
		patronesUsados.add(p);
	}

	/**
	 * Modulo que actualiza el patron.
	 *
	 * @throws ExcepcionEjecucion lanza una excepcion de ejecucion
	 */
	public void actualiza() throws ExcepcionEjecucion {
		HashMap<TipoCoordenada, EstadoCelda> celdas = new HashMap<TipoCoordenada, EstadoCelda>();
		Collection<TipoCoordenada> coordenada;
		EstadoCelda next_status;
		try {
			coordenada=tablero.getPosiciones();
			
			for(TipoCoordenada posicion : coordenada) {
				next_status=regla.calculaSiguienteEstadoCelda(tablero, posicion);
				celdas.put(posicion, next_status);
			}
			coordenada=celdas.keySet();
			for(TipoCoordenada c: coordenada) {
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
	public Tablero<TipoCoordenada> getTablero() {
		return tablero;
	}

	/**
	 * getter de patrones.
	 *
	 * @return los patrones usados
	 */
	public ArrayList<Patron<TipoCoordenada>> getPatrones(){
		return patronesUsados;
	}
}
