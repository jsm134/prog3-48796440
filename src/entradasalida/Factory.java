package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.imagen.GeneradorGIFTablero1D;
import entradasalida.imagen.GeneradorGifAnimadoTablero2D;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.Coordenada;
import modelo.Coordenada1D;
import modelo.Coordenada2D;
import modelo.Regla;
import modelo.Regla30;
import modelo.ReglaConway;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.Tablero2D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;

public class Factory {
	public Factory() {
		
	}
	private static void tableronull(Tablero tablero) {
		if(tablero==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
	}
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero, String extension) throws ExcepcionGeneracion {
		IGeneradorFichero gif;
		tableronull(tablero);
		if(extension==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(extension.equals("txt")) {
			gif = new GeneradorFicheroPlano();
		}else if(extension.equals("gif")) {
			if(tablero instanceof Tablero1D) {
				gif = new GeneradorGIFTablero1D();
			}else if(tablero instanceof Tablero2D) {
				gif = new GeneradorGifAnimadoTablero2D();
			}else {
				throw new ExcepcionEjecucion("No es un tablero valido");
			}
		}else {
			throw new ExcepcionGeneracion("No tiene una extension valida");
		}
		return gif;
	}
	
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
