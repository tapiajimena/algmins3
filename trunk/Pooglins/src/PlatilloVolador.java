

public class PlatilloVolador extends Habilidad {

	@Override
	public void interactuar(Pooglin pooglin, Planeta planeta) {

			while(planeta.getBloque(pooglin.getPosicionX(), pooglin.getPosicionY()+ 1).esTraspasable())
				pooglin.setPosicionY(pooglin.getPosicionY()+ 1);
				pooglin.definirInteraccion(null);
		}
		
	}
	 
	
 
 
