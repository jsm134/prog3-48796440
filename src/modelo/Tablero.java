package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import modelo.excepciones.*;

public abstract class Tablero {

	protected Coordenada dimensiones;

	protected HashMap<Coordenada,EstadoCelda> celdas;

	public Tablero(Coordenada dimensiones)throws ExcepcionArgumentosIncorrectos, ExcepcionEjecucion{
		//celdas=new HashMap<Coordenada, EstadoCelda>();
		if(dimensiones==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else {
			this.dimensiones=dimensiones;
		}
	}

	public Coordenada getDimensiones() {
		return dimensiones;
	}

	public abstract String toString(); /*{
		StringBuilder sb = new StringBuilder();
		int cx=dimensiones.getX();
		int cy=dimensiones.getY();
		sb.append("+");
		for(int i=1; i <= cx;i++) {
			sb.append("-");
		}
		sb.append("+\n");
		for(int j=0; j < cy; j++) {
			sb.append("|");
			for(int i = 0; i < cx; i++) {
				if(celdas.get(new Coordenada(i,j)) == EstadoCelda.MUERTA) {
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
	}*/

	public Collection<Coordenada> getPosiciones(){
			return celdas.keySet();
	}

/*	private void muestraErrorPosicionInvalida(Coordenada c) {
		StringBuilder sb = new StringBuilder();
		sb.append("Error: La celda (");
		sb.append(c.getX());
		sb.append(",");
		sb.append(c.getY());
		sb.append(") no existe");
		System.err.println(sb);
	}*/

	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero{
		if(posicion==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		Set<Coordenada> coordenadas = celdas.keySet();
		if(coordenadas.contains(posicion)==false) {
			//muestraErrorPosicionInvalida(posicion);
			throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
			//return null;
		}else {
			return celdas.get(posicion);
		}
	}

	public void setCelda(Coordenada posicion, EstadoCelda e) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero{
		 if(posicion==null || e==null){
		 	throw new ExcepcionArgumentosIncorrectos();
		 }
		if(celdas.containsKey(posicion)) {
			celdas.put(posicion, e);
		}else {
			//muestraErrorPosicionInvalida(posicion);
			throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
		}
	}

	public abstract ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero;/*{
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
	}*/

	public void cargaPatron(Patron patron, Coordenada coordenadaInicial)throws ExcepcionEjecucion{
		boolean p_charge = true;
		Coordenada c_final = null;
		Collection<Coordenada> coordenada;
		if(patron != null && coordenadaInicial != null) {
			coordenada = patron.getPosiciones();
			if(coordenada!=null) {
				for(Coordenada select:coordenada) {
					try {
						c_final=select.suma(coordenadaInicial);
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
					if(celdas.containsKey(c_final) == false){
						p_charge=false;
					}
				}
			
				EstadoCelda c_status;
				if(p_charge==true) {
				coordenada = patron.getPosiciones();
					for(Coordenada select:coordenada) {
						try {
							c_final=select.suma(coordenadaInicial);
						}catch(ExcepcionCoordenadaIncorrecta error) {
							throw new ExcepcionEjecucion(error);
						}
						try {
							c_status=patron.getCelda(select);
							celdas.put(c_final,c_status);
						}catch(ExcepcionPosicionFueraTablero error) {
							throw new ExcepcionEjecucion(error);
						}
					}
				}
				/*else {
					muestraErrorPosicionInvalida(c_final);
					throw new ExcepcionPosicionFueraTablero(dimensiones, select);
				}*/
			}
		}else {
			throw new ExcepcionArgumentosIncorrectos();
			//p_charge=false;
		}
		//return p_charge;
	}

	public boolean contiene(Coordenada posicion) {
		return celdas.containsKey(posicion);
	}

}
	