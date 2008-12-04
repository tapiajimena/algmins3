package modelo.bloque;

import modelo.Pooglin;
import modelo.Punto;

public class Roca extends Bloque {

	public Roca(Punto punto) {
		super(punto);
	}

	public void interactuar(Pooglin unPooglin) {
		if (this.posicion.equals(unPooglin.getPosicion()))
			unPooglin.morir();
		unPooglin.caminar();
	}

	public boolean esTraspasable() {
		return false;
	}

	public char getLetra() {
		return 'R';
	}

	public boolean equals(Object obj) {
		if (obj instanceof Roca) {
			return super.equals(obj);
		}
		return false;
	}
}