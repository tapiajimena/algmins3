package habilidad;
import juego.Planeta;
import pooglin.Pooglin;
import bloque.Hielo;


public class Congelamiento extends Habilidad {


	public Congelamiento(Pooglin pooglin) {
		super(pooglin);
	}

	public void interactuar(Planeta planeta) {
		planeta.agregarObstaculo(new Hielo(pooglin.getPosicion()));
		pooglin.morir();
	}

}
 
