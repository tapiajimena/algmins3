package modelo.habilidad;

import modelo.Planeta;
import modelo.Pooglin;
import modelo.Punto;
import modelo.bloque.Rompible;

import org.dom4j.Element;

public class RayoLaser extends Habilidad {

	private int disparos = 20;

	public RayoLaser(Pooglin unPooglin) {
		super(unPooglin);
	}

	public RayoLaser(Pooglin unPooglin, int cantidadDisparos) {
		super(unPooglin);
		this.disparos = cantidadDisparos;
	}

	/*
	 * Toma la posici�n del bloque que se encuentra delante del Pooglin,
	 * chequea que sea rompible y en caso afirmativo, comienza a golpear.
	 */
	public void interactuar(Planeta unPlaneta) {

		Punto posicionBloque;

		/* el bloque de adelante */
		posicionBloque = pooglin.getPosicion().puntoRelativo(0,
				pooglin.getVectorDireccion());

		if (unPlaneta.getBloque(posicionBloque) instanceof Rompible) {
			if (this.getDisparos() > 0) {
				Rompible bloqueRompible = (Rompible) unPlaneta
						.getBloque(posicionBloque);
				bloqueRompible.golpear();
				this.decremetarDisparos();
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

	public void decremetarDisparos() {
		this.disparos--;
	}

	public int getDisparos() {
		return this.disparos;
	}

	public Element serializar() {
		Element elementRayoLaser = super.serializar();
		elementRayoLaser
				.addAttribute("disparos", String.valueOf(this.disparos));
		return elementRayoLaser;
	}

	public void recuperarEstado(Element elementoRayoLaser) {
		this.disparos = Integer.parseInt(elementoRayoLaser
				.attributeValue("disparos"));
	}

	public char getLetra() {
		return 'L';
	}
}
