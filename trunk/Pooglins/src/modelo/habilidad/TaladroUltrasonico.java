package modelo.habilidad;

import modelo.Planeta;
import modelo.Pooglin;
import modelo.Punto;
import modelo.bloque.Rompible;

import org.dom4j.Element;

public class TaladroUltrasonico extends Habilidad {

	private int vueltasDeTorpedo = 10;

	public TaladroUltrasonico(Pooglin unPooglin) {
		super(unPooglin);
	}

	public void interactuar(Planeta unPlaneta) {
		Punto posicionBloque = pooglin.getPosicion();
		posicionBloque = pooglin.getPosicion().puntoRelativo(1, 0);
		if (unPlaneta.getBloque(posicionBloque) instanceof Rompible) {
			if (this.getVueltasDeTorpedo() > 0) {
				Rompible bloqueRompible = (Rompible) unPlaneta
						.getBloque(posicionBloque);
				bloqueRompible.golpear();
				this.decrementarVueltas();
				if (bloqueRompible.getDureza() <= 0) {
					unPlaneta.quitarBloque(posicionBloque);
					pooglin.caminar();
				}
			} else {
				pooglin.definirHabilidad(null);
			}
		} else
			pooglin.definirHabilidad(null);
	}

	public void decrementarVueltas() {
		this.vueltasDeTorpedo--;
	}

	public int getVueltasDeTorpedo() {
		return vueltasDeTorpedo;
	}

	public Element serializar() {
		Element elementTaladroUltrasonico = super.serializar();
		elementTaladroUltrasonico.addAttribute("vueltasDeTorpedo", String
				.valueOf(this.vueltasDeTorpedo));
		return elementTaladroUltrasonico;
	}

	public void recuperarEstado(Element elementoTaladroUltrasonico) {
		this.vueltasDeTorpedo = Integer.parseInt(elementoTaladroUltrasonico
				.attributeValue("vueltasDeTorpedo"));
	}

	public char getLetra() {
		return 'U';
	}
}