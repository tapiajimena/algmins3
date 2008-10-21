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
	private int bloquesCaidos;
	
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
		/*le pide la interaccion a los bloques contiguos*/
		for(int i=-1;i<2;i++){
			for(int j=-1;j<2;j++)
				nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(i,j));
			
		}
	}
	 
	public void morir() {
	 estaMuerto=true;
	}
	public void caminar() {
		
		if((!estaMuerto)){
			//Si de entrada abajo no hay nada...
			if((nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(1,0)).esTraspasable())){
				System.out.println("Cae para abajo");
				this.caer();
			}
			
			//Si abajo a la derecha no hay bloque no transpasable el pooglin cae.
			//No puede haber un bloque tierra si abajo hay aire.
			else if((nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(0, 1)).esTraspasable()) && (nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(1, 1)).esTraspasable()) ){
				
					System.out.println("Cae en diagonal");
					this.posicion.setY(this.getPosicion().getY()+1);
					this.posicion.setX(this.getPosicion().getX()+1);
					//this.caer();
				
			}
			//Adelante normal...
			else if((nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(0, 1)).esTraspasable()) && !(nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(1, 1)).esTraspasable() )){
				System.out.println("Avanzo hacia adelante");
				this.posicion.setY(this.getPosicion().getY()+1);
			}
			else if(!(nivel.getPlaneta().getBloque(this.getPosicion().puntoRelativo(0, 1)).esTraspasable())){
				System.out.println("Doy la vuelta");
				this.darVuelta();
		}
		}
	}
	
	 
	public void darVuelta() {
		this.cantidadDeMovimiento*=-1;
	}
	 
	public void caer() {
		
		if (bloquesCaidos<=5){
			System.out.println("Me cai, ouch");
			bloquesCaidos++;
			this.posicion.setX(this.getPosicion().getX()+1);
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
	
	public Punto obtenerDireccion(){ 
		return new Punto(this.cantidadDeMovimiento,0);
	}

	public int getId() {
		return id;
	}
}
 
