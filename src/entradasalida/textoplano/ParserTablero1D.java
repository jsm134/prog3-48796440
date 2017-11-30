package entradasalida.textoplano;
import entradasalida.IParserTablero;
import modelo.Coordenada1D;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionEjecucion;
import entradasalida.excepciones.*;



public class ParserTablero1D implements IParserTablero{
	
	private boolean cadenaIncorrecta(String cadena) {
		boolean comprobado = false;
		for(int i=0;i < cadena.length(); i++) {
			if(cadena.charAt(i) != '*' && cadena.charAt(i) != ' ') {
				comprobado = true;
			}
		}
		return comprobado;
	}
	
	public Tablero leeTablero(String cadena) throws ExcepcionLectura{
		Tablero tablero;
		if(cadena != null) {
			if(cadena.equals("")) {
				throw new ExcepcionLectura();
			}
			if(cadenaIncorrecta(cadena)){
				throw new ExcepcionLectura();
			}else {
				try {
					int largo = cadena.length();
					tablero = new Tablero1D(largo);
					for(int i=0; i < largo;i++) {
						if(cadena.charAt(i) == ' ') {
							tablero.setCelda(new Coordenada1D(i), EstadoCelda.MUERTA);
						}else {
							tablero.setCelda(new Coordenada1D(i), EstadoCelda.VIVA);
						}
					}
				
				}catch(Exception error) {
					throw new ExcepcionEjecucion(error);
				}
			}
		}else {
			throw new ExcepcionArgumentosIncorrectos();
		}
		return tablero;
	}
}