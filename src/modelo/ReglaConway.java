/**
 * 
 */
package modelo;

import java.util.ArrayList;

/**
 * @author rootear
 *
 */
public class ReglaConway {
	public ReglaConway() {}
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada coordenada) {
		EstadoCelda nuevo=EstadoCelda.MUERTA;
		ArrayList<Coordenada> vecinas; //cambiar
		int vivas = 0; //cambiar
		vecinas=tablero.getPosicionesVecinasCCW(coordenada);
		for(int i = 0; i<vecinas.size();i++) {
			if(tablero.getCelda(vecinas.get(i))==EstadoCelda.VIVA) {
				vivas++;
			}
		}
		if(tablero.getCelda(coordenada)==EstadoCelda.VIVA) {
			if(vivas==2 || vivas ==3) {
				nuevo = EstadoCelda.MUERTA;
			}
			else {
				nuevo=EstadoCelda.MUERTA;
			}
		}else {
			if(vivas==3) {
				
			}else {
				
			}
		}
		return null;
	}
}
