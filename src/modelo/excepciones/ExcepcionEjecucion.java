package modelo.excepciones;

public class ExcepcionEjecucion extends RuntimeException{
	public ExcepcionEjecucion(String mensaje) {
		super(mensaje);
	}
	public ExcepcionEjecucion(Throwable cause) {
		super(cause);
	}
}