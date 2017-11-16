/**
 * @author Jose Soler Martinez 48796440P
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import modelo.excepciones.*;

/**
 * La Clase Tablero.
 * Clase principal a partir de la cual se hacen modificaciones tanto en los
 * tableros de 1 dimension como los de 2
 */
public abstract class Tablero {

	/** Las dimensiones. */
	protected Coordenada dimensiones;

	/** Las celdas. */
	protected HashMap<Coordenada,EstadoCelda> celdas;

	/**
	 * Inicializa un nuevo tablero.
	 *
	 * @param dimensiones las dimensiones del tablero
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 */
	protected Tablero(Coordenada dimensiones)throws ExcepcionArgumentosIncorrectos{
		//celdas=new HashMap<Coordenada, EstadoCelda>();
		if(dimensiones==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else {
			this.dimensiones=dimensiones;
		}
	}

	/**
	 * Getter de dimensiones.
	 *
	 * @return las dimensiones del tablero
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
	}

	//@Override
	//public abstract String toString();

	/**
	 * Getter de posiciones.
	 *
	 * @return las posiciones de las celdas del tablero
	 */
	public Collection<Coordenada> getPosiciones(){
		return celdas.keySet();
	}
	
	/**
	 * Getter de celda.
	 *
	 * @param posicion la posicion
	 * @return la posicion de la celda
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 * @throws ExcepcionPosicionFueraTablero lanza una excepcion de posicion fuera tablero
	 */
	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero{
			if(posicion==null) {
				throw new ExcepcionArgumentosIncorrectos();
			}
			Set<Coordenada> coordenadas = celdas.keySet();
			if(coordenadas.contains(posicion)==false) {
				throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
			}else {
				return celdas.get(posicion);
			}
		}

	/**
	 * Setter de celda.
	 *
	 * @param posicion la posicion de la coordenada
	 * @param e el estado de la celda pasado por parametro
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 * @throws ExcepcionPosicionFueraTablero lanza una excepcion de posicion fuera tablero
	 */
	public void setCelda(Coordenada posicion, EstadoCelda e) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero{
		 if(posicion==null || e==null){
		 	throw new ExcepcionArgumentosIncorrectos();
		 }
		if(celdas.containsKey(posicion)) {
			celdas.put(posicion, e);
		}else {
			throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
		}
	}

	/**
	 * Getter de posiciones vecinas CCW.
	 *
	 * @param posicion la posicion de la celda
	 * @return las posiciones vecinas
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 * @throws ExcepcionPosicionFueraTablero lanza una excepcion de posicion fuera tablero
	 */
	public abstract ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero;

	/**
	 * Carga patron, carga un patron a utilizar.
	 *
	 * @param patron el patron a seguir
	 * @param coordenadaInicial la coordenada inicial a partir de la cual se genera el partron
	 * @throws ExcepcionEjecucion lanza una excepcion de ejecucion
	 * @throws ExcepcionPosicionFueraTablero lanza una excepcion fuera del tablero
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 */
	public void cargaPatron(Patron patron, Coordenada coordenadaInicial)throws ExcepcionEjecucion, ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos{
		boolean p_charge = true;
		Coordenada c_final = null;
		Collection<Coordenada> coordenada;
		if(patron != null && coordenadaInicial != null) {
			coordenada = patron.getPosiciones();
			if(coordenada!=null) {
				for(Coordenada select:coordenada) {
					try {
						c_final=select.suma(coordenadaInicial);
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
					if(celdas.containsKey(c_final) == false){
						p_charge=false;
						throw new ExcepcionPosicionFueraTablero(dimensiones, c_final);
					}
				}
			
				EstadoCelda c_status;
				if(p_charge) {
				coordenada = patron.getPosiciones();
					for(Coordenada select:coordenada) {
						try {
							c_final=select.suma(coordenadaInicial);
						}catch(ExcepcionCoordenadaIncorrecta error) {
							throw new ExcepcionEjecucion(error);
						}
						try {
							c_status=patron.getCelda(select);
							celdas.put(c_final,c_status);
						}catch(ExcepcionPosicionFueraTablero error) {
							throw new ExcepcionEjecucion(error);
						}
					}
				}else{
					//muestraErrorPosicionInvalida(c_final);
					//throw new ExcepcionPosicionFueraTablero(dimensiones, c_final);
				}
			}
		}else {
			throw new ExcepcionArgumentosIncorrectos();
			//p_charge=false;
		}
		//return p_charge;
	}

	/**
	 * Booleano Contiene.
	 *
	 * @param posicion la posicion de la celda en el tablero
	 * @return true, si contiene la posicion
	 */
	public boolean contiene(Coordenada posicion) {
		if(posicion != null) {
			return celdas.containsKey(posicion);
		}else {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}

}
	