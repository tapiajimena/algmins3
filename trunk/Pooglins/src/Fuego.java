
public class Fuego extends Bloque implements Apagable {
 
	private int resistencia=100;
		
	public Fuego(Punto punto){
		super(punto);
			
	}
	
	public boolean esTraspasable() {
		return true;
	}
	
	public boolean esApagable(){
		return true;
	}
	
	public void interactuar(Pooglin unPooglin){
	    if(unPooglin.getPosicionX()==this.getPosicionX()){
	    	if(unPooglin.getPosicionY()==this.getPosicionY()){
	    		unPooglin.morir();
	    	}
	    }
	 }
	
	
}
 
