
public class Pooglin {
 
	private int id;

	 
	private int cantidadDeMovimiento;
	 
	private Punto posicion;
	
	
	private Nivel nivel;
	 
	private Habilidad habilidad;
	
	private boolean estaMuerto;
	
	Pooglin(){
		Punto p1=new Punto(1,1);
		this.posicion=p1;
	}
	
	 Pooglin(Punto punto){
		this.posicion=punto;
		this.estaMuerto =false;
	}
	
	public Habilidad interactuar(Bloque obstaculo) {
		return null;
	}
	 
	public void morir() {
	 setEstaMuerto(true);
	}
	 
	public void caminar() {
	 
	}
	 
	public void darVuelta() {
	 
	}
	 
	public void definirInteraccion(Habilidad interaccion) {
	 
	}

	public void setPosicionX(int x) {
		this.posicion.setx(x);
	}

	public int getPosicionX() {
		return posicion.getx();
	}

	public void setPosicionY(int y) {
		this.posicion.sety(y);
	}

	public int getPosicionY() {
		return posicion.gety();
	}

	public void setEstaMuerto(boolean estaMuerto) {
		this.estaMuerto = estaMuerto;
	}

	public boolean isEstaMuerto() {
		return estaMuerto;
	}

	
	 
}
 
