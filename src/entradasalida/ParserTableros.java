package entradasalida;
import entradasalida.excepciones.*;
import modelo.Tablero;
import modelo.excepciones.*;
import entradasalida.textoplano.*;

public class ParserTableros {
	public ParserTableros() {
		
	}
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
