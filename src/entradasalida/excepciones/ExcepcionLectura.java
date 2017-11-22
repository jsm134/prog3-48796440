package entradasalida.excepciones;

public class ExcepcionLectura extends Exception {
	public ExcepcionLectura() {
		super("Error: Excepcion Lectura");
	}
	public ExcepcionLectura(String cadena) {
		super(cadena);
	}
	public ExcepcionLectura(Throwable causa) {
		super(causa);
	}
}
