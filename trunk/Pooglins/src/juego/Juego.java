package juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


@SuppressWarnings("unused")
public class Juego {
	// TODO que hacemos? lista de niveles o lista de configuracion de nivel, es decir cargamos todo de una sola vez o a medida q se necesita?
	private String[] configNiveles;
	private Nivel nivel;
	public Juego(){
		// TODO 
		//guarda de alguna forma en orden los niveles q deben ser cargados  
	}
	public Juego(String config){
		// TODO 
	}
	//interno para cargar el nivel q sigue
	private void siguienteNivel(){
		// TODO 
		
	
	}
	//Para ver el nivel actual desde MVC
	public Nivel getNivelActual(){
		return nivel;
	}

}
 
