/*
 * @author Jose Soler Martinez 48796440P
 * 
 */
package entradasalida.txt;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.d2.Coordenada2D;
import modelo.d2.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * La clase ParserTablero2D.
 */
public class ParserTablero2D implements IParserTablero {

	/**
	 * Cadena incorrecta.
	 * Comprueba si la cadena pasada por parametro es correcta o no
	 * @param cadena parametro cadena pasado por parametro
	 * @return true, si tiene caracteres invalidos
	 */
	private boolean cadenaIncorrecta(String cadena) {
		boolean comprobado = false;
		for(int i=0;i < cadena.length(); i++) {
			if(cadena.charAt(i) != '*' && cadena.charAt(i) != ' ') {
				comprobado = true;
			}
		}
		return comprobado;
	}
	
	/**
	 * Lee tablero.
	 *
	 * @param cadena parametro cadena pasado por referencia
	 * @return el tablero a evaluar
	 * @throws ExcepcionLectura lanza una excepcion lectura
	 */
	public Tablero leeTablero(String cadena) throws ExcepcionLectura{
		Tablero tablero;
		if(cadena != null) {
			if(cadena.equals("")) {
				throw new ExcepcionLectura();
			}else{
				String[] lineas;
				lineas = cadena.split("\n");
				int n_lineas = lineas.length;
				int longitud = lineas[0].length();
				for(int i=0; i < n_lineas; i++) {
					if(longitud != lineas[i].length()) {
						throw new ExcepcionLectura();
					}
				}
				for(int i = 0; i < n_lineas; i++) {
					if(cadenaIncorrecta(lineas[i])) {
						throw new ExcepcionLectura();
					}
				}
				try {
					tablero = new TableroCeldasCuadradas(longitud, n_lineas);
				}catch(Exception error) {
					throw new ExcepcionEjecucion(error);
				}
					for(int i = 0; i < n_lineas; i++) {
						int largo = lineas[i].length();
						for(int j = 0; j < largo; j++) {
							char caracter = lineas[i].charAt(j);
							try {
							if(caracter == ' ') {
								tablero.setCelda(new Coordenada2D(j,i), EstadoCelda.MUERTA);
							}else {
								tablero.setCelda(new Coordenada2D(j,i), EstadoCelda.VIVA);
							}
							}catch(ExcepcionCoordenadaIncorrecta error) {
								throw new ExcepcionEjecucion(error);
							}catch(ExcepcionPosicionFueraTablero error) {
								throw new ExcepcionEjecucion(error);
							}
						}
					}
			}
		
		}else {
			throw new ExcepcionArgumentosIncorrectos();
		}
		return tablero;
	}

}
