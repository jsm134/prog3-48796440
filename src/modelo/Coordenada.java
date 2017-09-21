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
	private int NUMERO_COORDENADAS;
	public Coordenada(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public Coordenada (Coordenada otra) {
		this.x=otra.x;
		this.y=otra.y;
	}
	public static int getNumeroCoordenadas() {
		
	}

	@Override
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
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
		
	}
	public int getY() {
		
	}
	public Coordenada suma(Coordenada otra) {
		
	}
	
}
