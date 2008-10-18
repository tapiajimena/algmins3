package habilidad;
import juego.Planeta;
import pooglin.Pooglin;
import punto.Punto;
import bloque.Hielo;


public class Congelamiento extends Habilidad {


	public Congelamiento(Pooglin pooglin) {
		super(pooglin);
	}

	public void interactuar(Planeta planeta) {
		int posicionX=pooglin.getPosicionX();
		int posicionY=pooglin.getPosicionY();
		Punto punto=new Punto(posicionX,posicionY);
		planeta.agregarObstaculo(new Hielo(punto), posicionX, posicionY);
		pooglin.morir();
	}

}
 
