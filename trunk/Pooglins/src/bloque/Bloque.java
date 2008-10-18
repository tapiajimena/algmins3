package bloque;
import pooglin.Pooglin;
import punto.Punto;

public abstract class Bloque {
 
	private Punto posicion;
	 
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
		return posicion.getx();
	}
	public int getPosicionY() {
		return posicion.getY();
	}

	public void setPosicionX(int x) {
		this.posicion.setx(x);
	}
	public void setPosicionY(int y) {
		this.posicion.sety(y);
	} 
	
}
 