package entradasalida;
import entradasalida.excepciones.*;
import modelo.Tablero;

/**
 * La Interface IParserTablero.
 */
public interface IParserTablero {
	
	/**
	 * Lee tablero.
	 *
	 * @param cadena parametro cadena pasado por referencia
	 * @return el tablero a evaluar
	 * @throws ExcepcionLectura lanza una excepcion lectura
	 */
	public abstract Tablero leeTablero(String cadena) throws ExcepcionLectura;
}
