package entradasalida.excepciones;

public class ExcepcionGeneracion extends Exception {
	public ExcepcionGeneracion() {
		super("Error: Excepcion Generacion");
	}
	public ExcepcionGeneracion(String cadena) {
		super(cadena);
	}
	public ExcepcionGeneracion(Throwable causa) {
		super(causa);
	}
}
