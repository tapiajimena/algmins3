package juego;
;



public class TiempoNivel {

	
	private int minutosRestantes;
	private int segundosRestantes;
	private int tiempoTrascurrido;//en segundos.
	

	public TiempoNivel(){
	
		setMinutosRestantes(0);
		setSegundosRestantes(0);
		setTiempoTrascurrido(0);

     
	}


	public void setMinutosRestantes(int minutosRestantes) {
		this.minutosRestantes = minutosRestantes;
	}


	public int getMinutosRestantes() {
		return minutosRestantes;
	}


	public void setSegundosRestantes(int segundosRestantes) {
		this.segundosRestantes = segundosRestantes;
	}


	public int getSegundosRestantes() {
		return segundosRestantes;
	}


	public void setTiempoTrascurrido(int tiempoTrascurrido) {
		this.tiempoTrascurrido = tiempoTrascurrido;
	}


	public int getTiempoTrascurrido() {
		return tiempoTrascurrido;
	}



    
}
