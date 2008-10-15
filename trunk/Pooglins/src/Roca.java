public class Roca extends Bloque{
	
	private double dureza;
	public Roca(Punto punto){
		super (punto);
		dureza = 1000;
	}	
	public void interactuar(Pooglin unPooglin) {
		  if(unPooglin.getPosicionX()==this.getPosicionX()){
		    	if(unPooglin.getPosicionY()==this.getPosicionY()){
		    		unPooglin.caminar();
		    	}
		  }
	}
	public void golpear() {
		dureza = dureza - 0.1;
	}
	
	public boolean esTraspasable(){
		return false;
	}

}