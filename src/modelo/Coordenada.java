/*
 * @author Jose Soler Martinez 48796440P
 * 
 */
package modelo;

import modelo.excepciones.*;

/**
 * La clase Coordenada
 * Clase que se utiliza para inicializar las corrdenadas y que se
 * usa como base para Coordenada1D y Coordenada2D
 */
public abstract class Coordenada {
	
	/**
	 * Constructor de una coordenada.
	 */
	public Coordenada() {
		
	}
	
	/**
	 * Suma de varias coordenadas, sumando una coordeada llamada otra a la que ya se tenia guardada.
	 *
	 * @param otra coordenada a sumar llamada otra
	 * @return una coordenada
	 * @throws ExcepcionCoordenadaIncorrecta ejecuta una excepcion de coordenada incorrecta
	 * @throws ExcepcionArgumentosIncorrectos ejecuta una excepcion de argumentos incorrectos
	 */
	public abstract Coordenada suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos;
}
