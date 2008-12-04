package modelo.bloque;

import modelo.Pooglin;
import modelo.Punto;

public class Entrada extends Bloque {

	public Entrada(Punto punto) {
		super(punto);
	}

	public void interactuar(Pooglin unPooglin) {
		unPooglin.caminar();
	}

	public char getLetra() {
		return 'E';
	}

	public boolean equals(Object obj) {
		if (obj instanceof Entrada) {
			return super.equals(obj);
		}
		return false;
	}
}
