public class Roca extends Bloque{

	public Roca(Punto punto){
		super (punto);	
	}	

	public void interactuar(Pooglin unPooglin) {
		unPooglin.darVuelta();
	}

	public int getDureza() {
		return 0;
	}

	public void golpear() {

	}
 
}