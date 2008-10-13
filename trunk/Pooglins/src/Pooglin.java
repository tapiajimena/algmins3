
public class Pooglin {
 
	private int id;
 	private int cantidadDeMovimiento;
	private Punto posicion;
	private Nivel nivel;
	private Habilidad habilidad;
	private boolean estaMuerto;
	
	
		
	Pooglin(Punto punto){
		this.posicion=punto;
		this.estaMuerto =false;
	}
	
	public Habilidad interactuar(Bloque obstaculo) {
		return null;
	}
	 
	public void morir() {
	 estaMuerto=true;
	}
	 
	public void caminar() {
	if((!estaMuerto)){	
		if((nivel.getPlaneta().getBloque(this.getPosicionX()+1,this.getPosicionY()).esTraspasable()) && !(nivel.getPlaneta().getBloque(this.getPosicionX()+1,this.getPosicionY()+1).esTraspasable() ))
		{
			this.setPosicionX(this.getPosicionX()+1);
		}
	//Diagonal inferior adelante;
	else if((nivel.getPlaneta().getBloque(this.getPosicionX()+1,this.getPosicionY()).esTraspasable()) && (nivel.getPlaneta().getBloque(this.getPosicionX()+1,this.getPosicionY()+1).esTraspasable() ))
	{
		this.caer();
	}	
	else if(!(nivel.getPlaneta().getBloque(this.getPosicionX()+1,this.getPosicionY()).esTraspasable())){
		this.darVuelta();
	}
	}
	}
	
	 
	public void darVuelta() {
		this.cantidadDeMovimiento*=-1;
	}
	 
	public void caer() {
		int bloquesCaidos=0;
		
		while ((nivel.getPlaneta().getBloque(this.getPosicionX(),this.getPosicionY()+1).esTraspasable())&& (bloquesCaidos<=5)){
			
			bloquesCaidos++;
			this.setPosicionY(this.getPosicionY()+1);
		}
		if (bloquesCaidos>5){
			this.morir();
		}
	
	}
		
	
	public void definirHabilidad(Habilidad habilidad) {
		this.habilidad=habilidad;
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

	public boolean estaMuerto() {
		return estaMuerto;
	}

	
	 
}
 
