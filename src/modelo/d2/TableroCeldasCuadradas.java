/**
 * @author Jose Soler Martinez	48796440P
 */
package modelo.d2;

import java.util.ArrayList;

import modelo.Coordenada;
import modelo.EstadoCelda;
import modelo.Imprimible;
import modelo.excepciones.*;

/**
 * Clase TableroCeldasCuadradas
 * Clase extendida de Tablero2D que permite la creacion de un tablero de dos dimension,
 * mostrarlo y calcular sus posiciones vecinas a partir de una celda
 */
public class TableroCeldasCuadradas extends Tablero2D implements Imprimible{
	
	/**
	 * Instantiates a new tablero celdas cuadradas.
	 *
	 * @param x la variable x de la coordenada
	 * @param y la variable y de la coordenada
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 * @throws ExcepcionCoordenadaIncorrecta lanza una excepcion de coordenada incorrecta
	 */
	public TableroCeldasCuadradas(int x, int y) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta{
		super(x,y);
	}
	
	@Override
	public ArrayList<Coordenada2D> getPosicionesVecinasCCW(Coordenada2D posicion) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos, ExcepcionEjecucion{
		ArrayList<Coordenada2D> vecinas = new ArrayList<Coordenada2D>();
		
		if(posicion == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(celdas.containsKey(posicion)==false) {
			throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
		}
		int i=posicion.getX();
		int j=posicion.getY();
		if(celdas.containsKey(posicion)) {
			Coordenada coordenada;
			//vecina0
			try {
				coordenada = new Coordenada2D (i - 1, j - 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada2D(i - 1, j - 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina1
			try {
				coordenada = new Coordenada2D(i - 1, j);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada2D(i - 1, j));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina2
			try {
				coordenada = new Coordenada2D(i - 1, j + 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada2D(i - 1, j + 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina3
			try {
				coordenada = new Coordenada2D(i, j + 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada2D(i , j + 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina4
			try {
				coordenada = new Coordenada2D(i + 1, j + 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada2D(i + 1, j + 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina5
			try {
				coordenada = new Coordenada2D(i + 1, j);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada2D(i + 1, j));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina6
			try {
				coordenada = new Coordenada2D(i + 1, j - 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada2D(i + 1, j - 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina7
			try {
				coordenada = new Coordenada2D(i, j - 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada2D(i, j - 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
		}
		return vecinas;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int cx=dimensiones.getX();
		int cy=dimensiones.getY();
		try {
			sb.append("+");
			for(int i=1; i <= cx;i++) {
				sb.append("-");
			}
			sb.append("+\n");
			for(int j=0; j < cy; j++) {
				sb.append("|");
				for(int i = 0; i < cx; i++) {
					if(celdas.get(new Coordenada2D(i,j)) == EstadoCelda.MUERTA) {
						sb.append(" ");
					}else {
						sb.append("*");
					}
				}
				sb.append("|\n");
			}
			sb.append("+");
			for(int i=1;i <= cx;i++) {
				sb.append("-");
			}
			sb.append("+\n");
			return sb.toString();
		}catch(ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
	}
	
	@Override
	public String generaCadena() {
		return toString();
	}
}
