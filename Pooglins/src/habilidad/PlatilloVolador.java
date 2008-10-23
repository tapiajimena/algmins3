package habilidad;
import pooglin.Pooglin;
import punto.Punto;
import juego.Planeta;



public class PlatilloVolador extends Habilidad {

	public PlatilloVolador(Pooglin pooglin) {
		super(pooglin);
	}
	@Override
	public void interactuar(Planeta planeta) {
		Punto posicionBloque=pooglin.getPosicion();
		posicionBloque.setX(posicionBloque.getX()+1);
		if(planeta.getBloque(posicionBloque).esTraspasable())
			pooglin.setPosicion(posicionBloque);
				
		}

	}
	 
	
 
 
