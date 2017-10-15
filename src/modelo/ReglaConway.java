/**
 * 
 */
package modelo;

import java.util.ArrayList;

/**
 * Clae ReglaConway, permite el uso de la ReglaConway para el correspondiete transcurso del juego
 * de la vida
 * @author José Soler Martínez
 */
public class ReglaConway {
	/**
	 * Llamada a la ReglaConway
	 */
	public ReglaConway() {}
	/**
	 * Constructor: dada una celda del tablero, devuelve el nuevo estado que tendrá esa celda
	 * @param tablero paremetro pasado por referencia que incluye el tablero a utilizar
	 * @param posicion parametro pasado por referencia que incluye la posicion a evaluar
	 * @return new_status variable que guarda el estado de la nueva celda
	 */
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
