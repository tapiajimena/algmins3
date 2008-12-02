package modelo.habilidad;
import modelo.Planeta;
import modelo.Pooglin;
import modelo.Punto;
import modelo.bloque.Tunel;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class TunelElectroMagnetico extends Habilidad {
 
	private int longitudFaltante;
	
	public TunelElectroMagnetico(Pooglin unPooglin){
		super(unPooglin);
		this.longitudFaltante = 2;
	}
	
	public void interactuar(Planeta unPlaneta){
		Punto posicionBloque = pooglin.getPosicion();
		/*el bloque de adelante*/	
		
		posicionBloque=pooglin.getPosicion().puntoRelativo(0,pooglin.getVectorDireccion());
		
		if (unPlaneta.getBloque(posicionBloque).esTraspasable()){
			if (this.longitudFaltante>0){
				unPlaneta.agregar(new Tunel(posicionBloque));
				this.longitudFaltante--;
				pooglin.caminar();
			}else pooglin.definirHabilidad(null);
		} else pooglin.definirHabilidad(null);
		
	}

	public int getLongitudFaltante() {
		return longitudFaltante;
	}
	
	public Element serializar() {
		Element elementTunelElectroMagnetico=DocumentHelper.createElement("TunelElectromagnetico");
		elementTunelElectroMagnetico.addAttribute("longitudFaltante",String.valueOf(this.longitudFaltante));
		return elementTunelElectroMagnetico;
	}

	public void recuperarEstado(Element elementoTunelElectroMagnetico) {
		this.longitudFaltante = Integer.parseInt(elementoTunelElectroMagnetico.attributeValue("longitudFaltante"));
	}
	
	public char getLetra(){
		return 'E';
	}
	 
}
 
