package pooglin;
import punto.Punto;
import juego.Nivel;
import habilidad.Habilidad;

public class Pooglin {
 
	private int id;
 	private int cantidadDeMovimiento;
	private Punto posicion;
	private Nivel nivel;
	private Habilidad habilidad;
	private boolean estaMuerto;
	
	public Pooglin(){
		this.estaMuerto =false;
		this.posicion=new Punto(0,0);
	}
		
	public Pooglin(Punto punto){
		this.posicion=punto;
		this.estaMuerto =false;
	}
	
	public Pooglin(Punto punto, Nivel nivel) {
		this.posicion=punto;
		this.nivel=nivel;
	}

	public void interactuar() {
		if (habilidad!=null){
			this.habilidad.interactuar(nivel.getPlaneta());
		} else {
			this.caminar();
		}
		
		}
	 
	public void morir() {
	 estaMuerto=true;
	}
	public void caminar() {
		
		if((!estaMuerto)){	
			if((nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(1, 0)).esTraspasable()) && !(nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(1, 1)).esTraspasable() )){
				this.posicion.setX(this.getPosicion().getX()+1);
			}
		//Diagonal inferior adelante;
		else if((nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(1, 0)).esTraspasable()) && (nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(1, 1)).esTraspasable() )){
			this.caer();
		}	
		else if(!(nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(1, 0)).esTraspasable())){
			this.darVuelta();
		}
		}
	}
	
	 
	public void darVuelta() {
		this.cantidadDeMovimiento*=-1;
	}
	 
	public void caer() {
		int bloquesCaidos=0;
		
		if ((nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(0,1)).esTraspasable())&& (bloquesCaidos<=5)){
			bloquesCaidos++;
			this.posicion.setY(this.getPosicion().getY()+1);
		}
		if (bloquesCaidos>5){
			this.morir();
		}
	
	}
		
	public void definirHabilidad(Habilidad habilidad) {
		this.habilidad=habilidad;
	}
	
	public Punto getPosicion(){
		return new Punto(this.posicion);
	}
	
	public void setPosicion(Punto punto){
		this.posicion=punto;
	}
	
	public boolean estaMuerto() {
		return estaMuerto;
	}

	public void salvar() {
		
	}

	public int getId() {
		return id;
	}
}
 
