package bloque;
import java.util.Observable;

import pooglin.Pooglin;
import punto.Punto;

public abstract class Bloque extends Observable{
 
	protected Punto posicion;
	 
	public Bloque(Punto punto){
		super();
		this.posicion=punto;
	}
	
	public abstract void interactuar(Pooglin unPooglin);
	
	public boolean esTraspasable() {
		return true;
	}
	public boolean vacio() {
		return false;
	}
	 
	public void destruir() {
	    if(super.countObservers()>0)
	    	notifyObservers();
	 
	}
	public int getPosicionX() {
		return posicion.getX();
	}
	public int getPosicionY() {
		return posicion.getY();
	}
	public Punto getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Punto punto) {
		this.posicion.copiar(punto);
	}
	
	public void setPosicionX(int x) {
		this.posicion.setX(x);
	}
	public void setPosicionY(int y) {
		this.posicion.setY(y);
	} 
	public boolean esDerretible(){
		return false;
	}
	public void queEs(){
		
	}
	public char getLetra(){
		return 'A';
	}
}
 