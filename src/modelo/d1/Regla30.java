/**
 * @author Jose Soler Martinez 48796440P
 */
package modelo.d1;
 
import java.util.ArrayList;

import modelo.Coordenada;
import modelo.EstadoCelda;
import modelo.Regla;
import modelo.Tablero;
import modelo.excepciones.*;

/**
 * La clase Regla30 permite calcular el estado siguiente de cada una de
 * las celdas del tablero mediante un algoritmo previamente implementado
 * basado en 111 110 101 000.
 */
public class Regla30 extends Regla<Coordenada1D> {
	
	/**
	 * Constructor de Regla30.
	 */
	public Regla30() {
		
	}
	
	@Override
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero<Coordenada1D> tablero, Coordenada1D posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero{
		if(tablero == null || posicion == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		EstadoCelda new_status;
		if(tablero.contiene(posicion)){
			ArrayList<Coordenada1D> c_vecinas = tablero.getPosicionesVecinasCCW(posicion);
			if(c_vecinas.size()!=1) {
				EstadoCelda A = tablero.getCelda(c_vecinas.get(0));
				EstadoCelda B = tablero.getCelda(posicion);
				EstadoCelda C = tablero.getCelda(c_vecinas.get(1));
				// 111
				if((A == EstadoCelda.VIVA && B == EstadoCelda.VIVA && C == EstadoCelda.VIVA) || 
						// 110
						(A == EstadoCelda.VIVA && B == EstadoCelda.VIVA && C == EstadoCelda.MUERTA) ||
						// 101
						(A == EstadoCelda.VIVA && B == EstadoCelda.MUERTA && C == EstadoCelda.VIVA) ||
						// 000
						(A == EstadoCelda.MUERTA && B == EstadoCelda.MUERTA && C == EstadoCelda.MUERTA)) {
					new_status = EstadoCelda.MUERTA;
				// Si no es 111, 110, 101, 000
				}else {
					new_status = EstadoCelda.VIVA;
				}
			}else {
				new_status=EstadoCelda.MUERTA;
			}
			return new_status;
		}else {
			throw new ExcepcionPosicionFueraTablero(tablero.getDimensiones(), posicion);
		}
	}
}
