
public class Fuego extends Bloque implements Apagable {
 
	private int resistencia;
	
	private Punto posicionX;
	
	private Punto posicionY;
	
	private Apagable apagable;
	
	
	public Fuego(Punto X,Punto Y){
		posicionX=X;
		posicionY=Y;
		
	}
	public boolean esApagable(){
		return true;
	}
	public void interactuar(Pooglin unPooglin){
	    if(unPooglin.getPosicionX()==this.getPosicionX()){
	    	if (unPooglin.getPosicionY()==this.getPosicionY()){
	    		unPooglin.matar();	
	    	}
	    }
	 }
	
	public Punto getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(Punto posicionX) {
		this.posicionX = posicionX;
	}
	public Punto getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(Punto posicionY) {
		this.posicionY = posicionY;
	}
}
 
