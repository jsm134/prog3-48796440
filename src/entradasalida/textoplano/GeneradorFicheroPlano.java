package entradasalida.textoplano;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

/**
 * La clase GeneradorFicheroPlano.
 */
public class GeneradorFicheroPlano implements IGeneradorFichero {
	
	/**
	 * Constructor de un generador de fichero plano.
	 */
	public GeneradorFicheroPlano() {
		
	}
	
	@Override
	public void generaFichero(File file, Juego juego, int iteracciones) throws ExcepcionGeneracion {
			if(file == null || juego == null) {
				throw new ExcepcionArgumentosIncorrectos();
			}
			if(iteracciones > 0) {
				if(juego.getTablero() instanceof Imprimible) {
				try {
					PrintWriter printWriter = new PrintWriter(file);
					for(int i=0; i < iteracciones; i++) {
						juego.actualiza();
						printWriter.print(juego.getTablero());
					}
					printWriter.close();
				}catch(FileNotFoundException error) {
					throw new ExcepcionGeneracion(error);
				}
				}else {
					throw new ExcepcionGeneracion("Error: no pertenece a Imprimible");
				}
			}else {
				throw new ExcepcionGeneracion("Las iteracciones no pueden ser menores o cero");
			}
	}
}
