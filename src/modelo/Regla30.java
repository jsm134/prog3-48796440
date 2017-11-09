package modelo;
 
import java.util.ArrayList;

import modelo.excepciones.*;

public class Regla30 extends Regla {
	public Regla30() {
		
	}
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero{
		if(tablero == null || posicion == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}
		EstadoCelda new_status;
		if(((Tablero1D)tablero).contiene(posicion)){
			ArrayList<Coordenada> c_vecinas = tablero.getPosicionesVecinasCCW(posicion);
			if(c_vecinas.size()!=1) {
				EstadoCelda A = ((Tablero1D)tablero).getCelda(c_vecinas.get(0));
				EstadoCelda B = ((Tablero1D)tablero).getCelda(posicion);
				EstadoCelda C = ((Tablero1D)tablero).getCelda(c_vecinas.get(1));
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
