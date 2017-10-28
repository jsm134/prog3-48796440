package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import modelo.excepciones.*;

public class Tablero {

	private Coordenada dimensiones;

	private HashMap<Coordenada,EstadoCelda> celdas;

	public Tablero(Coordenada dimensiones)throws ExcepcionArgumentosIncorrectos, ExcepcionEjecucion{
		celdas=new HashMap<Coordenada, EstadoCelda>();
		if(dimensiones==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else{
			try {
				int x=dimensiones.getX();
				int y=dimensiones.getY();
				this.dimensiones=dimensiones;
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < y; j++) {
							celdas.put(new Coordenada(i,j), EstadoCelda.MUERTA);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta coord) {
				throw new ExcepcionEjecucion(coord);
			}
		}
	}

	public Coordenada getDimensiones() {
		try {
			return new Coordenada(dimensiones.getX(), dimensiones.getY());
		}catch (ExcepcionCoordenadaIncorrecta coordenada) {
			throw new ExcepcionEjecucion(coordenada);
		}
	}

	public String toString() {
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
	}

	public Collection<Coordenada> getPosiciones(){
			return celdas.keySet();
	}

	private void muestraErrorPosicionInvalida(Coordenada c) {
		StringBuilder sb = new StringBuilder();
		sb.append("Error: La celda (");
		sb.append(c.getX());
		sb.append(",");
		sb.append(c.getY());
		sb.append(") no existe");
		System.err.println(sb);
	}

	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero{
		if(posicion==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		Set<Coordenada> coordenadas = celdas.keySet();
		if(coordenadas.contains(posicion)==false) {
			//muestraErrorPosicionInvalida(posicion);
			throw new ExcepcionPosicionFueraTablero(dimensiones, posicion); //donde tengamos el mensaje MuestraError...
			//return null;
		}else {
			return celdas.get(posicion);
		}
	}

	public void setCelda(Coordenada posicion, EstadoCelda e) {
		 if(posicion==null || e==null){
		 	throw new ExcepcionArgumentosIncorrectos();
		 }
		if(celdas.containsKey(posicion)) {
			celdas.put(posicion, e);
		}else {
			muestraErrorPosicionInvalida(posicion);
		}
	}

	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero{
		ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
		
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
				coordenada = new Coordenada (i - 1, j - 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada(i - 1, j - 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina1
			try {
				coordenada = new Coordenada (i - 1, j);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada(i - 1, j));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina2
			try {
				coordenada = new Coordenada (i - 1, j + 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada(i - 1, j + 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina3
			try {
				coordenada = new Coordenada (i, j + 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada(i , j + 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina4
			try {
				coordenada = new Coordenada (i + 1, j + 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada(i + 1, j + 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina5
			try {
				coordenada = new Coordenada (i + 1, j);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada(i + 1, j));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina6
			try {
				coordenada = new Coordenada (i + 1, j - 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada(i + 1, j - 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
			//vecina7
			try {
				coordenada = new Coordenada (i, j - 1);
				if(celdas.get(coordenada)!=null) {
					try {
						vecinas.add(new Coordenada(i, j - 1));
					}catch(ExcepcionCoordenadaIncorrecta error) {
						throw new ExcepcionEjecucion(error);
					}
				}
			}catch(ExcepcionCoordenadaIncorrecta error) {
				
			}
		}
		return vecinas;
	}

	public boolean cargaPatron(Patron patron, Coordenada coordenadaInicial) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta {
		boolean p_charge = true;
		Coordenada c_final = null;
		Collection<Coordenada> coordenada;
		if(patron != null && coordenadaInicial != null) {
			coordenada = patron.getPosiciones();
			if(coordenada!=null) {
				for(Coordenada select:coordenada) {
					c_final=select.suma(coordenadaInicial);
					if(celdas.containsKey(c_final) == false){
						p_charge=false;
					}
				}
			
				EstadoCelda c_status;
				if(p_charge==true) {
					coordenada = patron.getPosiciones();
					for(Coordenada select:coordenada) {
						c_final=select.suma(coordenadaInicial);
						c_status=patron.getCelda(select);
						celdas.put(c_final,c_status);
					}
				}else {
					muestraErrorPosicionInvalida(c_final);
				}
			}
		}else {
			p_charge=false;
		}
		return p_charge;
	}

	public boolean contiene(Coordenada posicion) {
		return celdas.containsKey(posicion);
	}

}
	