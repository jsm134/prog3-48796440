/*
 * @author Jose Soler Martinez 48796440P
 * 
 */
package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.gif.GeneradorTableroCoordenada1D;
import entradasalida.gif.GeneradorTableroCoordenada2D;
import entradasalida.txt.GeneradorFicheroPlano;
import modelo.Coordenada;
import modelo.Regla;
import modelo.Tablero;
import modelo.d1.Coordenada1D;
import modelo.d1.Regla30;
import modelo.d1.Tablero1D;
import modelo.d2.Coordenada2D;
import modelo.d2.ReglaConway;
import modelo.d2.Tablero2D;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;

/**
 * La Clase Factory.
 */
public class Factory {
	
	/**
	 * Instantiates a new factory.
	 */
	public Factory() {
		
	}
	
	/**
	 * Tableronull.
	 * Comprueba si el tablero pasado por parámetro es nulo y lanza una excepcion
	 * @param tablero el tablero a evaluar
	 */
	private static void tableronull(Tablero tablero) {
		if(tablero==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	
	/**
	 * Crea generador fichero.
	 *
	 * @param tablero el parametro tablero pasados por referencia
	 * @param extension el parametr extension pasado por variable
	 * @return el gif
	 * @throws ExcepcionGeneracion lanza una excepcion generacion
	 */
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension) throws ExcepcionGeneracion {
		IGeneradorFichero gif;
		tableronull(tablero);
		if(extension==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		String nombre_fichero = "entradasalida." + extension + ".GeneradorTablero" + tablero.getDimensiones().getClass().getSimpleName();
		try {
			Class clase = Class.forName(nombre_fichero);
			try {
				gif = (IGeneradorFichero)clase.newInstance();
			} catch (InstantiationException error) {
				throw new ExcepcionGeneracion(error);
			} catch (IllegalAccessException error) {
				throw new ExcepcionGeneracion(error);
			}
		}catch(ClassNotFoundException error) {
			throw new ExcepcionGeneracion("nombre_fichero incorrecto");
		}
		return gif;
	}
	
	/**
	 * Crea regla.
	 *
	 * @param tablero el parametro tablero
	 * @return la regla a utilizar
	 */
	public static Regla creaRegla(Tablero tablero) {
		Regla regla;
		tableronull(tablero);
		if(!(tablero instanceof Tablero1D) && !(tablero instanceof Tablero2D)) {
			throw new ExcepcionEjecucion("No es un tipo de tablero");
		}else if(tablero instanceof Tablero1D) {
			regla = new Regla30();
		}else {
			regla = new ReglaConway();
		}
		return regla;
	}
	
	/**
	 * Crea tablero.
	 *
	 * @param dimensiones parametro dimensiones pasado por referencia 
	 * @return el tablero creado
	 * @throws ExcepcionCoordenadaIncorrecta lanza una excepcion coordenada incorrecta
	 */
	public static Tablero creaTablero(Coordenada dimensiones) throws ExcepcionCoordenadaIncorrecta {
		if(dimensiones == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		Tablero tablero;
		if(!(dimensiones instanceof Coordenada1D) && !(dimensiones instanceof Coordenada2D)) {
			throw new ExcepcionEjecucion("No es una coordenada valida");
		}else if(dimensiones instanceof Coordenada1D) {
			int x = ((Coordenada1D)dimensiones).getX();
			tablero = new Tablero1D(x);
		}else {
			Coordenada2D coordenada = (Coordenada2D)dimensiones;
			int x = coordenada.getX();
			int y = coordenada.getY();
			tablero = new TableroCeldasCuadradas(x,y);
		}
		return tablero;
	}
	
}
