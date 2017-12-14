/**
 * @author Jose Soler Martinez 48796440P
 */
package modelo.d2;

import java.util.HashMap;

import modelo.Coordenada;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.excepciones.*;
/**
 *	Clase Tablero2D
 *	Clase extendida de Tablero que permite la creacion de un tablero
 *	de dos dimensiones
 */
public abstract class Tablero2D extends Tablero<Coordenada2D>{
	
	/**
	 * Inicializa un nuevo Tablero2D.
	 *
	 * @param ancho el ancho de la celda
	 * @param alto el alto de la celda
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 * @throws ExcepcionCoordenadaIncorrecta lanza una excepcion de coordenada incorrecta
	 */
	public Tablero2D(int ancho, int alto) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta{
		super(new Coordenada2D(ancho, alto));
		celdas=new HashMap<Coordenada2D, EstadoCelda>();
		try {
			int x=dimensiones.getX();
			int y=dimensiones.getY();
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
						celdas.put(new Coordenada2D(i,j), EstadoCelda.MUERTA);
				}
			}
		}catch(ExcepcionCoordenada2DIncorrecta coord) {
			throw new ExcepcionEjecucion(coord);
		}
	}
}
