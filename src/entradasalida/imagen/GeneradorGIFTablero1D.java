package entradasalida.imagen;

import java.io.File;

import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import modelo.Coordenada1D;
import modelo.EstadoCelda;
import modelo.Imprimible;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
import entradasalida.IGeneradorFichero;

/**
 * La clase GeneradorGIFTablero1D.
 */
public class GeneradorGIFTablero1D implements IGeneradorFichero{
	
	/**
	 * Posibles errores.
	 * Comprueba los posibles errores que se especifican en la practica
	 * @param file el parametro file pasado por referencia
	 * @param juego el parametro juego pasado por referencia
	 * @param iteracciones el parametro iteracciones pasado por referencia
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
	 * Constructor del generador GIF de un talbero tablero 1D.
	 */
	public GeneradorGIFTablero1D(){
		
	}
	
	@Override
	public void generaFichero(File file, Juego juego, int iteracciones) throws ExcepcionGeneracion {
		posiblesErrores(file, juego, iteracciones);
		Coordenada1D coordenada = (Coordenada1D)juego.getTablero().getDimensiones();
		int ancho = coordenada.getX();
		ImagenGIF gif = new ImagenGIF(ancho, iteracciones);
		for(int j = 0; j < iteracciones; j++) {
			for(int i = 0; i < ancho; i++){
				try {
				if(juego.getTablero().getCelda(new Coordenada1D(i)) == EstadoCelda.VIVA){
					gif.pintaCuadrado(i, j);
				}
				}catch(ExcepcionCoordenadaIncorrecta error) {
					throw new ExcepcionEjecucion(error);
				}catch(ExcepcionPosicionFueraTablero error) {
					throw new ExcepcionEjecucion(error);
				}
			}
			juego.actualiza();
		}
		gif.guardaFichero(file);
	}
}
