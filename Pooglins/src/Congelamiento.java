
public class Congelamiento extends Habilidad {

	@Override
	public void interactuar(Pooglin pooglin, Planeta planeta) {
		int posicionX=pooglin.getPosicionX();
		int posicionY=pooglin.getPosicionY();
		Punto punto=new Punto(posicionX,posicionY);
		planeta.agregarObstaculo(new Hielo(punto), posicionX, posicionY);
		pooglin.morir();
	}

}
 