public class Roca extends Bloque implements Rompible{

	public Roca(Punto punto){
		super (punto);	
	}
	

	public void interactuar(Pooglin unPooglin) {
		unPooglin.darVuelta();
	}

	public boolean esRomplible() {
			return false;
	}


	public int getDureza() {
		return 0;
	}

	public void golpear() {

	}
 
}