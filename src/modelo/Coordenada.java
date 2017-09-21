package modelo;
/**
 * 
 * @author José Soler Martínez 48796440P
 * @date
 * @link
 * @param
 * @return
 */
public class Coordenada {
	private int x;
	private int y;
	private static int NUMERO_COORDENADAS;
	public Coordenada(int x, int y) {
		this.x=x;
		this.y=y;
		NUMERO_COORDENADAS++;
	}
	public Coordenada (Coordenada otra) {
		this.x=otra.x;
		this.y=otra.y;
		NUMERO_COORDENADAS++;
	}
	public static int getNumeroCoordenadas() {
		return NUMERO_COORDENADAS;
	}

	@Override
	public String toString() {
		return "Coordenada (x=" + x + ", y=" + y + ")";
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
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Coordenada suma (Coordenada otra) {
		return new Coordenada (x+otra.x,y+otra.y);
	}
	
}
