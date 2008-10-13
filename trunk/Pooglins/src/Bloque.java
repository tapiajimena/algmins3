

public class Bloque {
 
	private Punto posicion;
	 
	private Planeta planeta;
	 
	public abstract void interactuar(Pooglin unPooglin);
	public boolean esTraspasable() {
		return false;
	}
	 
	public boolean vacio() {
		return false;
	}
	 
	public void destruir() {
	 
	}
	 
}
 
