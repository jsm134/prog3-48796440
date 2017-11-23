package entradasalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

public class IGeneradorFichero {
	public void generaFichero(File file, Juego juego, int iteracciones) throws ExcepcionArgumentosIncorrectos, ExcepcionGeneracion{
		if(juego.getTablero() instanceof Imprimible) {
			if(file == null || juego == null) {
				throw new ExcepcionArgumentosIncorrectos();
			}
			if(iteracciones > 0) {
				try {
					PrintWriter printWriter = new PrintWriter(file);
					for(int i=0; i < iteracciones-1; i++) {
						juego.actualiza();
						Imprimible tablero = (Imprimible)juego.getTablero();
						printWriter.println(tablero);
					}
					printWriter.close();
				}catch(FileNotFoundException error) {
					throw new ExcepcionGeneracion(error);
				}
			}else {
				throw new ExcepcionGeneracion("Las iteracciones no pueden ser menores o cero");
			}
		}else {
			throw new ExcepcionGeneracion("Error: no pertenece a Imprimible");
		}
	}
}
