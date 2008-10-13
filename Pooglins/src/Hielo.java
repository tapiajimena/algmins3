

public class Hielo extends Bloque implements Rompible {
 
	private int dureza;

	public Hielo(Punto punto) {
		super(punto);
		this.dureza=6;
	}

	public void golpear() {
		decrementarDureza(1);
	}

	public void interactuar(Pooglin unPooglin) {
		unPooglin.caminar();
		
	}

	public boolean esRomplible() {
			return true;
	}

	public void decrementarDureza(int dec){
		if (dureza>=0){
			this.dureza=-dec;
		}	
		
	}
	public int getDureza() {
		return dureza;
	} 
}
 
