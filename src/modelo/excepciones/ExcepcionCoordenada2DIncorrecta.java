package modelo.excepciones;

public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	private int x;
	private int y;
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String getMessage() {
		return "La coordenada 2D (" + x + "," + y + ") es incorrecta";
	}
}
