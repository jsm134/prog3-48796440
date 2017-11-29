package entradasalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Imprimible;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

public interface IGeneradorFichero {
	public static void generaFichero(File file, Juego juego, int iteracciones) throws ExcepcionArgumentosIncorrectos, ExcepcionGeneracion{
		
	}
}
