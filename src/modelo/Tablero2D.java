package modelo;

import java.util.HashMap;

import modelo.excepciones.*;

public abstract class Tablero2D extends Tablero{
	
	/**
	 * Inicializa un nuevo Tablero2D.
	 *
	 * @param ancho el ancho de la celda
	 * @param alto el alto de la celda
	 * @throws ExcepcionArgumentosIncorrectos la excepcion argumentos incorrectos
	 * @throws ExcepcionCoordenadaIncorrecta la excepcion coordenada incorrecta
	 */
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
