package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Tablero {
	private HashMap<Coordenada,EstadoCelda> celdas;
	public Tablero(Coordenada dimensiones){
		int x=dimensiones.getX();
		int y=dimensiones.getY();
		for (int i = 0; i < x+2; i++) {
			for (int j = 0; j < y+2; j++) {
				celdas.put(new Coordenada(i,j), EstadoCelda.MUERTA);
			}
		}
	}
	public Coordenada getDimensiones() {
		return null;
	}
	public Collection<Coordenada> getPosiciones(){
		return null;
	}
	public EstadoCelda getCelda(Coordenada posicion) {
		return null;
		
	}
	public void setCelda(Coordenada posicion, EstadoCelda e) {
		
	}
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion){
		ArrayList<Coordenada> vecinas = null;
		vecinas = new ArrayList<Coordenada>();
		vecinas.add(new Coordenada(posicion.getX() - 1, posicion.getY()-1));
		vecinas.add(new Coordenada(posicion.getX() - 1, posicion.getY()));
		vecinas.add(new Coordenada(posicion.getX() - 1, posicion.getY()+1));
		vecinas.add(new Coordenada(posicion.getX(), posicion.getY()+1));
		vecinas.add(new Coordenada(posicion.getX() + 1, posicion.getY()+1));
		vecinas.add(new Coordenada(posicion.getX() + 1, posicion.getY()));
		vecinas.add(new Coordenada(posicion.getX() + 1, posicion.getY()-1));
		vecinas.add(new Coordenada(posicion.getX(), posicion.getY()-1));
		return vecinas;


		
	}
	public void muestraErrorPosicionInvalida(Coordenada c) {
		
	}
	public boolean cargaPatron(Patron patron, Coordenada coordenadaInicial) {
		boolean cargado; //se cambia
		Coordenada destino; //se cambia
		EstadoCelda valor;	//se cambia
		Collection<Coordenada> cp;
		
		cargado=true;	//se cambia
		
		cp = patron.getPosiciones();
		for(Coordenada actual:cp) {
			destino=actual.suma(coodenadaInicial);
			if(tablero.containsKey(destino))==false){
				cargado=false;
			}
		}
		//comprobar que se puede hacer el patrón en ese sitio
		if(cargado==true) {
			cp = patron.getPosiciones();
			for(Coordenada actual:cp) {
				destino=actual.suma(coordenadaInicial);
				valor=patron.getCelda(actual);
				tablero.put(destino,valor);
			}
		}
		return cargado;
		
	}
	
	
	public boolean contiene(Coordenada posicion) {
		return false;
		
	}
	@Override
	public String toString() {
		return "Tablero []";
	}

}
	