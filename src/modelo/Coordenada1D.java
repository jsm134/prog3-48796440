package modelo;
import modelo.excepciones.*;

public class Coordenada1D extends Coordenada {
	private int x;
	//private static int NUMERO_COORDENADAS;

	public Coordenada1D(int x) throws ExcepcionCoordenadaIncorrecta{
		if(x<0) {
			throw new ExcepcionCoordenadaIncorrecta();
		}else {
			this.x=x;
			//NUMERO_COORDENADAS++;
		}
	}

	public Coordenada1D (Coordenada1D otra) throws ExcepcionArgumentosIncorrectos {
		if(otra == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else{
			this.x=otra.x;
			//NUMERO_COORDENADAS++;
		}
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

	@Override
	public boolean equals(Object otro) {
		if (this == otro)
			return true;
		if (otro == null)
			return false;
		if (getClass() != otro.getClass())
			return false;
		Coordenada1D other = (Coordenada1D) otro;
		if (x != other.x)
			return false;
		return true;
	}

	/*public static int getNumeroCoordenadas() {
		return NUMERO_COORDENADAS;
	}*/
	@Override
	public String toString() {
		return "(" + this.x + ")";
	}

	public int getX() {
		return x;
	}

	public Coordenada1D suma (Coordenada otra) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos {
		if(otra==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else {
			return new Coordenada1D (x+((Coordenada1D)otra).x);
		}
	}
	
}


