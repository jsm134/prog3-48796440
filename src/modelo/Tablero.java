package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
/**
 * Clase Tablero: sirve para crear el tablero a partir del cual se va a trabajar, tambien se utiliza
 * para imprimir dicho tablero, obtener las posiciones de un patron, saber si es posibile que una celda se pueda ubicar
 * dentro del tablero, crear strings, poder saber si existen celdas vecinas o no y definir la posicion de una celda
 * @author José Soler Martínez 48796440P
 */
public class Tablero {
	/**
	 * Atributo que permite guardar las dimensiones del tablero
	 */
	private Coordenada dimensiones;
	/**
	 * Atributo que relaciona una coordenada con su estado
	 */
	private HashMap<Coordenada,EstadoCelda> celdas;
	/**
	 * Constructor: crea un tablero con las dimensiones que se le pasan por parámetro
	 * @param dimensiones Dimensiones del tablero
	 * @param x guarda la extension horizontal del tablero
	 * @param y guarda la extension vertical del tablero
	 */
	public Tablero(Coordenada dimensiones){
		celdas=new HashMap<Coordenada, EstadoCelda>();
		int x=dimensiones.getX();
		int y=dimensiones.getY();
		this.dimensiones=dimensiones;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				celdas.put(new Coordenada(i,j), EstadoCelda.MUERTA);
			}
		}
	}
	/**
	 * Getter: devuelve las dimensiones del tablero
	 * @return dimensiones valor que al macena las dimensiones del tablero
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	/**
	 * String que crea el tablero de forma visual mediante el uso de un StringBuilder para que sea más eficiente
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int cx=dimensiones.getX();
		int cy=dimensiones.getY();
		sb.append("+");
		for(int i=1; i <= cx;i++) {
			sb.append("-");
		}
		sb.append("+\n");
		for(int j=0; j < cy; j++) {
			sb.append("|");
			for(int i = 0; i < cx; i++) {
				if(celdas.get(new Coordenada(i,j)) == EstadoCelda.MUERTA) {
					sb.append(" ");
				}else {
					sb.append("*");
				}
			}
			sb.append("|\n");
		}
		sb.append("+");
		for(int i=1;i <= cx;i++) {
			sb.append("-");
		}
		sb.append("+\n");
		return sb.toString();
	}
	/**
	 * Getter: devuelve las posiciones de las celdas en el tablero
	 * @return celdas.keySet() variable que almacena la posición de las celdas en el tablero
	 */
	public Collection<Coordenada> getPosiciones(){
			return celdas.keySet();
	}
	/**
	 * Permite la creaciónde un texto de error a partir de una posicion invalida a la que no se puede acceder
	 * @param c variable de la clase Coordenada que se utiliza como referencia para mostrar el error
	 */
	private void muestraErrorPosicionInvalida(Coordenada c) {
		StringBuilder sb = new StringBuilder();
		sb.append("Error: la celda (");
		sb.append(c.getX());
		sb.append(",");
		sb.append(c.getY());
		sb.append(") no existe");
		System.out.println(sb);
	}
	/**
	 * Getter: devuelve el estado de una celda, en el caso de que exista se mostrará dicho estado y en caso contrario se mostrará null
	 * @param posicion variable de la clase Coordenada que se pasa por parametro para evaluar si existe o no
	 * @return celdas.get(posicion) devuelve la posicion valida de una coordenada
	 * @return null la coordenada no ha sido valida
	 */
	public EstadoCelda getCelda(Coordenada posicion) {
		Set<Coordenada> coordenadas = celdas.keySet();
		if(coordenadas.contains(posicion)==false) {
			muestraErrorPosicionInvalida(posicion);
			return null;
		}else {
			return celdas.get(posicion);
		}
	}
	/**
	 * Setter: asigna a la celda posicion el estado de celda e
	 * @param posicion variable pasada por referencia que contiene una posicion del tablero
	 * @param e variable pasada por referencia que contiene el estado de la celda
	 */
	public void setCelda(Coordenada posicion, EstadoCelda e) {
		if(celdas.containsKey(posicion)) {
			celdas.put(posicion, e);
		}else {
			muestraErrorPosicionInvalida(posicion);
		}
	}
	/**
	 * Constructor: permite la creación de una coordenada a partir de las de su alrededor
	 * @param posicion parametro pasado por referencia de la clase Coordenada que tiene la posicion inicial a partir de la cual se buscan las vecinas
	 * @return vecinas devuelve el conjunto de las variables vecinas a la principal
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion){
		ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
		int i=posicion.getX();
		int j=posicion.getY();
		//vecina0
		Coordenada coordenada = new Coordenada (i - 1, j - 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i - 1, j - 1));
		}
		//vecina1
		coordenada = new Coordenada (i - 1, j);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i - 1, j));
		}
		//vecina2
		coordenada = new Coordenada (i - 1, j + 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i - 1, j + 1));
		}
		//vecina3
		coordenada = new Coordenada (i, j + 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i , j + 1));
		}
		//vecina4
		coordenada = new Coordenada (i + 1, j + 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i + 1, j + 1));
		}
		//vecina5
		coordenada = new Coordenada (i + 1, j);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i + 1, j));
		}
		//vecina6
		coordenada = new Coordenada (i + 1, j - 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i + 1, j - 1));
		}
		//vecina7
		coordenada = new Coordenada (i, j - 1);
		if(celdas.get(coordenada)!=null) {
			vecinas.add(new Coordenada(i, j - 1));
		}
		return vecinas;
	}
	/**
	 * Booleano: este metodo permite conocer si es posible cargar el patron o no especificado a partir de una coordenada inicial
	 * @param patron variable que guarda patron pasado por referencia
	 * @param coordenadaInicial variable que guarda la coordenada por la cual comienza el patron
	 * @return p_charge permite conocer si es posible o no crear el patron (devuelve true o false)
	 */
	public boolean cargaPatron(Patron patron, Coordenada coordenadaInicial) {
		boolean p_charge = true;
		Coordenada c_final = null;
		Collection<Coordenada> coordenada;
		if(patron != null && coordenadaInicial != null) {
			coordenada = patron.getPosiciones();
			if(coordenada!=null) {
				for(Coordenada select:coordenada) {
					c_final=select.suma(coordenadaInicial);
					if(celdas.containsKey(c_final) == false){
						p_charge=false;
					}
				}
			
				EstadoCelda c_status;
				if(p_charge==true) {
					coordenada = patron.getPosiciones();
					for(Coordenada select:coordenada) {
						c_final=select.suma(coordenadaInicial);
						c_status=patron.getCelda(select);
						celdas.put(c_final,c_status);
					}
				}else {
					muestraErrorPosicionInvalida(c_final);
				}
			}
		}else {
			p_charge=false;
		}
		return p_charge;
	}
	/**
	 * Booleano: debuelve true solo si la posicion se encuentra entre las celdas inicializadas del tablero
	 * @param posicion variable pasada por referencia que contiene la posicion a evaluar
	 * @return celdas.containsKey(posicion) devuelve el contenido de dicha posicion
	 */
	public boolean contiene(Coordenada posicion) {
		return celdas.containsKey(posicion);
	}

}
	