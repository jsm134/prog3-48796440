/*
 * @author Jose Soler Martinez 48796440P
 * 
 */
package entradasalida;
import entradasalida.excepciones.*;
import modelo.Tablero;
import modelo.excepciones.*;
import entradasalida.textoplano.*;

/**
 * La Clase ParserTableros.
 */
public class ParserTableros {
	
	/**
	 * Constructor de ParserTableros
	 */
	public ParserTableros() {
		
	}
	
	/**
	 * Lee tablero.
	 *
	 * @param cadena parametro cadena cadena pasado por referencia
	 * @return devuelve el tablero sobre el cual vamos a trabajar
	 * @throws ExcepcionLectura lanza una excepcion lectura
	 */
	public static Tablero leeTablero(String cadena) throws ExcepcionLectura{
		Tablero principal;
		
		if(cadena != null) {
			if(cadena.equals("")) {
				throw new ExcepcionLectura();
			}else {
				if(((cadena.split("\n")).length) > 1) {
					ParserTablero2D tablero = new ParserTablero2D();
					principal = tablero.leeTablero(cadena);
				}else {
					ParserTablero1D tablero = new ParserTablero1D();
					principal = tablero.leeTablero(cadena);
				}
			}
		}else {
			throw new ExcepcionArgumentosIncorrectos();
		}
		return principal;
	}
}
