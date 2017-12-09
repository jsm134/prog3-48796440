/*
 * @author Jose Soler Martinez 48796440P
 * 
 */
package entradasalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

/**
 * La Interface IGeneradorFichero.
 */
public interface IGeneradorFichero {
	
	/**
	 * Genera fichero.
	 *
	 * @param file parametro file pasado por referencia
	 * @param juego parametro juego pasado por referencia
	 * @param iteracciones parametro iteracciones pasado por referencia
	 * @throws ExcepcionGeneracion lanza una excepcion generacion
	 */
	public abstract void generaFichero(File file, Juego juego, int iteracciones) throws ExcepcionGeneracion;
}
