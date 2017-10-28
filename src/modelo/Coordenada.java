package modelo;
import modelo.excepciones.*;

public class Coordenada {
	private int x;
	private int y;
	private static int NUMERO_COORDENADAS;

	public Coordenada(int x, int y) throws ExcepcionCoordenadaIncorrecta{
		if(x<0 || y<0) {
			throw new ExcepcionCoordenadaIncorrecta();
		}else {
			this.x=x;
			this.y=y;
			NUMERO_COORDENADAS++;
		}
	}

	public Coordenada (Coordenada otra) throws ExcepcionArgumentosIncorrectos {
		if(otra == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else {
			this.x=otra.x;
			this.y=otra.y;
			NUMERO_COORDENADAS++;
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Coordenada other = (Coordenada) otro;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public static int getNumeroCoordenadas() {
		return NUMERO_COORDENADAS;
	}
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Coordenada suma (Coordenada otra) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos {
		if(otra==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else {
			return new Coordenada (x+otra.x,y+otra.y);
		}
	}
	
}


