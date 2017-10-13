package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
/**
 * @author José Soler Martínez
 *
 */
public class Tablero {
	private Coordenada dimensiones;
	private HashMap<Coordenada,EstadoCelda> celdas;
	public Tablero(Coordenada dimensiones){
		celdas=new HashMap<Coordenada, EstadoCelda>();
		int x=dimensiones.getX();
		int y=dimensiones.getY();
		this.dimensiones=dimensiones;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				celdas.put(new Coordenada(i,j), EstadoCelda.MUERTA);
			}
		}
	}
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	public String toString() {
		int cx=dimensiones.getX();
		int cy=dimensiones.getY();
		String tablero="";
		tablero="+";
		for(int i=1; i <= cx;i++) {
			tablero+= "-";
		}
		tablero+="+ \n";
		for(int j=0; j < cy; j++) {
			tablero+="|";
			for(int i = 0; i < cx; i++) {
				if(celdas.get(new Coordenada(i,j)) == EstadoCelda.MUERTA) {
					tablero+= " ";
				}else {
					tablero+= "*";
				}
			}
			tablero+="| \n";
		}
		tablero+="+";
		for(int i=1;i <= cx;i++) {
			tablero+= "-";
		}
		tablero= tablero + "+ \n";
		return tablero;
	}
	public Collection<Coordenada> getPosiciones(){
		return celdas.keySet();
	}
	private void muestraErrorPosicionInvalida(Coordenada c) {
		StringBuilder sb = new StringBuilder();
		sb.append("Error: la celda (");
		sb.append(c.getX());
		sb.append(",");
		sb.append(c.getY());
		sb.append(") no existe");
		System.out.println(sb);
		// return sb.toString();
		//System.out.println("Error: la celda (" +c.getX() + "," + c.getY() + ") no existe");
	}
	
	public EstadoCelda getCelda(Coordenada posicion) {
		Set<Coordenada> coordenadas = celdas.keySet();
		if(coordenadas.contains(posicion)==false) {
			muestraErrorPosicionInvalida(posicion);
			return null;
		}else {
			return celdas.get(posicion);
		}
	}
	public void setCelda(Coordenada posicion, EstadoCelda e) {
		if(celdas.containsKey(posicion)) {
			celdas.put(posicion, e);
		}else {
			muestraErrorPosicionInvalida(posicion);
		}
	}
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion){
		ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
		int i=posicion.getX();
		int j=posicion.getY();
		//vecina0
		Coordenada coordenada = new Coordenada (i - 1, j - 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i - 1, j - 1));
		}
		//vecina1
		coordenada = new Coordenada (i - 1, j);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i - 1, j));
		}
		//vecina2
		coordenada = new Coordenada (i - 1, j + 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i - 1, j + 1));
		}
		//vecina3
		coordenada = new Coordenada (i, j + 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i , j + 1));
		}
		//vecina4
		coordenada = new Coordenada (i + 1, j + 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i + 1, j + 1));
		}
		//vecina5
		coordenada = new Coordenada (i + 1, j);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i + 1, j));
		}
		//vecina6
		coordenada = new Coordenada (i + 1, j - 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i + 1, j - 1));
		}
		//vecina7
		coordenada = new Coordenada (i, j - 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i, j - 1));
		}
		return vecinas;
	}
	
	public boolean cargaPatron(Patron patron, Coordenada coordenadaInicial) {
		boolean p_charge = true;
		Coordenada c_final;
		Collection<Coordenada> cp;
		cp = patron.getPosiciones();
		for(Coordenada select:cp) {
			c_final=select.suma(coordenadaInicial);
			if(celdas.containsKey(c_final) == false){
				p_charge=false;
			}
		}
		EstadoCelda c_status;
		//comprobar que se puede hacer el patrón en ese sitio
		if(p_charge==true) {
			cp = patron.getPosiciones();
			for(Coordenada select:cp) {
				c_final=select.suma(coordenadaInicial);
				c_status=patron.getCelda(select);
				celdas.put(c_final,c_status);
			}
		}
		return p_charge;	
	}
	
	
	public boolean contiene(Coordenada posicion) {
		return celdas.containsKey(posicion);
	}

}
	