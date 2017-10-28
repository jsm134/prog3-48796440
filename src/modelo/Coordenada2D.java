package modelo;
import modelo.excepciones.*;

public class Coordenada2D extends Coordenada {
	private int x;
	private int y;
	private static int NUMERO_COORDENADAS;

	public Coordenada2D(int x, int y) throws ExcepcionCoordenadaIncorrecta{
		if(x<0 || y<0) {
			throw new ExcepcionCoordenadaIncorrecta();
		}else {
			this.x=x;
			this.y=y;
			NUMERO_COORDENADAS++;
		}
	}

	public Coordenada2D (Coordenada2D otra) throws ExcepcionArgumentosIncorrectos {
		if(otra == null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else{
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
		Coordenada2D other = (Coordenada2D) otro;
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

	public Coordenada2D suma (Coordenada otra) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos {
		if(otra==null) {
			throw new ExcepcionArgumentosIncorrectos();
		}else {
			return new Coordenada2D (x+((Coordenada2D)otra).x,y+((Coordenada2D)otra).y);
		}
	}
	
}

