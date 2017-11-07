package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.excepciones.*;

public class Tablero1D extends Tablero {
	public Tablero1D(int cx) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos{
		super(new Coordenada1D(cx));
		celdas=new HashMap<Coordenada, EstadoCelda>();
			try {
				for (int i = 0; i < cx; i++) {
					celdas.put(new Coordenada1D(i), EstadoCelda.MUERTA);
				}
			}catch(ExcepcionCoordenada1DIncorrecta error) {
				throw new ExcepcionEjecucion(error);
			}
	}
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero{
		ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
		
		if(posicion == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(celdas.containsKey(posicion)) {
			Coordenada1D coordenada = (Coordenada1D)posicion;
			int i=coordenada.getX();
			try {
				if(i - 1 >=0) {
					vecinas.add(new Coordenada1D(i-1));
				}
				if(i+1 < ((Coordenada1D)dimensiones).getX()){
					vecinas.add(new Coordenada1D(i+1));
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				throw new ExcepcionEjecucion(error);
			}
		}
		return vecinas;
	}
	public String toString() {
		try {
			int cx=((Coordenada1D)dimensiones).getX();
			StringBuilder sb = new StringBuilder();
			sb.append("|");
			for(int i = 0; i < cx; i++) {
				if(celdas.get(new Coordenada1D(i)) == EstadoCelda.MUERTA) {
					sb.append(" ");
				}else {
					sb.append("*");
				}
			}
			sb.append("|");
			return sb.toString();
		}catch(ExcepcionCoordenadaIncorrecta error) {
			throw new ExcepcionEjecucion(error);
		}
	}
}



