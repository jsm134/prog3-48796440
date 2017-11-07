package modelo;

import java.util.ArrayList;
import modelo.excepciones.*;

public class TableroCeldasCuadradas extends Tablero2D{
	public TableroCeldasCuadradas(int x, int y) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta{
		super(x,y);
	}
	
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos, ExcepcionEjecucion{
		ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
		
		if(posicion == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		if(celdas.containsKey(posicion)==false) {
			throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
		}
		int i=((Coordenada2D)posicion).getX();
		int j=((Coordenada2D)posicion).getY();
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
		int cx=((Coordenada2D)dimensiones).getX();
		int cy=((Coordenada2D)dimensiones).getY();
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
}
