/*
 * @author Jose Soler Martinez 48796440P
 * 
 */
package entradasalida.gif;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import gifs.ImagenGIFAnimado;
import modelo.EstadoCelda;
import modelo.Imprimible;
import modelo.Juego;
import modelo.d2.Coordenada2D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * La clase GeneradorGifAnimadoTablero2D.
 */
public class GeneradorTableroCoordenada2D implements IGeneradorFichero {
	
	/**
	 * Posibles errores.
	 * Comprueba los posibles errores que se pueden dar
	 * @param file parametro file pasado por parametro
	 * @param juego el parametro juego pasado por parametro
	 * @param iteracciones el parametro iteracciones pasado por parametro
	 * @throws ExcepcionGeneracion lanza una excepcion generacion
	 */
	private void posiblesErrores(File file, Juego juego, int iteracciones) throws ExcepcionGeneracion {
		if(file == null || juego == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else if(iteracciones <= 0) {
			throw new ExcepcionGeneracion("Las iteracciones deben ser mayores que 0");
		}else if(!(juego.getTablero() instanceof Imprimible)){
			throw new ExcepcionGeneracion("No pertenece a imprimible");
		}
	}
	
	/**
	 * Constructor de un gif animado a partir de un tablero 2D.
	 */
	public GeneradorTableroCoordenada2D() {
		
	}

	@Override
	public void generaFichero(File file, Juego juego, int iteracciones) throws ExcepcionGeneracion{
		posiblesErrores(file, juego, iteracciones);
		ImagenGIFAnimado gifa = new ImagenGIFAnimado(100);
		ImagenGIF gif;
		int x = ((Coordenada2D)juego.getTablero().getDimensiones()).getX();
		int y = ((Coordenada2D)juego.getTablero().getDimensiones()).getY();	
		for(int i = 0; i < iteracciones; i++) {
			gif = new ImagenGIF(x,y);
			for(int j = 0; j < x; j++) {
				for(int z = 0; z < y; z++) {
					try {
						Coordenada2D coordenada = new Coordenada2D(j,z);
						EstadoCelda estaviva = juego.getTablero().getCelda(coordenada);
						if(estaviva == EstadoCelda.VIVA) {
							gif.pintaCuadrado(j, z);
						}
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					} catch (ExcepcionPosicionFueraTablero error) {
						throw new ExcepcionEjecucion(error);
					}
				}			
			}
			gifa.addFotograma(gif);
			juego.actualiza();
		}
		gifa.guardaFichero(file);
	}
}
