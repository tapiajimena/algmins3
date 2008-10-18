package habilidad;
import pooglin.Pooglin;
import juego.Planeta;



public class PlatilloVolador extends Habilidad {

	public PlatilloVolador(Pooglin pooglin) {
		super(pooglin);
	}

	@Override
	public void interactuar(Planeta planeta) {

			while(planeta.getBloque(pooglin.getPosicionX(), pooglin.getPosicionY()+ 1).esTraspasable())
				pooglin.setPosicionY(pooglin.getPosicionY()+ 1);
				
		}

	}
	 
	
 
 
