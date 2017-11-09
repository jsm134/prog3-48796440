package modelo;

import java.util.HashMap;

import modelo.excepciones.*;

public abstract class Tablero2D extends Tablero{
	public Tablero2D(int ancho, int alto) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta{
		super(new Coordenada2D(ancho, alto));
		celdas=new HashMap<Coordenada, EstadoCelda>();
		try {
			int x=((Coordenada2D)dimensiones).getX();
			int y=((Coordenada2D)dimensiones).getY();
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
						celdas.put(new Coordenada2D(i,j), EstadoCelda.MUERTA);
				}
			}
		}catch(ExcepcionCoordenadaIncorrecta coord) {
			throw new ExcepcionEjecucion(coord);
		}
	}
}
