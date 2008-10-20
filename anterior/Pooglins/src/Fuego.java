
public class Fuego extends Bloque implements Apagable {
 
	@SuppressWarnings("unused")
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
	
// Quitar, abria que agregar como un toString en cada clase, para visualizarlo mejor...
	public void queES(){
		System.out.println("Esto es Fuego en la pos:"+this.getPosicionX()+"-"+this.getPosicionY());
	}
}
 