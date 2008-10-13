

public class Tierra extends Bloque implements Rompible {
	private int dureza;
	
	public Tierra(Punto punto) {
		super(punto);
	}


	public void golpear() {
	 
	}

	public void interactuar(Pooglin unPooglin) {
		
		
	}

	public boolean esRomplible() {
			return true;
	}

	public void setDureza(int dureza) {
		this.dureza = dureza;
	}

	public int getDureza() {
		return dureza;
	}
	 
}
 
