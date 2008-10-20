public class Tierra extends Bloque implements Rompible {
	
	private int dureza;

	public Tierra(Punto punto) {
		super(punto);
		this.dureza = 4;
	}

	public void golpear() {
		this.decrementarDureza(1);
	}

	public void interactuar(Pooglin unPooglin) {
		unPooglin.caminar();
		unPooglin.interactuar(this);
	}
	public boolean esTraspasable(){
		return false;
	}
	public boolean esRomplible() {
			return true;
	}

	public void decrementarDureza(int dec){
		if (dec<=4 && dec>=0){
			this.dureza=this.dureza-dec;
		}
			else{
				this.dureza=0;
			}
	}
	
				
	
	public int getDureza() {
		return dureza;
	}
	 
}
 
