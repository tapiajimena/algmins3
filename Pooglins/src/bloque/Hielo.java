package bloque;
import pooglin.Pooglin;
import punto.Punto;



public class Hielo extends Bloque implements Rompible{
 
	private int dureza;

	public Hielo(Punto punto) {
		super(punto);
		this.dureza=6;
	}

	public void golpear() {
		decrementarDureza(1);
	}
	 public boolean esDerretible(){
		 return true;
	 }
	public boolean esTraspasable(){
		return false;
	}
	public void interactuar(Pooglin unPooglin) {

		unPooglin.caminar();
		unPooglin.caminar();


	}

	public boolean esRomplible() {
			return true;
	}

	public void decrementarDureza(int dec){
		if (dureza>0){
			if (dec<=6){
			this.dureza=dureza-dec;
		}else if (dec>6){
			dureza = 0;
		}
		}
	}
	public int getDureza() {
		return dureza;
	} 

	public char getLetra(){
		return 'H';
	}

	
}
 
