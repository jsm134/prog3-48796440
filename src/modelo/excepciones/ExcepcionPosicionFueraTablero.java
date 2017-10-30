package modelo.excepciones;

import modelo.Coordenada;

public class ExcepcionPosicionFueraTablero extends Exception{
	private Coordenada dimensiones;
	private Coordenada coordenada;
	public ExcepcionPosicionFueraTablero(Coordenada d, Coordenada c) {
		dimensiones = d;
		coordenada = c;
	}
	public Coordenada getCoordenada() {
		return coordenada;
	}
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	public String getMessage() {
		return "Error: Posicion Fuera del Tablero";
	}
}
