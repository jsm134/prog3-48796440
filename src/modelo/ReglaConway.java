/**
 * 
 */
package modelo;

import java.util.ArrayList;

/**
 * @author José Soler Martínez
 *
 */
public class ReglaConway {
	public ReglaConway() {}
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) {
		EstadoCelda new_status=EstadoCelda.MUERTA;
		ArrayList<Coordenada> c_vecinas = tablero.getPosicionesVecinasCCW(posicion);
		int c_vivas = 0;
		for(int i = 0; i<c_vecinas.size();i++) {
			if(tablero.getCelda(c_vecinas.get(i))==EstadoCelda.VIVA) {
				c_vivas++;
			}
		}
		if(tablero.getCelda(posicion)==EstadoCelda.VIVA) {
			if(c_vivas==2 || c_vivas ==3) {
				new_status = EstadoCelda.VIVA;
			}
			else {
				new_status=EstadoCelda.MUERTA;
			}
		}else {
			if(c_vivas==3) {
				new_status = EstadoCelda.VIVA;
			}else {
				new_status = EstadoCelda.MUERTA;
			}
		}
		return new_status;
	}
}
