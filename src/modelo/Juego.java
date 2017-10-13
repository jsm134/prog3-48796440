/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
	public void cargaPatron(Patron p, Coordenada posicionInicial) {
		if(tablero.cargaPatron(p, posicionInicial)) {
			patronesUsados.add(p);
		}else {
			/*System.out.print("Error cargando plantilla ");
			System.out.print(p.getNombre());
			System.out.print(" en (");
			System.out.print(posicionInicial.getX());
			System.out.print(",");
			System.out.print(posicionInicial.getY());
			System.out.println(")");*/
			///////////////////
			StringBuilder sb = new StringBuilder();
			sb.append("Error cargando plantilla ");
			sb.append(p.getNombre());
			sb.append(" en (");
			sb.append(posicionInicial.getX());
			sb.append(",");
			sb.append(posicionInicial.getY());
			sb.append(")");
			System.out.println(sb);
		}
	}
	public void actualiza() {
		HashMap<Coordenada, EstadoCelda> celdas = new HashMap<Coordenada, EstadoCelda>();
		Collection<Coordenada> coordenada;
		EstadoCelda next_status;
		
		coordenada=tablero.getPosiciones();
		
		for(Coordenada posicion : coordenada) {
			next_status=regla.calculaSiguienteEstadoCelda(tablero, posicion);
			celdas.put(posicion, next_status);
		}
		coordenada=celdas.keySet();
		for(Coordenada c: coordenada) {
			tablero.setCelda(c, celdas.get(c));
		}
	}
	public Tablero getTablero() {
		return tablero;
	}
	public ArrayList<Patron> getPatrones(){
		return patronesUsados;
	}
}
