package entradasalida;
import entradasalida.excepciones.*;
import modelo.Tablero;
public interface IParserTablero {
	public abstract Tablero leeTablero(String cadena) throws ExcepcionLectura;
}
