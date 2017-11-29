package entradasalida.imagen;

import java.io.File;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import gifs.ImagenGIFAnimado;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Imprimible;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionEjecucion;

public class GeneradorGifTablero2D implements IGeneradorFichero {
	private void posiblesErrores(File file, Juego juego, int iteracciones) throws ExcepcionGeneracion {
		if(file == null || juego == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else if(iteracciones <= 0) {
			throw new ExcepcionGeneracion("Las iteracciones deben ser mayores que 0");
		}else if(!(juego.getTablero() instanceof Imprimible)){
			throw new ExcepcionGeneracion("No pertenece a imprimible");
		}
	}
	public GeneradorGifTablero2D() {
		
	}
	public void generaFichero(File file, Juego juego, int iteracciones) throws ExcepcionGeneracion{
		posiblesErrores(file, juego, iteracciones);
		ImagenGIFAnimado gifa = new ImagenGIFAnimado(100);
		ImagenGIF gif;
		int x = ((Coordenada2D)juego.getTablero().getDimensiones()).getX();
		int y = ((Coordenada2D)juego.getTablero().getDimensiones()).getY();
		try {
			Coordenada2D coordenada = new Coordenada2D(x,y);
			EstadoCelda estaviva = juego.getTablero().getCelda(coordenada);
			for(int i = 0; i < iteracciones; i++) {
				gif = new ImagenGIF(x,y);
				for(int j = 0; j < x; j++) {
					for(int z = 0; z < y; z++) {
						if(estaviva == EstadoCelda.VIVA) {
							gif.pintaCuadrado(j, z);
						}
					}
				}
				juego.actualiza();
				gifa.addFotograma(gif);
			}
			gifa.guardaFichero(file);
		}catch(Exception error) {
			throw new ExcepcionEjecucion(error);
		}
	}
}
