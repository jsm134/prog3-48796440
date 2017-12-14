/*
 * @author Jose Soler Martinez 48796440P
 * 
 */
package modelo.d1;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Coordenada;
import modelo.EstadoCelda;
import modelo.Imprimible;
import modelo.Tablero;
import modelo.excepciones.*;

/**
 * La Clase Tablero1D.
 * Clase extendida de Tablero que permite la creacion de un tablero de una unica dimension,
 * mostrarlo y calcular sus posiciones vecinas a partir de una celda
 */
public class Tablero1D extends Tablero<Coordenada1D> implements Imprimible {
	
	/**
	 * Constructor de Tablero1D.
	 *
	 * @param ancho el ancho de las celdas
	 * @throws ExcepcionCoordenadaIncorrecta lanza una excepcion de coordenada incorrecta
	 * @throws ExcepcionArgumentosIncorrectos lanza una excepcion de argumentos incorrectos
	 */
	public Tablero1D(int ancho) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos{
		super(new Coordenada1D(ancho));
		celdas=new HashMap<Coordenada1D, EstadoCelda>();
			try {
				for (int i = 0; i < ancho; i++) {
					celdas.put(new Coordenada1D(i), EstadoCelda.MUERTA);
				}
			}catch(ExcepcionCoordenada1DIncorrecta error) {
				throw new ExcepcionEjecucion(error);
			}
	}
	

	@Override
	public ArrayList<Coordenada1D> getPosicionesVecinasCCW(Coordenada1D posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero{
		ArrayList<Coordenada1D> vecinas = new ArrayList<Coordenada1D>();
		
		if(posicion == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(celdas.containsKey(posicion)) {
			Coordenada1D coordenada = posicion;
			int i=coordenada.getX();
			try {
				if(i - 1 >=0) {
					vecinas.add(new Coordenada1D(i-1));
				}
				if(i+1 < dimensiones.getX()){
					vecinas.add(new Coordenada1D(i+1));
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				throw new ExcepcionEjecucion(error);
			}
		}
		return vecinas;
	}
	
	@Override
	public String toString() {
		try {
			int cx=(dimensiones).getX();
			StringBuilder sb = new StringBuilder();
			sb.append("|");
			for(int i = 0; i < cx; i++) {
				if(celdas.get(new Coordenada1D(i)) == EstadoCelda.MUERTA) {
					sb.append(" ");
				}else {
					sb.append("*");
				}
			}
			sb.append("|\n");
			return sb.toString();
		}catch(ExcepcionCoordenadaIncorrecta error) {
			throw new ExcepcionEjecucion(error);
		}
	}
	
	@Override
	public String generaCadena() {
		return toString();
	}
	
}



