package modelo;

import modelo.excepciones.*;

public abstract class Coordenada {
	public Coordenada() {
		
	}
	public abstract Coordenada suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos;
}
