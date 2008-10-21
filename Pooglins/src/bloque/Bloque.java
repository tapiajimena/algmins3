package bloque;
import pooglin.Pooglin;
import punto.Punto;

public abstract class Bloque {
 
	protected Punto posicion;
	 
	public Bloque(Punto punto){
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
	public void queEs(){
		
	}
}
 