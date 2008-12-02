package modelo.bloque;

import modelo.Pooglin;
import modelo.Punto;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public abstract class Bloque {
 
	protected Punto posicion;
	 
	public Bloque(Punto punto){
		super();
		this.posicion=punto;
	}
	
	public abstract void interactuar(Pooglin unPooglin);
	
	public boolean esTraspasable() {
		return true;
	}
	
	public boolean vacio() {
		return false;
	}
	 
	public void destruir(){} ;
	
	public int getPosicionX() {
		return posicion.getX();
	}
	
	public int getPosicionY() {
		return posicion.getY();
	}
	
	public Punto getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Punto punto) {
		this.posicion.copiar(punto);
	}
	
	public void setPosicionX(int x) {
		this.posicion.setX(x);
	}
	
	public void setPosicionY(int y) {
		this.posicion.setY(y);
	} 
	
	public boolean esDerretible(){
		return false;
	}
	
	public void queEs(){
	}
	
	public char getLetra(){
		return 'A';
	}
	
	public boolean esMatable() {
		return false;
	}
	
	public boolean equals(Object obj){
		Bloque otroBloque=(Bloque)obj;
		return this.posicion.equals(otroBloque.posicion);
	}
	
	public Element serializar(){
		Element bloqueXML=DocumentHelper.createElement(this.getClass().getName());
		bloqueXML.add(this.posicion.serializar());
		return bloqueXML;
	};
	
	public void recuperarEstado(Element bloqueXML){
		this.posicion.recuperarEstado(bloqueXML.element("Punto"));
	};
}
 