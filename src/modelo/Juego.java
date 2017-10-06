/**
 * 
 */
package modelo;

import java.util.ArrayList;

/**
 * @author José Soler Martínez
 *
 */
public class Juego {
	private ReglaConway regla;
	private ArrayList<Patron> patronesUsados;
	private Tablero tablero;
	public Juego(Tablero tablero, ReglaConway regla) {
		this.tablero=tablero;
		this.regla=regla;
		patronesUsados=new ArrayList<Patron>();
	}
	public void cargaPatron(Patron p, Coordenada c) {
		if(tablero.cargaPatron(p, c)) {
			patronesUsados.add(p);
		}
	}
	public void actualiza() {
		//hay que llamar a siguienteEstadoCelda para
		//cada posición del tablero
		Collection<Coordenada> cerdas; //cambiar
		cerdas=tablero.getPosiciones();
		for(Coordenada actual : cerdas) {
			EstadoCelda nuevo=regla.calculaSiguienteEstadoCelda(tablero, actual);
			tablero.setCelda(actual, nuevo);
		}
	}
	public Tablero getTablero() {
		return tablero;
	}
	public ArrayList<Patron> getPatrones(){
		return patronesUsados;
	}
}
